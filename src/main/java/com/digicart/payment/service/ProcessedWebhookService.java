package com.digicart.payment.service;

import com.digicart.payment.dto.ProcessedWebhookRequest;
import com.digicart.payment.entity.ProcessedWebhook;
import com.digicart.payment.exception.EntityNotFoundException;
import com.digicart.payment.repository.ProcessedWebhookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessedWebhookService {

    private final ProcessedWebhookRepository repository;

    public ProcessedWebhookService(ProcessedWebhookRepository repository) {
        this.repository = repository;
    }

    public List<ProcessedWebhook> findAll() {
        return repository.findAll();
    }

    public ProcessedWebhook findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ProcessedWebhook not found with id: " + id));
    }

    public boolean existsById(String id) {
        return repository.existsById(id);
    }

    public ProcessedWebhook create(ProcessedWebhookRequest request) {
        ProcessedWebhook webhook = new ProcessedWebhook();
        webhook.setId(request.getId());
        webhook.setEventType(request.getEventType());
        return repository.save(webhook);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }
}
