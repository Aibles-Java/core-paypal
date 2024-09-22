package org.aibles.core_paypal.controller;

import java.util.Collections;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.core_paypal.dto.paypal.PaypalOrderDetail;
import org.aibles.core_paypal.dto.response.PaypalCaptureResponse;
import org.aibles.core_paypal.dto.request.OrderRequest;
import org.aibles.core_paypal.dto.request.RefundRequest;
import org.aibles.core_paypal.dto.paypal.PaypalOrderSimple;
import org.aibles.core_paypal.dto.response.PaypalRefundResponse;
import org.aibles.core_paypal.service.PayPalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
@Slf4j
public class OrderController {

  private final PayPalService payPalService;

  @PostMapping("/purchase")
  public PaypalOrderSimple purchaseOrder(@RequestBody OrderRequest orderRequest) {
    log.info("(purchaseOrder)orderRequest: {}", orderRequest);
    return payPalService.createOrder(Collections.singletonList(orderRequest));
  }

  @PostMapping("/refund")
  public PaypalRefundResponse refundOrder(@RequestBody RefundRequest refundRequest) {
    log.info("(refundOrder)refundRequest: {}", refundRequest);
    return payPalService.refundPayment(refundRequest.getCaptureId(),
        refundRequest.getOrderId(), refundRequest.getAmount());
  }

  @GetMapping("/{paypal_id}")
  public PaypalOrderDetail getDetailOrder(@PathVariable("paypal_id") String paypalId) {
    log.info("(getDetailOrder)paypalId: {}", paypalId);
    return payPalService.getOrderDetails(paypalId);
  }

}
