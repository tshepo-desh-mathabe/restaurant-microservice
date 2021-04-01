package dubby.serve.service.update.accountupdate.mapper;

import dubby.serve.service.update.accountupdate.domain.ContactDetails;
import dubby.serve.service.update.accountupdate.domain.dto.ContactDetailsDto;
import dubby.serve.service.update.accountupdate.util.helper.IFieldPropertyMapper;
import dubby.serve.service.update.accountupdate.util.helper.IModelMapper;
import org.springframework.stereotype.Component;

/**
 * ContactDetails Entity to DTO mapper implementor and vice-versa
 */
@Component
public class ContactDetailsImpl implements IModelMapper<ContactDetails, ContactDetailsDto> {

    @Override
    public ContactDetailsDto toDto(ContactDetails contactDetails) {
        return convertToDto(contactDetails);
    }

    @Override
    public ContactDetails toEntity(ContactDetailsDto contactDetailsDto) {
        return convertToEntity(contactDetailsDto);
    }

    /**
     * Converts ContactDetails Entity to ContactDetailsDTO
     * @param contactDetails - entity object to be converted into a DTO
     * @return - returns a converted Object in DTO format
     */
    private ContactDetailsDto convertToDto(ContactDetails contactDetails) {
        if (contactDetails != null) {
            IFieldPropertyMapper<ContactDetailsDto> mapper = destination -> {
                destination.setContactId(contactDetails.getContactId());
                destination.setMobileNumberDetails(
                        new MobileNumberImpl().toDto(contactDetails.getMobileNumber())
                );

                destination.setEmailAddressDetails(
                        new EmailAddressImpl().toDto(contactDetails.getEmailAddress())
                );

                destination.setDeviceIpAddressDetails(
                        new DeviceIpAddressImpI().toDto(contactDetails.getDeviceIpAddress())
                );

                return destination;
            };

            return mapper.mapTo(new ContactDetailsDto());
        } else {
            return null;
        }
    }

    /**
     * Converts ContactDetailsDTO to ContactDetails entity
     * @param contactDetailsDto - DTO to be converted into an entity
     * @return - returns a converted Object in DTO format
     */
    private ContactDetails convertToEntity(ContactDetailsDto contactDetailsDto) {
        if (contactDetailsDto != null) {
            IFieldPropertyMapper<ContactDetails> mapper = destination -> {
                destination.setMobileNumber(
                        new MobileNumberImpl().toEntity(contactDetailsDto.getMobileNumberDetails())
                );

                destination.setEmailAddress(
                        new EmailAddressImpl().toEntity(contactDetailsDto.getEmailAddressDetails())
                );

                destination.setDeviceIpAddress(
                        new DeviceIpAddressImpI().toEntity(contactDetailsDto.getDeviceIpAddressDetails())
                );

                return destination;
            };

            return mapper.mapTo(new ContactDetails());
        } else {
            return null;
        }
    }
}
