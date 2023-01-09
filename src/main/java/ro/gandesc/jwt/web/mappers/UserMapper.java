package ro.gandesc.jwt.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ro.gandesc.jwt.domain.security.User;
import ro.gandesc.jwt.web.models.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source="user.authorities", target = "authorities")
    @Mapping(target="password", ignore = true)
    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);
}
