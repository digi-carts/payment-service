package com.digicart.payment.dto;

/**
 * Request/response DTO: Platform Payment Config Request.
 */
public class PlatformPaymentConfigRequest {
    private String razorpayKeyId;
    private String razorpayKeySecret;
    private Boolean enabled;
    private Boolean routeEnabled;
    private Double defaultPlatformFeePercent;
    private String webhookSecret;

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
}
