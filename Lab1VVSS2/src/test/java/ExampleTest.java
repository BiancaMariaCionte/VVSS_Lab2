import domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import repository.StudentXMLRepo;
import service.Service;
import validation.StudentValidator;
import validation.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

@Tag("StudentTest")
class ExampleTest {

    private StudentXMLRepo studentRepo = new StudentXMLRepo("Studenti.xml");
    private StudentValidator studentValidator = new StudentValidator();
    private Service service = new Service(studentRepo, studentValidator, null, null, null, null);

    @BeforeEach
    void setUp() {
        studentRepo = new StudentXMLRepo("Studenti.xml");
    }


    @Test
    void testAddExistingStudent() {
        Student student = new Student("205", "Mariaa Ana", 104, "mariaa.ana@gmail.com");

        //  add the student so it exists
        assertNull(service.addStudent(student));

        //  add the same student again, it returns the existing student
        assertNotNull(service.addStudent(student));
    }


    @Test
    void testAddStudent_InvalidStudent() {
        Student student = new Student("", "", -5, "invalid-email");
        assertThrows(ValidationException.class, () -> {
            service.addStudent(student);
        });
    }

    @Test
    void testAddStudent_EmptyStudentId() {
        Student student = new Student("", "Bianca", 111, "bibi.bia@gmail.com");
        assertThrows(ValidationException.class, () -> {
            service.addStudent(student);
        });
    }

//    @Test
//    void testAddStudent_NullStudentId() {
//        Student student = new Student(null, "John Doe", 101, "john.doe@example.com");
//        assertThrows(ValidationException.class, () -> {
//            service.addStudent(student);
//        });
//    }
}
