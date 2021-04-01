package dubby.serve.service.signup.repository;

import dubby.serve.service.signup.domain.oauth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A User CRUD operator
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    boolean existsByKnownAs(String username);

    User getByContactDetails(String emailAddress);
}
