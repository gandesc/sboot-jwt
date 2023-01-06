package ro.gandesc.jwt.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ro.gandesc.jwt.domain.security.User;
import ro.gandesc.jwt.repositories.security.UserRepository;
import ro.gandesc.jwt.web.mappers.UserMapper;
import ro.gandesc.jwt.web.models.UserDto;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto getUser(String username) {
       Optional<User> userOptional = userRepository.findByUsername(username);

       if(userOptional.isPresent()) {
           return userMapper.userToUserDto(userOptional.get());
       } else {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found. username: " + username);
       }
    }
}
