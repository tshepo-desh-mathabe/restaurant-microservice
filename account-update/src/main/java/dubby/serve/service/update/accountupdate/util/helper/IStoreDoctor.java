package dubby.serve.service.update.accountupdate.util.helper;

import dubby.serve.service.update.accountupdate.util.response.ApiResponse;

public interface IStoreDoctor<T> extends IService<T>{

    /**
     * Validates request before persisting
     * @param request - data received from end-point
     * @return - API response object
     */
    ApiResponse isPersistentReady(T request);
}
