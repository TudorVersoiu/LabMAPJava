package com.map.controllers;

import com.map.domain.Student;
import com.map.exceptions.AlreadyExistsError;
import com.map.exceptions.ValidationException;
import com.map.repository.Repository;
import com.map.util.ContactInfo;
import com.map.util.StudentInput;
import com.map.validation.DummyValidator;

public class StudentController {
    private Repository<Integer, Student> studentRepository;

    public StudentController(Repository<Integer, Student> studentRepository) {
        this.studentRepository = studentRepository;
    }

    void add(StudentInput student) throws AlreadyExistsError, ValidationException {
        studentRepository.save(
                new Student(
                        Integer.parseInt(student.ID),
                        Integer.parseInt(student.group),
                        student.supervisorName,
                        new ContactInfo(student.name, student.surname, student.email)
                )
        );
    }

    void update(StudentInput student) throws ValidationException {
        studentRepository.update(
                new Student(
                        Integer.parseInt(student.ID),
                        Integer.parseInt(student.group),
                        student.supervisorName,
                        new ContactInfo(student.name, student.surname, student.email)
                )
        );
    }

    void remove(String id){
        studentRepository.delete(Integer.parseInt(id));
    }
}
