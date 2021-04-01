package dubby.serve.service.update.accountupdate.util.helper;

import dubby.serve.service.update.accountupdate.domain.dto.oauth.UserDto;
import dubby.serve.service.update.accountupdate.util.property_fetcher.IPropertyFetcher;

public interface IDefaultApplier {

    void applyDefaults(UserDto request, IPropertyFetcher propertyFetcher);
}
