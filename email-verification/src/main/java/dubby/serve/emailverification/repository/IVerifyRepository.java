package dubby.serve.emailverification.repository;

import dubby.serve.emailverification.domain.Verify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IVerifyRepository extends JpaRepository<Verify, Long> {

    Boolean existsByToken(String token);

    void deleteByToken(String token);

    Optional<Verify> findByToken(String token);
}
