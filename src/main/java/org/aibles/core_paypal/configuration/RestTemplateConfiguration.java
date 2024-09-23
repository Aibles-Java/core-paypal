package org.aibles.core_paypal.configuration;

import org.aibles.core_paypal.controller.advice.RestTemplateErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

  private final RestTemplateErrorHandler errorHandler;

  public RestTemplateConfiguration(RestTemplateErrorHandler errorHandler) {
    this.errorHandler = errorHandler;
  }

  @Bean
  public RestTemplate paypalRestTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.setErrorHandler(errorHandler);
    return restTemplate;
  }

}
