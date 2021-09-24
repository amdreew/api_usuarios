package mx.inova_core.infrastructure.adapter.repository.jpa;

import mx.inova_core.infrastructure.adapter.repository.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactJpaRepository extends JpaRepository<ContactEntity, Long> {
}
