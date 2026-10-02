# nuxx-svc Code Insight manual-test project

Compile-ready Java 17 sample based on the supplied NUXx service examples. No network dependencies are required; framework classes are local stubs so ImpactScope can scan realistic package/import/call structures.

## Configuration
- Domain files are under `src/main/resources/config` and retain the supplied uppercase catalog keys.
- Placeholders use `{@nuxy-svc.apiId}` and exercise case-insensitive catalog matching.

## Baseline coverage
- Controller -> Order service -> Detail/customer services.
- Direct and contextual outbound API through WaffulRestTemplete/ApimRestTemplate.
- Literal, local variable, same-class constant, other-class constant, FQN constant, uppercase domain, invalid API/domain, dynamic/concatenated/mutable URL and false-positive CustomHttpHelper.
- Kafka publish/send and subscriber handlers.
- Repository reads/writes, overloads, constructor identity, DTO/entity calls and method-level Korean `@name` comments.

## Build
```bash
javac -encoding UTF-8 -d target/classes $(find src/main/java -name '*.java')
```

## Make commits for manual scans
Run one step, push, scan, inspect Code Insight, then continue.
```bash
./scripts/make-test-commits.sh baseline
./scripts/make-test-commits.sh c1
./scripts/make-test-commits.sh c2
./scripts/make-test-commits.sh c3
```

### Expected focus
- `baseline`: full graph and all evidence styles.
- `c1`: changed call in `HmOrderService.savePhone`; external API should be NEW/Via callee and compact behavior should stay bounded.
- `c2`: only a 3-hop constant leaf changes; Full Rebuild should map callers to `api-selectUserChain-002`.
- `c3`: deleted callable must correlate to the parent graph and must not cause false `METHOD_NOT_IN_TARGET_GRAPH`.

The scripts are intentionally sequential. Start from a fresh extracted directory.
