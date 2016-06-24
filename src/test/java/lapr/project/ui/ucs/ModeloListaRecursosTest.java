/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import lapr.project.model.*;
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
public class ModeloListaRecursosTest {

    private RegistoRecursos listaRecursos;
    
    public ModeloListaRecursosTest() {

        this.listaRecursos = new RegistoRecursos();
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
     * Test of getSize method, of class ModeloListaRecursos.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        ModeloListaRecursos instance = new ModeloListaRecursos(listaRecursos);
        int expResult = 1;
        instance.addElement(new Recurso("Descrição"));
        int result = instance.getSize();
        assertEquals(expResult, result);

    }

    /**
     * Test of getElementAt method, of class ModeloListaRecursos.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int indice = 0;
        ModeloListaRecursos instance = new ModeloListaRecursos(listaRecursos);
        Recurso expResult = new Recurso("teste");
        instance.addElement(expResult);
        Object result = instance.getElementAt(indice);
        assertEquals(expResult, result);

    }

    /**
     * Test of addElement method, of class ModeloListaRecursos.
     */
    @Test
    public void testAddElement() {
        System.out.println("addElement");
        Recurso recurso = new Recurso("Teste");
        ModeloListaRecursos instance = new ModeloListaRecursos(listaRecursos);
        boolean expResult = true;
        boolean result = instance.addElement(recurso);
        assertEquals(expResult, result);

    }

    /**
     * Test of removeElement method, of class ModeloListaRecursos.
     */
    @Test
    public void testRemoveElement() {
        System.out.println("removeElement");
        Recurso recurso = new Recurso("Teste");
        ModeloListaRecursos instance = new ModeloListaRecursos(listaRecursos);  
        instance.addElement(recurso);
        boolean expResult = true;
        boolean result = instance.removeElement(recurso);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of contains method, of class ModeloListaRecursos.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Recurso recurso = new Recurso("teste");
        ModeloListaRecursos instance = new ModeloListaRecursos(listaRecursos);
        instance.addElement(recurso);
        boolean expResult = true;
        boolean result = instance.contains(recurso);
        assertEquals(expResult, result);
      
    }

}
