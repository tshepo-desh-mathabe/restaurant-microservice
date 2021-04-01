package dubby.serve.service.update.accountupdate.repository;

import dubby.serve.service.update.accountupdate.domain.oauth.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A User CRUD operator
 */
@Repository
public interface IPermissionRepository extends JpaRepository<Permission, Long> {
}