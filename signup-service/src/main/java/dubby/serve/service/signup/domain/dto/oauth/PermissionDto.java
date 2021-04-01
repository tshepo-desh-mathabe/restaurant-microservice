package dubby.serve.service.signup.domain.dto.oauth;

import dubby.serve.service.signup.util.constants.CrudPermission;

public class PermissionDto {
    private Long id;
    private CrudPermission permission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CrudPermission getPermission() {
        return permission;
    }

    public void setPermission(CrudPermission permission) {
        this.permission = permission;
    }
}
