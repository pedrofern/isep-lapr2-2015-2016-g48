/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

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
public class RecursoTest {

    public RecursoTest() {
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

    /**
     * Test of RegistaRecurso method, of class Recurso.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String result = "Luz";
        Recurso instance = new Recurso();
        instance.setDescricao(result);
        String expResult = instance.getDescricao();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRecurso method, of class Recurso.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        Recurso instance = new Recurso("Agua");
        String expResult = "Agua";
        String result = instance.getDescricao();
        assertEquals(expResult, result);

    }

    /**
     * Test of valida method, of class Recurso.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Recurso instance = new Recurso("Energia");
        boolean expResult = true;
        boolean result = instance.valida();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toString method, of class Recurso.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Recurso instance = new Recurso("Agua");
        String expResult = "Agua";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of equals method, of class Recurso.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new Recurso("Agua");
        Recurso instance = new Recurso("Agua");
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of hashCode method, of class Recurso.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Recurso instance = new Recurso("Recurso");
        int expResult = -1547537368;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of compareTo method, of class Recurso.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Recurso outroRecurso = new Recurso("Agua");
        Recurso instance = new Recurso("Agua");
        int expResult = 0;
        int result = instance.compareTo(outroRecurso);
        assertEquals(expResult, result);
        
    }

}
