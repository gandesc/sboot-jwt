package ro.gandesc.jwt.repositories.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.gandesc.jwt.domain.security.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
