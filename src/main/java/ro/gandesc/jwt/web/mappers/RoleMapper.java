package ro.gandesc.jwt.web.mappers;

import org.mapstruct.Mapper;
import ro.gandesc.jwt.domain.security.Role;
import ro.gandesc.jwt.web.models.RoleDto;

@Mapper
public interface RoleMapper {
    RoleDto roleToRoleDto(Role entity);

    Role roleDtoToRole(RoleDto dto);
}
