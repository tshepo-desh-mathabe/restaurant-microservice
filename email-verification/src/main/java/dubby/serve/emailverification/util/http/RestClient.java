package dubby.serve.emailverification.util.http;

import dubby.serve.emailverification.dto.VerifyDto;
import dubby.serve.emailverification.util.constants.AppConstant;
import dubby.serve.emailverification.util.property_fetcher.IPropertyFetcher;
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

    public VerifyDto post(VerifyDto body) {
        String serviceUrl = propertyFetcher.getProperty(AppConstant.EMAIL_SERVICE_PATH);
        HttpEntity<VerifyDto> request = new HttpEntity(body, headers);
        return template.postForObject(serviceUrl, request, VerifyDto.class);
    }
//
//    private void disableSerializationFeature() {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setVisibility(mapper
//                .getSerializationConfig()
//                .getDefaultVisibilityChecker()
//                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
//                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
//                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE)
//        );
//    }
}
