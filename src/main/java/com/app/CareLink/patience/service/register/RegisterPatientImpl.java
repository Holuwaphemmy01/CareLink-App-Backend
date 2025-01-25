package com.app.CareLink.patience.service.register;

import com.app.CareLink.patience.dtos.request.RegisterPatientRequest;
import com.app.CareLink.patience.mapper.MapRegisterPatienceRequest;
import com.app.CareLink.patience.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.logging.log4j.util.StringBuilders.equalsIgnoreCase;


@Service
public class RegisterPatientImpl implements RegisterPatient {

    @Autowired
    private Patient patient;

    @Autowired
    private MapRegisterPatienceRequest mapRegisterPatienceRequest;


    @Override
    public HttpStatus registerPatient(RegisterPatientRequest registerPatientRequest) {
        if(registerPatientRequest.getFirstName().isBlank()) throw new IllegalArgumentException("First name cannot be blank");
        if (registerPatientRequest.getLastName().isBlank()) throw new IllegalArgumentException("Last name cannot be blank");
        if (registerPatientRequest.getEmail().isBlank()) throw new IllegalArgumentException("Email cannot be blank");
        if(registerPatientRequest.getPassword().isBlank()) throw new IllegalArgumentException("Password cannot be blank");
        if(registerPatientRequest.getGender().isBlank()) throw new IllegalArgumentException("Gender cannot be blank");
        if(registerPatientRequest.getAddress().isBlank()) throw new IllegalArgumentException("Address cannot be blank");
        if(registerPatientRequest.getBirthDate().isAfter(LocalDate.now())) throw new IllegalArgumentException("Birth date cannot be in the future");
        if(!registerPatientRequest.getGender().equalsIgnoreCase("male") || !registerPatientRequest.getGender().equalsIgnoreCase("female")) throw new IllegalArgumentException("Gender can be only male or female");

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_-]{3,16}$");
        Matcher matcher = pattern.matcher(registerPatientRequest.getFirstName());
        registerPatientRequest.setFirstName(String.valueOf(matcher));
//        ^[a-zA-Z0-9_-]+$

        Patient newPatient = mapRegisterPatienceRequest.mapRegisterPatientRequest(patient, registerPatientRequest);

        return HttpStatus.CREATED;
    }


}
