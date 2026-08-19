package com.digicart.payment.service;

import com.digicart.payment.dto.PlatformPaymentConfigRequest;
import com.digicart.payment.entity.PlatformPaymentConfig;
import com.digicart.payment.exception.EntityNotFoundException;
import com.digicart.payment.repository.PlatformPaymentConfigRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Application service implementing platform payment config use cases for <em>payment-service</em>.
 */
@Service
public class PlatformPaymentConfigService {

    private final PlatformPaymentConfigRepository repository;

    /**
     * Creates a new {@code PlatformPaymentConfigService}.
     *
     * @param repository repository
     */
    public PlatformPaymentConfigService(PlatformPaymentConfigRepository repository) {
        this.repository = repository;
    }

    /**
     * Finds all.
     * @return matching records
     */
    public List<PlatformPaymentConfig> findAll() {
        return repository.findAll();
    }

    /**
     * Finds by id.
     *
     * @param id resource identifier
     * @return the platform payment config
     */
    public PlatformPaymentConfig findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PlatformPaymentConfig not found with id: " + id));
    }

    /**
     * Returns global.
     * @return the platform payment config
     */
    public PlatformPaymentConfig getGlobal() {
        return repository.findById("global")
                .orElseThrow(() -> new EntityNotFoundException("Global PlatformPaymentConfig not found"));
    }

    /**
     * Creates a new record.
     *
     * @param request request payload
     * @return the platform payment config
     */
    public PlatformPaymentConfig create(PlatformPaymentConfigRequest request) {
        PlatformPaymentConfig config = new PlatformPaymentConfig();
        applyRequest(config, request);
        return repository.save(config);
    }

    /**
     * Updates an existing record.
     *
     * @param id resource identifier
     * @param request request payload
     * @return the platform payment config
     */
    public PlatformPaymentConfig update(String id, PlatformPaymentConfigRequest request) {
        PlatformPaymentConfig config = findById(id);
        applyRequest(config, request);
        return repository.save(config);
    }

    /**
     * Deletes the record.
     *
     * @param id resource identifier
     */
    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    private void applyRequest(PlatformPaymentConfig config, PlatformPaymentConfigRequest request) {
        if (request.getRazorpayKeyId() != null) config.setRazorpayKeyId(request.getRazorpayKeyId());
        if (request.getRazorpayKeySecret() != null) config.setRazorpayKeySecret(request.getRazorpayKeySecret());
        if (request.getEnabled() != null) config.setEnabled(request.getEnabled());
        if (request.getRouteEnabled() != null) config.setRouteEnabled(request.getRouteEnabled());
        if (request.getDefaultPlatformFeePercent() != null) config.setDefaultPlatformFeePercent(request.getDefaultPlatformFeePercent());
        if (request.getWebhookSecret() != null) config.setWebhookSecret(request.getWebhookSecret());
    }
}
