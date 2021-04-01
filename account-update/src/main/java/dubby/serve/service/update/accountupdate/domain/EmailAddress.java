package dubby.serve.service.update.accountupdate.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A Email Address entity
 */
@Entity
@Table(name = "EMAIL_ADDRESS", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "EMAIL"
        })
})
public class EmailAddress implements Serializable {

    @Id
    @Column(name = "EMAIL_ADDRESS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;

    @Email
    @NotNull
    @Column(name = "EMAIL")
    @Size(min = 10, max = 60, message = "Email Address Should Be Less Than or Equal To 60 Characters")
    private String address;

    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
