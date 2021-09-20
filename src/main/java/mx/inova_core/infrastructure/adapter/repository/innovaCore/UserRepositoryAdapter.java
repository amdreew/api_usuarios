package mx.inova_core.infrastructure.adapter.repository.innovaCore;

import lombok.AllArgsConstructor;
import mx.inova_core.domain.model.User;
import mx.inova_core.domain.port.UserPort;
import mx.inova_core.infrastructure.adapter.repository.jpa.UserEntityJpaRepository;
import mx.inova_core.infrastructure.adapter.repository.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserRepositoryAdapter implements UserPort {

    private final UserEntityJpaRepository userEntityJpaRepository;
    private final UserMapper userMapper;

    @Override
    public User getById(Long id) {
        return this.userMapper.userEntityToUser(this.userEntityJpaRepository.findById(id).orElse(null));
    }

    @Override
    public User getByUserName(String userName) {
        return this.userMapper.userEntityToUser(this.userEntityJpaRepository.findByUsername(userName));
    }

    @Override
    public User save(User user) {
        return this.userMapper.userEntityToUser(this.userEntityJpaRepository.save(this.userMapper.userToUserEntity(user)));
    }

    @Override
    public List<User> getAll() {
        return this.userEntityJpaRepository.findAll()
                .stream()
                .map(userMapper::userEntityToUser)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.userEntityJpaRepository.deleteById(id);
    }
}
