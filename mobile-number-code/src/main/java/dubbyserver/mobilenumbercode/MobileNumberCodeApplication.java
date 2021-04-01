package dubbyserver.mobilenumbercode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MobileNumberCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileNumberCodeApplication.class, args);
	}

}
