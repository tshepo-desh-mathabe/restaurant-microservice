package dubbyserver.mobilenumbercode.util.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Wrapper object for HTTP responses
 */
public class ResponseApiWrapper {

    /**
     * HTTP.OK_REQUEST (non-bad) response wrapper
     * @param message - message to be returned
     * @return - returns API response wrapped
     */
    public static ResponseEntity<?> okRequest(Object message) {
        return ResponseEntity.ok(new ApiResponse(true, message));
    }

    /**
     * HTTP.BAD_REQUEST response wrapper
     * @param message - message to be returned
     * @return - returns API response wrapped
     */
    public static ResponseEntity<?> badRequest(Object message) {
        return new ResponseEntity(new ApiResponse(false, message), HttpStatus.BAD_REQUEST);
    }

}

