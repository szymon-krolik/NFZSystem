package pl.backend.nfzBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.backend.nfzBackend.entity.VisitType;

public interface VisitTypeRepository extends JpaRepository<VisitType, Long> {
}
