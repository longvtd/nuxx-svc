package com.lguplus.nuxx.subcriber;

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
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @name: Home order subscriber
 * <PRE>
 * 홈주문(NUXX) 주문 이벤트 수신
 * </PRE>
 * @author: Tester (tester@example.local)
 * @class  : HmOrderSubcriber.java
 * @Date   : 2026. 10. 01.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *     1.  2026. 10. 01.   09:00:00.        Tester.             Initial creation
 * </PRE>
 */
@Configuration
public class HmOrderSubcriber {

    private final HmOrderService serviceHm;
    private final String topicNm = "from_nuxx_order_event"; //홈주문 신규 주문 수집

    public HmOrderSubcriber(HmOrderService serviceHm) {
        this.serviceHm = serviceHm;
    }

    @Bean
    public WaffulEventDispatcher hmOrderEventDispatcher(WaffullEventDispatcherFactory wedf) {
        return wedf.make(UtilConstants.GROUP_TOPIC_ORDER, this.domainEventHandlers());
    }

    public DomainEventHandlers domainEventHandlers() {
        return DomainEventHandlersBuilder.forAggregateType(this.topicNm)
                .onEvent(PhoneCreateEvent.class, this::handlerPhoneCreateEvent)
                .onEvent(PhoneUpdateEvent.class, this::handlerPhoneUpdateEvent)
                .onEvent(PhoneDeleteEvent.class, this::handlerPhoneDeleteEvent)
                .build();
    }

    /**
     * @name: 휴대폰주문생성수신
     * <PRE>
     * 휴대폰 주문 생성 이벤트 수신 후 주문 생성
     * </PRE>
     * @MethodName: handlerPhoneCreateEvent
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public void handlerPhoneCreateEvent(PhoneCreateEvent event) {
        serviceHm.createPhone(List.of(new PhoneDTO(event.getPhoneId(), "Y")));
    }

    /**
     * @name: 휴대폰주문변경수신
     * <PRE>
     * 휴대폰 주문 변경 이벤트 수신 후 주문 변경
     * </PRE>
     * @MethodName: handlerPhoneUpdateEvent
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public void handlerPhoneUpdateEvent(PhoneUpdateEvent event) {
        serviceHm.changePhone(List.of(new PhoneDTO(event.getPhoneId(), "Y")));
    }

    /**
     * @name: 휴대폰주문삭제수신
     * <PRE>
     * 휴대폰 주문 삭제 이벤트 수신 후 사용여부 N 처리
     * </PRE>
     * @MethodName: handlerPhoneDeleteEvent
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public void handlerPhoneDeleteEvent(PhoneDeleteEvent event) {
        serviceHm.changePhone(List.of(new PhoneDTO(event.getPhoneId(), "N")));
    }
}
