package com.pm.patientservice.service;

import com.pm.patientservice.payload.PatientDTO;
import com.pm.patientservice.payload.PatientResponse;


public interface PatientService {
    PatientResponse getAllPatient();
    PatientDTO createPatient(PatientDTO patientDTO);
}
