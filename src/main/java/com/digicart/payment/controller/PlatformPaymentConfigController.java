package com.digicart.payment.controller;

import com.digicart.payment.dto.PlatformPaymentConfigRequest;
import com.digicart.payment.entity.PlatformPaymentConfig;
import com.digicart.payment.service.PlatformPaymentConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platform-payment-config")
public class PlatformPaymentConfigController {

    private final PlatformPaymentConfigService service;

    public PlatformPaymentConfigController(PlatformPaymentConfigService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PlatformPaymentConfig>> findAll(
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/global")
    public ResponseEntity<PlatformPaymentConfig> getGlobal(
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(service.getGlobal());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatformPaymentConfig> findById(
            @PathVariable String id,
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<PlatformPaymentConfig> create(
            @RequestBody PlatformPaymentConfigRequest request,
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlatformPaymentConfig> update(
            @PathVariable String id,
            @RequestBody PlatformPaymentConfigRequest request,
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id,
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
