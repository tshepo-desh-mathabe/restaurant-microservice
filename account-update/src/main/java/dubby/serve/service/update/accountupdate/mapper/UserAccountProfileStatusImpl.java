package dubby.serve.service.update.accountupdate.mapper;

import dubby.serve.service.update.accountupdate.domain.UserAccountProfileStatus;
import dubby.serve.service.update.accountupdate.domain.dto.UserAccountProfileStatusDto;
import dubby.serve.service.update.accountupdate.util.constants.AccountStatus;
import dubby.serve.service.update.accountupdate.util.helper.IFieldPropertyMapper;
import dubby.serve.service.update.accountupdate.util.helper.IModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserAccountProfileStatusImpl implements IModelMapper<UserAccountProfileStatus, UserAccountProfileStatusDto> {

    @Override
    public UserAccountProfileStatus toEntity(UserAccountProfileStatusDto accountProfileStatusDto) {
        return convertToEntity(accountProfileStatusDto);
    }

    @Override
    public UserAccountProfileStatusDto toDto(UserAccountProfileStatus accountProfileStatus) {
        return convertToDto(accountProfileStatus);
    }

    private UserAccountProfileStatusDto convertToDto(UserAccountProfileStatus accountProfileStatus) {
        if (accountProfileStatus != null) {
            IFieldPropertyMapper<UserAccountProfileStatusDto> mapper = destination -> {
                destination.setUserAccountProfileStatusId(accountProfileStatus.getId());
                destination.setAccountStatus(accountProfileStatus.getAccountStatus());

                return destination;
            };

            return mapper.mapTo(new UserAccountProfileStatusDto());
        } else {
            return null;
        }
    }

    private UserAccountProfileStatus convertToEntity(UserAccountProfileStatusDto accountProfileStatusDto) {
        if (accountProfileStatusDto != null) {
            IFieldPropertyMapper<UserAccountProfileStatus> mapper = destination -> {
                destination.setId(accountProfileStatusDto.getUserAccountProfileStatusId());
                // when received from endpoint, it will come through as string
                destination.setAccountStatus(AccountStatus.valueOf(accountProfileStatusDto.getAccountStatus().name()));

                return destination;
            };

            return mapper.mapTo(new UserAccountProfileStatus());
        } else {
            return null;
        }
    }
}
