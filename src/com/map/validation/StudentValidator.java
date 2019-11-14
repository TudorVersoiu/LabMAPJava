package com.map.validation;

import com.map.domain.Student;
import com.map.exceptions.ValidationException;

public class StudentValidator<ID> implements Validator<Student<ID>> {
    @Override
    public void validate(Student<ID> entity) throws ValidationException {
        // DOn't throw anything
    }
}
