package com.digicart.payment.service;

import com.digicart.payment.dto.PaymentOrderRequest;
import com.digicart.payment.entity.PaymentOrder;
import com.digicart.payment.entity.PaymentType;
import com.digicart.payment.exception.EntityNotFoundException;
import com.digicart.payment.repository.PaymentOrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentOrderServiceTest {

    @Mock
    private PaymentOrderRepository repository;

    @InjectMocks
    private PaymentOrderService service;

    @Test
    void createMapsRazorpayId() {
        PaymentOrderRequest req = new PaymentOrderRequest();
        req.setRazorpayOrderId("rp_1");
        req.setAmount(50000);
        req.setType(PaymentType.PRODUCT);
        req.setReferenceId("ord_1");
        when(repository.save(any(PaymentOrder.class))).thenAnswer(i -> i.getArgument(0));
        assertThat(service.create(req).getRazorpayOrderId()).isEqualTo("rp_1");
        assertThat(service.create(req).getAmount()).isEqualTo(50000);
    }

    @Test
    void findByRazorpayThrows() {
        when(repository.findByRazorpayOrderId("no")).thenReturn(Optional.empty());
        assertThatThrownBy(() -> service.findByRazorpayOrderId("no")).isInstanceOf(EntityNotFoundException.class);
    }
}
