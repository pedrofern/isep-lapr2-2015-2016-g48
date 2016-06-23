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
public class OrganizadorTest {

    private Utilizador u = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", true, 15);

    public OrganizadorTest() {
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
     * Test of getUtilizador method, of class Organizador.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        Organizador instance = new Organizador(u);
        Utilizador expResult =u;
        Utilizador result = instance.getUtilizador();
        assertEquals(expResult, result);

    }

    /**
     * Test of valida method, of class Organizador.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Organizador instance = new Organizador(u);
        boolean expResult = false;
        boolean result = instance.valida();
        assertEquals(expResult, result);
         
    }

    /**
     * Test of toString method, of class Organizador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Organizador instance = new Organizador(u);
        String expResult = "Nuno Bettencourt";
        String result = instance.toString();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of isUtilizador method, of class Organizador.
     */
    @Test
    public void testIsUtilizador() {
        System.out.println("isUtilizador");
        Utilizador u = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", true, 15);
        Organizador instance = new Organizador(u);
        boolean expResult = true;
        boolean result = instance.isUtilizador(u);
        assertEquals(expResult, result);
        
    }

}
