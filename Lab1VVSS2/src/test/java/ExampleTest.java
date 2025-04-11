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
class StudentValidationTest {

    private StudentXMLRepo studentRepo;
    private StudentValidator studentValidator;
    private Service service;

    @BeforeEach
    void setUp() {
        studentRepo = new StudentXMLRepo("Studenti.xml");
        studentValidator = new StudentValidator();
        service = new Service(studentRepo, studentValidator, null, null, null, null);
    }

    // === STUDENT ID ===

    @Test
    void testInvalidId_Negative() {
        Student student = new Student("-1", "John", 921, "john@gmail.com");
        assertThrows(ValidationException.class, () -> service.addStudent(student));
    }

    @Test
    void testValidId_Zero() {
        Student student = new Student("0", "Bibi", 921, "bibi@gmail.com");
        Student addedStudent = service.addStudent(student);
        assertEquals(student, addedStudent);
    }

    @Test
    void testValidId_One() {
        Student student = new Student("1", "Biaa", 921, "john@gmail.com");
        Student addedStudent = service.addStudent(student);
        assertEquals(student, addedStudent);
    }

    @Test
    void testValidId_Max() {
        Student student = new Student("9999", "Anaa", 922, "john@gmail.com");
        Student addedStudent = service.addStudent(student);
        assertEquals(student, addedStudent);
    }

    @Test
    void testInvalidId_TooLarge() {
        Student student = new Student("10000", "Inaa", 924, "john@gmail.com");
        assertThrows(ValidationException.class, () -> service.addStudent(student));
    }

    @Test
    void testInvalidId_Empty() {
        Student student = new Student("", "Mihai", 921, "john@gmail.com");
        assertThrows(ValidationException.class, () -> service.addStudent(student));
    }

    @Test
    void testInvalidId_Null() {
        Student student = new Student(null, "Nico", 921, "john@gmail.com");
        assertThrows(NullPointerException.class, () -> service.addStudent(student));
    }

    // === GROUP ===

    @Test
    void testInvalidGroup_BelowRange() {
        Student student = new Student("140", "Anna", 820, "anna@gmail.com");
        assertThrows(ValidationException.class, () -> service.addStudent(student));
    }

    @Test
    void testValidGroup_821() {
        Student student = new Student("90", "Ina", 821, "anna@gmail.com");
        Student addedStudent = service.addStudent(student);
        assertEquals(student, addedStudent);
    }

    @Test
    void testValidGroup_822() {
        Student student = new Student("988", "Anna", 822, "anna@gmail.com");
        Student addedStudent = service.addStudent(student);
        assertEquals(student, addedStudent);
    }

    @Test
    void testValidGroup_921() {
        Student student = new Student("555", "Anna", 921, "anna@gmail.com");
        Student addedStudent = service.addStudent(student);
        assertEquals(student, addedStudent);
    }

    @Test
    void testValidGroup_927() {
        Student student = new Student("566", "Anna", 927, "anna@gmail.com");
        Student addedStudent = service.addStudent(student);
        assertEquals(student, addedStudent);
    }

    @Test
    void testInvalidGroup_928() {
        Student student = new Student("786", "Anna", 928, "anna@gmail.com");
        assertThrows(ValidationException.class, () -> service.addStudent(student));
    }

    // === EMAIL ===

    @Test
    void testValidEmail() {
        Student student = new Student("789", "Ionut", 921, "emma@gmail.com");
        Student addedStudent = service.addStudent(student);
        assertEquals(student, addedStudent);
    }

    @Test
    void testInvalidEmail_Empty() {
        Student student = new Student("987", "Maria", 921, "");
        assertThrows(ValidationException.class, () -> service.addStudent(student));
    }

    @Test
    void testInvalidEmail_Null() {
        Student student = new Student("560", "Emma", 921, null);
        assertThrows(ValidationException.class, () -> service.addStudent(student));
    }

    @Test
    void testInvalidEmail_WrongFormat() {
        Student student = new Student("88", "Emma", 921, "@gmail.com");
        assertThrows(ValidationException.class, () -> service.addStudent(student));
    }

    // === NAME ===

    @Test
    void testInvalidName_Empty() {
        Student student = new Student("778", "", 921, "emma@gmail.com");
        assertThrows(ValidationException.class, () -> service.addStudent(student));
    }

    @Test
    void testInvalidName_Null() {
        Student student = new Student("987", null, 921, "emma@gmail.com");
        assertThrows(ValidationException.class, () -> service.addStudent(student));
    }

    @Test
    void testValidName() {
        Student student = new Student("458", "Buti", 921, "alex@gmail.com");
        Student addedStudent = service.addStudent(student);
        assertEquals(student, addedStudent);
    }
}
