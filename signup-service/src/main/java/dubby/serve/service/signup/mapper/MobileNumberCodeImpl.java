package dubby.serve.service.signup.mapper;

import dubby.serve.service.signup.domain.MobileNumberCode;
import dubby.serve.service.signup.domain.dto.MobileNumberCodeDto;
import dubby.serve.service.signup.util.helper.IFieldPropertyMapper;
import dubby.serve.service.signup.util.helper.IModelMapper;
import org.springframework.stereotype.Component;

/**
 * MobileNumberCode Entity to DTO mapper implementor and vice-versa
 */
@Component
public class MobileNumberCodeImpl implements IModelMapper<MobileNumberCode, MobileNumberCodeDto> {

    @Override
    public MobileNumberCodeDto toDto(MobileNumberCode mobileNumberCode) {
        return convertToDto(mobileNumberCode);
    }

    @Override
    public MobileNumberCode toEntity(MobileNumberCodeDto mobileNumberCodeDto) {
        return convertToEntity(mobileNumberCodeDto);
    }

    /**
     * Converts MobileNumberCode Entity to MobileNumberCodeDTO
     * @param mobileNumberCode - entity object to be converted into a DTO
     * @return - returns a converted Object in DTO format
     */
    private MobileNumberCodeDto convertToDto(MobileNumberCode mobileNumberCode) {
        if (mobileNumberCode != null) {
            IFieldPropertyMapper<MobileNumberCodeDto> mapper = destination -> {
                destination.setMobileNumberCodeId(mobileNumberCode.getNumberCodeId());
                destination.setMobileNumberCode(mobileNumberCode.getNumberCode());

                return destination;
            };

            return mapper.mapTo(new MobileNumberCodeDto());
        } else {
            return null;
        }
    }

    /**
     * Converts MobileNumberCodeDTO to MobileNumberCode entity
     * @param mobileNumberCodeDto - DTO to be converted into an entity
     * @return - returns a converted Object in DTO format
     */
    private MobileNumberCode convertToEntity(MobileNumberCodeDto mobileNumberCodeDto) {
        if (mobileNumberCodeDto != null) {
            IFieldPropertyMapper<MobileNumberCode> mapper = destination -> {
                destination.setNumberCodeId(mobileNumberCodeDto.getMobileNumberCodeId());
                destination.setNumberCode(mobileNumberCodeDto.getMobileNumberCode());

                return destination;
            };

            return mapper.mapTo(new MobileNumberCode());
        } else {
            return null;
        }
    }
}
