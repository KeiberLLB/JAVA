package com.riwi.beautySalon.api.exceptions;

public class BadRequestException
    extends RuntimeException {

  public BadRequestException(String message) {
    super(message);
  }
}
