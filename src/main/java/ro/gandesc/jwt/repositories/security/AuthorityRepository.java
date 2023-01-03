package ro.gandesc.jwt.repositories.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.gandesc.jwt.domain.security.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
