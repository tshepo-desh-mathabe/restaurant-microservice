package dubbyserver.mobilenumbercode.repository;

import dubbyserver.mobilenumbercode.domain.MobileNumberCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMobileNumberCodeRepository extends JpaRepository<MobileNumberCode, Long> {

    boolean existsByNumberCode(String mobileCountryCode);
}
