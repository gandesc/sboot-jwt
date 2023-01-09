package ro.gandesc.jwt.web.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Getter
@Setter
public class UserDto {
    private Integer id;
    @NotNull
    @Size(max = 255)
    private String username;

    @NotNull
    private Boolean accountNonExpired;

    @NotNull
    private Boolean accountNonLocked;

    @NotNull
    private Boolean credentialsNonExpired;

    @NotNull
    private Boolean enabled;

    private Timestamp createdAt;
    private Timestamp updatedAt;
}
