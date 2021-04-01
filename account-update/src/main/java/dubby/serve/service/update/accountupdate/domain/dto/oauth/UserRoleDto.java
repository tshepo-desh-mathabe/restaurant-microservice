package dubby.serve.service.update.accountupdate.domain.dto.oauth;

import java.util.List;

/**
 * A User Role DTO
 */
public class UserRoleDto {

    private Long roleId;
    private String type;
    private List<PermissionDto> permissions;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<PermissionDto> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionDto> permissions) {
        this.permissions = permissions;
    }
}
