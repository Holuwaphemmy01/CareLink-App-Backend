package com.app.CareLink.patience.service.register;


import com.app.CareLink.patience.dtos.request.RegisterPatientRequest;
import com.app.CareLink.patience.model.Patient;
import org.springframework.http.HttpStatus;

public interface RegisterPatient {
    HttpStatus registerPatient(RegisterPatientRequest patient);
}
