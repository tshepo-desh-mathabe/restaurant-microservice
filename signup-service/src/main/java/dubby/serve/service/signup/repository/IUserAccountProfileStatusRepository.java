package dubby.serve.service.signup.repository;

import dubby.serve.service.signup.domain.UserAccountProfileStatus;
import dubby.serve.service.signup.util.constants.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A User Role CRUD operator
 */
@Repository
public interface IUserAccountProfileStatusRepository extends JpaRepository<UserAccountProfileStatus, Long> {

    UserAccountProfileStatus getByAccountStatus(AccountStatus accountStatusValue);

}
