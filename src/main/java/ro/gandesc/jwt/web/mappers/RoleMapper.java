package ro.gandesc.jwt.web.mappers;

import ro.gandesc.jwt.domain.security.Role;
import ro.gandesc.jwt.web.models.RoleDto;

public interface RoleMapper {
    RoleDto roleToRoleDto(Role entity);

    Role roleDtoToRole(RoleDto dto);
}
