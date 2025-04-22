package com.pm.patientservice.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PatientNotFoundException extends RuntimeException {

    String message;
    public PatientNotFoundException(String message) {
        this.message = message;
    }
}
