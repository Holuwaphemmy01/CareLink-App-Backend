package com.app.CareLink.patience.controllers.register;

import com.app.CareLink.patience.dtos.request.RegisterPatientRequest;
import com.app.CareLink.patience.service.register.RegisterPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()

public class PatienceRegisterController {

    @Autowired
    private RegisterPatient registerPatient;

    @PostMapping("/registerPatient")
    public ResponseEntity<?> registerPatient(@RequestBody RegisterPatientRequest registerPatientRequest) {
        try{
            registerPatient.registerPatient(registerPatientRequest);
            return ResponseEntity.ok(HttpStatus.valueOf(200));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
