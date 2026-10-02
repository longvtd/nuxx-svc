package org.springframework.data.jpa.repository;

import java.util.List;

/**
 * @name: Spring Data JpaRepository 컴파일 스텁
 * <PRE>오프라인 컴파일에 필요한 조회 및 저장 API를 선언합니다.</PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : JpaRepository.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
public interface JpaRepository<T, ID> {
    List<T> findAllById(Iterable<ID> ids);

    T save(T entity);
}
