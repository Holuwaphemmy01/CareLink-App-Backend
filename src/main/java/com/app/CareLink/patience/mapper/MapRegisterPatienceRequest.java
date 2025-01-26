package com.app.CareLink.patience.mapper;


import com.app.CareLink.patience.dtos.request.RegisterPatientRequest;
import com.app.CareLink.patience.model.Patient;


public class MapRegisterPatienceRequest {


    public Patient mapRegisterPatientRequest(Patient patient, RegisterPatientRequest registerPatientRequest) {
        patient.setUsername(patient.getUsername());
        patient.setGender(registerPatientRequest.getGender());
        patient.setFirstName(registerPatientRequest.getFirstName());
        patient.setLastName(registerPatientRequest.getLastName());
        patient.setEmail(registerPatientRequest.getEmail());
        patient.setBirthDate(registerPatientRequest.getBirthDate());
        patient.setPhoneNumber(registerPatientRequest.getPhoneNumber());
        patient.setAddress(registerPatientRequest.getAddress());
        patient.setPassword(registerPatientRequest.getPassword());
        return patient;
    }
}
