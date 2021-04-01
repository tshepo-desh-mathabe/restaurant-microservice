package dubby.serve.emailservice.service.util;

import dubby.serve.emailservice.payload.VerificationBody;
import dubby.serve.emailservice.util.constants.AppConstant;
import dubby.serve.emailservice.util.mail_sender.EmailUtil;
import dubby.serve.emailservice.util.mail_sender.IMailBody;
import dubby.serve.emailservice.util.property_fetcher.IPropertyFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class ServiceImpl implements IService {

    @Autowired
    private EmailUtil emailUtil;
    @Autowired
    private IMailBody registrationMailBody;
    @Autowired
    private IPropertyFetcher propertyFetcher;

    @Override
    public void registrationMail(VerificationBody body) {
        String subject = propertyFetcher.getProperty(AppConstant.USER_REGISTRATION_SUBJECT);
        String htmlBody = registrationMailBody.htmlMessageBody(body.getFullName(), body.getVerificationToken());
        try {
            emailUtil.sendMail(body.getEmailAddress(), subject, htmlBody);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
