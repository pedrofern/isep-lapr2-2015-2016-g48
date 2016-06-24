/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import lapr.project.model.Produto;
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
public class ModeloListaProdutosTest {
    
    private ListaProduto listaproduto;
    
    public ModeloListaProdutosTest() {
        
        this.listaproduto = new ListaProduto();
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
     * Test of getSize method, of class ModeloListaProdutos.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        ModeloListaProdutos instance = new ModeloListaProdutos(listaproduto);
        instance.addElement(new Produto("teste"));
        int expResult = 1;
        int result = instance.getSize();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getElementAt method, of class ModeloListaProdutos.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int indice = 0;
        ModeloListaProdutos instance = new ModeloListaProdutos(listaproduto);
        instance.addElement(new Produto("Teste"));
        Object expResult = instance.getElementAt(indice);
        Object result = instance.getElementAt(indice);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addElement method, of class ModeloListaProdutos.
     */
    @Test
    public void testAddElement() {
        System.out.println("addElement");
        ModeloListaProdutos instance = new ModeloListaProdutos(listaproduto);
        boolean expResult = true;
        boolean result = instance.addElement(new Produto("Teste"));
        assertEquals(expResult, result);
        
    }

    /**
     * Test of removeElement method, of class ModeloListaProdutos.
     */
    @Test
    public void testRemoveElement() {
        System.out.println("removeElement");
        ModeloListaProdutos instance = new ModeloListaProdutos(listaproduto);
        Produto produto=new Produto("teste");
        instance.addElement(produto);
        boolean expResult = true;
        boolean result = instance.removeElement(produto);
        assertEquals(expResult, result);
         
    }

    /**
     * Test of contains method, of class ModeloListaProdutos.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Produto produto=new Produto("teste");
        ModeloListaProdutos instance = new ModeloListaProdutos(listaproduto);
        instance.addElement(produto);
        boolean expResult = true;
        boolean result = instance.contains(produto);
        assertEquals(expResult, result);
         
    }
    
}
