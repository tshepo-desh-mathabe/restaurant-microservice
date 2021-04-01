package dubby.serve.service.signup.util.helper;

import dubby.serve.service.signup.domain.dto.oauth.UserDto;
import dubby.serve.service.signup.util.property_fetcher.IPropertyFetcher;

public interface IDefaultApplier {

    void applyDefaults(UserDto request, IPropertyFetcher propertyFetcher);
}
