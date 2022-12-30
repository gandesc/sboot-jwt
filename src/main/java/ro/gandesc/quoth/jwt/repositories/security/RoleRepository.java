package ro.gandesc.quoth.jwt.repositories.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.gandesc.quoth.jwt.domain.security.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
