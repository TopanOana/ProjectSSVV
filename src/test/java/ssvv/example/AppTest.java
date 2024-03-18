package ssvv.example;
//
//import junit.framework.Test;
//import junit.framework.TestSuite;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Test;
import ssvv.example.domain.Student;
import ssvv.example.repository.StudentRepository;
import ssvv.example.validation.StudentValidator;

import static junit.framework.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public StudentRepository studentRepository;

    public Student student;
    public AppTest(  )
    {
//        super( testName );
        studentRepository = new StudentRepository(new StudentValidator());
    }

    @Test
    public void tc_valid_studentID(){
        student = new Student("1", "name student", 937);
        try{
            studentRepository.save(student);
            assertTrue(true);
        }catch (Exception ex){
            fail();
        }
    }

    @Test
    public void tc_invalid_studentID(){
        student = new Student("", "name student", 937);
        try{
            studentRepository.save(student);
            fail();
        }catch (Exception ex){
            assertTrue(true);
        }
    }


    /**
     * @return the suite of tests being tested
     */
    public static TestSuite suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
