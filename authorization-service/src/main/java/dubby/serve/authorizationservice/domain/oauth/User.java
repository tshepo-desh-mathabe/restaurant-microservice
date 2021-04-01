package dubby.serve.authorizationservice.domain.oauth;

import dubby.serve.authorizationservice.audit.DateAudit;
import dubby.serve.authorizationservice.domain.ContactDetails;
import dubby.serve.authorizationservice.domain.UserAccountStatus;

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

    @NotNull
    @Column(name = "PASSWORD")
    @Size(min = 2, max = 70, message = "Password Should Be Less Than or Equal To 40 Characters")
    private String password;

//    @Email
//    @NotNull
//    @Column(name = "EMAIL")
//    @Size(min = 10, max = 60, message = "Email Address Should Be Less Than or Equal To 60 Characters")
//    private String email;

    @Column(name = "ENABLED", nullable = false, columnDefinition = "TINYINT", length = 1)
    private Boolean isEnabled;

    @Column(name = "accountNonExpired", nullable = false, columnDefinition = "TINYINT", length = 1)
    private Boolean accountNonExpired;

    @Column(name = "credentialsNonExpired", nullable = false, columnDefinition = "TINYINT", length = 1)
    private Boolean credentialsNonExpired;

    @Column(name = "accountNonLocked", nullable = false, columnDefinition = "TINYINT", length = 1)
    private Boolean accountNonLocked;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
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

    public User() {}

    public  User(User user) {
        this.id = user.getId();
        this.knownAs = user.getKnownAs();
        this.firstName  = user.getFirstName();
        this.lastName = user.getLastName();
        this.password = user.getPassword();
//        this.email = user.getEmail();
        this.isEnabled = user.getEnabled();
        this.accountNonExpired = user.getAccountNonExpired();
        this.credentialsNonExpired = user.getCredentialsNonExpired();
        this.accountNonLocked = user.getAccountNonLocked();
        this.roles = user.getRoles();
        this.contactDetails = user.getContactDetails();
        this.userAccountStatus = user.getUserAccountStatus();
    }

    public Long getId() {
        return id;
    }

    public String getKnownAs() {
        return knownAs;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

//    public String getEmail() {
//        return email;
//    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public UserAccountStatus getUserAccountStatus() {
        return userAccountStatus;
    }
}
