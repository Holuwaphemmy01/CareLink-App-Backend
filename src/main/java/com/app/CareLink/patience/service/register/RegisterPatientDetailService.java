package com.app.CareLink.patience.service.register;

import com.app.CareLink.patience.model.Patient;
import com.app.CareLink.patience.model.PatientPrincipal;
import com.app.CareLink.patience.repository.register.PatientRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RegisterPatientDetailService implements UserDetailsService {

    @Autowired
    private PatientRegisterRepository patientRegisterRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Patient patient = patientRegisterRepository.findByUsername(username);
        if (patient == null) throw new UsernameNotFoundException("Patient not found");
        return new PatientPrincipal(patient);
    }


}
