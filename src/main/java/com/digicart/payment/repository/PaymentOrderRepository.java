package com.digicart.payment.repository;

import com.digicart.payment.entity.PaymentOrder;
import com.digicart.payment.entity.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for payment order  persistence.
 */
@Repository
public interface PaymentOrderRepository extends JpaRepository<PaymentOrder, String> {
    Optional<PaymentOrder> findByRazorpayOrderId(String razorpayOrderId);
    List<PaymentOrder> findByStoreId(String storeId);
    List<PaymentOrder> findByUserId(String userId);
    List<PaymentOrder> findByStatus(PaymentStatus status);
    List<PaymentOrder> findByStoreIdAndStatus(String storeId, PaymentStatus status);
}
