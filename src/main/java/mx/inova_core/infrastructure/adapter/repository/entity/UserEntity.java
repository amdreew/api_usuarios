package mx.inova_core.infrastructure.adapter.repository.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private String username;

    @Column(unique = true, length = 20)
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private String code;

    @Column(length = 60)
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    @Size(min = 8, message = "el tamaño de la contraseña debe ser mayor a 8  caracteres")
    private String password;

    private boolean enabled;

    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    @Size(min = 2, max = 20, message = "el tamaño del nombre estar entre 2 y 20 caracteres")
    private String name;

    @Column(name = "last_name")
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    @Size(min = 2, max = 20, message = "el tamaño del apellido estar entre 2 y 20 caracteres")
    private String lastName;

    @Column(unique = true)
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    @Email(message = "formato invalido use la notacion correo@example.local")
    private String email;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_rols", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn( name = "role_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role_id"})})
    private List<RoleEntity> roleEntities;


    @Column(name = "created_user")
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private String creacteUser;

    @Column(name = "update_user")
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
