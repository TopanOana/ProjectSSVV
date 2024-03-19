package ssvv.example;



import org.junit.Test;
import ssvv.example.domain.Student;
import ssvv.example.repository.StudentRepository;
import ssvv.example.validation.StudentValidator;

import static junit.framework.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public StudentRepository studentRepository = new StudentRepository(new StudentValidator());

    public Student student;

    public AppTest() {
//        super( testName );
//        studentRepository = new StudentRepository(new StudentValidator());
    }

    @Test
    public void tc_valid_studentID() {
        student = new Student("1", "name student", 937);
        try {
            studentRepository.save(student);
            assertTrue(true);
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void tc_invalid_studentID() {
        student = new Student("", "name student", 937);

        if (studentRepository.save(student) == null)
            assertTrue(true);
        else fail();

    }


//    /**
//     * @return the suite of tests being tested
//     */
////    public static Test suite() {
////        return (Test) new TestSuite(AppTest.class);
////    }
//
//    /**
//     * Rigourous Test :-)
//     */
//    public void testApp() {
//        assertTrue(true);
//    }
}
