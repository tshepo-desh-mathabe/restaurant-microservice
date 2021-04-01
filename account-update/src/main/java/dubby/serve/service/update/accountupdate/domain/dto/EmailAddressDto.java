package dubby.serve.service.update.accountupdate.domain.dto;

/**
 * A Email Address DTO
 */
public class EmailAddressDto {

    private Long emailId;
    private String mailAddress;

    public long getEmailId() {
        return emailId;
    }

    public void setEmailId(long emailId) {
        this.emailId = emailId;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
}
