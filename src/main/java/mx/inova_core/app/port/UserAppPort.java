package mx.inova_core.app.port;

import mx.inova_core.app.dto.UserDTO;
import mx.inova_core.domain.model.User;

import java.util.List;

public interface UserAppPort {
    UserDTO getById(Long id);
    UserDTO getByUserName(String userName);
    UserDTO save(UserDTO user);
    List<UserDTO> getAll();
    void deleteById(Long id);
}
