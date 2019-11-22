package com.map.controllers;

import com.map.domain.Assignment;
import com.map.exceptions.AlreadyExistsError;
import com.map.exceptions.ValidationException;
import com.map.repository.Repository;
import com.map.util.AssignmentInput;

public class AssignmentController {
    private Repository<Integer, Assignment> assigmentRepository;


    public void add(AssignmentInput assignment) throws ValidationException, AlreadyExistsError {
        assigmentRepository.save(
                new Assignment(assignment.description, Integer.parseInt(assignment.end_week))
        );
    }
    public void delete(String id) {
        assigmentRepository.delete(Integer.parseInt(id));
    }
    public void update(AssignmentInput assignment) throws ValidationException {
        assigmentRepository.update(
                new Assignment(assignment.description, Integer.parseInt(assignment.end_week))
        );
    }
}
