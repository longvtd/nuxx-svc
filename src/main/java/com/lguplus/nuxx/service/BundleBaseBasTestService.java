package com.lguplus.nuxx.service;
import com.lguplus.nuxx.repository.BundleBaseRepository;
import com.lguplus.nuxx.entity.BundleBaseEntity;
import com.lguplus.wafful.event.BundleMessagePublisher;
import org.springframework.stereotype.Service;
@Service
public class BundleBaseBasTestService {
    private final BundleApiService bundleApiService;
    private final BundleBaseRepository bundleBaseRepository;
    private final BundleMessagePublisher bundleMessagePublisher;
    public BundleBaseBasTestService(BundleApiService api, BundleBaseRepository repository, BundleMessagePublisher publisher) {
        bundleApiService=api; bundleBaseRepository=repository; bundleMessagePublisher=publisher;
    }
    public String oldMethod() { return "baseline"; }
}
