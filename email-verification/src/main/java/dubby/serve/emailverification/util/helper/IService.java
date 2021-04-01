package dubby.serve.emailverification.util.helper;

import dubby.serve.emailverification.dto.VerifyDto;

/**
 * Service operator logic
 */
public interface IService {

    void saveData(VerifyDto verificationBody);

    void deleteData(String token);

}
