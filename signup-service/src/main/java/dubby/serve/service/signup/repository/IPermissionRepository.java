package dubby.serve.service.signup.repository;

import dubby.serve.service.signup.domain.oauth.Permission;
import dubby.serve.service.signup.domain.oauth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A User CRUD operator
 */
@Repository
public interface IPermissionRepository extends JpaRepository<Permission, Long> {
}