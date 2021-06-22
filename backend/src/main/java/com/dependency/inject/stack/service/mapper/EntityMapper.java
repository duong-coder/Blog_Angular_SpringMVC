package com.dependency.inject.stack.service.mapper;

import java.util.List;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <E> - Entity type parameter.
 * @param <D> - DTO type parameter.
 * @author Huu Duan
 */
public interface EntityMapper<E, D, K> {

    /**
     * To entity e.
     *
     * @param dto the dto
     * @return the e
     */
    E toEntity(D dto);

    /**
     * To dto d.
     *
     * @param entity the entity
     * @return the d
     */
    D toDTO(E entity);

    /**
     * To dt os list.
     *
     * @param entities the entities
     * @return the list
     */
    List<D> toDTOs(List<E> entities);

    /**
     * To entities list.
     *
     * @param dtos the dtos
     * @return the list
     */
    List<E> toEntities(List<D> dtos);

    /**
     * To entity from id e.
     *
     * @param id the id
     * @return the e
     */
    E toEntityFromId(K id);
    
    /**
     * @param id
     * @return e
     */
    D toDTOFromId(K id);

}