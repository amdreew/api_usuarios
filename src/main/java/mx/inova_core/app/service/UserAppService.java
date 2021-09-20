package mx.inova_core.app.service;

import lombok.AllArgsConstructor;
import mx.inova_core.app.dto.UserDTO;
import mx.inova_core.app.mapper.UserAppMapper;
import mx.inova_core.app.port.UserAppPort;
import mx.inova_core.domain.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserAppService implements UserAppPort {

    private final UserService userService;
    private final UserAppMapper userAppMapper;

    @Override
    public UserDTO getById(Long id) {
        return this.userAppMapper.userToUserDTO(this.userService.getById(id));
    }

    @Override
    public UserDTO getByUserName(String userName) {
        return this.userAppMapper.userToUserDTO(this.userService.getByUserName(userName));
    }

    @Override
    public UserDTO save(UserDTO user) {
        return this.userAppMapper.userToUserDTO(this.userService.save(this.userAppMapper.userDTOToUser(user)));
    }

    @Override
    public List<UserDTO> getAll() {
        return this.userService.getAll()
                .stream()
                .map(userAppMapper::userToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.userService.deleteById(id);
    }
}
