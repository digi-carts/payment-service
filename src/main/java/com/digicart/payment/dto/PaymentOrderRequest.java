package com.digicart.payment.dto;

import com.digicart.payment.entity.PaymentType;
import com.digicart.payment.entity.PaymentStatus;
import jakarta.validation.constraints.NotNull;

/**
 * Request/response DTO: Payment Order Request.
 */
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

    /**
     * Returns razorpay order id.
     * @return the string
     */
    public String getRazorpayOrderId() { return razorpayOrderId; }
    /**
     * Sets razorpay order id.
     *
     * @param razorpayOrderId Razorpay order id
     */
    public void setRazorpayOrderId(String razorpayOrderId) { this.razorpayOrderId = razorpayOrderId; }
    /**
     * Returns amount.
     * @return the integer
     */
    public Integer getAmount() { return amount; }
    /**
     * Sets amount.
     *
     * @param amount amount
     */
    public void setAmount(Integer amount) { this.amount = amount; }
    /**
     * Returns currency.
     * @return the string
     */
    public String getCurrency() { return currency; }
    /**
     * Sets currency.
     *
     * @param currency currency
     */
    public void setCurrency(String currency) { this.currency = currency; }
    /**
     * Returns type.
     * @return the payment type
     */
    public PaymentType getType() { return type; }
    /**
     * Sets type.
     *
     * @param type type
     */
    public void setType(PaymentType type) { this.type = type; }
    /**
     * Returns reference id.
     * @return the string
     */
    public String getReferenceId() { return referenceId; }
    /**
     * Sets reference id.
     *
     * @param referenceId reference id
     */
    public void setReferenceId(String referenceId) { this.referenceId = referenceId; }
    /**
     * Returns store id.
     * @return the string
     */
    public String getStoreId() { return storeId; }
    /**
     * Sets store id.
     *
     * @param storeId store (tenant) identifier
     */
    public void setStoreId(String storeId) { this.storeId = storeId; }
    /**
     * Returns user id.
     * @return the string
     */
    public String getUserId() { return userId; }
    /**
     * Sets user id.
     *
     * @param userId caller user id from the gateway ({@code X-User-Id})
     */
    public void setUserId(String userId) { this.userId = userId; }
    /**
     * Returns status.
     * @return the payment status
     */
    public PaymentStatus getStatus() { return status; }
    /**
     * Sets status.
     *
     * @param status status
     */
    public void setStatus(PaymentStatus status) { this.status = status; }
    /**
     * Returns razorpay payment id.
     * @return the string
     */
    public String getRazorpayPaymentId() { return razorpayPaymentId; }
    /**
     * Sets razorpay payment id.
     *
     * @param razorpayPaymentId razorpay payment id
     */
    public void setRazorpayPaymentId(String razorpayPaymentId) { this.razorpayPaymentId = razorpayPaymentId; }
}
