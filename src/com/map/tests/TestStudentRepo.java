package com.map.tests;

import com.map.domain.Assignment;
import com.map.domain.Student;
import com.map.exceptions.AlreadyExistsError;
import com.map.exceptions.ValidationException;
import com.map.repository.Repository;
import com.map.util.ContactInfo;
import com.map.validation.AssignmentValidator;
import com.map.validation.StudentValidator;

public class TestStudentRepo {
    public static void main(String[] args) {
        Repository<Integer, Student> student_repo = new Repository<>(new StudentValidator());

        try {
            student_repo.save(
                    new Student(
                            1,227, "George",
                            new ContactInfo("Marian", "Tudor", "versoiutudorsorin@gmail.com")));
            student_repo.save(
                    new Student(
                            2,227, "George",
                            new ContactInfo("Milka", "Tudor", "versoiutudorsorin@gmail.com")));
            student_repo.save(
                    new Student(
                            3, 227, "George",
                            new ContactInfo("Huaaa", "Tudor", "versoiutudorsorin@gmail.com")));
        } catch (ValidationException | AlreadyExistsError error ) {
            System.out.println("Invalid student");
        }

        // Validation test for Assignments
        Repository<Integer, Assignment> ass_repo = new Repository<>(new AssignmentValidator<Integer>());

        try {
            ass_repo.save(
                    new Assignment("Week 6 assignment", 1)
            );
            throw new Error();
        } catch ( ValidationException | AlreadyExistsError val_except ) {
            System.out.println("Assignment repo test passed for throwing exception");
        }

        for ( Student student : student_repo.findAll() ) {
            System.out.println(student);
        }
    }
}
