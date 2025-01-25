package com.app.CareLink.patience.repository.register;

import com.app.CareLink.patience.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatienceRegisterRepository extends JpaRepository<Patient, String> {

}
