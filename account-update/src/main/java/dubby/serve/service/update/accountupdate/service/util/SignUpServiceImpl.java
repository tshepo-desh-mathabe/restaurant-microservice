package dubby.serve.service.update.accountupdate.service.util;

import dubby.serve.service.update.accountupdate.domain.dto.oauth.UserDto;
import dubby.serve.service.update.accountupdate.domain.oauth.User;
import dubby.serve.service.update.accountupdate.payload.VerificationMessageBody;
import dubby.serve.service.update.accountupdate.repository.IEmailAddressRepository;
import dubby.serve.service.update.accountupdate.repository.IMobileNumberRepository;
import dubby.serve.service.update.accountupdate.repository.IUserRepository;
import dubby.serve.service.update.accountupdate.util.constants.AppConstant;
import dubby.serve.service.update.accountupdate.util.helper.IDefaultApplier;
import dubby.serve.service.update.accountupdate.util.helper.IModelMapper;
import dubby.serve.service.update.accountupdate.util.helper.IStoreDoctor;
import dubby.serve.service.update.accountupdate.util.http.RestClient;
import dubby.serve.service.update.accountupdate.util.property_fetcher.IPropertyFetcher;
import dubby.serve.service.update.accountupdate.util.response.ApiResponse;
import dubby.serve.service.update.accountupdate.util.response.ResponseApiWrapper;
import dubby.serve.service.update.accountupdate.util.validator.IValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Service implementation logic
 */
@Component
public class SignUpServiceImpl implements IStoreDoctor<UserDto> {

    @Autowired
    private RestClient restClient;
    @Autowired
    private IValidator validator;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IPropertyFetcher propertyFetcher;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IEmailAddressRepository emailAddressRepository;
    @Autowired
    private IMobileNumberRepository mobileNumberRepository;
    @Autowired
    private IModelMapper<User, UserDto> userMapper;
    @Autowired
    private IDefaultApplier defaultApplier;

    @Override
    public ResponseEntity<?> saveData(UserDto userDto){
        if(!isPersistentReady(userDto).getSuccess()) {
            return ResponseApiWrapper.badRequest(isPersistentReady(userDto).getMessage());
        } else {
            userDto.setPwd(passwordEncoder.encode(userDto.getPwd()));
            sendToVerificationService(userDto, userRepository.save(userMapper.toEntity(userDto)).getId());
            return ResponseApiWrapper.okRequest(propertyFetcher.getProperty(AppConstant.USER_REGISTERED_MESSAGE));
        }
    }

    @Override
    public ApiResponse isPersistentReady(UserDto userRequest) {
        if (userRepository.existsByKnownAs(userRequest.getKnownAs())) {
            return new ApiResponse(false, propertyFetcher.getProperty(AppConstant.USERNAME_TAKEN_MESSAGE));
        } else if (!isContactPersistReady(userRequest).getSuccess()) {
            return isContactPersistReady(userRequest);
        } else if(!validator.isBadIpAddress(userRequest.getContactDetails().getDeviceIpAddressDetails().getDeviceIpAddress())) {
            return new ApiResponse(false, propertyFetcher.getProperty(AppConstant.UNRECOGNIZED_IP_MESSAGE));
        }
        else {
            defaultApplier.applyDefaults(userRequest, propertyFetcher);
            return new ApiResponse(true);
        }
    }

    private ApiResponse isContactPersistReady(UserDto userRequest) {
        if (userRequest.getContactDetails() != null) {
            if (!validator.isValidEmailAddress(userRequest.getContactDetails().getEmailAddressDetails())) {
                return new ApiResponse(false, propertyFetcher.getProperty(AppConstant.BAD_EMAIL_FORMAT_MESSAGE));
            }  else if (emailAddressRepository.existsByAddress(userRequest.getContactDetails().getEmailAddressDetails().getMailAddress())) {
                return new ApiResponse(false, propertyFetcher.getProperty(AppConstant.EMAIL_IN_USE_MESSAGE));
            } else if (userRequest.getContactDetails().getEmailAddressDetails().getMailAddress() != null
                    && mobileNumberRepository.existsByNumber(userRequest.getContactDetails().getMobileNumberDetails().getNumber())) {
                return new ApiResponse(false, propertyFetcher.getProperty(AppConstant.MOBILE_NUMBER_IN_USE_MESSAGE));
            } else {
                return new ApiResponse(true);
            }
        } else {
            return new ApiResponse(false, propertyFetcher.getProperty(AppConstant.CONTACT_DETAILS_REQUIRED_MESSAGE));
        }
    }

    private void sendToVerificationService(UserDto userDto, long id) {
        var messageBody = new VerificationMessageBody();
        messageBody.setCreatedByUserId(id);
        messageBody.setEmailAddress(userDto.getContactDetails().getEmailAddressDetails().getMailAddress());
        messageBody.setFullName(userDto.getFirstName() + " " +userDto.getLastName());
        restClient.post(messageBody);
    }
}
