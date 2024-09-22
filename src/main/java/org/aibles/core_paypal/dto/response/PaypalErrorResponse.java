package org.aibles.core_paypal.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PaypalErrorResponse {

  private String name;
  private String message;
  private List<ErrorDetail> details;
  private String debugId;
  private List<Link> links;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class ErrorDetail {
    private String issue;
    private String description;
    private String field;
    private String value;
    private String location;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Link {
    private String href;
    private String rel;
    private String method;
  }
}
