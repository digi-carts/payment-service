package com.digicart.payment.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

/**
 * JPA entity mapped in this service schema (Platform Payment Config).
 */
@Entity
@Table(name = "platform_payment_config", schema = "payment_svc")
@EntityListeners(AuditingEntityListener.class)
public class PlatformPaymentConfig {

    @Id
    @Column(name = "id")
    private String id = "global";

    @Column(name = "razorpay_key_id")
    private String razorpayKeyId;

    @Column(name = "razorpay_key_secret")
    private String razorpayKeySecret;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = false;

    @Column(name = "route_enabled", nullable = false)
    private Boolean routeEnabled = false;

    @Column(name = "default_platform_fee_percent", nullable = false)
    private Double defaultPlatformFeePercent = 0.0;

    @Column(name = "webhook_secret")
    private String webhookSecret;

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
     * Returns razorpay key id.
     * @return the string
     */
    public String getRazorpayKeyId() { return razorpayKeyId; }
    /**
     * Sets razorpay key id.
     *
     * @param razorpayKeyId razorpay key id
     */
    public void setRazorpayKeyId(String razorpayKeyId) { this.razorpayKeyId = razorpayKeyId; }
    /**
     * Returns razorpay key secret.
     * @return the string
     */
    public String getRazorpayKeySecret() { return razorpayKeySecret; }
    /**
     * Sets razorpay key secret.
     *
     * @param razorpayKeySecret razorpay key secret
     */
    public void setRazorpayKeySecret(String razorpayKeySecret) { this.razorpayKeySecret = razorpayKeySecret; }
    /**
     * Returns enabled.
     * @return the boolean
     */
    public Boolean getEnabled() { return enabled; }
    /**
     * Sets enabled.
     *
     * @param enabled enabled
     */
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }
    /**
     * Returns route enabled.
     * @return the boolean
     */
    public Boolean getRouteEnabled() { return routeEnabled; }
    /**
     * Sets route enabled.
     *
     * @param routeEnabled route enabled
     */
    public void setRouteEnabled(Boolean routeEnabled) { this.routeEnabled = routeEnabled; }
    /**
     * Returns default platform fee percent.
     * @return the double
     */
    public Double getDefaultPlatformFeePercent() { return defaultPlatformFeePercent; }
    /**
     * Sets default platform fee percent.
     *
     * @param defaultPlatformFeePercent default platform fee percent
     */
    public void setDefaultPlatformFeePercent(Double defaultPlatformFeePercent) { this.defaultPlatformFeePercent = defaultPlatformFeePercent; }
    /**
     * Returns webhook secret.
     * @return the string
     */
    public String getWebhookSecret() { return webhookSecret; }
    /**
     * Sets webhook secret.
     *
     * @param webhookSecret webhook secret
     */
    public void setWebhookSecret(String webhookSecret) { this.webhookSecret = webhookSecret; }
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
