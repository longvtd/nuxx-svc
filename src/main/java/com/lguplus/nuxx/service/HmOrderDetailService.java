package com.lguplus.nuxx.service;

import com.lguplus.nuxx.dto.PhoneDetailDTO;
import com.lguplus.nuxx.dto.PhoneReqDTO;
import com.lguplus.nuxx.entity.PhoneDetailEntity;
import com.lguplus.nuxx.repository.PhoneDetailRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @name: Home order detail Service
 * <PRE>
 * 홈주문 휴대폰 주문 상세 서비스
 * </PRE>
 * @author: Tester (tester@example.local)
 * @class  : HmOrderDetailService.java
 * @Date   : 2026. 10. 01.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *     1.  2026. 10. 01.   09:00:00.        Tester.             Initial creation
 * </PRE>
 */
@Service
public class HmOrderDetailService {

    private final PhoneDetailRepository detailRepo;

    public HmOrderDetailService(PhoneDetailRepository detailRepo) {
        this.detailRepo = detailRepo;
    }

    /**
     * @name: 휴대폰주문상세조회
     * <PRE>
     * 휴대폰 주문 상세 목록 조회
     * </PRE>
     * @MethodName: retrievePhoneOrderDetail
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public List<PhoneDetailDTO> retrievePhoneOrderDetail(PhoneReqDTO dtoObj) {
        List<PhoneDetailDTO> result = new ArrayList<>();
        for (PhoneDetailEntity entity : detailRepo.findByPhoneId(dtoObj.getId())) {
            result.add(new PhoneDetailDTO(entity.getId(), entity.getPhoneId()));
        }
        return result;
    }
}
