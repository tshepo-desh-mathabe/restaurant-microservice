package dubby.serve.emailverification.util.property_fetcher;

import dubby.serve.emailverification.util.constants.AppConstant;

/**
 * Property retrieval operator
 */
@FunctionalInterface
public interface IPropertyFetcher {

    /**
     * gets the property value/s
     * @param keyValue - key for property
     * @return - returns value/s of property
     */
    String getProperty(AppConstant keyValue);
}
