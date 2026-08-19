package com.digicart.payment.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

/**
 * JPA entity mapped in this service schema (Payment Order).
 */
@Entity
@Table(name = "payment_order", schema = "payment_svc")
@EntityListeners(AuditingEntityListener.class)
public class PaymentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "razorpay_order_id", nullable = false, unique = true)
    private String razorpayOrderId;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "currency", nullable = false)
    private String currency = "INR";

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PaymentType type;

    @Column(name = "reference_id", nullable = false)
    private String referenceId;

    @Column(name = "store_id")
    private String storeId;

    @Column(name = "user_id")
    private String userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PaymentStatus status = PaymentStatus.CREATED;

    @Column(name = "razorpay_payment_id")
    private String razorpayPaymentId;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    /**
     * Returns id.
     * @return the string
     */
    public String getId() { return id; }
    /**
     * Sets id.
     *
     * @param id resource identifier
     */
    public void setId(String id) { this.id = id; }
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
    /**
     * Returns created at.
     * @return the instant
     */
    public Instant getCreatedAt() { return createdAt; }
    /**
     * Sets created at.
     *
     * @param createdAt created at
     */
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    /**
     * Returns updated at.
     * @return the instant
     */
    public Instant getUpdatedAt() { return updatedAt; }
    /**
     * Sets updated at.
     *
     * @param updatedAt updated at
     */
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
