package dubby.serve.service.update.accountupdate.util.validator;

import dubby.serve.service.update.accountupdate.domain.dto.EmailAddressDto;
import dubby.serve.service.update.accountupdate.util.constants.AppConstant;
import dubby.serve.service.update.accountupdate.util.property_fetcher.IPropertyFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.regex.Pattern;

/**
 * Implementation object for validations
 */
@Component
public class ValidatorImpl implements IValidator {

    @Autowired
    private IPropertyFetcher propertyFetcher;

    @Override
    public boolean isValidEmailAddress(EmailAddressDto email) {
        if (email != null) {
            var isValidMail = true;
            try {
                var emailAddress = new InternetAddress(email.getMailAddress());
                emailAddress.validate();
            } catch (AddressException e) {
                isValidMail = false;
            }

            return isValidMail;
        }

        return false;
    }

    @Override
    public boolean isBadIpAddress(String ipAddress) {
        return Pattern.matches(propertyFetcher.getProperty(AppConstant.IP_ADDRESS_REGEX), ipAddress);
    }
}
