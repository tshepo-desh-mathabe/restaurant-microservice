package dubby.serve.service.update.accountupdate.domain.dto.oauth;

import dubby.serve.service.update.accountupdate.domain.dto.ContactDetailsDto;
import dubby.serve.service.update.accountupdate.domain.dto.UserAccountStatusDto;
import dubby.serve.service.update.accountupdate.domain.dto.audit.DateAuditDto;

import java.util.List;

/**
 * A User DTO
 */
public class UserDto extends DateAuditDto {

    private Long userId;
    private String knownAs;
    private String firstName;
    private String lastName;
    private String pwd;
    private String emailAddress;
    private Boolean isEnabled;
    private Boolean accountNotExpired;
    private Boolean credentialsNotExpired;
    private Boolean accountNotLocked;
    private List<UserRoleDto> userRoleDetails;
    private ContactDetailsDto contactDetails;
    private UserAccountStatusDto userAccountStatusDetails;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getKnownAs() {
        return knownAs;
    }

    public void setKnownAs(String knownAs) {
        this.knownAs = knownAs;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Boolean getAccountNotExpired() {
        return accountNotExpired;
    }

    public void setAccountNotExpired(Boolean accountNotExpired) {
        this.accountNotExpired = accountNotExpired;
    }

    public Boolean getCredentialsNotExpired() {
        return credentialsNotExpired;
    }

    public void setCredentialsNotExpired(Boolean credentialsNotExpired) {
        this.credentialsNotExpired = credentialsNotExpired;
    }

    public Boolean getAccountNotLocked() {
        return accountNotLocked;
    }

    public void setAccountNotLocked(Boolean accountNotLocked) {
        this.accountNotLocked = accountNotLocked;
    }

    public List<UserRoleDto> getUserRoleDetails() {
        return userRoleDetails;
    }

    public void setUserRoleDetails(List<UserRoleDto> userRoleDetails) {
        this.userRoleDetails = userRoleDetails;
    }

    public ContactDetailsDto getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetailsDto contactDetails) {
        this.contactDetails = contactDetails;
    }

    public UserAccountStatusDto getUserAccountStatusDetails() {
        return userAccountStatusDetails;
    }

    public void setUserAccountStatusDetails(UserAccountStatusDto userAccountStatusDetails) {
        this.userAccountStatusDetails = userAccountStatusDetails;
    }
}
