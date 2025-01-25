package com.app.CareLink.patience.dtos.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterPatientRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String gender;
    private LocalDate birthDate;
    private String password;
}
