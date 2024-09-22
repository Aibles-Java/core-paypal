package org.aibles.core_paypal.exception;

public class PaypalRestTemplateException extends RuntimeException {

  private int status;
  private String code;
  private String message;

  public PaypalRestTemplateException(int status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }

}
