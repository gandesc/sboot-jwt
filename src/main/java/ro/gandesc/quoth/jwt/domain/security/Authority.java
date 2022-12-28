package ro.gandesc.quoth.jwt.domain.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue
    private Integer id;

    private String permission;

    @JsonIgnore //TODO create user dto
    @ManyToMany(mappedBy = "authorities")
    private Set<Role> roles;
}
