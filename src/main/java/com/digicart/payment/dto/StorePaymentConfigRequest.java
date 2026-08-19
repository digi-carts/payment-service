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

    public String getStoreId() { return storeId; }
    public void setStoreId(String storeId) { this.storeId = storeId; }
    public String getRazorpayKeyId() { return razorpayKeyId; }
    public void setRazorpayKeyId(String razorpayKeyId) { this.razorpayKeyId = razorpayKeyId; }
    public String getRazorpayKeySecret() { return razorpayKeySecret; }
    public void setRazorpayKeySecret(String razorpayKeySecret) { this.razorpayKeySecret = razorpayKeySecret; }
    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }
    public OnlineMode getOnlineMode() { return onlineMode; }
    public void setOnlineMode(OnlineMode onlineMode) { this.onlineMode = onlineMode; }
    public String getRouteAccountId() { return routeAccountId; }
    public void setRouteAccountId(String routeAccountId) { this.routeAccountId = routeAccountId; }
    public KycStatus getKycStatus() { return kycStatus; }
    public void setKycStatus(KycStatus kycStatus) { this.kycStatus = kycStatus; }
}
