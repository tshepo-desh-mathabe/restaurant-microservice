package dubby.serve.service.update.accountupdate.util.property_fetcher;

import dubby.serve.service.update.accountupdate.util.constants.AppConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Implementation for property retrieval operator
 * Here we get a property and insert it in a field
 */
@Component
public class PropertyFetcherImpl implements IPropertyFetcher {

    @Value("${response.successful.text.user-registered}")
    private String successUserRegistration;
    @Value("${response.unsuccessful.text.bad-mail-format}")
    private String badEmailFormat;
    @Value("${response.unsuccessful.text.mail-in-use}")
    private String emailInUse;
    @Value("${response.unsuccessful.text.mail-not-sent}")
    private String emailNotSent;
    @Value("${response.unsuccessful.text.bad-mobile-number}")
    private String badMobileNumber;
    @Value("${response.unsuccessful.text.mobile-number-in-use}")
    private String mobileNumberInUse;
    @Value("${response.unsuccessful.text.username-taken}")
    private String usernameTaken;
    @Value("${response.unsuccessful.text.contact-details-required}")
    private String contactDetailsRequired;
    @Value("${service.path.verify-email}")
    private String verifyEmailServicePath;
    @Value("${data.text.verification-message-reason}")
    private String verificationMsgReason;
    @Value("${regex.pattern.ip-address}")
    private String ipAddressRegex;
    @Value("${data.text.unrecognized-ip}")
    private String unrecognizedIp;
//    @Value("${spring.datasource.username}")
//    private String databaseUsername;
//    @Value("${spring.datasource.password}")
//    private String databasePassword;
//    @Value("${spring.datasource.url.profile-account}")
//    private String databaseUrl;

    @Override
    public String getProperty(AppConstant keyValue) {
        return switch (keyValue) {
            case USER_REGISTERED_MESSAGE -> successUserRegistration;
            case BAD_EMAIL_FORMAT_MESSAGE -> badEmailFormat;
            case EMAIL_IN_USE_MESSAGE -> emailInUse;
            case BAD_MOBILE_NUMBER_MESSAGE -> badMobileNumber;
            case EMAIL_NOT_SENT_MESSAGE -> emailNotSent;
            case MOBILE_NUMBER_IN_USE_MESSAGE -> mobileNumberInUse;
            case USERNAME_TAKEN_MESSAGE -> usernameTaken;
            case CONTACT_DETAILS_REQUIRED_MESSAGE -> contactDetailsRequired;
            case VERIFY_EMAIL_PATH_SERVICE -> verifyEmailServicePath;
            case VERIFICATION_REASON_MESSAGE -> verificationMsgReason;
            case UNRECOGNIZED_IP_MESSAGE -> unrecognizedIp;
            case IP_ADDRESS_REGEX -> ipAddressRegex;
//            case DATABASE_URL -> databaseUrl;
//            case DATABASE_USERNAME -> databaseUsername;
//            case DATABASE_PASSWORD -> databasePassword;
        };
    }

}
