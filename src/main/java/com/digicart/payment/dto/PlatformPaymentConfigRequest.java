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
}
