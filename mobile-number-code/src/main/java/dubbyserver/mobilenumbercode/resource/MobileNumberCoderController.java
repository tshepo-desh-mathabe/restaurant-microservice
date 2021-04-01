package dubbyserver.mobilenumbercode.resource;

import dubbyserver.mobilenumbercode.domain.dto.MobileNumberCodeDto;
import dubbyserver.mobilenumbercode.service.MobileNumberCodeService;
import dubbyserver.mobilenumbercode.util.constants.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ServicePath.ENTRY_POINT)
public class MobileNumberCoderController {

    @Autowired
    private MobileNumberCodeService mobileNumberCodeService;

    @PostMapping(ServicePath.SAVE_POINT)
    @Secured({ "ROLE_ADMIN", "ROLE_SYS_USER" })
    public ResponseEntity saveCode(@RequestBody MobileNumberCodeDto numberCodeDto) {
        return mobileNumberCodeService.storeCodes(numberCodeDto);
    }

    @GetMapping(ServicePath.GET_ALL_POINT)
    public ResponseEntity getAllCodes() {
        return mobileNumberCodeService.retrieveAllNumberCodes();
    }

}
