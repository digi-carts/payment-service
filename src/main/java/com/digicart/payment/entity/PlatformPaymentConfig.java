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

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getRazorpayKeyId() { return razorpayKeyId; }
    public void setRazorpayKeyId(String razorpayKeyId) { this.razorpayKeyId = razorpayKeyId; }
    public String getRazorpayKeySecret() { return razorpayKeySecret; }
    public void setRazorpayKeySecret(String razorpayKeySecret) { this.razorpayKeySecret = razorpayKeySecret; }
    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }
    public Boolean getRouteEnabled() { return routeEnabled; }
    public void setRouteEnabled(Boolean routeEnabled) { this.routeEnabled = routeEnabled; }
    public Double getDefaultPlatformFeePercent() { return defaultPlatformFeePercent; }
    public void setDefaultPlatformFeePercent(Double defaultPlatformFeePercent) { this.defaultPlatformFeePercent = defaultPlatformFeePercent; }
    public String getWebhookSecret() { return webhookSecret; }
    public void setWebhookSecret(String webhookSecret) { this.webhookSecret = webhookSecret; }
    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
