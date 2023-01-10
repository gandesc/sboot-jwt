package ro.gandesc.jwt.web.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Getter
@Setter
public class RoleDto {
    private Integer id;
    @NotNull
    @Size(max = 255)
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
