package ro.gandesc.jwt.web.controllers.resource;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class LoginResult {

	@NonNull
	private String jwt;
}
