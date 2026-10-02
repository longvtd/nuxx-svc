# C3X operations notes — nuxx-svc documentation

## Code Insight comment sources

- Method-level `@name` and the method `<PRE>` body are the expected Code Insight comment sources for callable purpose.
- Swagger `@Operation.summary` / `description` provide inbound endpoint context on REST controllers.
- Class-level JavaDoc describes the type responsibility and must not override a more specific method purpose.

## Manual customer-controller validation

Use `HmCustController` (`/api/v1/customer`) for inbound-path checks only:

| Endpoint | Delegates to | Expected External API path |
|---|---|---|
| `GET /api/v1/customer/v1/{custId}` | `HmCustClientService.selectCustInline` | Direct Wafful `{@nuxy-svc.api-selectCust-001}` |
| `GET /api/v1/customer/v1/apim/{custId}` | `HmCustClientService.selectCustByApim` | Direct APIM `{@nuxy-svc.api-selectCust-001}` |
| `GET /api/v1/customer/v1/profile/{custId}` | `HmCustClientService.selectCustProfile` | Contextual APIM via `selectCustByApim` |
| `GET /api/v1/customer/v1/list` | `HmCustClientService.selectCustList` | Direct Wafful `{@nuxy-svc.api-selectCustList-001}` |

Do not use this controller to exercise unresolved/negative cases (dynamic URL, concatenated URL, unknown domain/API, mutable field URL, `CustomHttpHelper`).
