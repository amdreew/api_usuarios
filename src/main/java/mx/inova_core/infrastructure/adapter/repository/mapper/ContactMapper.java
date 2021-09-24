package mx.inova_core.infrastructure.adapter.repository.mapper;

import mx.inova_core.domain.model.Contact;
import mx.inova_core.infrastructure.adapter.repository.entity.ContactEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {
    Contact toDomain(ContactEntity contactEntity);
    ContactEntity toEntity(Contact contact);
}
