package ro.gandesc.jwt.web.mappers;

import org.mapstruct.Mapper;
import ro.gandesc.jwt.domain.security.User;
import ro.gandesc.jwt.web.models.UserDto;

@Mapper
public interface UserMapper {

    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
}
