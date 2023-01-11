package ro.gandesc.jwt.web.mappers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ro.gandesc.jwt.domain.security.Authority;
import ro.gandesc.jwt.web.models.AuthorityDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorityMapperTest {

    private final AuthorityMapper authorityMapper = Mappers.getMapper(AuthorityMapper.class);

    @Test
    public void testEntityToDto() {
        Authority entity = Authority.builder()
                .id(1)
                .permission("some.permission")
                .build();

        AuthorityDto dto = authorityMapper.roleToAuthorityDto(entity);

        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getPermission(), dto.getPermission());
    }

    @Test
    public void testDtoToEntity() {
        AuthorityDto dto = new AuthorityDto();
        dto.setId(1);
        dto.setPermission("some.permission");

        Authority entity = authorityMapper.roleDtoToAuthority(dto);

        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getPermission(), dto.getPermission());
    }
}
