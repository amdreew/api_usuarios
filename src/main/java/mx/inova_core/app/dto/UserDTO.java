package mx.inova_core.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private String username;
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private String code;
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private String password;
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private boolean enabled;
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private String name;
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private String lastName;
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private String email;
    private List<RoleDTO> roleEntities;
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private String creacteUser;
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private String endUpdateUser;
    private Timestamp createAt;
    private Timestamp endUpdateDate;
}
