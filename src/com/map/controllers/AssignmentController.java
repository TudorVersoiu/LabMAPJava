package com.map.controllers;

import com.map.domain.Assignment;
import com.map.exceptions.AlreadyExistsError;
import com.map.exceptions.ValidationException;
import com.map.repository.Repository;
import com.map.util.AssignmentInput;

public class AssignmentController {
    private Repository<Integer, Assignment> assignmentRepository;

    public AssignmentController(Repository<Integer, Assignment> assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public void add(AssignmentInput assignment) throws ValidationException, AlreadyExistsError {
        assignmentRepository.save(
                new Assignment(
                        Integer.parseInt(assignment.assignmentID),
                        assignment.description,
                        Integer.parseInt(assignment.endWeek)
                )
        );
    }
    public void delete(String id) {
        assignmentRepository.delete(Integer.parseInt(id));
    }
    public void update(AssignmentInput assignment) throws ValidationException {
        assignmentRepository.update(
                new Assignment(
                    Integer.parseInt(assignment.assignmentID),
                    assignment.description,
                    Integer.parseInt(assignment.endWeek)
                )
        );
    }
}
