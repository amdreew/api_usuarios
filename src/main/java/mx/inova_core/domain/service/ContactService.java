package mx.inova_core.domain.service;

import lombok.AllArgsConstructor;
import mx.inova_core.domain.model.Contact;
import mx.inova_core.domain.port.ContactPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactService {
    private final ContactPort port;
    public Contact getById(Long id) {
        return this.port.getById(id);
    }
    public Contact save(Contact contact) {
        return this.port.save(contact);
    }
    public List<Contact> getAll() {
        return this.port.getAll();
    }
    public void deleteById(Long id) {
        this.port.deleteById(id);
    }

}
