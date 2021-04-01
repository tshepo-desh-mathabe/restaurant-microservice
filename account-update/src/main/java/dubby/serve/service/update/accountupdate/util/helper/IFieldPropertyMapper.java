package dubby.serve.service.update.accountupdate.util.helper;

/**
 * Property / field mapper for DTOs and Entities
 * @param <D> - the destination property / field
 */
@FunctionalInterface
public interface IFieldPropertyMapper<D> {

    /**
     * Field conversion happens here
     * @param destination - field to be converted
     * @return - returns required field after conversion
     */
    D mapTo(D destination);
}
