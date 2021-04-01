package dubbyserver.mobilenumbercode.util.helper;

import java.util.List;

/**
 * Entity to DTO mapper operator and vice-versa
 * @param <E> - An entity object
 * @param <D> - A DTO
 */
public interface IModelMapper<E, D> {

    /**
     * Mapping DTO to entity
     * @param dto - DTO to be mapped
     * @return - returns a entity
     */
    E toEntity(D dto);

    /**
     * Mapping entity to DTO
     * @param entity - entity to be mapped
     * @return - returns a DTO
     */
    D toDto(E entity);

    /**
     * Mapping collection of DTOs to a collection of entities
     * @param dtos - DTOs to be mapped
     * @return - returns entities
     */
    default List<E> toEntity(List<D> dtos) {
        return null;
    }

    /**
     * Mapping collection of entities to a collection of DTOs
     * @param entities - entity to be mapped
     * @return - returns DTOs
     */
    default List<D> toDto(List<E> entities) {
        return null;
    }

}
