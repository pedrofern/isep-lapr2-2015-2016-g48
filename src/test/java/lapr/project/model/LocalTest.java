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
public class LocalTest {

    public LocalTest() {
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
     * Test of getLocal method, of class Local.
     */
    @Test
    public void testGetLocal() {
        System.out.println("getLocal");
        Local instance = new Local();
        String expResult = "Teste";
        instance.setLocal(expResult);
        String result = instance.getLocal();
        assertEquals(expResult, result);

    }

    /**
     * Test of setLocal method, of class Local.
     */
    @Test
    public void testSetLocal() {
        System.out.println("setLocal");
        String result = "Teste";
        Local instance = new Local();
        instance.setLocal(result);
        String expResult = instance.getLocal();
        assertEquals(expResult, result);
    }

    /**
     * Test of validaLocal method, of class Local.
     */
    @Test
    public void testValidaLocal() {
        System.out.println("validaLocal");
        String local = "Teste";
        Local instance = new Local();
        instance.setLocal(local);
        boolean expResult = true;
        boolean result = instance.validaLocal();
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class Local.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String local = "Teste";
        Local instance = new Local();
        instance.setLocal(local);
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);

    }

}
