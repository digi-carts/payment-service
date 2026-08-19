package com.digicart.payment.dto;

public class ProcessedWebhookRequest {
    private String id;
    private String eventType;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
}
