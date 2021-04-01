package dubby.serve.service.update.accountupdate.repository;

import dubby.serve.service.update.accountupdate.domain.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A Email Address CRUD operator
 */
@Repository
public interface IEmailAddressRepository extends JpaRepository<EmailAddress, Long> {

    boolean existsByAddress(String emailAddress);
}