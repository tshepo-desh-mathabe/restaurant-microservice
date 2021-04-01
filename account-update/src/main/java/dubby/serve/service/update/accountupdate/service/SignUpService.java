package dubby.serve.service.update.accountupdate.service;

import dubby.serve.service.update.accountupdate.domain.dto.oauth.UserDto;
import dubby.serve.service.update.accountupdate.util.helper.IService;
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
