package com.digicart.payment.dto;

import com.digicart.payment.entity.OnlineMode;
import com.digicart.payment.entity.KycStatus;

/**
 * Request/response DTO: Store Payment Config Request.
 */
public class StorePaymentConfigRequest {
    private String storeId;
    private String razorpayKeyId;
    private String razorpayKeySecret;
    private Boolean enabled;
    private OnlineMode onlineMode;
    private String routeAccountId;
    private KycStatus kycStatus;

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
}
