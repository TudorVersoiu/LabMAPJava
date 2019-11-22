package com.map.validation;

import com.map.domain.Assignment;
import com.map.exceptions.ValidationException;

public class AssignmentValidator implements Validator<Assignment> {
    @Override
    public void validate(Assignment entity) throws ValidationException {
        if ( entity.getStartWeek() >= entity.getEndWeek() )
            throw new ValidationException();
    }
}
