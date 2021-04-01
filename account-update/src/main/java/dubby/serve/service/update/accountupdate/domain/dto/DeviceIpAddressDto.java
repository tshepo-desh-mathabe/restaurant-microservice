package dubby.serve.service.update.accountupdate.domain.dto;

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
