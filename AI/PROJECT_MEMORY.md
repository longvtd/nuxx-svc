# PROJECT MEMORY — nuxx-svc

## Documentation status (2026. 10. 02.)

- All production source under `com.lguplus.nuxx` now follows the full class/method JavaDoc templates (`@name`, `<PRE>`, `@author`, `@class`/`@MethodName`, `@Part`, history).
- REST controllers use class-level Swagger `@Tag`.
- Every controller endpoint uses method-level JavaDoc plus `@Operation`.
- Method-level descriptions (`@name` and `<PRE>`) are designed as Local Knowledge Pack / Code Insight input. Service method purpose must be taken from the method comment, not the class `@name`.
- Existing interaction logic was not changed: method signatures, call paths, External API placeholders, Kafka topics, repository calls, and controller URL paths remain as before.
- `HmCustController` was added only to create realistic inbound REST paths for manual ImpactScope testing of four positive customer lookups. Negative/unresolved customer-service methods are not exposed as endpoints.
