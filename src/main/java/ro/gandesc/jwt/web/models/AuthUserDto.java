package ro.gandesc.jwt.web.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Collection;

@Getter
@Setter
public class AuthUserDto {
    private Integer id;
    private String username;
    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;

    private Boolean enabled;

    private Collection<String> authorities;

    private Timestamp createdAt;
    private Timestamp updatedAt;
}
