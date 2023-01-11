package ro.gandesc.jwt.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.gandesc.jwt.services.UserServiceImpl;
import ro.gandesc.jwt.web.models.AuthUserDto;
import ro.gandesc.jwt.web.models.UserDto;

@RequiredArgsConstructor
@CrossOrigin(origins = {"${app.security.cors.origin}"})
@RestController
@RequestMapping("users")
public class UserController {

	private final UserServiceImpl userService;

	@GetMapping("authenticated")
	public AuthUserDto getUser(Authentication authentication) {
		return userService.getUser(authentication.getName());
	}
}
