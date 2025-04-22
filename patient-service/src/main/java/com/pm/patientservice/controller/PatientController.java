package com.pm.patientservice.controller;

import com.pm.patientservice.payload.PatientDTO;
import com.pm.patientservice.payload.PatientResponse;
import com.pm.patientservice.payload.UpdatePatientDTO;
import com.pm.patientservice.service.impl.PatientServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Tag(name="Patient", description = "API for managing patients")
public class PatientController {
    private final PatientServiceImpl patientService;

    public PatientController(PatientServiceImpl patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    @Operation(summary = "Get all patients")
    public ResponseEntity<PatientResponse> findAllPatients() {
       PatientResponse response= patientService.getAllPatient();
       return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PostMapping("/patients")
    @Operation(summary = "Create a new patient")
    public ResponseEntity<PatientDTO> createPatient(@Valid @RequestBody PatientDTO patientDTO) {
        PatientDTO savedPatientDTO = patientService.createPatient(patientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatientDTO);
    }

    @PutMapping("/patients/{patientId}")
    @Operation(summary = "Update patient details")
    public ResponseEntity<UpdatePatientDTO> updatePatient(@PathVariable("patientId") Long patientId,
                                                    @Valid @RequestBody UpdatePatientDTO patientDTO) {

    UpdatePatientDTO updatedPatientDTO = patientService.updatePatient(patientId, patientDTO);
    return ResponseEntity.status(HttpStatus.OK).body(updatedPatientDTO);
    }


    @DeleteMapping("/patients/{patientId}")
    @Operation(summary = "Delete a patient")
    public ResponseEntity<PatientDTO> deletePatient(@PathVariable("patientId") Long patientId) {
        PatientDTO deletedPatient= patientService.deletePatient(patientId);
        return ResponseEntity.status(HttpStatus.OK).body(deletedPatient);
    }
}
