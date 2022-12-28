package ro.gandesc.quoth.jwt.domain.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @JsonIgnore //TODO create user dto
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Singular
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "authority_role",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    private Set<Authority> authorities;
}
