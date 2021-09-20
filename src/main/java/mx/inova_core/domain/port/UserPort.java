package mx.inova_core.domain.port;

import mx.inova_core.domain.model.User;

import java.util.List;

public interface UserPort {
    User getById(Long id);
    User getByUserName(String userName);
    User save(User name);
    List<User> getAll();
    void deleteById(Long id);
}
