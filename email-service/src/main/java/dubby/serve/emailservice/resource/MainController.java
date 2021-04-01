package dubby.serve.emailservice.resource;

import dubby.serve.emailservice.payload.VerificationBody;
import dubby.serve.emailservice.service.MainService;
import dubby.serve.emailservice.util.constants.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = ServicePath.BASE_DOMAIN_SERVICE)
@RequestMapping(ServicePath.ENTRY_POINT)
public class MainController {

    @Autowired
    private MainService service;

    @PostMapping(ServicePath.SIGN_UP_USER_POINT)
    public void verificationEmail(@RequestBody VerificationBody body) {
        service.signUpVerification(body);
    }

}
