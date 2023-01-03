package ro.gandesc.jwt.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ro.gandesc.jwt.domain.security.Authority;
import ro.gandesc.jwt.domain.security.Role;
import ro.gandesc.jwt.domain.security.User;
import ro.gandesc.jwt.repositories.security.AuthorityRepository;
import ro.gandesc.jwt.repositories.security.RoleRepository;
import ro.gandesc.jwt.repositories.security.UserRepository;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Component
public class DefaultDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        loadSecurityData();
    }

    private void loadSecurityData() {
        Authority createQuote = Authority.builder().permission("quote.create").build();
        Authority updateQuote = Authority.builder().permission("quote.update").build();
        Authority deleteQuote = Authority.builder().permission("quote.delete").build();

        List<Authority> authorities = Arrays.asList(createQuote, updateQuote, deleteQuote);
        authorityRepository.saveAll(authorities);

        Role adminRole = roleRepository.save(Role.builder()
                .name("admin")
                .authorities(new HashSet<>(authorities))
                .build());

        User adminUser = userRepository.save(User.builder()
                .username("admin")
                .password(passwordEncoder.encode("pass"))
                .roles(Collections.singleton(adminRole))
                .build());


        log.info("loaded security data");
    }
}
