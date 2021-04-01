package dubby.serve.emailverification.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUNT_VERIFICATION", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "VERIFICATION_TOKEN"
        })
})
public class Verify extends UserVerificationAudit implements Serializable {

    @NaturalId
    @Size(max = 150)
    @Column(name = "VERIFICATION_TOKEN")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
