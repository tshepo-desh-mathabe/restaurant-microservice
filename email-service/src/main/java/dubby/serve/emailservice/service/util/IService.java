package dubby.serve.emailservice.service.util;

import dubby.serve.emailservice.payload.VerificationBody;

public interface IService {

    void registrationMail(VerificationBody body);
}
