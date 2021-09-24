package mx.inova_core.app.service;

import lombok.AllArgsConstructor;
import mx.inova_core.app.dto.ContactDTO;
import mx.inova_core.app.mapper.ContactAppMapper;
import mx.inova_core.app.port.ContactAppPort;
import mx.inova_core.domain.service.ContactService;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ContactAppService implements ContactAppPort {

    private final ContactAppMapper mapper;
    private final ContactService service;

    @Override
    public ContactDTO getById(Long id) {
        return this.mapper.toDTO(this.service.getById(id));
    }

    @Override
    public ContactDTO update(ContactDTO contactDTO) {
        return this.mapper.toDTO(this.service.save(this.mapper.toDomain(contactDTO)));
    }

    @Override
    public ContactDTO save(ContactDTO contactDTO) {
        contactDTO.setCreatedAt(new Timestamp((new Date()).getTime()));
        return this.mapper.toDTO(this.service.save(this.mapper.toDomain(contactDTO)));
    }

    @Override
    public List<ContactDTO> getAll() {
        return this.service.getAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.service.deleteById(id);
    }
}
