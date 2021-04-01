package dubby.serve.service.update.accountupdate.domain.dto;

/**
 * A Contact Details DTO
 */
public class ContactDetailsDto {

    private Long contactId;
    private MobileNumberDto mobileNumberDetails;
    private EmailAddressDto emailAddressDetails;
    private DeviceIpAddressDto deviceIpAddressDetails;

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public MobileNumberDto getMobileNumberDetails() {
        return mobileNumberDetails;
    }

    public void setMobileNumberDetails(MobileNumberDto mobileNumberDetails) {
        this.mobileNumberDetails = mobileNumberDetails;
    }

    public EmailAddressDto getEmailAddressDetails() {
        return emailAddressDetails;
    }

    public void setEmailAddressDetails(EmailAddressDto emailAddressDetails) {
        this.emailAddressDetails = emailAddressDetails;
    }

    public DeviceIpAddressDto getDeviceIpAddressDetails() {
        return deviceIpAddressDetails;
    }

    public void setDeviceIpAddressDetails(DeviceIpAddressDto deviceIpAddressDetails) {
        this.deviceIpAddressDetails = deviceIpAddressDetails;
    }
}
