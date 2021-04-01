package dubby.serve.service.update.accountupdate.util.http;

import dubby.serve.service.update.accountupdate.payload.VerificationMessageBody;
import dubby.serve.service.update.accountupdate.util.constants.AppConstant;
import dubby.serve.service.update.accountupdate.util.property_fetcher.IPropertyFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class RestClient {

    @Autowired
    private IPropertyFetcher propertyFetcher;
    private RestTemplate template;
    private HttpHeaders headers;
    private HttpStatus status;

    public RestClient() {
        this.template = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    }

    public VerificationMessageBody post(VerificationMessageBody body) {
        String serviceUrl = propertyFetcher.getProperty(AppConstant.VERIFY_EMAIL_PATH_SERVICE);
        HttpEntity<VerificationMessageBody> request = new HttpEntity(body, headers);
        return template.postForObject(serviceUrl, request, VerificationMessageBody.class);
    }
}
