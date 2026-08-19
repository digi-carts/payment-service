package com.digicart.payment.repository;

import com.digicart.payment.entity.PlatformPaymentConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformPaymentConfigRepository extends JpaRepository<PlatformPaymentConfig, String> {
}
