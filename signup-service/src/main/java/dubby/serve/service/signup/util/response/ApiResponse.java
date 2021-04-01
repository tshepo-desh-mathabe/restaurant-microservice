package dubby.serve.service.signup.util.response;

/**
 * Help format end point API response
 * @param <T> - message type parameter
 */
public class ApiResponse<T> {

    private boolean success;
    private T message;

    public ApiResponse(boolean success) {
        this.success = success;
    }

    public ApiResponse(Boolean success, T message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
