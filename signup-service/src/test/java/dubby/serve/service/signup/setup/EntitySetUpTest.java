package dubby.serve.service.signup.setup;

import dubby.serve.service.signup.domain.oauth.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EntitySetUpTest {

    private Fixture fixture= new Fixture();;

//    @BeforeAll
//    public void setup() {
//        fixture 
//    }


    @Test
    public void SetUpTestDummyData() {
        fixture.givenAUser();
    }

    private class Fixture {

        @InjectMocks
        User user;
        
        public Fixture() {
        	user = new User();
        }

        public void givenAUser() {
            when(user.getId()).thenReturn(1L);
        }

    }
}
