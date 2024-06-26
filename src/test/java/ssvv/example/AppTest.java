package ssvv.example;


import org.junit.Test;
import ssvv.example.domain.Student;
import ssvv.example.repository.StudentRepository;
import ssvv.example.validation.StudentValidator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public StudentRepository studentRepo = new StudentRepository(new StudentValidator());
    public Student student;

    public AppTest() {
//        super( testName );
//        studentRepository = new StudentRepository(new StudentValidator());
    }

    @Test
    public void tc_valid_studentID() {
        student = new Student("1", "name student", 937);
        try {
            studentRepo.save(student);
            assertTrue(true);
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void tc_invalid_studentID() {
        student = new Student("", "name student", 937);

        if (studentRepo.save(student) == null)
            assertTrue(true);
        else fail();

    }

    @Test
    public void tc_3() {
        student = new Student(null, "name", 937);
        if (studentRepo.save(student) == null)
            assertTrue(true);
        else fail();
    }

    @Test
    public void tc_4() {
        student = new Student("4", "name", 937);
        if (studentRepo.save(student) == null)
            fail();
        else assertTrue(true);
    }

    @Test
    public void tc_5() {
        student = new Student("5", "", 937);
        if (studentRepo.save(student) == null)
            assertTrue(true);
        else fail();
    }

    @Test
    public void tc_6() {
        student = new Student("6", null, 937);
        if (studentRepo.save(student) == null)
            assertTrue(true);
        else fail();
    }

    @Test
    public void tc_7() {
        student = new Student("7", "name", 110);
        if (studentRepo.save(student) == null)
            assertTrue(true);
        else fail();
    }

    @Test
    public void tc_8() {
        student = new Student("8", "name", 111);
//        Student val = studentRepository.save(student);
        if (studentRepo.save(student) == null)
            fail();
        else assertTrue(true);
    }

    @Test
    public void tc_9() {
        student = new Student("9", "name", 112);
        if (studentRepo.save(student) == null)
            fail();
        else assertTrue(true);
    }

    @Test
    public void tc_10() {
        student = new Student("10", "name", 936);
        if (studentRepo.save(student) == null)
            fail();
        else assertTrue(true);
    }

    @Test
    public void tc_11() {
        student = new Student("11", "name", 937);
        if (studentRepo.save(student) == null)
            fail();
        else assertTrue(true);
    }

    @Test
    public void tc_12() {
        student = new Student("12", "name", 938);
        if (studentRepo.save(student) == null)
            assertTrue(true);
        else fail();
    }

    @Test
    public void tc_13() {
        student = new Student("test", "name", 926);
        studentRepo.save(student);
        if (studentRepo.save(student) == null)
            assertTrue(true);
        else fail();
    }




}
