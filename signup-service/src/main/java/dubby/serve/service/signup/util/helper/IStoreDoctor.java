package dubby.serve.service.signup.util.helper;

import dubby.serve.service.signup.util.response.ApiResponse;

import java.util.Optional;

public interface IStoreDoctor<T> extends IService<T>{

    /**
     * Validates request before persisting
     * @param request - data received from end-point
     * @return - API response object
     */
    ApiResponse isPersistentReady(T request);
}
