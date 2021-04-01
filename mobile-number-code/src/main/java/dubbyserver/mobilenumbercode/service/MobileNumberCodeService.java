package dubbyserver.mobilenumbercode.service;

import dubbyserver.mobilenumbercode.domain.dto.MobileNumberCodeDto;
import dubbyserver.mobilenumbercode.util.helper.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MobileNumberCodeService {

    @Autowired
    private IService<MobileNumberCodeDto> service;

    public ResponseEntity storeCodes(MobileNumberCodeDto request) {
        return service.saveData(request);
    }

    public ResponseEntity retrieveAllNumberCodes() {
        return service.retrieveAllData();
    }
}
