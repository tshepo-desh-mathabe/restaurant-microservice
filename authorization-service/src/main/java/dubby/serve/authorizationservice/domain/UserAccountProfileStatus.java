package dubby.serve.authorizationservice.domain;

import dubby.serve.authorizationservice.util.constants.AccountStatus;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A User Account Profile Status
 */
@Entity
@Table(name = "PROFILE_STATUS", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "ACCOUNT_STATUS"
        })
})
public class UserAccountProfileStatus implements Serializable {

    @Id
    @Column(name = "PROFILE_STATUS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NaturalId
    @Enumerated(EnumType.STRING)
    @Column(name = "ACCOUNT_STATUS", length = 10)
    private AccountStatus accountStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}
