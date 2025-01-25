package com.app.CareLink.patience.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Entity
@Data
public class Patient {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String gender;
    private LocalDate birthDate;
    @Id
    private String username;
    private String password;

}
