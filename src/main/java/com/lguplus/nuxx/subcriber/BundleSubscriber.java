package com.lguplus.nuxx.subcriber;
import com.lguplus.wafful.event.DomainEventHandlers;
import com.lguplus.wafful.event.DomainEventHandlersBuilder;
import org.springframework.context.annotation.Configuration;
@Configuration
public class BundleSubscriber {
    public DomainEventHandlers handlers() {
        return DomainEventHandlersBuilder.forAggregateType("to_nuxx_bundle_event").onEvent(Object.class, this::receive).build();
    }
    public void receive(Object message) { }
}
