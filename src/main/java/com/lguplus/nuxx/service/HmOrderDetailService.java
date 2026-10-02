package com.lguplus.nuxx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lguplus.nuxx.dto.CustDTO;
import com.lguplus.nuxx.dto.PhoneDetailDTO;
import com.lguplus.nuxx.dto.PhoneReqDTO;
import com.lguplus.nuxx.entity.PhoneDetailEntity;
import com.lguplus.nuxx.repository.PhoneDetailRepository;

/**
 * @name: Home order detail Service
 * <PRE>
 * 홈주문 휴대폰 주문 상세 서비스.
 * 주문 상세 조회와 고객명 반영을 담당합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : HmOrderDetailService.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@Service
public class HmOrderDetailService {
	private final PhoneDetailRepository detailRepo;

	/**
	 * @name: 주문상세서비스생성
	 * <PRE>
	 * 주문 상세 저장소 의존성을 주입합니다.
	 * </PRE>
	 * @MethodName: HmOrderDetailService
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public HmOrderDetailService(PhoneDetailRepository r) {
		detailRepo = r;
	}

	/**
	 * @name: 휴대폰주문상세조회
	 * <PRE>
	 * 휴대폰 식별자로 주문 상세 목록을 조회합니다.
	 * [DB-READ-03] derived repository query / TB_HM_PHONE_D
	 * </PRE>
	 * @MethodName: retrievePhoneOrderDetail
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
    public List<PhoneDetailDTO> retrievePhoneOrderDetail(PhoneReqDTO req) {
        List<PhoneDetailDTO> out = new ArrayList<>();
        for (PhoneDetailEntity e : detailRepo.findByPhoneId(req.getId()))
            out.add(new PhoneDetailDTO(e.getId(), e.getPhoneId()));
        return out;
    }

    /**
     * @name: 휴대폰주문상세저장
     * <PRE>[DB-WRITE-03] JpaRepository save / TB_HM_PHONE_D</PRE>
     * @MethodName: savePhoneOrderDetail
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public PhoneDetailEntity savePhoneOrderDetail(PhoneDetailEntity entity) {
        return detailRepo.save(entity);
    }

	/**
	 * @name: 주문상세고객정보반영
	 * <PRE>
	 * 각 주문 상세 DTO에 고객명을 반영합니다.
	 * </PRE>
	 * @MethodName: applyCustomerName
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public void applyCustomerName(List<PhoneDetailDTO> details, CustDTO customer) {
		for (PhoneDetailDTO d : details)
			d.setCustNm(customer.getCustNm());
	}
}
