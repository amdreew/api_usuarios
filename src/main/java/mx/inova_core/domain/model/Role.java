package mx.inova_core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Long id;
    private String name;
    private String guardName;
    private String creacteUser;
    private String endUpdateUser;
    private Timestamp createAt;
    private Timestamp endUpdateDate;
}
