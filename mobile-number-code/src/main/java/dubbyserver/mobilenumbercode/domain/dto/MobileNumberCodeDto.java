package dubbyserver.mobilenumbercode.domain.dto;

/**
 * A Mobile Country Code DTO
 */
public class MobileNumberCodeDto {

    private Long mobileNumberCodeId;
    private String mobileNumberCode;

    public Long getMobileNumberCodeId() {
        return mobileNumberCodeId;
    }

    public void setMobileNumberCodeId(Long mobileNumberCodeId) {
        this.mobileNumberCodeId = mobileNumberCodeId;
    }

    public String getMobileNumberCode() {
        return mobileNumberCode;
    }

    public void setMobileNumberCode(String mobileNumberCode) {
        this.mobileNumberCode = mobileNumberCode;
    }
}
