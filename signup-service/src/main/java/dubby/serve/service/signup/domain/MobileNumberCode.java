package dubby.serve.service.signup.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A Mobile Country Code entity
 */
@Entity
@Table(name = "MOBILE_NUMBER_CODE", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "MOBILE_NUMBER_CODE"
        })
})
public class MobileNumberCode implements Serializable {

    @Id
    @Column(name = "MOBILE_COUNTRY_CODE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numberCodeId;

    @NotNull
    @Column(name = "MOBILE_NUMBER_CODE")
    @Size(min = 3, max = 6, message = "Country Code Should Be Less Than or Equal To 6 Characters")
    private String numberCode;

    public Long getNumberCodeId() {
        return numberCodeId;
    }

    public void setNumberCodeId(Long numberCodeId) {
        this.numberCodeId = numberCodeId;
    }

    public String getNumberCode() {
        return numberCode;
    }

    public void setNumberCode(String numberCode) {
        this.numberCode = numberCode;
    }
}
