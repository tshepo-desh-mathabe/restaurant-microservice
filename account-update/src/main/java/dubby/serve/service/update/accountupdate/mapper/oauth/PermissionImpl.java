package dubby.serve.service.update.accountupdate.mapper.oauth;

import dubby.serve.service.update.accountupdate.domain.dto.oauth.PermissionDto;
import dubby.serve.service.update.accountupdate.domain.oauth.Permission;
import dubby.serve.service.update.accountupdate.util.constants.CrudPermission;
import dubby.serve.service.update.accountupdate.util.helper.IFieldPropertyMapper;
import dubby.serve.service.update.accountupdate.util.helper.IModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User Role Entity to DTO mapper implementor and vice-versa
 */
@Component
public class PermissionImpl implements IModelMapper<Permission, PermissionDto> {

    @Override
    public Permission toEntity(PermissionDto dto) {
        return null;
    }

    @Override
    public PermissionDto toDto(Permission entity) {
        return null;
    }

    @Override
    public List< Permission> toEntity(List< PermissionDto> dtos) {
        // check class cast exception --> suck on it!!!!!!!
        return dtos.stream().map(i ->  convertToEntity(i)).collect(Collectors.toList());
    }

    @Override
    public List< PermissionDto> toDto(List< Permission> entities) {
        // --> same here --> class cast exception --> its watching you!!!!
        return entities.stream().map(obj -> convertToDto(obj)).collect(Collectors.toList());
    }

    /**
     * Converts  Permission Entity to UserRoleDTO
     * @param permission - entity object to be converted into a DTO
     * @return - returns a converted Object in DTO format
     */
    private PermissionDto convertToDto(Permission permission) {
        if (permission != null) {
            IFieldPropertyMapper<PermissionDto> mapper = destination -> {
                destination.setId(permission.getId());
                destination.setPermission(permission.getName());
                return destination;
            };

            return mapper.mapTo(new PermissionDto());
        } else {
            return null;
        }
    }

    /**
     * Converts UserRoleDTO to  Permission entity
     * @param  permissionDto - DTO to be converted into an entity````````````````
     * @return - returns a converted Object in DTO format
     */
    private  Permission convertToEntity(PermissionDto  permissionDto) {
        if ( permissionDto != null) {
            IFieldPropertyMapper< Permission> mapper = destination -> {
                destination.setId(permissionDto.getId());
                destination.setName(CrudPermission.valueOf(permissionDto.getPermission().name()));
                return destination;
            };

            return mapper.mapTo(new  Permission());
        } else {
            return null;
        }

    }
}
