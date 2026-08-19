package com.digicart.payment.service;

import com.digicart.payment.dto.PaymentOrderRequest;
import com.digicart.payment.entity.PaymentOrder;
import com.digicart.payment.entity.PaymentStatus;
import com.digicart.payment.exception.EntityNotFoundException;
import com.digicart.payment.repository.PaymentOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentOrderService {

    private final PaymentOrderRepository repository;

    public PaymentOrderService(PaymentOrderRepository repository) {
        this.repository = repository;
    }

    public List<PaymentOrder> findAll() {
        return repository.findAll();
    }

    public PaymentOrder findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PaymentOrder not found with id: " + id));
    }

    public PaymentOrder findByRazorpayOrderId(String razorpayOrderId) {
        return repository.findByRazorpayOrderId(razorpayOrderId)
                .orElseThrow(() -> new EntityNotFoundException("PaymentOrder not found with razorpayOrderId: " + razorpayOrderId));
    }

    public List<PaymentOrder> findByStoreId(String storeId) {
        return repository.findByStoreId(storeId);
    }

    public List<PaymentOrder> findByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    public List<PaymentOrder> findByStatus(PaymentStatus status) {
        return repository.findByStatus(status);
    }

    public PaymentOrder create(PaymentOrderRequest request) {
        PaymentOrder order = new PaymentOrder();
        applyRequest(order, request);
        return repository.save(order);
    }

    public PaymentOrder update(String id, PaymentOrderRequest request) {
        PaymentOrder order = findById(id);
        applyRequest(order, request);
        return repository.save(order);
    }

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
