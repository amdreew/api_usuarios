package mx.inova_core.infrastructure.adapter.repository.innovaCore;

import lombok.AllArgsConstructor;
import mx.inova_core.domain.model.Contact;
import mx.inova_core.domain.port.ContactPort;
import mx.inova_core.infrastructure.adapter.repository.jpa.ContactJpaRepository;
import mx.inova_core.infrastructure.adapter.repository.mapper.ContactMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ContactRepositoryAdapter implements ContactPort {
    private final ContactMapper mapper;
    private final ContactJpaRepository jpa;

    @Override
    public Contact getById(Long id) {
        return this.mapper.toDomain(this.jpa.findById(id).orElse(null));
    }

    @Override
    public Contact save(Contact contact) {
        return this.mapper.toDomain(this.jpa.save(this.mapper.toEntity(contact)));
    }

    @Override
    public List<Contact> getAll() {
        return this.jpa.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.jpa.deleteById(id);
    }
}
