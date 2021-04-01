package dubby.serve.emailservice.util.body;

import dubby.serve.emailservice.util.constants.AppConstant;
import dubby.serve.emailservice.util.mail_sender.IMailBody;
import dubby.serve.emailservice.util.property_fetcher.IPropertyFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("registrationVerificationBody")
public class RegistrationVerificationBody implements IMailBody {

    @Autowired
    private IPropertyFetcher propertyFetcher;

    @Override
    public String htmlMessageBody(String userFullName, int verificationToken) {
        return portion1() + portion2(userFullName) + verifyButton(verificationToken) + lastPotion();
    }

    private String portion1() {
        return """
                <html>
                	<head>
                		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
                	</head>
                                
                	<body>
                	
                		<div class="card">
                			<div class="card-body" style='
                				padding: 2%;'>
                				
                				<div class="card">
                				  <div class="card-body">
                					<h5 class="card-title">
                					""";
    }

    private String portion2(String userFullName) {

        return """ 
                Dear 
                """
                + userFullName +
                """
                 <span style='font-size:25px;'>&#129409;</span>
            					</h5> 
            					<p class="card-subtitle mb-2 text-muted">
            						Welcome to your pleasure of real food ordering for the last hour.
            						<br/>
            						<br/>
                                    We are a team called Dubby Serve and will make the best of this to see that you get served with no problems.
                                    <br/>
                                    <br/>
                                    
                                    We thought that we could pop you an mail to notify you, that you have joined with us.<br/>
                                    Start ordering and enjoy the outcome that we have provided to you. In addition, we handle any kind of errors personally.<br/>
                                    Having said that, if you do experience any sort of problems, please ping us on this email address, blindury@gmail.com.<br/>
                                    <br/>
                                    <br/>
                                    
                                    <b>For safety reasons, please click on the "verify Your Account" link to confirm and activate you account.</b>
                                    <br/>
                                    <br/>
                                    
                                    Enjoy Your Feast,<br>
                                    Dubby Serve Team<br>
            					</p>
            					<div class="container">
            						<div class="row">
            							<div class="col-3">
            """;

    }

    private String verifyButton(int token) {
        String path = propertyFetcher.getProperty(AppConstant.USER_REGISTRATION_FRONTEND_URL);

        return """
                <a href="
                """
                + path + token +
                """
                "  class="btn btn-primary">Verify Your Account</a>
                """;
    }

    private String lastPotion() {
        return """
            							</div>
            							<div class="col-9"></div>
            						</div>
            					</div>
            					
            				  </div>
            				</div>
            			</div>
            		</div>
            		
            	</body>
            	
            </html>
                """;
    }

}

