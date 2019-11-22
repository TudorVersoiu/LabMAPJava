package com.map.UI;

import com.map.controllers.AssignmentController;
import com.map.controllers.GradeController;
import com.map.controllers.StudentController;
import com.map.exceptions.AlreadyExistsError;
import com.map.exceptions.ValidationException;
import com.map.util.AssignmentInput;
import com.map.util.StudentInput;

import java.util.Scanner;

public class CLI {
    private AssignmentController assignmentController;
    private GradeController gradeController;
    private StudentController studentController;
    private Scanner in = new Scanner(System.in);

    public CLI(AssignmentController assignmentController, GradeController gradeController, StudentController studentController) {
        this.assignmentController = assignmentController;
        this.gradeController = gradeController;
        this.studentController = studentController;
    }

    public void runMenu() {
        boolean running = true;


        while ( running ) {
            System.out.println("Commands: ");
            System.out.println("exit");
            System.out.println("addStudent");
            System.out.println("removeStudent");
            System.out.println("addAssignment");
            System.out.println("removeAssignment");

            String input = in.nextLine();
            if ( input.equals("exit") ) {
                running = false;
            }
            if ( input.equals("addStudent") ) {
                addStudent();
            }
            if ( input.equals("removeStudent") ) {
                removeStudent();
            }
            if ( input.equals("addAssignment") ) {
                addAssignment();
            }
            if ( input.equals("removeAssignment") ) {
                removeAssignment();
            }
        }
    }

    private void addAssignment() {
        try {
            assignmentController.add(readAssignment());
        } catch (ValidationException e) {
            System.out.println("Invalid input");
        } catch (AlreadyExistsError alreadyExistsError) {
            System.out.println("Duplicate");
        }
    }
    private void removeAssignment() {
        System.out.println("ID: ");
        String id = in.nextLine();
        assignmentController.delete(id);
    }

    private void removeStudent() {
        System.out.println("ID: ");
        String id = in.nextLine();
        studentController.delete(id);
    }

    private void addStudent() {
        try {
            studentController.add(readStudent());
        } catch (AlreadyExistsError alreadyExistsError) {
            System.out.println("Already exists");
        } catch (ValidationException e) {
            System.out.println("Invalid input");
        }
    }

    private StudentInput readStudent() {
        StudentInput input = new StudentInput();
        System.out.println("ID");
        input.ID = in.nextLine();
        System.out.println("Name:");
        input.name = in.nextLine();
        System.out.println("Surname");
        input.surname = in.nextLine();
        System.out.println("Email: ");
        input.email = in.nextLine();
        System.out.println("Group number");
        input.group = in.nextLine();
        System.out.println("Supervisor name: ");
        input.supervisorName = in.nextLine();

        return input;
    }
    private AssignmentInput readAssignment() {
        AssignmentInput input = new AssignmentInput();
        System.out.println("Description: ");
        input.description = in.nextLine();
        System.out.println("Start week: ");
        input.startWeek = in.nextLine();
        System.out.println("End week: ");
        input.endWeek = in.nextLine();

        return input;
    }
}
