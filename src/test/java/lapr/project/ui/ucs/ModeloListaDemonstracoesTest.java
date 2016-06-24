/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import lapr.project.model.Demonstracao;
import lapr.project.model.lists.ListaDemonstracoes;
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
public class ModeloListaDemonstracoesTest {
    
    private ListaDemonstracoes lista;
    public ModeloListaDemonstracoesTest() {
        lista=new ListaDemonstracoes();
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
     * Test of getSize method, of class ModeloListaDemonstracoes.
     */
    @Test
    public void testGetSize() throws Exception {
        System.out.println("getSize");
        ModeloListaDemonstracoes instance = new ModeloListaDemonstracoes(lista);
        Demonstracao demonstracao=new Demonstracao();
        demonstracao.setDados("Tema", "Descrição");
        instance.addElement(demonstracao);
        int expResult = 1;
        int result = instance.getSize();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getElementAt method, of class ModeloListaDemonstracoes.
     */
    @Test
    public void testGetElementAt() throws Exception {
        System.out.println("getElementAt");
        int indice = 0;
        ModeloListaDemonstracoes instance = new ModeloListaDemonstracoes(lista);
        Demonstracao demonstracao=new Demonstracao();
        demonstracao.setDados("Tema", "Descrição");
        instance.addElement(demonstracao);
        Object expResult = instance.getElementAt(indice);
        Object result = instance.getElementAt(indice);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addElement method, of class ModeloListaDemonstracoes.
     */
    @Test
    public void testAddElement() throws Exception {
        System.out.println("addElement");
       ModeloListaDemonstracoes instance = new ModeloListaDemonstracoes(lista);
        Demonstracao demonstracao=new Demonstracao();
        demonstracao.setDados("Tema", "Descrição");
        instance.addElement(demonstracao);
        boolean expResult = true;
        boolean result = instance.addElement(demonstracao);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of removeElement method, of class ModeloListaDemonstracoes.
     */
    @Test
    public void testRemoveElement() throws Exception {
        System.out.println("removeElement");
       ModeloListaDemonstracoes instance = new ModeloListaDemonstracoes(lista);
        Demonstracao demonstracao=new Demonstracao();
        demonstracao.setDados("Tema", "Descrição");
        instance.addElement(demonstracao);
        boolean expResult = true;
        boolean result = instance.removeElement(demonstracao);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of contains method, of class ModeloListaDemonstracoes.
     */
    @Test
    public void testContains() throws Exception {
        System.out.println("contains");
        ModeloListaDemonstracoes instance = new ModeloListaDemonstracoes(lista);
        Demonstracao demonstracao=new Demonstracao();
        demonstracao.setDados("Tema", "Descrição");
        instance.addElement(demonstracao);
        boolean expResult = true;
        boolean result = instance.contains(demonstracao);
        assertEquals(expResult, result);
        
    }
    
}
