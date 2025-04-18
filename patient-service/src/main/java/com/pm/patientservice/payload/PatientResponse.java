package com.pm.patientservice.payload;

import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponse {
    private List<PatientDTO> contents;
}
