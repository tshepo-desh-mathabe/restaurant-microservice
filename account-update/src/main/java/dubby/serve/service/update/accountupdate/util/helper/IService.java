package dubby.serve.service.update.accountupdate.util.helper;

import org.springframework.http.ResponseEntity;

/**
 * Service operator logic
 * @param <D> - a DTO object
 */
public interface IService<D> {

    ResponseEntity<?> saveData(D dto);

}
