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
public class KeywordTest {
    
    public KeywordTest() {
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
     * Test of setKeyword method, of class Keyword.
     */
    @Test
    public void testSetKeyword() {
        System.out.println("setKeyword");
        String result = "Teste";
        Keyword instance = new Keyword();
        instance.setKeyword(result);
        String expResult=instance.getKeyword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getKeyword method, of class Keyword.
     */
    @Test
    public void testGetKeyword() {
        System.out.println("getKeyword");
        Keyword instance = new Keyword();
        String expResult = "teste";
        instance.setKeyword(expResult);
        String result = instance.getKeyword();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of valida method, of class Keyword.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Keyword instance = new Keyword();
        instance.setKeyword("teste");
        boolean expResult = true;
        boolean result = instance.valida();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of toString method, of class Keyword.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Keyword instance = new Keyword();
        instance.setKeyword("teste");
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
         
    }

    /**
     * Test of equals method, of class Keyword.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Keyword palavra = new Keyword();
        palavra.setKeyword("teste");
        Keyword instance = new Keyword();
        instance.setKeyword("Teste");
        boolean expResult = true;
        boolean result = instance.equals(palavra);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of hashCode method, of class Keyword.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Keyword instance = new Keyword();
        instance.setKeyword("Teste");
        int expResult =80699546;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
    }
    
}
