package org.aibles.core_paypal.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aibles.core_paypal.dto.paypal.PaymentSource;
import org.aibles.core_paypal.dto.paypal.PurchaseUnit;
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PaypalCaptureResponse {

  private String id;

  private String status;

  private String createdTime;

  private String updatedTime;

  private List<PaymentSource> paymentSources;

  private List<PurchaseUnit> purchaseUnits;

  private String intent;

}
