package pl.backend.nfzBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.backend.nfzBackend.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByLogin(String login);
}
