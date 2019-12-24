package com.darwin.javatest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
@SuppressWarnings("serial")
public class BadRequestException extends RuntimeException {
  public BadRequestException(String message) {
    super(message);
  }
}