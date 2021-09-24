package mx.inova_core.app.mapper;

import mx.inova_core.app.dto.ContactDTO;
import mx.inova_core.domain.model.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactAppMapper {
    ContactDTO toDTO(Contact contact);
    Contact toDomain(ContactDTO contactDTO);
}
