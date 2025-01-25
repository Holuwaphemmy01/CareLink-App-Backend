package com.app.CareLink.patience.mapper;


import com.app.CareLink.patience.dtos.request.RegisterPatientRequest;
import com.app.CareLink.patience.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class MapRegisterPatienceRequest {

    public Patient mapRegisterPatientRequest(Patient patient, RegisterPatientRequest registerPatientRequest) {
        patient.setGender(registerPatientRequest.getGender());
        patient.setFirstName(registerPatientRequest.getFirstName());
        patient.setLastName(registerPatientRequest.getLastName());
        patient.setEmail(registerPatientRequest.getEmail());
        patient.setGender(registerPatientRequest.getGender());
        patient.setBirthDate(registerPatientRequest.getBirthDate());
        patient.setPhoneNumber(registerPatientRequest.getPhoneNumber());
        return patient;
    }
}
