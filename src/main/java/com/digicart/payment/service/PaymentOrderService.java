package com.digicart.payment.service;

import com.digicart.payment.dto.PaymentOrderRequest;
import com.digicart.payment.entity.PaymentOrder;
import com.digicart.payment.entity.PaymentStatus;
import com.digicart.payment.exception.EntityNotFoundException;
import com.digicart.payment.repository.PaymentOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Application service implementing payment order use cases for <em>payment-service</em>.
 */
@Service
public class PaymentOrderService {

    private final PaymentOrderRepository repository;

    /**
     * Creates a new {@code PaymentOrderService}.
     *
     * @param repository repository
     */
    public PaymentOrderService(PaymentOrderRepository repository) {
        this.repository = repository;
    }

    /**
     * Finds all.
     * @return matching records
     */
    public List<PaymentOrder> findAll() {
        return repository.findAll();
    }

    /**
     * Finds by id.
     *
     * @param id resource identifier
     * @return the payment order
     */
    public PaymentOrder findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PaymentOrder not found with id: " + id));
    }

    /**
     * Finds by razorpay order id.
     *
     * @param razorpayOrderId Razorpay order id
     * @return the payment order
     */
    public PaymentOrder findByRazorpayOrderId(String razorpayOrderId) {
        return repository.findByRazorpayOrderId(razorpayOrderId)
                .orElseThrow(() -> new EntityNotFoundException("PaymentOrder not found with razorpayOrderId: " + razorpayOrderId));
    }

    /**
     * Finds by store id.
     *
     * @param storeId store (tenant) identifier
     * @return matching records
     */
    public List<PaymentOrder> findByStoreId(String storeId) {
        return repository.findByStoreId(storeId);
    }

    /**
     * Finds by user id.
     *
     * @param userId caller user id from the gateway ({@code X-User-Id})
     * @return matching records
     */
    public List<PaymentOrder> findByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    /**
     * Finds by status.
     *
     * @param status status
     * @return matching records
     */
    public List<PaymentOrder> findByStatus(PaymentStatus status) {
        return repository.findByStatus(status);
    }

    /**
     * Creates a new record.
     *
     * @param request request payload
     * @return the payment order
     */
    public PaymentOrder create(PaymentOrderRequest request) {
        PaymentOrder order = new PaymentOrder();
        applyRequest(order, request);
        return repository.save(order);
    }

    /**
     * Updates an existing record.
     *
     * @param id resource identifier
     * @param request request payload
     * @return the payment order
     */
    public PaymentOrder update(String id, PaymentOrderRequest request) {
        PaymentOrder order = findById(id);
        applyRequest(order, request);
        return repository.save(order);
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

    private void applyRequest(PaymentOrder order, PaymentOrderRequest request) {
        if (request.getRazorpayOrderId() != null) order.setRazorpayOrderId(request.getRazorpayOrderId());
        if (request.getAmount() != null) order.setAmount(request.getAmount());
        if (request.getCurrency() != null) order.setCurrency(request.getCurrency());
        if (request.getType() != null) order.setType(request.getType());
        if (request.getReferenceId() != null) order.setReferenceId(request.getReferenceId());
        if (request.getStoreId() != null) order.setStoreId(request.getStoreId());
        if (request.getUserId() != null) order.setUserId(request.getUserId());
        if (request.getStatus() != null) order.setStatus(request.getStatus());
        if (request.getRazorpayPaymentId() != null) order.setRazorpayPaymentId(request.getRazorpayPaymentId());
    }
}
