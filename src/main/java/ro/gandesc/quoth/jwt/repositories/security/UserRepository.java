package ro.gandesc.quoth.jwt.repositories.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.gandesc.quoth.jwt.domain.security.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
