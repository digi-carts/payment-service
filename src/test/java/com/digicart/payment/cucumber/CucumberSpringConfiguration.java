package com.digicart.payment.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import com.digicart.payment.exception.GlobalExceptionHandler;
import com.digicart.payment.controller.HealthController;
import com.digicart.payment.controller.PaymentOrderController;
import com.digicart.payment.service.PaymentOrderService;

@CucumberContextConfiguration
@WebMvcTest(controllers = { HealthController.class, PaymentOrderController.class })
@AutoConfigureMockMvc(addFilters = false)
@Import(GlobalExceptionHandler.class)
public class CucumberSpringConfiguration {
    @MockBean
    PaymentOrderService paymentOrderService;

}
