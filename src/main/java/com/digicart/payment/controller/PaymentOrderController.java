package com.digicart.payment.controller;

import com.digicart.payment.dto.PaymentOrderRequest;
import com.digicart.payment.entity.PaymentOrder;
import com.digicart.payment.entity.PaymentStatus;
import com.digicart.payment.service.PaymentOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller exposing payment order HTTP APIs for <em>payment-service</em>.
 */
@RestController
@RequestMapping("/api/payment-orders")
public class PaymentOrderController {

    private final PaymentOrderService service;

    /**
     * Creates a new {@code PaymentOrderController}.
     *
     * @param service service
     */
    public PaymentOrderController(PaymentOrderService service) {
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
    public ResponseEntity<List<PaymentOrder>> findAll(
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
    public ResponseEntity<PaymentOrder> findById(
            @PathVariable String id,
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * Handles {@code GET /razorpay/{razorpayOrderId}}.
     *
     * @param razorpayOrderId Razorpay order id
     * @param userId caller user id from the gateway ({@code X-User-Id})
     * @param userRole caller role from the gateway ({@code X-User-Role})
     * @return HTTP response
     */
    @GetMapping("/razorpay/{razorpayOrderId}")
    public ResponseEntity<PaymentOrder> findByRazorpayOrderId(
            @PathVariable String razorpayOrderId,
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(service.findByRazorpayOrderId(razorpayOrderId));
    }

    /**
     * Handles {@code GET /store/{storeId}}.
     *
     * @param storeId store (tenant) identifier
     * @param userId caller user id from the gateway ({@code X-User-Id})
     * @param userRole caller role from the gateway ({@code X-User-Role})
     * @return HTTP response
     */
    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<PaymentOrder>> findByStoreId(
            @PathVariable String storeId,
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(service.findByStoreId(storeId));
    }

    /**
     * Handles {@code GET /user/{userId}}.
     *
     * @param userId caller user id from the gateway ({@code X-User-Id})
     * @param xUserId x user id
     * @param userRole caller role from the gateway ({@code X-User-Role})
     * @return HTTP response
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PaymentOrder>> findByUserId(
            @PathVariable String userId,
            @RequestHeader(value = "X-User-Id", required = false) String xUserId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(service.findByUserId(userId));
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
    public ResponseEntity<PaymentOrder> create(
            @RequestBody PaymentOrderRequest request,
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(service.create(request));
    }

    /**
     * Handles {@code PUT /{id}}.
     *
     * @param id resource identifier
     * @param request request payload
     * @param userId caller user id from the gateway ({@code X-User-Id})
     * @param userRole caller role from the gateway ({@code X-User-Role})
     * @return HTTP response
     */
    @PutMapping("/{id}")
    public ResponseEntity<PaymentOrder> update(
            @PathVariable String id,
            @RequestBody PaymentOrderRequest request,
            @RequestHeader(value = "X-User-Id", required = false) String userId,
            @RequestHeader(value = "X-User-Role", required = false) String userRole) {
        return ResponseEntity.ok(service.update(id, request));
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
