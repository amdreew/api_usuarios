package mx.inova_core.app.port;

import mx.inova_core.app.dto.ContactDTO;

import java.util.List;

public interface ContactAppPort {
    ContactDTO getById(Long id);
    ContactDTO update(ContactDTO contactDTO);
    ContactDTO save(ContactDTO contactDTO);
    List<ContactDTO> getAll();
    String deleteById(Long id);
}
