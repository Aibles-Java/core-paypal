package org.aibles.core_paypal.util;

import java.util.Base64;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.core_paypal.dto.response.AuthPaypalResponse;
import org.aibles.core_paypal.configuration.PaypalConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Component
@Slf4j
public class AccessTokenUtil {

  private final RestTemplate restTemplate;

  private final PaypalConfiguration paypalConfiguration;

  public  String getAccessToken() {
    log.info("(getAccessToken)");
    String auth = paypalConfiguration.getClientId() + ":" + paypalConfiguration.getClientSecret();
    String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Basic " + encodedAuth);
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    HttpEntity<String> entity = new HttpEntity<>("grant_type=client_credentials", headers);

    ResponseEntity<AuthPaypalResponse> response = restTemplate.postForEntity(
        paypalConfiguration.getBaseUrl() + "/v1/oauth2/token",
        entity,
        AuthPaypalResponse.class
    );

    return Objects.requireNonNull(response.getBody()).getAccessToken();
  }
}
