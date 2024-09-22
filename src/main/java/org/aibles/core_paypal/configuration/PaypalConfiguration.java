package org.aibles.core_paypal.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("application.paypal")
public class PaypalConfiguration {

  private String clientId;
  private String clientSecret;
  private String baseUrl;
  private String tunnelUrl;
  private String successPath;
  private String cancelPath;

}
