package com.digicart.payment.cucumber;

import com.digicart.payment.entity.PaymentOrder;
import com.digicart.payment.service.PaymentOrderService;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.mockito.Mockito.when;

public class PaymentStepDefinitions {
    @Autowired
    PaymentOrderService paymentOrderService;

    @Before
    public void stubs() {
        when(paymentOrderService.findAll()).thenReturn(List.of(new PaymentOrder()));
    }
}
