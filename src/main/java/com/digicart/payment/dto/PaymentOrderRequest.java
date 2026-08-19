package com.digicart.payment.dto;

import com.digicart.payment.entity.PaymentType;
import com.digicart.payment.entity.PaymentStatus;
import jakarta.validation.constraints.NotNull;

public class PaymentOrderRequest {
    @NotNull
    private String razorpayOrderId;
    @NotNull
    private Integer amount;
    private String currency = "INR";
    @NotNull
    private PaymentType type;
    @NotNull
    private String referenceId;
    private String storeId;
    private String userId;
    private PaymentStatus status;
    private String razorpayPaymentId;

    public String getRazorpayOrderId() { return razorpayOrderId; }
    public void setRazorpayOrderId(String razorpayOrderId) { this.razorpayOrderId = razorpayOrderId; }
    public Integer getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount = amount; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public PaymentType getType() { return type; }
    public void setType(PaymentType type) { this.type = type; }
    public String getReferenceId() { return referenceId; }
    public void setReferenceId(String referenceId) { this.referenceId = referenceId; }
    public String getStoreId() { return storeId; }
    public void setStoreId(String storeId) { this.storeId = storeId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public PaymentStatus getStatus() { return status; }
    public void setStatus(PaymentStatus status) { this.status = status; }
    public String getRazorpayPaymentId() { return razorpayPaymentId; }
    public void setRazorpayPaymentId(String razorpayPaymentId) { this.razorpayPaymentId = razorpayPaymentId; }
}
