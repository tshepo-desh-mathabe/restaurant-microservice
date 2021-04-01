package dubby.serve.authorizationservice.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DeviceIpAddressDto entity
 */
@Entity
@Table(name = "DEVICE_IP_ADDRESS", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "IP_ADDRESS"
        })
})
public class DeviceIpAddress implements Serializable {

    @Id
    @Column(name = "IP_ADDRESS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IP_ADDRESS", length = 40)
    @NotNull(message = "IP Address Cannot Be Empty")
    private String ipAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
