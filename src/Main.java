import com.map.UI.CLI;
import com.map.controllers.AssignmentController;
import com.map.controllers.GradeController;
import com.map.controllers.ProfessorController;
import com.map.controllers.StudentController;
import com.map.domain.Assignment;
import com.map.domain.Grade;
import com.map.domain.Professor;
import com.map.domain.Student;
import com.map.repository.Repository;
import com.map.validation.DummyValidator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main started");

        Repository<Integer, Professor> professorRepository = new Repository<>(new DummyValidator<>());
        Repository<Integer, Student> studentRepository = new Repository<>(new DummyValidator<>());
        Repository<Integer, Assignment> assignmentRepository = new Repository<>(new DummyValidator<>());
        Repository<Integer, Grade> gradeRepository = new Repository<>(new DummyValidator<>());

        AssignmentController assignmentController = new AssignmentController(assignmentRepository);
        StudentController studentController = new StudentController(studentRepository);
        GradeController gradeController = new GradeController(gradeRepository, studentRepository, assignmentRepository);
        ProfessorController professorController = new ProfessorController();


        CLI consoleUI = new CLI(assignmentController, gradeController, studentController);
        consoleUI.runMenu();
    }
}
