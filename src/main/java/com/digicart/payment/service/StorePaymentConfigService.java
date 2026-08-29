package com.digicart.payment.service;

import com.digicart.payment.dto.StorePaymentConfigRequest;
import com.digicart.payment.entity.StorePaymentConfig;
import com.digicart.payment.exception.EntityNotFoundException;
import com.digicart.payment.repository.StorePaymentConfigRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Application service implementing store payment config use cases for <em>payment-service</em>.
 */
@Service
public class StorePaymentConfigService {

    private final StorePaymentConfigRepository repository;

    public StorePaymentConfigService(StorePaymentConfigRepository repository) {
        this.repository = repository;
    }

    public List<StorePaymentConfig> findAll() {
        return repository.findAll();
    }

    public StorePaymentConfig findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("StorePaymentConfig not found with id: " + id));
    }

    public StorePaymentConfig findByStoreId(String storeId) {
        return repository.findByStoreId(storeId)
                .orElseThrow(() -> new EntityNotFoundException("StorePaymentConfig not found for storeId: " + storeId));
    }

    public StorePaymentConfig create(StorePaymentConfigRequest request) {
        StorePaymentConfig config = new StorePaymentConfig();
        applyRequest(config, request);
        return repository.save(config);
    }

    public StorePaymentConfig update(String id, StorePaymentConfigRequest request) {
        StorePaymentConfig config = findById(id);
        applyRequest(config, request);
        return repository.save(config);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    private void applyRequest(StorePaymentConfig config, StorePaymentConfigRequest request) {
        if (request.getStoreId() != null) config.setStoreId(request.getStoreId());
        if (request.getRazorpayKeyId() != null) config.setRazorpayKeyId(request.getRazorpayKeyId());
        if (request.getRazorpayKeySecret() != null) config.setRazorpayKeySecret(request.getRazorpayKeySecret());
        if (request.getEnabled() != null) config.setEnabled(request.getEnabled());
        if (request.getOnlineMode() != null) config.setOnlineMode(request.getOnlineMode());
        if (request.getRouteAccountId() != null) config.setRouteAccountId(request.getRouteAccountId());
        if (request.getKycStatus() != null) config.setKycStatus(request.getKycStatus());
    }
}
