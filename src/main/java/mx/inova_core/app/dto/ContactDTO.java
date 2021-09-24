package mx.inova_core.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
    private Long id;
    @NotNull(message = "no puede ser null")
    @NotEmpty(message = "no puede ser vacio")
    private String name;
    @NotNull(message = "no puede ser null")
    @NotEmpty(message = "no puede ser vacio")
    private String lastName;
    @NotNull(message = "no puede ser null")
    private Date birth;
    private String foto;
    @NotNull(message = "no puede ser null")
    @NotEmpty(message = "no puede ser vacio")
    private String civilStatus;
    @NotNull(message = "no puede ser null")
    private Boolean hasBrothers;
    private Timestamp createdAt;
}
