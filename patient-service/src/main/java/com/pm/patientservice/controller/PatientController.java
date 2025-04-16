package com.pm.patientservice.controller;

import com.pm.patientservice.payload.PatientDTO;
import com.pm.patientservice.payload.PatientResponse;
import com.pm.patientservice.service.impl.PatientServiceImpl;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class PatientController {
    private final PatientServiceImpl patientService;

    public PatientController(PatientServiceImpl patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public ResponseEntity<PatientResponse> findAllPatients() {
       PatientResponse response= patientService.getAllPatient();
       return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PostMapping("/patients")
    public ResponseEntity<PatientDTO> createPatient(@Valid @RequestBody PatientDTO patientDTO) {
        PatientDTO savedPatientDTO = patientService.createPatient(patientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatientDTO);
    }
}
