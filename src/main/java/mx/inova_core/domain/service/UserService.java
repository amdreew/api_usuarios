package mx.inova_core.domain.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.inova_core.domain.model.User;
import mx.inova_core.domain.port.UserPort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserPort userPort ;

    public User getById(Long id) {
        return this.userPort.getById(id);
    }
    public User getByUserName(String userName) {
        return this.userPort.getByUserName(userName);
    }
    public User save(User user) {
        return this.userPort.save(user);
    }
    public List<User> getAll() {
        return this.userPort.getAll();
    }
    public void deleteById(Long id) {
        this.userPort.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Error en el login: no existe el usuario '" + username + "' en el sistema!");
        }
        List<GrantedAuthority> authorities = user.getRoleEntities().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getName()))
                .peek(authority -> log.info("Role: " + authority.getAuthority()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
    }
}
