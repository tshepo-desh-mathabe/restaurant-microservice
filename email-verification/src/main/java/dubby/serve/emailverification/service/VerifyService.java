package dubby.serve.emailverification.service;

import dubby.serve.emailverification.dto.VerifyDto;
import dubby.serve.emailverification.util.helper.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VerifyService {

    @Autowired
    private IService service;

    public void createVerification(VerifyDto verifyDto) {
        service.saveData(verifyDto);
    }

    public void deleteVerification(String token) {
        service.deleteData(token);
    }
}
