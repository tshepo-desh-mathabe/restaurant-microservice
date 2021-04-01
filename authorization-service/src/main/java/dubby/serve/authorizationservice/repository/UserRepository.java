package dubby.serve.authorizationservice.repository;

import dubby.serve.authorizationservice.domain.oauth.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByKnownAs(String name);

}