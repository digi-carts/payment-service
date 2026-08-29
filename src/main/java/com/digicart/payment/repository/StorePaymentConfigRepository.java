package com.digicart.payment.repository;

import com.digicart.payment.entity.StorePaymentConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data JPA repository for store payment config  persistence.
 */
@Repository
public interface StorePaymentConfigRepository extends JpaRepository<StorePaymentConfig, String> {
    Optional<StorePaymentConfig> findByStoreId(String storeId);
}
