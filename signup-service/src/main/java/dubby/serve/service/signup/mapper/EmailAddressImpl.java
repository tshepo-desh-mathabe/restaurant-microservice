package dubby.serve.service.signup.mapper;

import dubby.serve.service.signup.domain.EmailAddress;
import dubby.serve.service.signup.domain.dto.EmailAddressDto;
import dubby.serve.service.signup.util.helper.IFieldPropertyMapper;
import dubby.serve.service.signup.util.helper.IModelMapper;
import org.springframework.stereotype.Component;

/**
 * EmailAddress Entity to DTO mapper implementor and vice-versa
 */
@Component
public class EmailAddressImpl implements IModelMapper<EmailAddress, EmailAddressDto> {

    @Override
    public EmailAddressDto toDto(EmailAddress emailAddress) {
        return convertToDto(emailAddress);
    }

    @Override
    public EmailAddress toEntity(EmailAddressDto emailAddressDto) {
        return convertToEntity(emailAddressDto);
    }

    /**
     * Converts EmailAddress Entity to EmailAddressDTO
     * @param emailAddress - entity object to be converted into a DTO
     * @return - returns a converted Object in DTO format
     */
    private EmailAddressDto convertToDto(EmailAddress emailAddress) {
        if (emailAddress != null) {
            IFieldPropertyMapper<EmailAddressDto> mapper = destination -> {
                destination.setEmailId(emailAddress.getEmailId());
                destination.setMailAddress(emailAddress.getAddress());

                return destination;
            };

            return mapper.mapTo(new EmailAddressDto());
        } else {
            return null;
        }
    }

    /**
     * Converts EmailAddressDTO to EmailAddress entity
     * @param emailAddressDto - DTO to be converted into an entity
     * @return - returns a converted Object in DTO format
     */
    private EmailAddress convertToEntity(EmailAddressDto emailAddressDto) {
        if (emailAddressDto != null) {
            IFieldPropertyMapper<EmailAddress> mapper = destination -> {
                destination.setAddress(emailAddressDto.getMailAddress());

                return destination;
            };

            return mapper.mapTo(new EmailAddress());
        } else {
            return null;
        }
    }
}
