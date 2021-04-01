package dubby.serve.emailservice.service;

import dubby.serve.emailservice.payload.VerificationBody;
import dubby.serve.emailservice.service.util.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    @Autowired
    private IService service;

    public void signUpVerification(VerificationBody body) {
        service.registrationMail(body);
    }
}
