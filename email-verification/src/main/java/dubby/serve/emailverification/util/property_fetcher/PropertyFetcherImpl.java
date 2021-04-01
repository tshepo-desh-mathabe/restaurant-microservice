package dubby.serve.emailverification.util.property_fetcher;

import dubby.serve.emailverification.util.constants.AppConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Implementation for property retrieval operator
 * Here we get a property and insert it in a field
 */
@Component
public class PropertyFetcherImpl implements IPropertyFetcher {

    @Value("${service.path.mail-service}")
    private String emailServiceUri;

    @Override
    public String getProperty(AppConstant keyValue) {
        return switch (keyValue) {
            case EMAIL_SERVICE_PATH -> emailServiceUri;
        };
    }

}
