package dubby.serve.service.signup.mapper;

import dubby.serve.service.signup.domain.UserAccountStatus;
import dubby.serve.service.signup.domain.dto.UserAccountStatusDto;
import dubby.serve.service.signup.util.helper.IFieldPropertyMapper;
import dubby.serve.service.signup.util.helper.IModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserAccountStatusImpl implements IModelMapper<UserAccountStatus, UserAccountStatusDto> {

    @Override
    public UserAccountStatus toEntity(UserAccountStatusDto accountStatusDto) {
        return convertToEntity(accountStatusDto);
    }

    @Override
    public UserAccountStatusDto toDto(UserAccountStatus accountStatus) {
        return convertToDto(accountStatus);
    }

    private UserAccountStatusDto convertToDto(UserAccountStatus userAccountStatus) {
        if (userAccountStatus != null) {
            IFieldPropertyMapper<UserAccountStatusDto> mapper = destination -> {
                destination.setUserAccountStatusId(userAccountStatus.getId());
                destination.setUserAccountStatusReason(userAccountStatus.getReason());

                destination.setUserAccountProfileStatusDetails(
                        new UserAccountProfileStatusImpl().toDto(userAccountStatus.getUserAccountProfileStatus())
                );

                return destination;
            };

            return mapper.mapTo(new UserAccountStatusDto());
        } else {
            return null;
        }
    }

    private UserAccountStatus convertToEntity(UserAccountStatusDto accountStatusDto) {
        if (accountStatusDto != null) {
            IFieldPropertyMapper<UserAccountStatus> mapper = destination -> {
                destination.setId(accountStatusDto.getUserAccountStatusId());
                destination.setReason(accountStatusDto.getUserAccountStatusReason());

                destination.setUserAccountProfileStatus(
                        new UserAccountProfileStatusImpl().toEntity(accountStatusDto.getUserAccountProfileStatusDetails())
                );

                return destination;
            };

            return mapper.mapTo(new UserAccountStatus());
        } else {
            return null;
        }
    }

}
