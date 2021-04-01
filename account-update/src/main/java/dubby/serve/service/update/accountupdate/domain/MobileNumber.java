package dubby.serve.service.update.accountupdate.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A Mobile Number entity
 */
@Entity
@Table(name = "MOBILE_NUMBER", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "NUMBER"
        })
})
public class MobileNumber implements Serializable {

    @Id
    @Column(name = "MOBILE_NUMBER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mobileNumberId;

    @NotNull
    @Column(name = "NUMBER")
    @Size(min = 6, max = 9, message = "Number Should Be Less Than or Equal To 9 Characters")
    private String number;

    @OneToOne(cascade = CascadeType.MERGE)
    @NotNull(message = "Mobile Country Code Cannot Be Empty")
    @JoinColumn(name = "MOBILE_COUNTRY_CODE_ID", referencedColumnName = "MOBILE_COUNTRY_CODE_ID")
    private MobileNumberCode mobileNumberCode;

    public Long getMobileNumberId() {
        return mobileNumberId;
    }

    public void setMobileNumberId(Long mobileNumberId) {
        this.mobileNumberId = mobileNumberId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public MobileNumberCode getMobileNumberCode() {
        return mobileNumberCode;
    }

    public void setMobileNumberCode(MobileNumberCode mobileNumberCode) {
        this.mobileNumberCode = mobileNumberCode;
    }
}
