package ro.gandesc.quoth.jwt.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ro.gandesc.quoth.jwt.domain.security.User;
import ro.gandesc.quoth.jwt.repositories.security.UserRepository;

@Slf4j
@RequiredArgsConstructor
@Component
public class DefaultDataLoader implements CommandLineRunner {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        loadSecurityData();
    }

    private void loadSecurityData() {
        User admin = userRepository.save(User.builder()
            .username("admin")
            .password(passwordEncoder.encode("pass"))
            .build());

        log.info("loaded security data");
    }
}
