package dubby.serve.authorizationservice.domain.oauth;

import dubby.serve.authorizationservice.util.constants.RoleType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * A User Role entity
 */
@Entity
@Table(name = "ROLE", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "NAME"
        })
})
public class UserRole implements Serializable {

    @Id
    @Column(name = "ID", length = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "NAME", nullable = false, length = 15)
    private RoleType roleType;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permission_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<Permission> permissions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
