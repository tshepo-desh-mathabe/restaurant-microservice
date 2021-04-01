package dubby.serve.service.update.accountupdate.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A Contact Details entity
 */
@Entity
@Table(name = "CONTACT_DETAILS")
public class ContactDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTACT_ID")
    private Long contactId;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Mobile Number Cannot Be Empty")
    @JoinColumn(name = "MOBILE_NUMBER_ID", referencedColumnName = "MOBILE_NUMBER_ID")
    private MobileNumber mobileNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Email Address Cannot Be Empty")
    @JoinColumn(name = "EMAIL_ID", referencedColumnName = "EMAIL_ADDRESS_ID")
    private EmailAddress emailAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Device IP Address Cannot Be Empty")
    @JoinColumn(name = "DEVICE_IP_ADDRESS_ID", referencedColumnName = "IP_ADDRESS_ID")
    private DeviceIpAddress deviceIpAddress;

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public MobileNumber getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(MobileNumber mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }

    public DeviceIpAddress getDeviceIpAddress() {
        return deviceIpAddress;
    }

    public void setDeviceIpAddress(DeviceIpAddress deviceIpAddress) {
        this.deviceIpAddress = deviceIpAddress;
    }
}
