package com.digicart.payment.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

/**
 * JPA entity mapped in this service schema (Store Payment Config).
 */
@Entity
@Table(name = "store_payment_config", schema = "payment_svc")
@EntityListeners(AuditingEntityListener.class)
public class StorePaymentConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "store_id", nullable = false, unique = true)
    private String storeId;

    @Column(name = "razorpay_key_id")
    private String razorpayKeyId;

    @Column(name = "razorpay_key_secret")
    private String razorpayKeySecret;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "online_mode", nullable = false)
    private OnlineMode onlineMode = OnlineMode.OWN;

    @Column(name = "route_account_id")
    private String routeAccountId;

    @Enumerated(EnumType.STRING)
    @Column(name = "kyc_status", nullable = false)
    private KycStatus kycStatus = KycStatus.NOT_STARTED;

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
     * Returns online mode.
     * @return the online mode
     */
    public OnlineMode getOnlineMode() { return onlineMode; }
    /**
     * Sets online mode.
     *
     * @param onlineMode online mode
     */
    public void setOnlineMode(OnlineMode onlineMode) { this.onlineMode = onlineMode; }
    /**
     * Returns route account id.
     * @return the string
     */
    public String getRouteAccountId() { return routeAccountId; }
    /**
     * Sets route account id.
     *
     * @param routeAccountId route account id
     */
    public void setRouteAccountId(String routeAccountId) { this.routeAccountId = routeAccountId; }
    /**
     * Returns kyc status.
     * @return the kyc status
     */
    public KycStatus getKycStatus() { return kycStatus; }
    /**
     * Sets kyc status.
     *
     * @param kycStatus kyc status
     */
    public void setKycStatus(KycStatus kycStatus) { this.kycStatus = kycStatus; }
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
