# ImpactScope – Sample: Outbound URL qua Constant (format domain thật)

Sample để **manual test** impact External API khi URL placeholder `{@domain_id.url_id}` nằm trong constant và được gọi theo nhiều cách.

- Config đúng format thật: `src/main/resources/config/domain.yml`, `domain-api.yml`
  - `domain.yml`: key domain viết hoa `DO-01`, `DO-02`, `DO-03` (+ `service.apim*`, `amdocs`)
  - `domain-api.yml`: `DO-xx:` → `<url_id>:` → `url:`
- Placeholder trong code dùng chữ thường: `{@do-01.api-selectUser-001}` (case C1 dùng `{@DO-01...}`)
- Compile: Java 17, không cần Spring (`mvn compile` hoặc `javac`).

## 1. Cách test
```bash
./scripts/make-commits.sh baseline   # push -> Add Repository -> Full Scan -> kiểm tra mục 2,3,4
./scripts/make-commits.sh i1         # push -> scan commit mới -> mục 5
./scripts/make-commits.sh i2
./scripts/make-commits.sh i3
```

## 2. Positive (baseline) – method phải có `CALLS_EXTERNAL` tới API

| Case | Class.method | Kiểu URL | Receiver | Expected API |
|---|---|---|---|---|
| V1 | V1LiteralUserService.retrieveLiteral / retrieveLiteralThis | literal | restTemplate / this. | DO-01.api-selectUserLiteral-001 |
| V2 | V2QualifiedConstantUserService.retrieveListUserInfo / ...This | `ExpApiUriConstant.X` | restTemplate / this. | DO-01.api-selectUser-001 |
| V3 | V3FqnConstantUserService.retrieveFqn / retrieveFqnThis | `com.util.ExpApiUriConstant.X` | restTemplate / this. | DO-01.api-selectUserFqn-001 |
| V4 | V4StaticSingleImportUserService.retrieveChkUserInfo / ...NoThis | static import 1 field | this. / restTemplate | DO-01.api-selectUserList-001 |
| V5 | V5StaticWildcardImportUserService.retrieveWildcard / ...This | static import `*` | restTemplate / this. | DO-01.api-selectUserWildcard-001 |
| V5 | V5StaticWildcardImportUserService.retrieveListUserInfo | **sample gốc** – qualified | restTemplate | DO-01.api-selectUser-001 |
| V5 | V5StaticWildcardImportUserService.retrieveChkUserInfo | **sample gốc** – unqualified | this.restTemplate | DO-01.api-selectUserList-001 |
| V6 | V6LocalConstantUserService.retrieveLocal / retrieveLocalThis | private const cùng class | restTemplate / this. | DO-01.api-selectUserLocal-001 |
| V6 | V6LocalConstantUserService.retrieveLocalPublicQualified | `OwnClass.X` | this. | DO-01.api-selectUserLocalPublic-001 |
| V7a | V7aInterfaceConstantUserService.retrieveIface / ...This | const từ interface | restTemplate / this. | DO-01.api-selectUserIface-001 |
| V7b | V7bParentConstantUserService.retrieveParent / ...This | const + field từ superclass | restTemplate / this. | DO-01.api-selectUserParent-001 |
| V8 | V8ChainedConstantUserService.retrieveChain / ...This | chain 3 hop | restTemplate / this. | DO-01.api-selectUserChain-001 |
| R1 | R1ReceiverVariantsService.retrieveCustApim / ...This | const, POST | ApimRestTemplate | DO-02.selectCust-001 |
| R1 | R1ReceiverVariantsService.retrieveCustListApim | const, GET | this.apimRestTemplate | DO-02.selectCustList-001 |
| R1 | R1ReceiverVariantsService.retrieveUserByCustomFieldName / ...This | const | Wafful field `userClient` | DO-01.api-selectUser-001 |
| P1 | UserInfoController.listUser / checkUser | gọi qua service V5 | – | Path Controller → Service → API hiển thị đúng |

## 3. Dedupe / chuẩn hóa ID

| Case | Kiểm tra | Expected |
|---|---|---|
| D1 | D1DedupeUserService: literal / qualified / static import / FQN | **1** node `DO-01.api-selectUser-001`, edge từ cả 4 method |
| C1 | D1DedupeUserService.dedupeUppercaseDomain (`{@DO-01...}`) | Cùng node trên, **không** sinh node thứ 2 |
| Tổng | Edge tới `DO-01.api-selectUser-001` sau baseline | Đúng **10**: V2×2, V5.retrieveListUserInfo×1, R1 userClient×2, D1×5 |
| All | Mọi API | Không có node trùng domainId.apiId (khác hoa/thường) |

## 4. Negative – scan không fail/không treo

| Case | N1UnresolvedUserService / F1NotOutboundService | Expected |
|---|---|---|
| N1 | unresolvedRuntimeConcat | Không edge; `UNRESOLVED_OUTBOUND_URL` |
| N2 | unresolvedMethodCall | Không edge; `UNRESOLVED_OUTBOUND_URL` |
| N3 | unresolvedCycle (A→B→A) | Không edge; `UNRESOLVED_OUTBOUND_URL`; **không treo** |
| N4 | unresolvedNotFinal | Không edge tới `api-selectUserNotFinal-001` dù API có trong yml |
| N5 | unresolvedLocalVariable | Không edge; `UNRESOLVED_OUTBOUND_URL` |
| N6 | notInCatalogApi (`do-01.api-notExist-999`) | Không link sai sang API khác; ghi nhận theo rule hiện tại (unmapped/diagnostic) |
| N7 | unknownDomain (`do-99...`) | Không link sang DO-01; ghi nhận theo rule hiện tại |
| F1 | readCacheByConstant | Không edge, không diagnostic |
| F2 | logConstant | Không edge, không diagnostic |
| F3 | fakeTemplateCall (field `restTemplate` khác type) | Không edge |

## 5. Commit mới (scan commit mới / rebuild)

| Step | Thay đổi | Expected |
|---|---|---|
| I1 | Chỉ đổi value `URL_API_CHKUSERINFO` → `api-selectUserList-002` | V4.retrieveChkUserInfo, V4.retrieveChkUserInfoNoThis, V5.retrieveChkUserInfo → **api-selectUserList-002**; không còn edge active tới -001. Kiểm tra thêm: Commit Impact của commit này có liệt kê 3 caller không |
| I2 | Chỉ sửa V2.retrieveListUserInfo dùng `URL_API_USERINFO_FQN` | retrieveListUserInfo → api-selectUserFqn-001; edge tới api-selectUser-001 còn **9** |
| I3 | Chỉ đổi literal ở `ExpApiUriChainLeafConstant` → `api-selectUserChain-002` | V8.retrieveChain / ...This → **api-selectUserChain-002** (lan qua 3 hop) |

Kết quả sau mỗi step phải giống chạy Full Scan lại trên cùng commit.
