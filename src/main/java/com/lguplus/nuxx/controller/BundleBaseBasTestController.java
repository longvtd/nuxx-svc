package com.lguplus.nuxx.controller;
import com.lguplus.nuxx.service.BundleBaseBasTestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BundleBaseBasTestController {
    private final BundleBaseBasTestService service;
    public BundleBaseBasTestController(BundleBaseBasTestService service) { this.service=service; }
    public String oldMethod() { return service.oldMethod(); }
}
