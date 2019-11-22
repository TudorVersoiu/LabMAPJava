package com.map.validation;

import com.map.domain.Student;
import com.map.exceptions.ValidationException;

public class StudentValidator implements Validator<Student> {
    @Override
    public void validate(Student entity) throws ValidationException {
        // DOn't throw anything
    }
}

