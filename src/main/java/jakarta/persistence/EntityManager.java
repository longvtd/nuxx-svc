package jakarta.persistence;

/**
 * @name: JPA EntityManager 컴파일 스텁
 * <PRE>오프라인 컴파일에 필요한 native query API를 선언합니다.</PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : EntityManager.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
public interface EntityManager {
    Query createNativeQuery(String sql);
}
