package com.app.CareLink.patience.service.register;

import com.app.CareLink.patience.dtos.request.RegisterPatientRequest;
import com.app.CareLink.patience.model.Patient;
import com.app.CareLink.patience.repository.register.PatientRegisterRepository;
import com.app.CareLink.regex.DateOfBirthValidator;
import com.app.CareLink.regex.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDate;



@Service
public class RegisterPatientImpl implements RegisterPatient{


    @Autowired
    private PatientRegisterRepository patientRegisterRepository;


    @Override
    public HttpStatus registerPatient(RegisterPatientRequest registerPatientRequest) {
        if(registerPatientRequest.getFirstName().isBlank()) throw new IllegalArgumentException("First name cannot be blank");
        if(registerPatientRequest.getFirstName().contains(" ")) throw new IllegalArgumentException("First name cannot contain spaces");
        if(registerPatientRequest.getLastName().isBlank()) throw new IllegalArgumentException("Last name cannot be blank");
        if(registerPatientRequest.getLastName().contains(" ")) throw new IllegalArgumentException("Last name cannot contain spaces");
        if(registerPatientRequest.getPassword().isBlank()) throw new IllegalArgumentException("Password cannot be blank");
        if(registerPatientRequest.getPassword().length() < 6) throw new IllegalArgumentException("Password must be at least 6 characters");
        if(registerPatientRequest.getPassword().contains(" ")) throw new IllegalArgumentException("Password cannot contain spaces");
        if(registerPatientRequest.getGender().isBlank()) throw new IllegalArgumentException("Gender cannot be blank");
        if(registerPatientRequest.getAddress().isBlank()) throw new IllegalArgumentException("Address cannot be blank");
        if(registerPatientRequest.getBirthDate().isAfter(LocalDate.now())) throw new IllegalArgumentException("Birth date cannot be in the future");
        if(!registerPatientRequest.getGender().equalsIgnoreCase("male") && registerPatientRequest.getGender().equalsIgnoreCase("female")) throw new IllegalArgumentException("Gender can be only male or female");
        if(!registerPatientRequest.getPhoneNumber().matches("^(\\+234|0)[789]\\d{9}$")) throw new IllegalArgumentException("Phone number must be eleven digits");
        if(!EmailValidator.isValidEmail(registerPatientRequest.getEmail())) throw new IllegalArgumentException("Email is invalid");
        if(registerPatientRequest.getBirthDate().toString().isBlank()) throw new IllegalArgumentException("Birth date cannot be blank");
        if(DateOfBirthValidator.isValidDateOfBirth(registerPatientRequest.getBirthDate())) throw new IllegalArgumentException("Date of birth is invalid");
        if(registerPatientRequest.getUsername().isBlank()) throw new IllegalArgumentException("Username cannot be blank");
        if(registerPatientRequest.getUsername().contains(" ")) throw new IllegalArgumentException("Username cannot contain spaces");
        if(registerPatientRequest.getUsername().length() < 6) throw new IllegalArgumentException("Username must be at least 6 characters");



        Patient patient = new Patient();
        patient.setFirstName(registerPatientRequest.getFirstName());
        patient.setLastName(registerPatientRequest.getLastName());
        patient.setEmail(registerPatientRequest.getEmail());
        patient.setPassword(new BCryptPasswordEncoder().encode(registerPatientRequest.getPassword()));
        patient.setGender(registerPatientRequest.getGender());
        patient.setAddress(registerPatientRequest.getAddress());
        patient.setBirthDate(registerPatientRequest.getBirthDate());
        patient.setPhoneNumber(registerPatientRequest.getPhoneNumber());
        patient.setUsername(registerPatientRequest.getUsername());
        patientRegisterRepository.save(patient);

        return HttpStatus.CREATED;
    }



}
