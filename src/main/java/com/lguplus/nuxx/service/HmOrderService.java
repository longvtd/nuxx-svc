package com.lguplus.nuxx.service;

import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lguplus.nuxx.common.UtilConstants;
import com.lguplus.nuxx.dto.*;
import com.lguplus.nuxx.dto.event.PhoneCreateEvent;
import com.lguplus.nuxx.entity.PhoneEntity;
import com.lguplus.nuxx.repository.*;
import com.lguplus.wafful.event.WaffulEventPublisher;
import com.lguplus.wafful.message.WaffulMessageProducer;

/**
 * @name: Home order Service
 * 
 *        <PRE>
 * 홈주문 휴대폰 주문 서비스
 *        </PRE>
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

	public HmOrderService(HmOrderRepository r, HmOrderNativeQueryRepository n, HmOrderDetailService d,
	        HmCustClientService c, WaffulEventPublisher p, WaffulMessageProducer m) {
		repoHmOrder = r;
		nativeRepo = n;
		detailService = d;
		custClient = c;
		pubEvent = p;
		producer = m;
	}

	/** @name: 휴대폰주문목록조회 */
	public List<PhoneDTO> retrievePhone(PhoneReqDTO req) {
		return PhoneDTO.fromEntities(repoHmOrder.findAllById(List.of(req.getId())));
	}

	/** @name: 휴대폰주문단건조회 */
	public List<PhoneDTO> retrievePhone(String id) {
		return PhoneDTO.fromEntities(repoHmOrder.findAllById(List.of(id)));
	}

	/** @name: 휴대폰주문저장 */
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

	/** @name: 휴대폰주문검증 */
	public boolean isValidation(List<PhoneDTO> values) {
		return values != null && !values.isEmpty();
	}

	/** @name: 휴대폰주문생성 */
	public String createPhone(List<PhoneDTO> values) {
		PhoneEntity entity = values.get(0).toEntity();
		entity.setName(nativeRepo.selectPhoneName(entity.getId()));
		repoHmOrder.save(entity);
		return "ok";
	}

	/** @name: 휴대폰주문변경 */
	public String changePhone(List<PhoneDTO> values) {
		PhoneEntity e = values.get(0).toEntity();
		CustDTO c = custClient.selectCustByApim(values.get(0).getId());
		e.setName(c.getCustNm());
		repoHmOrder.save(e);
		return "ok";
	}

	/** @name: 휴대폰주문레거시조회 */
	public List<PhoneDTO> retrievePhoneLegacy(String id) {
		return PhoneDTO.fromEntities(repoHmOrder.findAllById(List.of(id)));
	}

	/** @name: 휴대폰주문생성이벤트발행 */
	public void createPhoneTbEvent(PhoneDTO p) {
		pubEvent.publish(UtilConstants.TOPIC_PHONE_TB, p.getId(), new PhoneCreateEvent(p.getId()));
	}

	/** @name: SMS발송 */
	public void sentSms(SmsDTO s) {
		producer.send(UtilConstants.TOPIC_SMS, s.getId(), s);
	}

	/** @name: 고객주문알림발행 */
	public void publishCustNotice(PhoneDTO p) {
		pubEvent.publish(UtilConstants.TOPIC_CUST, p.getId(), new PhoneCreateEvent(p.getId()));
	}

	/** @name: 포인트알림발송 */
	public void sendPointNotice(SmsDTO s) {
		producer.send(UtilConstants.TOPIC_POINT, s.getId(), s);
	}
}
