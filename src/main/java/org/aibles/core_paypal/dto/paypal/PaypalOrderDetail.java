package org.aibles.core_paypal.dto.paypal;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PaypalOrderDetail {

  private String id;
  private String intent;
  private String status;
  private List<PurchaseUnit> purchaseUnits;
  private List<PaypalOrderSimple.Link> links;

  @AllArgsConstructor
  @Data
  @NoArgsConstructor
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Link {

    private String href;
    private String rel;
    private String method;
  }

}
