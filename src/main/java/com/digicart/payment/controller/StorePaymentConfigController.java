package com.digicart.payment.controller;

import com.digicart.payment.dto.StorePaymentConfigRequest;
import com.digicart.payment.entity.StorePaymentConfig;
import com.digicart.payment.service.StorePaymentConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store-payment-config")
public class StorePaymentConfigController {

    private final StorePaymentConfigService service;

    public StorePaymentConfigController(StorePaymentConfigService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<StorePaymentConfig>> findAll(
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StorePaymentConfig> findById(
            @PathVariable String id,
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<StorePaymentConfig> findByStoreId(
            @PathVariable String storeId,
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(service.findByStoreId(storeId));
    }

    @PostMapping
    public ResponseEntity<StorePaymentConfig> create(
            @RequestBody StorePaymentConfigRequest request,
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StorePaymentConfig> update(
            @PathVariable String id,
            @RequestBody StorePaymentConfigRequest request,
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
