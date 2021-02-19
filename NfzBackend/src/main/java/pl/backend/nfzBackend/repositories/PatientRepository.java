package pl.backend.nfzBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.backend.nfzBackend.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
