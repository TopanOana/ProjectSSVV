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
}
