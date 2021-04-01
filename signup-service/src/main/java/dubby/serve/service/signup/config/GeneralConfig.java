package dubby.serve.service.signup.config;

import dubby.serve.service.signup.util.property_fetcher.IPropertyFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class GeneralConfig {

    @Autowired
    private IPropertyFetcher propertyFetcher;

    /**
     * Spring needs a bean to be setup the PasswordEncoder
     * Here we create the required bean
     * @return - returns BCryptPasswordEncoder, given that there are multiple implementations for PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
