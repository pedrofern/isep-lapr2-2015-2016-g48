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
public class StandTest {

    public StandTest() {
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
     * Test of setDescricao method, of class Stand.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String result = "Teste";
        Stand instance = new Stand();
        instance.setDescricao(result);
        String expResult = instance.getDescricao();
        assertEquals(expResult, result);

    }

    /**
     * Test of getDescricao method, of class Stand.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        Stand instance = new Stand();
        String expResult = "teste";
        instance.setDescricao(expResult);
        String result = instance.getDescricao();
        assertEquals(expResult, result);

    }

    /**
     * Test of setArea method, of class Stand.
     */
    @Test
    public void testSetArea() {
        System.out.println("setArea");
        String result = "85";
        Stand instance = new Stand();
        instance.setArea(result);
        String expResult = instance.getArea();
        assertEquals(expResult, result);

    }

    /**
     * Test of getArea method, of class Stand.
     */
    @Test
    public void testGetArea() {
        System.out.println("getArea");
        Stand instance = new Stand();
        String expResult = "85";
        instance.setArea(expResult);
        String result = instance.getArea();
        assertEquals(expResult, result);

    }

    /**
     * Test of valida method, of class Stand.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Stand instance = new Stand();
        instance.setArea("85");
        instance.setDescricao("teste");
        boolean expResult = true;
        boolean result = instance.valida();
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class Stand.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Stand instance = new Stand();
        instance.setArea("85");
        instance.setDescricao("teste");
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Stand.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Stand stand = new Stand();
       stand.setArea("85");
        stand.setDescricao("teste");
        Stand instance = new Stand();
        instance.setArea("85");
        instance.setDescricao("teste");
        boolean expResult = true;
        boolean result = instance.equals(stand);
        assertEquals(expResult, result);

    }

    /**
     * Test of hashCode method, of class Stand.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Stand instance = new Stand();
        instance.setArea("85");
        instance.setDescricao("teste");
        int expResult = 110252050;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of compareTo method, of class Stand.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Stand stand = new Stand();
       stand.setArea("85");
        stand.setDescricao("teste");
        Stand instance = new Stand();
        instance.setArea("85");
        instance.setDescricao("teste");
        int expResult = 0;
        int result = instance.compareTo(stand);
        assertEquals(expResult, result);
         
    }

}
