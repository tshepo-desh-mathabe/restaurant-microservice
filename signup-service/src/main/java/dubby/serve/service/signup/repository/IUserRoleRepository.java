package dubby.serve.service.signup.repository;

import dubby.serve.service.signup.domain.oauth.UserRole;
import dubby.serve.service.signup.util.constants.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A User Role CRUD operator
 */
@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByRoleType(RoleType type);

}
