package mx.inova_core.infrastructure.adapter.repository.jpa;

import mx.inova_core.infrastructure.adapter.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityJpaRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String userName);
}
