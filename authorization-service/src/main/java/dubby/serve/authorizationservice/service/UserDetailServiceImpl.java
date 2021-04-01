package dubby.serve.authorizationservice.service;

import dubby.serve.authorizationservice.domain.oauth.User;
import dubby.serve.authorizationservice.repository.UserRepository;
import dubby.serve.authorizationservice.util.details.AuthUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepository.findByKnownAs(name);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username or password in incorrect"));

        UserDetails userDetails = new AuthUserDetail(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
        
    }
}