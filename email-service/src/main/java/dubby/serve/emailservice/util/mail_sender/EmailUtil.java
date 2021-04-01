package dubby.serve.emailservice.util.mail_sender;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class EmailUtil {

    /**
     * Sends an email
     * @param recipientEmail - address of the recipient email
     * @param subject - email subject/heading
     * @param body - mail body body to be sent
     * @throws MessagingException - messaging exception will be passed down the line
     */
    public void sendMail(String recipientEmail, String subject, String body) throws MessagingException {

        String myAccountEmail = "blindury@gmail.com";
        String myAccountEmailPassword = "killerory11";

        var session = getSession(getProperties(), myAccountEmail, myAccountEmailPassword);

        Message message = prepareMessage(session, body, subject, myAccountEmail, recipientEmail);
        Transport.send(message);
    }

    /**
     * Sets required email properties
     * @return returns set properties
     */
    private Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        return properties;
    }

    /**
     * Creates an email session
     * @param properties - email properties to be used
     * @param emailAddress - host account email address
     * @param password - host account password
     * @return - returns a configured session
     */
    private Session getSession(Properties properties, String emailAddress, String password) {
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailAddress, password);
            }
        });

        return session;
    }

    /**
     * Sets up the message to be sent
     * @param session - the session with the email provider
     * @param htmlMessageBody - HTML content message to be sent
     * @param senderAddress - the email address of the sender
     * @param recipientAddress - the email address of the recipient
     * @return returns a message prepared to be sent
     */
    private Message prepareMessage(Session session, String htmlMessageBody, String subject, String senderAddress, String recipientAddress) {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(senderAddress));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientAddress));
            message.setSubject(subject);
//            message.setText("HAHA --> My first");
            message.setContent(htmlMessageBody, "text/html");
            return message;
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
