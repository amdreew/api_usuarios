package mx.inova_core.infrastructure.adapter.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
@DynamicUpdate
public class RoleEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private String name;

    @Column(name = "guard_name")
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private String guardName;

    @Column(name = "created_user")
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private String creacteUser;

    @Column(name = "updated_user")
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private String endUpdateUser;

    @Column(name = "created_at")
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private Timestamp createAt;

    @Column(name = "updated_at")
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private Timestamp endUpdateDate;
}
