package dubby.serve.service.signup.mapper;

import dubby.serve.service.signup.domain.DeviceIpAddress;
import dubby.serve.service.signup.domain.dto.DeviceIpAddressDto;
import dubby.serve.service.signup.util.helper.IFieldPropertyMapper;
import dubby.serve.service.signup.util.helper.IModelMapper;
import org.springframework.stereotype.Component;

/**
 * DeviceIpAddress Entity to DTO mapper implementor and vice-versa
 */
@Component
public class DeviceIpAddressImpI implements IModelMapper<DeviceIpAddress, DeviceIpAddressDto> {

    @Override
    public DeviceIpAddressDto toDto(DeviceIpAddress deviceIpAddress) {
        return convertToDto(deviceIpAddress);
    }

    @Override
    public DeviceIpAddress toEntity(DeviceIpAddressDto deviceIpAddressDto) {
        return convertToEntity(deviceIpAddressDto);
    }

    /**
     * Converts DeviceIpAddress Entity to LocationDTO
     * @param deviceIpAddress - entity object to be converted into a DTO
     * @return - returns a converted Object in DTO format
     */
    private DeviceIpAddressDto convertToDto(DeviceIpAddress deviceIpAddress) {
        if (deviceIpAddress != null) {
            IFieldPropertyMapper<DeviceIpAddressDto> mapper = destination -> {
                destination.setIpAddressId(deviceIpAddress.getId());
                destination.setDeviceIpAddress(deviceIpAddress.getIpAddress());

                return destination;
            };

            return mapper.mapTo(new DeviceIpAddressDto());
        } else {
            return null;
        }
    }

    /**
     * Converts LocationDTO to DeviceIpAddress entity
     * @param deviceIpAddressDto - DTO to be converted into an entity
     * @return - returns a converted Object in DTO format
     */
    private DeviceIpAddress convertToEntity(DeviceIpAddressDto deviceIpAddressDto) {
        if (deviceIpAddressDto != null) {
            IFieldPropertyMapper<DeviceIpAddress> mapper = destination -> {
                destination.setId(deviceIpAddressDto.getIpAddressId());
                destination.setIpAddress(deviceIpAddressDto.getDeviceIpAddress());

                return destination;
            };

            return mapper.mapTo(new DeviceIpAddress());
        } else {
            return null;
        }
    }
}
