package ssvv.example;

import org.junit.Test;
import ssvv.example.domain.Tema;
import ssvv.example.repository.NotaXMLRepository;
import ssvv.example.repository.StudentXMLRepository;
import ssvv.example.repository.TemaXMLRepository;
import ssvv.example.service.Service;
import ssvv.example.validation.NotaValidator;
import ssvv.example.validation.StudentValidator;
import ssvv.example.validation.TemaValidator;

import java.util.Scanner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class WBTTest {
    private Service service = new Service(new StudentXMLRepository(new StudentValidator(), "studentTest.xml"),
            new TemaXMLRepository(new TemaValidator(), "temaTest1.xml"), new NotaXMLRepository(new NotaValidator(),
            "notaTest.xml"));



    @Test
    public void tc_1(){
        if (service.saveTema("", "desc", 10, 9)==0)
            assertTrue(true);
        else fail();
    }

    @Test
    public void tc_2(){
        if (service.saveTema("1", "desc", 10, 9)==1)
            assertTrue(true);
        else fail();
    }

    @Test
    public void tc_3(){
        if (service.saveTema("1", "desc", 7, 10) == 0){
            assertTrue(true);
        }else fail();
    }
}
