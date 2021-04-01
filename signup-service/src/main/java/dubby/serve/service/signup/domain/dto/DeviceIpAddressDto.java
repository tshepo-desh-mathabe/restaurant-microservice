package dubby.serve.service.signup.domain.dto;

import javax.validation.constraints.NotBlank;

/**
 * A DeviceIpAddressDto DTO
 */
public class DeviceIpAddressDto {

    private Long ipAddressId;
    private String deviceIpAddress;

    public Long getIpAddressId() {
        return ipAddressId;
    }

    public void setIpAddressId(Long ipAddressId) {
        this.ipAddressId = ipAddressId;
    }

    public String getDeviceIpAddress() {
        return deviceIpAddress;
    }

    public void setDeviceIpAddress(String deviceIpAddress) {
        this.deviceIpAddress = deviceIpAddress;
    }
}
