package com.pm.patientservice.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Getter
public class ResourceExistsException extends RuntimeException {
    private HttpStatus httpStatus;
    private String message;

    public ResourceExistsException(String message) {
      this.message = message;
    }

  public ResourceExistsException(HttpStatus httpStatus, String message) {
    this.httpStatus = httpStatus;
    this.message = message;
  }
}
