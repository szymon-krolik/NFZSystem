package pl.backend.nfzBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.backend.nfzBackend.entity.Rfe;

public interface RfeRepository extends JpaRepository<Rfe,Long> {
}
