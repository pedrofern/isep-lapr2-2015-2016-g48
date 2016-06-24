/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import lapr.project.model.Utilizador;
import lapr.project.model.lists.*;
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
public class ModeloListaUtilizadoresTest {
    
    private RegistoUtilizadores registo;
    public ModeloListaUtilizadoresTest() {
        registo=new RegistoUtilizadores();
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
     * Test of getSize method, of class ModeloListaUtilizadores.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        ModeloListaUtilizadores instance = new ModeloListaUtilizadores(registo);
        instance.addElement(new Utilizador("Teste", "Teste", "Teste", "Teste"));
        int expResult = 1;
        int result = instance.getSize();
        assertEquals(expResult, result);
         
    }

    /**
     * Test of getElementAt method, of class ModeloListaUtilizadores.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int indice = 1;
        ModeloListaUtilizadores instance = new ModeloListaUtilizadores(registo);
        instance.addElement(new Utilizador("Teste", "Teste", "Teste", "Teste"));
        Object expResult = instance.getElementAt(indice);
        Object result = instance.getElementAt(indice);
        assertEquals(expResult, result);
    }

    /**
     * Test of addElement method, of class ModeloListaUtilizadores.
     */
    @Test
    public void testAddElement() {
        System.out.println("addElement");
        ModeloListaUtilizadores instance = new ModeloListaUtilizadores(registo);
        boolean expResult = true;
        boolean result = instance.addElement(new Utilizador("Teste", "Teste", "Teste", "Teste"));
        assertEquals(expResult, result);
        
    }

    /**
     * Test of removeElement method, of class ModeloListaUtilizadores.
     */
    @Test
    public void testRemoveElement() {
        System.out.println("removeElement");
        Utilizador utilizador =new Utilizador("Teste", "Teste", "Teste", "Teste");
        ModeloListaUtilizadores instance = new ModeloListaUtilizadores(registo);
        instance.addElement(utilizador);
        boolean expResult = true;
        boolean result = instance.removeElement(utilizador);
        assertEquals(expResult, result);
         
    }

    /**
     * Test of contains method, of class ModeloListaUtilizadores.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Utilizador utilizador = new Utilizador("Teste", "Teste", "Teste", "Teste");
        ModeloListaUtilizadores instance = new ModeloListaUtilizadores(registo);
        instance.addElement(utilizador);
        boolean expResult = true;
        boolean result = instance.contains(utilizador);
        assertEquals(expResult, result);
         
    }
    
}
