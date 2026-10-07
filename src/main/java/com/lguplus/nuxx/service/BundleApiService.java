package com.lguplus.nuxx.service;
import com.lguplus.wafful.framework.api.rest.WaffulRestTemplate;
import org.springframework.stereotype.Service;
@Service
public class BundleApiService {
    private final WaffulRestTemplate restTemplate;
    public BundleApiService(WaffulRestTemplate restTemplate) { this.restTemplate=restTemplate; }
    public String retrieveBundleInfo(String id) {
        return (String) restTemplate.get("{@nuxy-svc.api-selectCust-001}", new Object(), id);
    }
    public String retrieveBundleCode(String info, String code) {
        return (String) restTemplate.post("{@nuxz-svc.api-selectPoint-001}", new Object(), code);
    }
}
