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
public class RepresentanteTest {

    private Utilizador u = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", true, 15);

    public RepresentanteTest() {
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
     * Test of getRepresentante method, of class Representante.
     */
    @Test
    public void testGetRepresentante() {
        System.out.println("getRepresentante");
        Representante instance = new Representante(u);
        Utilizador expResult = u;
        Utilizador result = instance.getRepresentante();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of valida method, of class Representante.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Representante instance = new Representante(u);
        boolean expResult = false;
        boolean result = instance.valida();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toString method, of class Representante.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Representante instance = new Representante(u);
        String expResult = "Nuno Bettencourt";
        String result = instance.toString();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of isRepresentante method, of class Representante.
     */
    @Test
    public void testIsRepresentante() {
        System.out.println("isRepresentante");
        Utilizador u = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", true, 15);
        Representante instance = new Representante(u);
        boolean expResult = true;
        boolean result = instance.isRepresentante(u);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of compareTo method, of class Representante.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Utilizador u = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", true, 15);
        Representante instance = new Representante(u);
        int expResult = 0;
        int result = instance.compareTo(u);
        assertEquals(expResult, result);
         
    }

}
