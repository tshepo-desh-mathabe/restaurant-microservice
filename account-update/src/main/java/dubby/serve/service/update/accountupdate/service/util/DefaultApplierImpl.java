package dubby.serve.service.update.accountupdate.service.util;

import dubby.serve.service.update.accountupdate.domain.UserAccountProfileStatus;
import dubby.serve.service.update.accountupdate.domain.dto.UserAccountProfileStatusDto;
import dubby.serve.service.update.accountupdate.domain.dto.UserAccountStatusDto;
import dubby.serve.service.update.accountupdate.domain.dto.oauth.PermissionDto;
import dubby.serve.service.update.accountupdate.domain.dto.oauth.UserDto;
import dubby.serve.service.update.accountupdate.domain.dto.oauth.UserRoleDto;
import dubby.serve.service.update.accountupdate.domain.oauth.Permission;
import dubby.serve.service.update.accountupdate.domain.oauth.UserRole;
import dubby.serve.service.update.accountupdate.repository.IPermissionRepository;
import dubby.serve.service.update.accountupdate.repository.IUserAccountProfileStatusRepository;
import dubby.serve.service.update.accountupdate.repository.IUserRoleRepository;
import dubby.serve.service.update.accountupdate.util.constants.AccountStatus;
import dubby.serve.service.update.accountupdate.util.constants.AppConstant;
import dubby.serve.service.update.accountupdate.util.constants.RoleType;
import dubby.serve.service.update.accountupdate.util.helper.IDefaultApplier;
import dubby.serve.service.update.accountupdate.util.helper.IModelMapper;
import dubby.serve.service.update.accountupdate.util.property_fetcher.IPropertyFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultApplierImpl implements IDefaultApplier {

    @Autowired
    private IUserRoleRepository roleRepository;
    @Autowired
    private IPermissionRepository permissionRepository;
    @Autowired
    private IUserAccountProfileStatusRepository accountProfileStatusRepository;
    @Autowired
    private IModelMapper<UserRole, UserRoleDto> roleMapper;
    @Autowired
    private IModelMapper<Permission, PermissionDto> permissionMapper;
    @Autowired
    private IModelMapper<UserAccountProfileStatus, UserAccountProfileStatusDto> accountProfileMapper;

    @Override
    public void applyDefaults(UserDto userRequest, IPropertyFetcher propertyFetcher) {
        setRolePermission(userRequest);
        setAccountProfileDefaults(userRequest);
        UserAccountProfileStatusDto profileStatus = accountProfileMapper.toDto(accountProfileStatusRepository.getByAccountStatus(AccountStatus.INITIAL));
        String reason = propertyFetcher.getProperty(AppConstant.VERIFICATION_REASON_MESSAGE);
        userRequest.setUserAccountStatusDetails(new UserAccountStatusDto(reason, profileStatus));
    }

    private void setRolePermission(UserDto request) {
        if (request.getUserRoleDetails() == null) {
            rolePermissionHelper(request);
        } else if (request.getUserRoleDetails() != null &&
                !request.getUserRoleDetails().contains(RoleType.ROLE_ADMIN.toString())) {
            rolePermissionHelper(request);
        }
    }

    private void rolePermissionHelper(UserDto userDto) {
        List<UserRole> roles = Collections.singletonList(roleRepository.findByRoleType(RoleType.ROLE_USER));
        List<Permission> permissions = permissionRepository.findAll();

        roles.stream().map(e -> {
            e.setPermissions(permissions);
            return e;
        }).collect(Collectors.toList());

        userDto.setUserRoleDetails(roleMapper.toDto(roles));
    }

    private void setAccountProfileDefaults(UserDto userDto) {
        userDto.setEnabled(true);
        userDto.setAccountNotExpired(true);
        userDto.setCredentialsNotExpired(true);
        userDto.setAccountNotLocked(true);
    }
}
