package mx.inova_core.app.mapper;

import mx.inova_core.app.dto.UserDTO;
import mx.inova_core.domain.model.User;
import mx.inova_core.infrastructure.adapter.repository.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserAppMapper {
    User userDTOToUser(UserDTO userDTO);
    UserDTO userToUserDTO(User user);
}
