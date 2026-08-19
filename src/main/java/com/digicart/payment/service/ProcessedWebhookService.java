package com.digicart.payment.service;

import com.digicart.payment.dto.ProcessedWebhookRequest;
import com.digicart.payment.entity.ProcessedWebhook;
import com.digicart.payment.exception.EntityNotFoundException;
import com.digicart.payment.repository.ProcessedWebhookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Application service implementing processed webhook use cases for <em>payment-service</em>.
 */
@Service
public class ProcessedWebhookService {

    private final ProcessedWebhookRepository repository;

    /**
     * Creates a new {@code ProcessedWebhookService}.
     *
     * @param repository repository
     */
    public ProcessedWebhookService(ProcessedWebhookRepository repository) {
        this.repository = repository;
    }

    /**
     * Finds all.
     * @return matching records
     */
    public List<ProcessedWebhook> findAll() {
        return repository.findAll();
    }

    /**
     * Finds by id.
     *
     * @param id resource identifier
     * @return the processed webhook
     */
    public ProcessedWebhook findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ProcessedWebhook not found with id: " + id));
    }

    /**
     * Returns whether by id exists.
     *
     * @param id resource identifier
     * @return the boolean
     */
    public boolean existsById(String id) {
        return repository.existsById(id);
    }

    /**
     * Creates a new record.
     *
     * @param request request payload
     * @return the processed webhook
     */
    public ProcessedWebhook create(ProcessedWebhookRequest request) {
        ProcessedWebhook webhook = new ProcessedWebhook();
        webhook.setId(request.getId());
        webhook.setEventType(request.getEventType());
        return repository.save(webhook);
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
}
