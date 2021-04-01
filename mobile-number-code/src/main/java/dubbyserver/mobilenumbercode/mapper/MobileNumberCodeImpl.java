package dubbyserver.mobilenumbercode.mapper;

import dubbyserver.mobilenumbercode.domain.MobileNumberCode;
import dubbyserver.mobilenumbercode.domain.dto.MobileNumberCodeDto;
import dubbyserver.mobilenumbercode.util.helper.IFieldPropertyMapper;
import dubbyserver.mobilenumbercode.util.helper.IModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<MobileNumberCodeDto> toDto(List<MobileNumberCode> entities) {
        if (entities != null) {
            IFieldPropertyMapper<List<MobileNumberCodeDto>> mapper = destination -> {

                List<MobileNumberCodeDto> list = new ArrayList<>(entities.size());
                for (MobileNumberCode numberCode : entities) {
                    list.add(convertToDto(numberCode));
                }
                destination.addAll(list);

                return destination;
            };

            return mapper.mapTo(new ArrayList<>());
        } else {
            return null;
        }
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
