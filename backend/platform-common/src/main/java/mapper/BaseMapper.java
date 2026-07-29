package mapper;


import java.util.List;
import java.util.Set;

import org.mapstruct.MappingTarget;

/**
 * Generic mapper interface.
 *
 * @param <E> Entity
 * @param <D> DTO
 */
public interface BaseMapper<E, D> {

    /**
     * Entity -> DTO
     */
    D toDto(E entity);

    /**
     * DTO -> Entity
     */
    E toEntity(D dto);

    /**
     * Entity List -> DTO List
     */
    Set<D> toDtoList(Set<E> entityList);

    /**
     * DTO List -> Entity List
     */
    Set<E> toEntityList(Set<D> dtoList);
    
    void updateEntity(D dto, @MappingTarget E entity);


}
