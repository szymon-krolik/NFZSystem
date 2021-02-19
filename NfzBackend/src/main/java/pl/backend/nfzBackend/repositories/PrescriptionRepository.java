package pl.backend.nfzBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.backend.nfzBackend.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
