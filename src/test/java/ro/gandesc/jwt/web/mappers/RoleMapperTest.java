package ro.gandesc.jwt.web.mappers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ro.gandesc.jwt.domain.security.Role;
import ro.gandesc.jwt.web.models.RoleDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleMapperTest {

    private final RoleMapper roleMapper = Mappers.getMapper(RoleMapper.class);

    @Test
    public void testEntityToDto() {
        Role entity = Role.builder()
                .id(1)
                .name("rolename")
                .build();

        RoleDto dto = roleMapper.roleToRoleDto(entity);

        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getName(), dto.getName());
    }

    @Test
    public void testDtoToEntity() {
        RoleDto dto = new RoleDto();
        dto.setId(1);
        dto.setName("rolename");

        Role entity = roleMapper.roleDtoToRole(dto);

        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getName(), dto.getName());
    }
}
