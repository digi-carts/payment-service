package com.digicart.payment.dto;

/**
 * Request/response DTO: Processed Webhook Request.
 */
public class ProcessedWebhookRequest {
    private String id;
    private String eventType;

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
     * Returns event type.
     * @return the string
     */
    public String getEventType() { return eventType; }
    /**
     * Sets event type.
     *
     * @param eventType event type
     */
    public void setEventType(String eventType) { this.eventType = eventType; }
}
