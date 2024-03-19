package ssvv.example;




import ssvv.example.domain.Student;
import ssvv.example.repository.StudentRepository;
import ssvv.example.validation.StudentValidator;

import static org.junit.Assert.*;

import org.junit.Test;

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

    @Test
    public void tc_8(){
        student = new Student("8", "name", 111);
//        Student val = studentRepository.save(student);
        if (studentRepository.save(student) == null)
            fail();
        else assertTrue(true);
    }

    @Test
    public void tc_9(){
        student = new Student("9", "name", 112);
        if (studentRepository.save(student) == null)
            fail();
        else assertTrue(true);
    }

    @Test
    public void tc_10(){
        student = new Student("10", "name", 936);
        if (studentRepository.save(student) == null)
            fail();
        else assertTrue(true);
    }

    @Test
    public void tc_11(){
        student = new Student("11", "name", 937);
        if (studentRepository.save(student) == null)
            fail();
        else assertTrue(true);
    }

    @Test
    public void tc_12(){
        student = new Student("12", "name", 938);
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
