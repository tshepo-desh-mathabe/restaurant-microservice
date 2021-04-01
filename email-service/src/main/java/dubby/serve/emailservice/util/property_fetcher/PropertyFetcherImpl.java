package dubby.serve.emailservice.util.property_fetcher;

import dubby.serve.emailservice.util.constants.AppConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Implementation for property retrieval operator
 * Here we get a property and insert it in a field
 */
@Component
public class PropertyFetcherImpl implements IPropertyFetcher {

    @Value("${data.text.subject.user-registration}")
    private String userRegistrationSubject;
    @Value("${app.front-end.url.user-sign-up-verification}")
    private String userRegistrationFrontendUrl;

    @Override
    public String getProperty(AppConstant keyValue) {
        return switch (keyValue) {
            case USER_REGISTRATION_SUBJECT -> userRegistrationSubject;
            case USER_REGISTRATION_FRONTEND_URL -> userRegistrationFrontendUrl;
        };
    }

}
