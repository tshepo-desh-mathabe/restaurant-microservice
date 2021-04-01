package dubby.serve.service.signup.mapper.oauth;

import dubby.serve.service.signup.domain.dto.oauth.UserDto;
import dubby.serve.service.signup.domain.oauth.User;
import dubby.serve.service.signup.mapper.ContactDetailsImpl;
import dubby.serve.service.signup.mapper.UserAccountStatusImpl;
import dubby.serve.service.signup.util.helper.IFieldPropertyMapper;
import dubby.serve.service.signup.util.helper.IModelMapper;
import org.springframework.stereotype.Component;

/**
 * User Entity to DTO mapper implementor and vice-versa
 */
@Component
public class UserImpl implements IModelMapper<User, UserDto> {

    @Override
    public UserDto toDto(User user) {
        return convertToDto(user);
    }

    @Override
    public User toEntity(UserDto userDto) {
        return convertToEntity(userDto);
    }

    /**
     * Converts User Entity to UserDTO
     * @param user - entity object to be converted into a DTO
     * @return - returns a converted Object in DTO format
     */
    private UserDto convertToDto(User user) {
        if (user != null) {
            IFieldPropertyMapper<UserDto> mapper = destination -> {
                destination.setUserId(user.getId());
                destination.setKnownAs(user.getKnownAs());
                destination.setFirstName(user.getFirstName());
                destination.setLastName(user.getLastName());
                destination.setEmailAddress(user.getEmail());
                destination.setPwd(user.getPassword());
                destination.setEnabled(user.getEnabled());
                destination.setAccountNotExpired(user.getAccountNonExpired());
                destination.setCredentialsNotExpired(user.getCredentialsNonExpired());
                destination.setAccountNotLocked(user.getAccountNonLocked());
                destination.setUserRoleDetails(new UserRoleImpl().toDto(user.getRoles()));

                destination.setContactDetails(
                        new ContactDetailsImpl().toDto(user.getContactDetails())
                );

                destination.setUserAccountStatusDetails(
                        new UserAccountStatusImpl().toDto(user.getUserAccountStatus())
                );

                destination.setCreatedAtDate(user.getCreatedAt());
                destination.setUpdatedAtDate(user.getUpdatedAt());

                return destination;
            };

            return mapper.mapTo(new UserDto());
        } else {
            return null;
        }
    }

    /**
     * Converts UserDTO to User entity
     * @param userDto - DTO to be converted into an entity
     * @return - returns a converted Object in DTO format
     */
    private User convertToEntity(UserDto userDto) {
        if (userDto != null) {
            IFieldPropertyMapper<User> mapper = destination -> {
                destination.setId(userDto.getUserId());
                destination.setKnownAs(userDto.getKnownAs());
                destination.setFirstName(userDto.getFirstName());
                destination.setLastName(userDto.getLastName());
                destination.setEmail(userDto.getEmailAddress());
                destination.setPassword(userDto.getPwd());
                destination.setEnabled(userDto.getEnabled());
                destination.setAccountNonExpired(userDto.getAccountNotExpired());
                destination.setCredentialsNonExpired(userDto.getCredentialsNotExpired());
                destination.setAccountNonLocked(userDto.getAccountNotLocked());
                destination.setRoles(new UserRoleImpl().toEntity(userDto.getUserRoleDetails()));

                destination.setContactDetails(
                        new ContactDetailsImpl().toEntity(userDto.getContactDetails())
                );

                destination.setUserAccountStatus(
                        new UserAccountStatusImpl().toEntity(userDto.getUserAccountStatusDetails())
                );

                destination.setCreatedAt(userDto.getCreatedAtDate());
                destination.setUpdatedAt(userDto.getUpdatedAtDate());

                return destination;
            };

            return mapper.mapTo(new User());
        } else {
            return null;
        }
    }
}
