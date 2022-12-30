package ro.gandesc.quoth.jwt.repositories.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.gandesc.quoth.jwt.domain.security.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
