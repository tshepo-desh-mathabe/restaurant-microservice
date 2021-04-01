package dubby.serve.service.signup.domain.dto;

/**
 * A Mobile Number DTO
 */
public class MobileNumberDto {

    private Long phoneNumberId;
    private String number;
    private MobileNumberCodeDto mobileCountCodeDetail;

    public Long getPhoneNumberId() {
        return phoneNumberId;
    }

    public void setPhoneNumberId(Long phoneNumberId) {
        this.phoneNumberId = phoneNumberId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public MobileNumberCodeDto getMobileCountCodeDetail() {
        return mobileCountCodeDetail;
    }

    public void setMobileCountCodeDetail(MobileNumberCodeDto mobileCountCodeDetail) {
        this.mobileCountCodeDetail = mobileCountCodeDetail;
    }
}
