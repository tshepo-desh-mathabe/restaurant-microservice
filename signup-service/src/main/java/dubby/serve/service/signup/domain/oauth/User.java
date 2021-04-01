package dubby.serve.service.signup.domain.oauth;

import dubby.serve.service.signup.audit.DateAudit;
import dubby.serve.service.signup.domain.ContactDetails;
import dubby.serve.service.signup.domain.UserAccountStatus;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * A User entity
 */
@Entity
@Table(name = "USER", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "USERNAME"
        })
})
public class User extends DateAudit implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "USERNAME")
    @Size(min = 2, max = 40, message = "Username Should Be Less Than or Equal To 40 Characters")
    private String knownAs;

    @NotNull
    @Column(name = "FIRST_NAME")
    @Size(min = 2, max = 40, message = "First Name Should Be Less Than or Equal To 40 Characters")
    private String firstName;

    @NotNull
    @Column(name = "LAST_NAME")
    @Size(min = 2, max = 40, message = "Last Name Should Be Less Than or Equal To 40 Characters")
    private String lastName;

    @Email
    @NotNull
    @Column(name = "EMAIL")
    @Size(min = 10, max = 60, message = "Email Address Should Be Less Than or Equal To 60 Characters")
    private String email;

    @NotNull
    @Column(name = "PASSWORD")
    @Size(min = 2, max = 70, message = "Password Should Be Less Than or Equal To 40 Characters")
    private String password;

    @Column(name = "ENABLED", nullable = false, columnDefinition = "TINYINT", length = 1)
    private Boolean isEnabled;

    @Column(name = "accountNonExpired", nullable = false, columnDefinition = "TINYINT", length = 1)
    private Boolean accountNonExpired;

    @Column(name = "credentialsNonExpired", nullable = false, columnDefinition = "TINYINT", length = 1)
    private Boolean credentialsNonExpired;

    @Column(name = "accountNonLocked", nullable = false, columnDefinition = "TINYINT", length = 1)
    private Boolean accountNonLocked;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_user")
    private List<UserRole> roles;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Contact Details Cannot Be Empty")
    @JoinColumn(name = "CONTACT_DETAILS_ID", referencedColumnName = "CONTACT_ID")
    private ContactDetails contactDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "User Account Status Cannot Be Empty")
    @JoinColumn(name = "USER_ACCOUNT_STATUS_ID", referencedColumnName = "ACCOUNT_STATUS_ID")
    private UserAccountStatus userAccountStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public UserAccountStatus getUserAccountStatus() {
        return userAccountStatus;
    }

    public void setUserAccountStatus(UserAccountStatus userAccountStatus) {
        this.userAccountStatus = userAccountStatus;
    }
}
