package dubbyserver.mobilenumbercode.service;

import dubbyserver.mobilenumbercode.domain.MobileNumberCode;
import dubbyserver.mobilenumbercode.domain.dto.MobileNumberCodeDto;
import dubbyserver.mobilenumbercode.repository.IMobileNumberCodeRepository;
import dubbyserver.mobilenumbercode.util.helper.IModelMapper;
import dubbyserver.mobilenumbercode.util.helper.IStoreDoctor;
import dubbyserver.mobilenumbercode.util.constants.AppConstant;
import dubbyserver.mobilenumbercode.util.property_fetcher.IPropertyFetcher;
import dubbyserver.mobilenumbercode.util.response.ApiResponse;
import dubbyserver.mobilenumbercode.util.response.ResponseApiWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Service implementation logic
 */
@Component
public class MobileNumberCodeServiceImpl implements IStoreDoctor<MobileNumberCodeDto> {

    @Autowired
    private IMobileNumberCodeRepository mobileNumberCodeRepository;
    @Autowired
    private IPropertyFetcher propertyFetcher;
    @Autowired
    private IModelMapper<MobileNumberCode, MobileNumberCodeDto> mobileNumberCodeMapper;

    @Override
    public ResponseEntity<?> saveData(MobileNumberCodeDto mobileNumberCodeDto) {
        if(!isPersistentReady(mobileNumberCodeDto).getSuccess()) {
            return ResponseApiWrapper.badRequest(isPersistentReady(mobileNumberCodeDto).getMessage());
        } else {
            mobileNumberCodeRepository.save(mobileNumberCodeMapper.toEntity(mobileNumberCodeDto));
            return ResponseApiWrapper.okRequest(propertyFetcher.getProperty(AppConstant.MOBILE_NUMBER_CODE_REGISTERED));
        }
    }

    @Override
    public ResponseEntity<?> retrieveAllData() {
        return ResponseApiWrapper.okRequest(mobileNumberCodeMapper.toDto(mobileNumberCodeRepository.findAll()));
    }

    @Override
    public ApiResponse isPersistentReady(MobileNumberCodeDto numberCodeRequest) {
        if (numberCodeRequest.getMobileNumberCode() != null
                && mobileNumberCodeRepository.existsByNumberCode(numberCodeRequest.getMobileNumberCode())) {
            return new ApiResponse(false, propertyFetcher.getProperty(AppConstant.MOBILE_NUMBER_CODE_EXIST));
        } else {
            return new ApiResponse(true);
        }
    }
}
