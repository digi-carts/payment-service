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
    /**
     * Finds by razorpay order id.
     *
     * @param razorpayOrderId Razorpay order id
     * @return the value if present
     */
    Optional<PaymentOrder> findByRazorpayOrderId(String razorpayOrderId);
    /**
     * Finds by store id.
     *
     * @param storeId store (tenant) identifier
     * @return matching records
     */
    List<PaymentOrder> findByStoreId(String storeId);
    /**
     * Finds by user id.
     *
     * @param userId caller user id from the gateway ({@code X-User-Id})
     * @return matching records
     */
    List<PaymentOrder> findByUserId(String userId);
    /**
     * Finds by status.
     *
     * @param status status
     * @return matching records
     */
    List<PaymentOrder> findByStatus(PaymentStatus status);
    /**
     * Finds by store id and status.
     *
     * @param storeId store (tenant) identifier
     * @param status status
     * @return matching records
     */
    List<PaymentOrder> findByStoreIdAndStatus(String storeId, PaymentStatus status);
}
