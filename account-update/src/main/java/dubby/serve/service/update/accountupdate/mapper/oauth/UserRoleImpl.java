package dubby.serve.service.update.accountupdate.mapper.oauth;

import dubby.serve.service.update.accountupdate.domain.dto.oauth.UserRoleDto;
import dubby.serve.service.update.accountupdate.domain.oauth.UserRole;
import dubby.serve.service.update.accountupdate.util.constants.RoleType;
import dubby.serve.service.update.accountupdate.util.helper.IFieldPropertyMapper;
import dubby.serve.service.update.accountupdate.util.helper.IModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User Role Entity to DTO mapper implementor and vice-versa
 */
@Component
public class UserRoleImpl implements IModelMapper<UserRole, UserRoleDto> {

    @Override
    public UserRoleDto toDto(UserRole userRole) {
        return convertToDto(userRole);
    }

    @Override
    public UserRole toEntity(UserRoleDto userRoleDto) {
        return convertToEntity(userRoleDto);
    }

    @Override
    public List<UserRole> toEntity(List<UserRoleDto> dtos) {
        return dtos.stream().map(i ->  convertToEntity(i)).collect(Collectors.toList());
    }

    @Override
    public List<UserRoleDto> toDto(List<UserRole> entities) {
        return entities.stream().map(obj -> convertToDto(obj)).collect(Collectors.toList());
    }

    /**
     * Converts UserRole Entity to UserRoleDTO
     * @param userRole - entity object to be converted into a DTO
     * @return - returns a converted Object in DTO format
     */
    private UserRoleDto convertToDto(UserRole userRole) {
        if (userRole != null) {
            IFieldPropertyMapper<UserRoleDto> mapper = destination -> {
                destination.setRoleId(userRole.getId());
                destination.setType(String.valueOf(userRole.getRoleType()));
                destination.setPermissions(new PermissionImpl().toDto(userRole.getPermissions()));
                return destination;
            };

            return mapper.mapTo(new UserRoleDto());
        } else {
            return null;
        }
    }

    /**
     * Converts UserRoleDTO to UserRole entity
     * @param userRoleDto - DTO to be converted into an entity````````````````
     * @return - returns a converted Object in DTO format
     */
    private UserRole convertToEntity(UserRoleDto userRoleDto) {
        if (userRoleDto != null) {
            IFieldPropertyMapper<UserRole> mapper = destination -> {
                destination.setId(userRoleDto.getRoleId());
                destination.setRoleType(RoleType.valueOf(userRoleDto.getType()));
                destination.setPermissions(new PermissionImpl().toEntity(userRoleDto.getPermissions()));
                return destination;
            };

            return mapper.mapTo(new UserRole());
        } else {
            return null;
        }

    }
}
