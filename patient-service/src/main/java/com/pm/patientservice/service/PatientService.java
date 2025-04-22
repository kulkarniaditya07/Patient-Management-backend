package com.pm.patientservice.service;

import com.pm.patientservice.payload.PatientDTO;
import com.pm.patientservice.payload.PatientResponse;
import com.pm.patientservice.payload.UpdatePatientDTO;


public interface PatientService {
    PatientResponse getAllPatient();
    PatientDTO createPatient(PatientDTO patientDTO);
    UpdatePatientDTO updatePatient(Long patientId, UpdatePatientDTO patientDTO);
    PatientDTO deletePatient(Long patientId);
}
