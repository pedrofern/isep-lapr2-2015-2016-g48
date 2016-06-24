/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import lapr.project.model.mechanisms.MecanismoAtribuicao;
import lapr.project.model.mechanisms.MecanismoCarga;
import lapr.project.model.mechanisms.MecanismoRanking;
import lapr.project.model.mechanisms.MecanismoTempoServico;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Edu
 */
public class RegistoMecanismosAtribuicaoTest {
    
    public RegistoMecanismosAtribuicaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

//    /**
//     * Test of addMecanismo1 method, of class RegistoMecanismosAtribuicao.
//     */
//    @Test
//    public void testAddMecanismo1() {
//        System.out.println("addMecanismo1");
//        MecanismoCarga t = null;
//        RegistoMecanismosAtribuicao instance = new RegistoMecanismosAtribuicao();
//        instance.addMecanismo1(t);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addMecanismo2 method, of class RegistoMecanismosAtribuicao.
//     */
//    @Test
//    public void testAddMecanismo2() {
//        System.out.println("addMecanismo2");
//        MecanismoTempoServico t = null;
//        RegistoMecanismosAtribuicao instance = new RegistoMecanismosAtribuicao();
//        instance.addMecanismo2(t);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addMecanismo3 method, of class RegistoMecanismosAtribuicao.
//     */
//    @Test
//    public void testAddMecanismo3() {
//        System.out.println("addMecanismo3");
//        MecanismoRanking t = new MecanismoRanking();
//        RegistoMecanismosAtribuicao instance = new RegistoMecanismosAtribuicao();
//        instance.addMecanismo3(t);
//        MecanismoRanking expResult=(MecanismoRanking) instance.getRegistoMecanismos().get(0);
//        assertEquals(expResult, t);
//       
//    }

    /**
     * Test of getRegistoMecanismos method, of class RegistoMecanismosAtribuicao.
     */
    @Test
    public void testGetRegistoMecanismos() {
        System.out.println("getRegistoMecanismos");
        RegistoMecanismosAtribuicao instance = new RegistoMecanismosAtribuicao();
        ArrayList<MecanismoAtribuicao> expResult = instance.getRegistoMecanismos();
        ArrayList<MecanismoAtribuicao> result = instance.getRegistoMecanismos();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of listaMecanismostoString method, of class RegistoMecanismosAtribuicao.
     */
    @Test
    public void testListaMecanismostoString() {
        System.out.println("listaMecanismostoString");
        RegistoMecanismosAtribuicao instance = new RegistoMecanismosAtribuicao();
        instance.addMecanismo1(new MecanismoCarga());
        String expResult = instance.listaMecanismostoString();
        String result = instance.listaMecanismostoString();
        assertEquals(expResult, result);
         
    }

    /**
     * Test of getArray method, of class RegistoMecanismosAtribuicao.
     */
    @Test
    public void testGetArray() {
        System.out.println("getArray");
        RegistoMecanismosAtribuicao instance = new RegistoMecanismosAtribuicao();
        MecanismoAtribuicao[] expResult = instance.getRegistoMecanismos().toArray(new MecanismoAtribuicao[instance.getRegistoMecanismos().size()] );
        MecanismoAtribuicao[] result = instance.getArray();
        assertArrayEquals(expResult, result);
         
    }
    
}
