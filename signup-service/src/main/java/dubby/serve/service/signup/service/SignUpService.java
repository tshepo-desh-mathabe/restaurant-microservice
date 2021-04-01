package dubby.serve.service.signup.service;

import dubby.serve.service.signup.domain.dto.oauth.UserDto;
import dubby.serve.service.signup.util.helper.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Sign-up service used strictly by the controller
 */
@Service
public class SignUpService {

    @Autowired
    private IService<UserDto> service;

    public ResponseEntity<?> createUser(UserDto userRequest) {
        return service.saveData(userRequest);
    }
}
