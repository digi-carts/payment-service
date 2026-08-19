package com.digicart.payment.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

/**
 * JPA entity mapped in this service schema (Processed Webhook).
 */
@Entity
@Table(name = "processed_webhook", schema = "payment_svc")
@EntityListeners(AuditingEntityListener.class)
public class ProcessedWebhook {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "event_type")
    private String eventType;

    @CreatedDate
    @Column(name = "received_at", nullable = false, updatable = false)
    private Instant receivedAt;

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
    /**
     * Returns received at.
     * @return the instant
     */
    public Instant getReceivedAt() { return receivedAt; }
    /**
     * Sets received at.
     *
     * @param receivedAt received at
     */
    public void setReceivedAt(Instant receivedAt) { this.receivedAt = receivedAt; }
}
