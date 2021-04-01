package dubby.serve.service.signup.resource;

import dubby.serve.service.signup.domain.dto.oauth.UserDto;
import dubby.serve.service.signup.service.SignUpService;
import dubby.serve.service.signup.util.constants.ServicePath;
import dubby.serve.service.signup.util.response.ResponseApiWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A sign-up controller API end point
 */
@RestController
@RequestMapping(ServicePath.ENTRY_POINT)
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @PostMapping(ServicePath.SAVE_POINT)
    public ResponseEntity<?> saveUser(@RequestBody UserDto userRequest) {
        try {
            return signUpService.createUser(userRequest);
        } catch (ConstraintViolationException e) {
            List<String> violations = e.getConstraintViolations()
                                    .stream()
                                    .map(i -> i.getMessageTemplate())
                                    .collect(Collectors.toList());

            return new ResponseApiWrapper().badRequest(violations);
        }
    }

}
