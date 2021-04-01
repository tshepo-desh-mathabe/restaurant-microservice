package dubby.serve.service.update.accountupdate.repository;

import dubby.serve.service.update.accountupdate.domain.UserAccountProfileStatus;
import dubby.serve.service.update.accountupdate.util.constants.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A User Role CRUD operator
 */
@Repository
public interface IUserAccountProfileStatusRepository extends JpaRepository<UserAccountProfileStatus, Long> {

    UserAccountProfileStatus getByAccountStatus(AccountStatus accountStatusValue);

}
