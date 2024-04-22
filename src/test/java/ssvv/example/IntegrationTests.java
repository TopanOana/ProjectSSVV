package ssvv.example;

import org.junit.Test;
import ssvv.example.repository.NotaXMLRepository;
import ssvv.example.repository.StudentXMLRepository;
import ssvv.example.repository.TemaXMLRepository;
import ssvv.example.service.Service;
import ssvv.example.validation.NotaValidator;
import ssvv.example.validation.StudentValidator;
import ssvv.example.validation.TemaValidator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class IntegrationTests {
    private Service service = new Service(new StudentXMLRepository(new StudentValidator(), "studentTest1.xml"),
            new TemaXMLRepository(new TemaValidator(), "temaTest2.xml"), new NotaXMLRepository(new NotaValidator(),
            "notaTest1.xml"));


    @Test
    public void tc_1() {
        //add student test
        if (service.saveStudent("", "nume", 936) == 0) {
            assertTrue(true);
        } else fail();
    }

    @Test
    public void tc_2() {
        //add assignment test
        if (service.saveTema("", "desc", 10, 9) == 0)
            assertTrue(true);
        else fail();
    }

    @Test
    public void tc_3() {
        //add grade test
        if (service.saveNota("0", "0", 9.7, 10, "ok") != 1) {
            assertTrue(true);
        } else fail();
    }

    @Test
    public void tc_4() {
        tc_1();
        tc_2();
        tc_3();
    }

    @Test
    public void tc_5(){
        //add valid student
        service.deleteStudent("1");
        if (service.saveStudent("1", "new name", 937) == 1)
            assertTrue(true);
        else fail();
    }

    @Test
    public void tc_6(){
        //add valid assignment
        service.deleteTema("1");
        if (service.saveTema("1", "description", 10, 6) == 1)
            assertTrue(true);
        else fail();
    }

    @Test
    public void tc_7(){
        //add valid grade
        service.deleteGrade("1", "1");
        if (service.saveNota("1", "1", 10, 7, "super") == 1)
            assertTrue(true);
        else fail();
    }

    @Test
    public void tc_8(){
        //integration test add student + add assignment
        tc_5();
        tc_6();
    }

    @Test
    public void tc_9(){
        tc_5();
        tc_6();
        tc_7();
    }
}
