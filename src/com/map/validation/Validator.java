package com.map.validation;

import com.map.exceptions.ValidationException;
// import com.map.util.Entity;

/**
 * Generic class to validate Entities in a repository
 * @param <E> type of element to validate
 */
public interface Validator<E> {
    /**
     * Method to validate new elements in a repository
     * @param entity to be validated
     * @throws ValidationException in case the entity doesn't satisfy certain conditions
     */
    void validate(E entity) throws ValidationException;
}
