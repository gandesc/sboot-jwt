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

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Authority createProduct = Authority.builder().permission("products.create").build();
        Authority readProduct = Authority.builder().permission("products.read").build();
        Authority updateProduct = Authority.builder().permission("products.update").build();
        Authority deleteProduct = Authority.builder().permission("products.delete").build();

        authorityRepository.saveAll(Arrays.asList(createProduct, readProduct, updateProduct, deleteProduct));

        Role adminRole = roleRepository.save(Role.builder()
                .name("ADMIN")
                .authorities(Stream.of(createProduct, readProduct, updateProduct, deleteProduct)
                        .collect(Collectors.toSet()))
                .build());

        Role managerRole = roleRepository.save(Role.builder()
                .name("MANAGER")
                .authorities(Stream.of(createProduct, readProduct, updateProduct)
                        .collect(Collectors.toSet()))
                .build());

        User adminUser = userRepository.save(User.builder()
                .username("admin")
                .password(passwordEncoder.encode("pass"))
                .roles(Collections.singleton(adminRole))
                .build());

        User managerUser = userRepository.save(User.builder()
                .username("manager")
                .password(passwordEncoder.encode("pass"))
                .roles(Collections.singleton(managerRole))
                .build());


        log.info("loaded security data");
    }
}
