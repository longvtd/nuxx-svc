package com.lguplus.nuxx.subcriber;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lguplus.nuxx.common.UtilConstants;
import com.lguplus.nuxx.dto.PhoneDTO;
import com.lguplus.nuxx.dto.event.PhoneCreateEvent;
import com.lguplus.nuxx.dto.event.PhoneDeleteEvent;
import com.lguplus.nuxx.dto.event.PhoneUpdateEvent;
import com.lguplus.nuxx.service.HmOrderService;
import com.lguplus.wafful.event.DomainEventHandlers;
import com.lguplus.wafful.event.DomainEventHandlersBuilder;
import com.lguplus.wafful.event.WaffulEventDispatcher;
import com.lguplus.wafful.event.WaffullEventDispatcherFactory;

/**
 * @name: Home order subscriber
 * <PRE>
 * 홈주문 도메인 이벤트 구독 설정.
 * 주문 생성/변경/삭제 이벤트를 HmOrderService로 위임합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : HmOrderSubcriber.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@Configuration
public class HmOrderSubcriber {
	private final HmOrderService service;
	private final String topicNm = "from_nuxx_order_event";

	/**
	 * @name: 홈주문구독자생성
	 * <PRE>
	 * 주문 서비스 의존성을 주입합니다.
	 * </PRE>
	 * @MethodName: HmOrderSubcriber
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public HmOrderSubcriber(HmOrderService s) {
		service = s;
	}

	/**
	 * @name: 주문이벤트디스패처생성
	 * <PRE>
	 * 주문 그룹으로 도메인 이벤트 디스패처를 생성합니다.
	 * </PRE>
	 * @MethodName: hmOrderEventDispatcher
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	@Bean
	public WaffulEventDispatcher hmOrderEventDispatcher(WaffullEventDispatcherFactory f) {
		return f.make(UtilConstants.GROUP_TOPIC_ORDER, domainEventHandlers());
	}

	/**
	 * @name: 주문이벤트핸들러등록
	 * <PRE>
	 * 주문 생성, 변경, 삭제 이벤트 핸들러를 등록합니다.
	 * </PRE>
	 * @MethodName: domainEventHandlers
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public DomainEventHandlers domainEventHandlers() {
		return DomainEventHandlersBuilder.forAggregateType(topicNm)
		        .onEvent(PhoneCreateEvent.class, this::handlerPhoneCreateEvent)
		        .onEvent(PhoneUpdateEvent.class, this::handlerPhoneUpdateEvent)
		        .onEvent(PhoneDeleteEvent.class, this::handlerPhoneDeleteEvent)
		        .build();
	}

	/**
	 * @name: 휴대폰주문생성이벤트처리
	 * <PRE>
	 * PhoneCreateEvent를 수신하여 휴대폰 주문 생성을 위임합니다.
	 * </PRE>
	 * @MethodName: handlerPhoneCreateEvent
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public void handlerPhoneCreateEvent(PhoneCreateEvent e) {
		service.createPhone(List.of(new PhoneDTO(e.getPhoneId(), "Y")));
	}

	/**
	 * @name: 휴대폰주문변경이벤트처리
	 * <PRE>
	 * PhoneUpdateEvent를 수신하여 휴대폰 주문 변경을 위임합니다.
	 * </PRE>
	 * @MethodName: handlerPhoneUpdateEvent
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public void handlerPhoneUpdateEvent(PhoneUpdateEvent e) {
		service.changePhone(List.of(new PhoneDTO(e.getPhoneId(), "Y")));
	}

	/**
	 * @name: 휴대폰주문삭제이벤트처리
	 * <PRE>
	 * PhoneDeleteEvent를 수신하여 사용여부 변경 처리를 위임합니다.
	 * </PRE>
	 * @MethodName: handlerPhoneDeleteEvent
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public void handlerPhoneDeleteEvent(PhoneDeleteEvent e) {
		service.changePhone(List.of(new PhoneDTO(e.getPhoneId(), "N")));
	}
}
