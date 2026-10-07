package com.lguplus.wafful.event;
import org.springframework.stereotype.Component;
@Component
public class BundleMessagePublisher {
    public static final String TOPIC_BUNDLE = "to_nuxx_bundle_event";
    private final WaffulEventPublisher publisher;
    public BundleMessagePublisher(WaffulEventPublisher publisher) { this.publisher=publisher; }
    public void publishBundle(Object message, String key) { publisher.publish(TOPIC_BUNDLE, key, message); }
}
