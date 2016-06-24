/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import lapr.project.model.Candidatura;
import lapr.project.model.lists.ListaCandidaturas;
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
public class ModeloListaCandidaturaTest {

    private ListaCandidaturas lista;

    public ModeloListaCandidaturaTest() {
        lista = new ListaCandidaturas();
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
     * Test of getSize method, of class ModeloListaCandidatura.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        ModeloListaCandidatura instance = new ModeloListaCandidatura(lista);
        instance.addElement(new Candidatura("Teste", "Teste", 123456789, 858, 520));
        int expResult = 1;
        int result = instance.getSize();
        assertEquals(expResult, result);

    }

    /**
     * Test of getElementAt method, of class ModeloListaCandidatura.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int indice = 0;
        ModeloListaCandidatura instance = new ModeloListaCandidatura(lista);
        instance.addElement(new Candidatura("Teste", "Teste", 123456789, 858, 520));
        Object expResult = instance.getElementAt(indice);
        Object result = instance.getElementAt(indice);
        assertEquals(expResult, result);

    }

    /**
     * Test of addElement method, of class ModeloListaCandidatura.
     */
    @Test
    public void testAddElement() {
        System.out.println("addElement");
        ModeloListaCandidatura instance = new ModeloListaCandidatura(lista);
        boolean expResult = true;
        boolean result = instance.addElement(new Candidatura("Teste", "Teste", 123456789, 858, 520));
        assertEquals(expResult, result);
    }

    /**
     * Test of removeElement method, of class ModeloListaCandidatura.
     */
    @Test
    public void testRemoveElement() {
        System.out.println("removeElement");
        Candidatura candidatura = new Candidatura("Teste", "Teste", 123456789, 858, 520);
        ModeloListaCandidatura instance = new ModeloListaCandidatura(lista);
        instance.addElement(candidatura);
        boolean expResult = true;
        boolean result = instance.removeElement(candidatura);
        assertEquals(expResult, result);

    }

    /**
     * Test of contains method, of class ModeloListaCandidatura.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
       Candidatura candidatura = new Candidatura("Teste", "Teste", 123456789, 858, 520);
        ModeloListaCandidatura instance = new ModeloListaCandidatura(lista);
        instance.addElement(candidatura);
        boolean expResult = true;
        boolean result = instance.contains(candidatura);
        assertEquals(expResult, result);
         
    }

}
