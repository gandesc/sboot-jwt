package ro.gandesc.jwt.web.controllers;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"${app.security.cors.origin}"})
@RestController
@RequestMapping("users")
public class UserController {

	private final UserDetailsService userDetailsService;

	public UserController(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@GetMapping("authenticated")
	public UserDetails getUser(Authentication authentication) {
		return userDetailsService.loadUserByUsername(authentication.getName());
	}
}
