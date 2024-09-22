package org.aibles.core_paypal.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.core_paypal.dto.paypal.PaypalOrderDetail;
import org.aibles.core_paypal.dto.response.PaypalCaptureResponse;
import org.aibles.core_paypal.service.PayPalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paypal")
@Slf4j
@RequiredArgsConstructor
public class PaypalIPN {

    private final PayPalService  paypalService;

    @GetMapping("/success")
    public PaypalCaptureResponse successIPN(@RequestParam("token") String token) {
        log.info("(successIPN)token : {}", token);
        return paypalService.captureOrder(token);
    }

    @GetMapping("/cancel")
    public PaypalOrderDetail cancelIPN(@RequestParam("token") String token) {
        PaypalOrderDetail paypalOrderDetail = paypalService.getOrderDetails(token);
        log.info("(cancelIPN)detail : {}", paypalOrderDetail);
        return paypalService.getOrderDetails(token);
    }
}
