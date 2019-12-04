package com.map.repository;

import com.map.exceptions.AlreadyExistsError;
import com.map.exceptions.ValidationException;
import com.map.util.Entity;
import com.map.validation.Validator;

import java.util.HashMap;
import java.util.Map;


public class Repository<ID, E extends Entity<ID>> implements CrudRepository<ID, E> {
    private Map<ID, E> entries = new HashMap<>();
    private Validator<E> validator;

    public Repository(Validator<E> validator) {
        this.validator = validator;
    }

    @Override
    public E findOne(ID id) {
        return this.entries.get(id);
    }

    @Override
    public Iterable<E> findAll() {
        return this.entries.values();
    }

    @Override
    public E save(E newEntry) throws ValidationException, AlreadyExistsError {
        if ( findOne(newEntry.getId()) != null) {
            throw new AlreadyExistsError();
        }
        this.validator.validate(newEntry);
        return this.entries.put(newEntry.getId(), newEntry);
    }

    @Override
    public E delete(ID id) {
        return this.entries.remove(id);
    }

    @Override
    public E update(E entity) throws ValidationException {
        this.entries.remove(entity.getId());
        this.entries.put(entity.getId(), entity);
        return this.entries.get(entity.getId());
    }
}
