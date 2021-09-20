package mx.inova_core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String code;
    private String password;
    private boolean enabled;
    private String name;
    private String lastName;
    private String email;
    private List<Role> roleEntities;
    private String creacteUser;
    private String endUpdateUser;
    private Timestamp createAt;
    private Timestamp endUpdateDate;
}
