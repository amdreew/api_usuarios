package mx.inova_core.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private Long id;
    private String name;
    private String guardName;
    private String creacteUser;
    private String endUpdateUser;
    private Timestamp createAt;
    private Timestamp endUpdateDate;
}
