package org.aibles.core_paypal.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AuthPaypalResponse {

  private String scope;
  private String accessToken;
  private String tokenType;
  private String appId;
  private long expiresIn;
  private String nonce;

}
