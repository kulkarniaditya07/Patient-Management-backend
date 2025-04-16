package com.pm.patientservice.service.impl;

import com.pm.patientservice.model.Patient;
import com.pm.patientservice.payload.PatientDTO;
import com.pm.patientservice.payload.PatientResponse;
import com.pm.patientservice.repository.PatientRepository;
import com.pm.patientservice.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    private final ModelMapper modelMapper;

    public PatientServiceImpl(PatientRepository patientRepository, ModelMapper modelMapper) {
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public PatientResponse getAllPatient() {
        List<Patient> patients = patientRepository.findAll();

        List<PatientDTO> patientDTOs = patients.stream()
                .map(patient -> modelMapper.map(patient, PatientDTO.class))
                .toList();
        return PatientResponse.builder()
                .content(patientDTOs)
                .build();
    }

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient = modelMapper.map(patientDTO, Patient.class);
        Patient savedPatient = patientRepository.save(patient);

        return modelMapper.map(savedPatient, PatientDTO.class);
    }


}
