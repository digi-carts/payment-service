package com.digicart.payment.controller;

import com.digicart.payment.dto.ProcessedWebhookRequest;
import com.digicart.payment.entity.ProcessedWebhook;
import com.digicart.payment.service.ProcessedWebhookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * REST controller exposing processed webhook HTTP APIs for <em>payment-service</em>.
 */
@RestController
@RequestMapping("/api/processed-webhooks")
public class ProcessedWebhookController {

    private final ProcessedWebhookService service;

    /**
     * Creates a new {@code ProcessedWebhookController}.
     *
     * @param service service
     */
    public ProcessedWebhookController(ProcessedWebhookService service) {
        this.service = service;
    }

    /**
     * Handles GET.
     *
     * @param userId caller user id from the gateway ({@code X-User-Id})
     * @param userRole caller role from the gateway ({@code X-User-Role})
     * @return HTTP response
     */
    @GetMapping
    public ResponseEntity<List<ProcessedWebhook>> findAll(
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Handles {@code GET /{id}}.
     *
     * @param id resource identifier
     * @param userId caller user id from the gateway ({@code X-User-Id})
     * @param userRole caller role from the gateway ({@code X-User-Role})
     * @return HTTP response
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProcessedWebhook> findById(
            @PathVariable String id,
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * Handles {@code GET /{id}/exists}.
     *
     * @param id resource identifier
     * @param userId caller user id from the gateway ({@code X-User-Id})
     * @param userRole caller role from the gateway ({@code X-User-Role})
     * @return HTTP response
     */
    @GetMapping("/{id}/exists")
    public ResponseEntity<Map<String, Boolean>> existsById(
            @PathVariable String id,
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(Map.of("exists", service.existsById(id)));
    }

    /**
     * Handles POST.
     *
     * @param request request payload
     * @param userId caller user id from the gateway ({@code X-User-Id})
     * @param userRole caller role from the gateway ({@code X-User-Role})
     * @return HTTP response
     */
    @PostMapping
    public ResponseEntity<ProcessedWebhook> create(
            @RequestBody ProcessedWebhookRequest request,
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(service.create(request));
    }

    /**
     * Handles {@code DELETE /{id}}.
     *
     * @param id resource identifier
     * @param userId caller user id from the gateway ({@code X-User-Id})
     * @param userRole caller role from the gateway ({@code X-User-Role})
     * @return HTTP response
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id,
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
