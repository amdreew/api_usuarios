package mx.inova_core.infrastructure.adapter.repository.mapper;

import mx.inova_core.domain.model.User;
import mx.inova_core.infrastructure.adapter.repository.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    User userEntityToUser(UserEntity userEntity);
    UserEntity userToUserEntity(User user);
}
