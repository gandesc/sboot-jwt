package ro.gandesc.jwt.security;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import ro.gandesc.jwt.repositories.security.UserRepository;

import java.util.Collection;

@RequiredArgsConstructor
@Component
public class JwtGrantedAuthoritiesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    private final UserRepository userRepository;

    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {
        return userRepository.findByUsername(source.getClaimAsString("username"))
                .get()
                .getAuthorities();
    }
}
