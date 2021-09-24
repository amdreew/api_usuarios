package mx.inova_core.domain.port;

import mx.inova_core.domain.model.Contact;

import java.util.List;

public interface ContactPort {
    Contact getById(Long id);
    Contact save(Contact contact);
    List<Contact> getAll();
    void deleteById(Long id);
}
