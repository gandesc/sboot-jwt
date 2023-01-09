package ro.gandesc.jwt.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ro.gandesc.jwt.domain.security.User;
import ro.gandesc.jwt.web.models.UserDto;

@Mapper
public interface UserMapper {

    @Mapping(source="user.authorities", target = "authorities")
    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);
}
