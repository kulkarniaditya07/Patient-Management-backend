package com.pm.patientservice.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePatientDTO {
    @NotNull
    @NotBlank(message = "please provide name")
    private String name;

    @Email(message = "Entered email is not valid")
    @NotNull
    @NotBlank(message = "please provide email")
    private String email;

    @NotNull
    @NotBlank(message = "Please provide address")
    private String address;

    @NotNull
    private LocalDate dateOfBirth;
}
