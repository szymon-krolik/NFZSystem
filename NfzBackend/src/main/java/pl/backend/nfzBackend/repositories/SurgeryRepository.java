package pl.backend.nfzBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.backend.nfzBackend.entity.Surgery;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
}
