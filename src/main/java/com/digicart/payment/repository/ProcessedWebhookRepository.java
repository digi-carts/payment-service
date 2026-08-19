package com.digicart.payment.repository;

import com.digicart.payment.entity.ProcessedWebhook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for processed webhook  persistence.
 */
@Repository
public interface ProcessedWebhookRepository extends JpaRepository<ProcessedWebhook, String> {
}
