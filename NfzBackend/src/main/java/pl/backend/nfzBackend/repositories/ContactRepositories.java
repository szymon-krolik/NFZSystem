package pl.backend.nfzBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.backend.nfzBackend.entity.Contact;

public interface ContactRepositories extends JpaRepository<Contact, Long> {
}
