package dubbyserver.mobilenumbercode.util.property_fetcher;

import dubbyserver.mobilenumbercode.util.constants.AppConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Implementation for property retrieval operator
 * Here we get a property and insert it in a field
 */
@Component
public class PropertyFetcherImpl implements IPropertyFetcher {

    @Value("${response.successful.text.mobile-number-code-registered}")
    private String mobileNumberCodeRegistration;
    @Value("${response.unsuccessful.text.mobile-country-code-exists}")
    private String mobileNumberCodeExists;

    @Override
    public String getProperty(AppConstant keyValue) {
        return switch (keyValue) {
            case MOBILE_NUMBER_CODE_EXIST -> mobileNumberCodeExists;
            case MOBILE_NUMBER_CODE_REGISTERED -> mobileNumberCodeRegistration;
        };
    }

}
