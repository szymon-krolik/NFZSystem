package pl.backend.nfzBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.backend.nfzBackend.entity.SurgeryType;

public interface SurgeryTypeRepository extends JpaRepository<SurgeryType, Long> {
}
