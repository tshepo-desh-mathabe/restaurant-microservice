package dubby.serve.service.signup.mapper;

import dubby.serve.service.signup.domain.MobileNumber;
import dubby.serve.service.signup.domain.dto.MobileNumberDto;
import dubby.serve.service.signup.util.helper.IFieldPropertyMapper;
import dubby.serve.service.signup.util.helper.IModelMapper;
import org.springframework.stereotype.Component;

/**
 * MobileNumber Entity to DTO mapper implementor and vice-versa
 */
@Component
public class MobileNumberImpl implements IModelMapper<MobileNumber, MobileNumberDto> {

    @Override
    public MobileNumberDto toDto(MobileNumber mobileNumber) {
        return convertToDto(mobileNumber);
    }

    @Override
    public MobileNumber toEntity(MobileNumberDto mobileNumberDto) {
        return convertToEntity(mobileNumberDto);
    }

    /**
     * Converts MobileNumber Entity to MobileNumberDTO
     * @param mobileNumber - entity object to be converted into a DTO
     * @return - returns a converted Object in DTO format
     */
    private MobileNumberDto convertToDto(MobileNumber mobileNumber) {
        if (mobileNumber != null) {
            IFieldPropertyMapper<MobileNumberDto> mapper = destination -> {
                destination.setPhoneNumberId(mobileNumber.getMobileNumberId());
                destination.setNumber(mobileNumber.getNumber());
                destination.setMobileCountCodeDetail(
                        new MobileNumberCodeImpl().toDto(mobileNumber.getMobileNumberCode())
                );

                return destination;
            };

            return mapper.mapTo(new MobileNumberDto());
        } else {
            return null;
        }
    }

    /**
     * Converts MobileNumberDTO to MobileNumber entity
     * @param mobileNumberDto - DTO to be converted into an entity
     * @return - returns a converted Object in DTO format
     */
    private MobileNumber convertToEntity(MobileNumberDto mobileNumberDto) {
        if (mobileNumberDto != null) {
            IFieldPropertyMapper<MobileNumber> mapper = destination -> {
                destination.setMobileNumberId(mobileNumberDto.getPhoneNumberId());
                destination.setNumber(mobileNumberDto.getNumber());
                destination.setMobileNumberCode(
                        new MobileNumberCodeImpl().toEntity(mobileNumberDto.getMobileCountCodeDetail())
                );

                return destination;
            };

            return mapper.mapTo(new MobileNumber());
        } else {
            return null;
        }
    }
}
