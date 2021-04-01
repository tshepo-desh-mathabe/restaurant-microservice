package dubby.serve.emailservice.util.mail_sender;

public interface IMailBody {

    String htmlMessageBody(String userFullName, int verificationToken);
}
