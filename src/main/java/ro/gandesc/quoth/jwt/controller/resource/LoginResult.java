package ro.gandesc.quoth.jwt.controller.resource;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class LoginResult {
	
	@NonNull
	private String jwt;
}
