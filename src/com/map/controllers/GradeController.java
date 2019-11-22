package com.map.controllers;

import com.map.domain.Assignment;
import com.map.domain.Grade;
import com.map.domain.Student;
import com.map.exceptions.AlreadyExistsError;
import com.map.exceptions.ValidationException;
import com.map.repository.Repository;
import com.map.util.GradeInput;

import java.util.Date;

public class GradeController {
    private Repository<Integer, Grade> gradeRepository;
    private Repository<Integer, Student> studentRepository;
    private Repository<Integer, Assignment> assignmentRepository;

    public GradeController(
            Repository<Integer, Grade> gradeRepository,
            Repository<Integer, Student> studentRepository,
            Repository<Integer, Assignment> assignmentRepository) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
        this.assignmentRepository = assignmentRepository;
    }

    public void add(GradeInput grade) throws ValidationException, AlreadyExistsError {
        gradeRepository.save(
               new Grade(
                       new Date(),
                       studentRepository.findOne(Integer.parseInt(grade.professorID)),
                       assignmentRepository.findOne(Integer.parseInt(grade.studentID)),
                       Integer.parseInt(grade.gradeValue))
        );
    }
    public void delete(String ID) {
        gradeRepository.delete(Integer.parseInt(ID));
    }
    public void update(GradeInput grade) throws ValidationException {
        gradeRepository.update(
                new Grade(
                        new Date(),
                        studentRepository.findOne(Integer.parseInt(grade.professorID)),
                        assignmentRepository.findOne(Integer.parseInt(grade.studentID)),
                        Integer.parseInt(grade.gradeValue))
        );
    }
}
