package com.pm.patientservice.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class EmailExistsException extends RuntimeException {

    private String message;

    public EmailExistsException(String message) {
      this.message = message;
    }

}
