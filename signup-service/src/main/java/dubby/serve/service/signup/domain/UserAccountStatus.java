package dubby.serve.service.signup.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A User Account Status
 */
@Entity
@Table(name = "USER_ACCOUNT_STATUS")
public class UserAccountStatus implements Serializable {

        @Id
        @Column(name = "ACCOUNT_STATUS_ID")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "REASON", length = 60)
        private String reason;

        @OneToOne
        @NotNull(message = "User Account Profile Status Details Cannot Be Empty")
        @JoinColumn(name = "PROFILE_STATUS_ID", referencedColumnName = "PROFILE_STATUS_ID")
        private UserAccountProfileStatus userAccountProfileStatus;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getReason() {
                return reason;
        }

        public void setReason(String reason) {
                this.reason = reason;
        }

        public UserAccountProfileStatus getUserAccountProfileStatus() {
                return userAccountProfileStatus;
        }

        public void setUserAccountProfileStatus(UserAccountProfileStatus userAccountProfileStatus) {
                this.userAccountProfileStatus = userAccountProfileStatus;
        }
}
