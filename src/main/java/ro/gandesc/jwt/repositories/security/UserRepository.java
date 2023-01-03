package ro.gandesc.jwt.repositories.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.gandesc.jwt.domain.security.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
