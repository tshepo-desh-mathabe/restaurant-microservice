package dubby.serve.emailverification.resource;

import dubby.serve.emailverification.dto.VerifyDto;
import dubby.serve.emailverification.service.VerifyService;
import dubby.serve.emailverification.util.constants.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = ServicePath.BASE_DOMAIN_SERVICE)
@RequestMapping(ServicePath.ENTRY_POINT)
public class VerifyController {

    @Autowired
    private VerifyService verifyService;

    @PostMapping(ServicePath.SAVE_POINT)
    public void saveVerificationData(@RequestBody VerifyDto verificationBody) {
        verifyService.createVerification(verificationBody);
    }

    @DeleteMapping(ServicePath.DELETE_BY_ID)
    public void deleteEmailVerification(@PathVariable("id") String token) {
        verifyService.deleteVerification(token);
    }
}
