package com.app.CareLink.patience.service.register;

import com.app.CareLink.patience.dtos.request.RegisterPatientRequest;
import com.app.CareLink.patience.model.Patient;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterPatientImpl implements RegisterPatient {

    @Autowired
    private Patient patient;


    @Override
    public HttpStatus registerPatient(RegisterPatientRequest patient) {
        Mapper mapper = new Mapper();
        mapper.
        return null;
    }
}
