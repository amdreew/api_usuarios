package mx.inova_core.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
    private Long id;
    private String name;
    private String lastName;
    private Date birth;
    private String foto;
    private String civilStatus;
    private Boolean hasBrothers;
}
