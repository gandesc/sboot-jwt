package ro.gandesc.quoth.jwt.controllers.resource;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class LoginResult {

	@NonNull
	private String jwt;
}
