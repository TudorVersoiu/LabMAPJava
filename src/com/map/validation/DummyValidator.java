package com.map.validation;

import com.map.exceptions.ValidationException;

public class DummyValidator<E> implements Validator<E> {
    @Override
    public void validate(E entity) throws ValidationException {

    }
}
