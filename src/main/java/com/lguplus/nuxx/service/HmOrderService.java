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
 * 홈주문 휴대폰 주문 서비스.
 * 주문 조회/저장, 고객 연계, Kafka 이벤트 및 메시지 발행을 담당합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : HmOrderService.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@Service
@Transactional
public class HmOrderService {
	private final HmOrderRepository repoHmOrder;
	private final HmOrderNativeQueryRepository nativeRepo;
	private final HmOrderDetailService detailService;
	private final HmCustClientService custClient;
	private final WaffulEventPublisher pubEvent;
	private final WaffulMessageProducer producer;

	/**
	 * @name: 홈주문서비스생성
	 * <PRE>
	 * 주문 저장소, 상세 서비스, 고객 클라이언트, 이벤트 발행자와 메시지 생산자를 주입합니다.
	 * </PRE>
	 * @MethodName: HmOrderService
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public HmOrderService(HmOrderRepository r, HmOrderNativeQueryRepository n, HmOrderDetailService d,
	        HmCustClientService c, WaffulEventPublisher p, WaffulMessageProducer m) {
		repoHmOrder = r;
		nativeRepo = n;
		detailService = d;
		custClient = c;
		pubEvent = p;
		producer = m;
	}

	/**
	 * @name: 휴대폰주문목록조회
	 * <PRE>
	 * 요청 DTO 식별자로 휴대폰 주문 목록을 조회합니다.
     * [DB-READ-01] JpaRepository findAllById / TB_HM_PHONE_M
	 * </PRE>
	 * @MethodName: retrievePhone
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public List<PhoneDTO> retrievePhone(PhoneReqDTO req) {
		return PhoneDTO.fromEntities(repoHmOrder.findAllById(List.of(req.getId())));
	}

	/**
	 * @name: 휴대폰주문단건조회
	 * <PRE>
	 * 휴대폰 식별자로 주문 정보를 조회합니다.
     * [DB-READ-01] JpaRepository findAllById / TB_HM_PHONE_M
	 * </PRE>
	 * @MethodName: retrievePhone
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public List<PhoneDTO> retrievePhone(String id) {
		return PhoneDTO.fromEntities(repoHmOrder.findAllById(List.of(id)));
	}

	/**
	 * @name: 휴대폰주문저장
	 * <PRE>
	 * 주문 검증 후 고객 조회와 상세 보강을 수행하고 후속 알림을 발행합니다.
	 * </PRE>
	 * @MethodName: savePhone
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public void savePhone(PhoneReqDTO req) {
		List<PhoneDTO> phones = retrievePhone(req);
		if (!isValidation(phones))
			return;
		List<PhoneDetailDTO> details = detailService.retrievePhoneOrderDetail(req);
		CustDTO cust = custClient.selectCustProfile(req.getId());
		detailService.applyCustomerName(details, cust);
		String result = createPhone(phones);
		if ("ok".equals(result)) {
			createPhoneTbEvent(phones.get(0));
			publishCustNotice(phones.get(0));
		}
		sentSms(new SmsDTO(req.getId(), details.size()));
	}

	/**
	 * @name: 휴대폰주문검증
	 * <PRE>
	 * 휴대폰 주문 목록이 비어 있지 않은지 검증합니다.
	 * </PRE>
	 * @MethodName: isValidation
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public boolean isValidation(List<PhoneDTO> values) {
		return values != null && !values.isEmpty();
	}

	/**
	 * @name: 휴대폰주문생성
	 * <PRE>
	 * [DB-READ-02] EntityManager native SELECT / TB_HM_PHONE_M
	 * [DB-WRITE-01] JpaRepository save / TB_HM_PHONE_M
	 * 주문 이름을 조회한 뒤 휴대폰 주문을 저장합니다.
	 * </PRE>
	 * @MethodName: createPhone
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public String createPhone(List<PhoneDTO> values) {
		PhoneEntity entity = values.get(0).toEntity();
		entity.setName(nativeRepo.selectPhoneName(entity.getId()));
		repoHmOrder.save(entity);
		return "ok";
	}

	/**
	 * @name: 휴대폰주문변경
	 * <PRE>
	 * 고객 External API 응답으로 주문 이름과 사용 여부를 native UPDATE로 반영합니다.
	 * [DB-WRITE-02] HmOrderRepositoryCustom.updatePhoneName / TB_HM_PHONE_M
	 * [DB-WRITE-02] EntityManager native UPDATE / TB_HM_PHONE_M
	 * </PRE>
	 * @MethodName: changePhone
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public String changePhone(List<PhoneDTO> values) {
		PhoneEntity e = values.get(0).toEntity();
        CustDTO c = custClient.selectCustByApim(values.get(0).getId());
        e.setName(c.getCustNm());
        repoHmOrder.updatePhoneName(e.getId(), e.getName());
        nativeRepo.updatePhoneUseYn(e.getId(), e.getUseYn());
        return "ok";
    }

    /**
     * @name: 휴대폰주문요약조회
     * <PRE>[DB-JOIN-01] native SELECT JOIN / TB_HM_PHONE_M, TB_HM_PHONE_D, TB_HM_CUST_ORDER_M</PRE>
     * @MethodName: retrieveOrderSummary
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public List<?> retrieveOrderSummary(String phoneId) {
        return nativeRepo.selectPhoneOrderSummary(phoneId);
    }

	/**
	 * @name: 휴대폰주문레거시조회
	 * <PRE>
	 * 레거시 식별자 경로로 휴대폰 주문을 조회합니다.
	 * [DB-READ-01] repository read
	 * </PRE>
	 * @MethodName: retrievePhoneLegacy
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public List<PhoneDTO> retrievePhoneLegacy(String id) {
		return PhoneDTO.fromEntities(repoHmOrder.findAllById(List.of(id)));
	}

	/**
	 * @name: 휴대폰주문생성이벤트발행
	 * <PRE>
	 * [KAFKA-01] event publisher
	 * 휴대폰 주문 생성 이벤트를 주문 연계 토픽으로 발행합니다.
	 * </PRE>
	 * @MethodName: createPhoneTbEvent
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public void createPhoneTbEvent(PhoneDTO p) {
		pubEvent.publish(UtilConstants.TOPIC_PHONE_TB, p.getId(), new PhoneCreateEvent(p.getId()));
	}

	/**
	 * @name: SMS발송
	 * <PRE>
	 * [KAFKA-01] event publisher
	 * SMS 발송 메시지를 SMS 토픽으로 전송합니다.
	 * </PRE>
	 * @MethodName: sentSms
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public void sentSms(SmsDTO s) {
		producer.send(UtilConstants.TOPIC_SMS, s.getId(), s);
	}

	/**
	 * @name: 고객주문알림발행
	 * <PRE>
	 * [KAFKA-01] event publisher
	 * 고객 주문 알림 이벤트를 고객 연계 토픽으로 발행합니다.
	 * </PRE>
	 * @MethodName: publishCustNotice
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public void publishCustNotice(PhoneDTO p) {
		pubEvent.publish(UtilConstants.TOPIC_CUST, p.getId(), new PhoneCreateEvent(p.getId()));
	}

	/**
	 * @name: 포인트알림발송
	 * <PRE>
	 * [KAFKA-01] event publisher
	 * 포인트 알림 메시지를 포인트 토픽으로 전송합니다.
	 * </PRE>
	 * @MethodName: sendPointNotice
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public void sendPointNotice(SmsDTO s) {
		producer.send(UtilConstants.TOPIC_POINT, s.getId(), s);
	}
}
