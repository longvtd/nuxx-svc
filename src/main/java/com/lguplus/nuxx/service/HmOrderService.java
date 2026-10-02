package com.lguplus.nuxx.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lguplus.nuxx.common.UtilConstants;
import com.lguplus.nuxx.dto.CustDTO;
import com.lguplus.nuxx.dto.PhoneDTO;
import com.lguplus.nuxx.dto.PhoneDetailDTO;
import com.lguplus.nuxx.dto.PhoneReqDTO;
import com.lguplus.nuxx.dto.SmsDTO;
import com.lguplus.nuxx.dto.event.PhoneCreateEvent;
import com.lguplus.nuxx.entity.PhoneEntity;
import com.lguplus.nuxx.repository.HmOrderNativeQueryRepository;
import com.lguplus.nuxx.repository.HmOrderRepository;
import com.lguplus.wafful.event.WaffulEventPublisher;
import com.lguplus.wafful.message.WaffulMessageProducer;

/**
 * @name: Home order Service
 * <PRE>
 * 홈주문 휴대폰 주문 서비스
 * </PRE>
 * @author: Tester (tester@example.local)
 * @class  : HmOrderService.java
 * @Date   : 2026. 10. 01.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *     1.  2026. 10. 01.   09:00:00.        Tester.             Initial creation
 * </PRE>
 */
@Service
@Transactional
public class HmOrderService {

    private final HmOrderRepository repoHmOrder;
    private final HmOrderNativeQueryRepository nativeRepo;
    private final HmOrderDetailService hmOrderDetailService;
    private final HmCustClientService hmCustClientService;
    private final WaffulEventPublisher pubEvent;
    private final WaffulMessageProducer waffulMessageProducer;

    public HmOrderService(HmOrderRepository repoHmOrder, HmOrderNativeQueryRepository nativeRepo,
    		HmOrderDetailService hmOrderDetailService, HmCustClientService hmCustClientService,
            WaffulEventPublisher pubEvent,
            WaffulMessageProducer waffulMessageProducer) {
        this.repoHmOrder = repoHmOrder;
        this.nativeRepo = nativeRepo;
        this.hmOrderDetailService = hmOrderDetailService;
        this.pubEvent = pubEvent;
        this.waffulMessageProducer = waffulMessageProducer;
        this.hmCustClientService = hmCustClientService;
    }

    /**
     * @name: 휴대폰주문목록조회
     * <PRE>
     * 요청 조건으로 휴대폰 주문 목록 조회
     * </PRE>
     * @MethodName: retrievePhone
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public List<PhoneDTO> retrievePhone(PhoneReqDTO dtoObj) {
        return PhoneDTO.fromEntities(this.repoHmOrder.findAllById(List.of(dtoObj.getId())));
    }

    /**
     * @name: 휴대폰주문단건조회
     * <PRE>
     * 휴대폰 주문 ID로 단건 조회 (overload)
     * </PRE>
     * @MethodName: retrievePhone
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public List<PhoneDTO> retrievePhone(String phoneId) {
        return PhoneDTO.fromEntities(this.repoHmOrder.findAllById(List.of(phoneId)));
    }

    /**
     * @name: 휴대폰주문저장
     * <PRE>
     * 휴대폰 주문 저장 후 생성 이벤트 발행 및 SMS 발송
     * </PRE>
     * @MethodName: savePhone
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public void savePhone(PhoneReqDTO dtoObj) {
        List<PhoneDTO> listPhone = retrievePhone(dtoObj);
        boolean chk = this.isValidation(listPhone);
        if (!chk) {
            return;
        }
        List<PhoneDetailDTO> listDetail = hmOrderDetailService.retrievePhoneOrderDetail(dtoObj);
        CustDTO custDTO = hmCustClientService.selectCustByApim(dtoObj.getId()); //select customer info
        hmOrderDetailService.applyCustomerName(listDetail, custDTO);
        String rslt = createPhone(listPhone);
        if ("ok".equals(rslt)) {
            createPhoneTbEvent(listPhone.get(0));
            publishCustNotice(listPhone.get(0));
        }
        this.sentSms(new SmsDTO(dtoObj.getId(), listDetail.size()));
    }

    /**
     * @name: 휴대폰주문검증
     * <PRE>
     * 휴대폰 주문 목록 유효성 검증
     * </PRE>
     * @MethodName: isValidation
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public boolean isValidation(List<PhoneDTO> listPhone) {
        return listPhone != null && !listPhone.isEmpty();
    }

    /**
     * @name: 휴대폰주문생성
     * <PRE>
     * 휴대폰 주문 엔티티 생성 및 저장
     * </PRE>
     * @MethodName: createPhone
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public String createPhone(List<PhoneDTO> listPhone) {
        PhoneEntity phoneEntity = listPhone.get(0).toEntity();
        phoneEntity.setName(nativeRepo.selectPhoneName(phoneEntity.getId()));
        repoHmOrder.save(phoneEntity);
        return "ok";
    }

    /**
     * @name: 휴대폰주문변경
     * <PRE>
     * 휴대폰 주문 정보 변경
     * </PRE>
     * @MethodName: changePhone
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public String changePhone(List<PhoneDTO> listPhone) {
        PhoneEntity phoneEntity = listPhone.get(0).toEntity();
        CustDTO custDTO = hmCustClientService.selectCustByApim(listPhone.get(0).getId()); //select customer info
        phoneEntity.setName(custDTO.getCustNm());
        repoHmOrder.save(phoneEntity);
        return "ok";
    }

    /**
     * @name: 휴대폰주문레거시조회
     * <PRE>
     * 레거시 휴대폰 주문 조회 (S03에서 삭제 예정)
     * </PRE>
     * @MethodName: retrievePhoneLegacy
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public List<PhoneDTO> retrievePhoneLegacy(String phoneId) {
        return PhoneDTO.fromEntities(this.repoHmOrder.findAllById(List.of(phoneId)));
    }

    /**
     * @name: 휴대폰주문생성이벤트발행
     * <PRE>
     * 휴대폰 주문 생성 이벤트를 Kafka로 발행
     * </PRE>
     * @MethodName: createPhoneTbEvent
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public void createPhoneTbEvent(PhoneDTO phone) {
        PhoneCreateEvent event = new PhoneCreateEvent(phone.getId());
        pubEvent.publish(UtilConstants.TOPIC_PHONE_TB, phone.getId(), event);
    }

    /**
     * @name: SMS발송
     * <PRE>
     * SMS 발송 메시지를 Kafka로 전송
     * </PRE>
     * @MethodName: sentSms
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public void sentSms(SmsDTO smsDto) {
        waffulMessageProducer.send(UtilConstants.TOPIC_SMS, smsDto.getId(), smsDto);
    }
    /**
     * @name: 고객주문알림발행
     * <PRE>
     * [K-04] 고객 도메인으로 주문 알림 발행 (pattern -> NUXY-SVC)
     * </PRE>
     * @MethodName: publishCustNotice
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public void publishCustNotice(PhoneDTO phone) {
        pubEvent.publish(UtilConstants.TOPIC_CUST, phone.getId(), new PhoneCreateEvent(phone.getId()));
    }

    /**
     * @name: 포인트알림발송
     * <PRE>
     * [K-05] 미등록 도메인 코드 토픽 (TOPIC_DOMAIN_UNMAPPED)
     * </PRE>
     * @MethodName: sendPointNotice
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public void sendPointNotice(SmsDTO smsDto) {
        waffulMessageProducer.send(UtilConstants.TOPIC_POINT, smsDto.getId(), smsDto);
    }
}
