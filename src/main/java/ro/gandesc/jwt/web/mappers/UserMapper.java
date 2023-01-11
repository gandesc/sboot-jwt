package ro.gandesc.jwt.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.core.GrantedAuthority;
import ro.gandesc.jwt.domain.security.User;
import ro.gandesc.jwt.web.models.AuthUserDto;
import ro.gandesc.jwt.web.models.UserDto;

import java.util.Collection;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    UserDto userToUserDto(User user);

    AuthUserDto userToAuthUserDto(User user);

    User userDtoToUser(UserDto userDto);

    default Collection<String> grantedAuthoritiesToString(Collection<GrantedAuthority> authorities) {
        return authorities.stream()
                .map(a -> a.getAuthority())
                .collect(Collectors.toSet());
    }
}
