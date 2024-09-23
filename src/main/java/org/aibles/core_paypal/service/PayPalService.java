package org.aibles.core_paypal.service;

import java.util.List;
import org.aibles.core_paypal.dto.request.OrderRequest;
import org.aibles.core_paypal.dto.paypal.PaypalOrderDetail;
import org.aibles.core_paypal.dto.paypal.PaypalOrderSimple;
import org.aibles.core_paypal.dto.response.PaypalCaptureResponse;
import org.aibles.core_paypal.dto.response.PaypalRefundResponse;

public interface PayPalService {

  PaypalCaptureResponse captureOrder(String orderId);
  PaypalOrderSimple createOrder(List<OrderRequest> orderRequests);
  PaypalRefundResponse refundPayment(String captureId, String orderId, double refundAmount);
  PaypalOrderDetail getOrderDetails(String paypalToken);
}
