package pl.backend.nfzBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.backend.nfzBackend.entity.RfeType;

public interface RfeTypeRepository extends JpaRepository<RfeType,Long> {
}
