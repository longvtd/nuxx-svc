package com.lguplus.nuxx.subcriber;

import java.util.*;
import org.springframework.context.annotation.*;
import com.lguplus.nuxx.common.UtilConstants;
import com.lguplus.nuxx.dto.PhoneDTO;
import com.lguplus.nuxx.dto.event.*;
import com.lguplus.nuxx.service.HmOrderService;
import com.lguplus.wafful.event.*;

@Configuration
public class HmOrderSubcriber {
	private final HmOrderService service;
	private final String topicNm = "from_nuxx_order_event";

	public HmOrderSubcriber(HmOrderService s) {
		service = s;
	}

	@Bean
	public WaffulEventDispatcher hmOrderEventDispatcher(WaffullEventDispatcherFactory f) {
		return f.make(UtilConstants.GROUP_TOPIC_ORDER, domainEventHandlers());
	}

	public DomainEventHandlers domainEventHandlers() {
		return DomainEventHandlersBuilder.forAggregateType(topicNm)
		        .onEvent(PhoneCreateEvent.class, this::handlerPhoneCreateEvent)
		        .onEvent(PhoneUpdateEvent.class, this::handlerPhoneUpdateEvent)
		        .onEvent(PhoneDeleteEvent.class, this::handlerPhoneDeleteEvent).build();
	}

	public void handlerPhoneCreateEvent(PhoneCreateEvent e) {
		service.createPhone(List.of(new PhoneDTO(e.getPhoneId(), "Y")));
	}

	public void handlerPhoneUpdateEvent(PhoneUpdateEvent e) {
		service.changePhone(List.of(new PhoneDTO(e.getPhoneId(), "Y")));
	}

	public void handlerPhoneDeleteEvent(PhoneDeleteEvent e) {
		service.changePhone(List.of(new PhoneDTO(e.getPhoneId(), "N")));
	}
}