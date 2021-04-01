package dubby.serve.service.signup.repository;

import dubby.serve.service.signup.domain.MobileNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A Mobile Number CRUD operator
 */
@Repository
public interface IMobileNumberRepository extends JpaRepository<MobileNumber, Long> {

    boolean existsByNumber(String mobileNumber);
}