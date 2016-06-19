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
public class ProdutoTest {
    
    public ProdutoTest() {
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
     * Test of setTitulo method, of class Produto.
     */
    @Test
    public void testSetTitulo() {
        System.out.println("setTitulo");
        String result = "Cadeira";
        Produto instance = new Produto();
        instance.setTitulo(result);
        String expResult = instance.getNomeProduto();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNomeProduto method, of class Produto.
     */
    @Test
    public void testGetNomeProduto() {
        System.out.println("getNomeProduto");
        Produto instance = new Produto("Cadeira");
        String expResult = "Cadeira";
        String result = instance.getNomeProduto();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of valida method, of class Produto.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Produto instance = new Produto("Lampada");
        boolean expResult = true;
        boolean result = instance.valida();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toString method, of class Produto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Produto instance = new Produto("Mouse");
        String expResult = "Mouse";
        String result = instance.toString();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of equals method, of class Produto.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new Produto("Mesa");
        Produto instance = new Produto("Mesa");
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of hashCode method, of class Produto.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Produto instance = new Produto("Mesa");
        int expResult = 2395309;
        int result = instance.hashCode();
        assertEquals(expResult, result);
      
    }
    
}
