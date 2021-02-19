package pl.backend.nfzBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.backend.nfzBackend.entity.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
