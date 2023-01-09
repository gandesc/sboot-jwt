package ro.gandesc.jwt.web.mappers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ro.gandesc.jwt.domain.security.User;
import ro.gandesc.jwt.web.models.UserDto;

import static org.junit.jupiter.api.Assertions.*;

public class UserMapperTest {

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    public void testEntityToDto() {
        User entity = User.builder()
                .id(1)
                .username("username")
                .password("password")
                .build();

        UserDto dto = userMapper.userToUserDto(entity);

        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getUsername(), dto.getUsername());
        assertNull(dto.getPassword());
        assertEquals(entity.getAccountNonExpired(), dto.getAccountNonExpired());
        assertEquals(entity.getAccountNonLocked(), dto.getAccountNonLocked());
        assertEquals(entity.getCredentialsNonExpired(), dto.getCredentialsNonExpired());
        assertEquals(entity.getEnabled(), dto.getEnabled());
    }

    @Test
    public void testDtoToEntity() {
        UserDto dto = new UserDto();
        dto.setId(1);
        dto.setUsername("username");
        dto.setPassword("password");
        dto.setAccountNonExpired(true);
        dto.setAccountNonLocked(true);
        dto.setCredentialsNonExpired(true);
        dto.setEnabled(true);

        User entity = userMapper.userDtoToUser(dto);

        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getUsername(), dto.getUsername());
        assertEquals(entity.getPassword(), entity.getPassword());
        assertEquals(entity.getAccountNonExpired(), dto.getAccountNonExpired());
        assertEquals(entity.getAccountNonLocked(), dto.getAccountNonLocked());
        assertEquals(entity.getCredentialsNonExpired(), dto.getCredentialsNonExpired());
        assertEquals(entity.getEnabled(), dto.getEnabled());
    }
}
