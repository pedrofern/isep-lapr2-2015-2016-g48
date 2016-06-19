/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Recurso;
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
public class RegistoRecursosTest {

    public RegistoRecursosTest() {
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
     * Test of obterRecurso method, of class RegistoRecursos.
     */
    @Test
    public void testObterRecurso() {
        System.out.println("obterRecurso");
        Recurso recurso = new Recurso("Agua");
        int indice = 0;
        RegistoRecursos instance = new RegistoRecursos();
        RegistoRecursos registo = new RegistoRecursos();
        instance.addRecurso(recurso);
        registo.addRecurso(recurso);
        Recurso expResult = registo.getListaRecursos().get(0);
        Recurso result = instance.obterRecurso(indice);
        assertEquals(expResult, result);

    }

    /**
     * Test of getArray method, of class RegistoRecursos.
     */
    @Test
    public void testGetArray() {
        System.out.println("getArray");
        Recurso recurso1 = new Recurso("Agua");
        Recurso recurso2 = new Recurso("Agua");
        Recurso recurso3 = new Recurso("Agua");
        RegistoRecursos instance = new RegistoRecursos();
        instance.addRecurso(recurso3);
        instance.addRecurso(recurso2);
        instance.addRecurso(recurso1);
        Recurso[] expResult = instance.getListaRecursos().toArray(new Recurso[instance.getListaRecursos().size()]);
        Recurso[] result = instance.getArray();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of getListaRecursos method, of class RegistoRecursos.
     */
    @Test
    public void testGetListaRecursos() {
        System.out.println("getListaRecursos");
        Recurso recurso1 = new Recurso("Agua");
        Recurso recurso2 = new Recurso("Agua");
        Recurso recurso3 = new Recurso("Agua");
        RegistoRecursos instance = new RegistoRecursos();
        RegistoRecursos registo = new RegistoRecursos();
        instance.addRecurso(recurso3);
        instance.addRecurso(recurso2);
        instance.addRecurso(recurso1);
        registo.addRecurso(recurso3);
        registo.addRecurso(recurso2);
        registo.addRecurso(recurso1);
        List<Recurso> expResult = registo.getListaRecursos();
        List<Recurso> result = instance.getListaRecursos();
        assertEquals(expResult, result);

    }

    /**
     * Test of addRecurso method, of class RegistoRecursos.
     */
    @Test
    public void testAddRecurso() {
        System.out.println("addRecurso");
        Recurso recurso1 = new Recurso("Agua");
        RegistoRecursos instance = new RegistoRecursos();
        RegistoRecursos registo = new RegistoRecursos();
        boolean expResult = true;
        boolean result = instance.addRecurso(recurso1);
        assertEquals(expResult, result);

    }

    /**
     * Test of novoRecurso method, of class RegistoRecursos.
     */
    @Test
    public void testNovoRecurso() {
        System.out.println("novoRecurso");
        RegistoRecursos instance = new RegistoRecursos();
        RegistoRecursos registo = new RegistoRecursos();
        Recurso expResult = registo.novoRecurso();
        expResult.setDescricao("Agua");
        Recurso result = instance.novoRecurso();
        result.setDescricao("Agua");
        assertEquals(expResult, result);
    }

    /**
     * Test of removerRecurso method, of class RegistoRecursos.
     */
    @Test
    public void testRemoverRecurso() {
        System.out.println("removerRecurso");
        Recurso recurso1 = new Recurso("Agua");
        RegistoRecursos instance = new RegistoRecursos();
        RegistoRecursos registo = new RegistoRecursos();
        instance.addRecurso(recurso1);
        boolean expResult = true;
        boolean result = instance.removerRecurso(recurso1);
        assertEquals(expResult, result);

    }

    /**
     * Test of tamanho method, of class RegistoRecursos.
     */
    @Test
    public void testTamanho() {
        System.out.println("tamanho");
        Recurso recurso1 = new Recurso("Agua");
        
        RegistoRecursos instance = new RegistoRecursos();
        
        instance.addRecurso(recurso1);
        
        int expResult = 1;
        int result = instance.tamanho();
        assertEquals(expResult, result);

    }

    /**
     * Test of indiceDeRecurso method, of class RegistoRecursos.
     */
    @Test
    public void testIndiceDeRecurso() {
        System.out.println("indiceDeRecurso");
        Recurso recurso1 = new Recurso("Agua");

        RegistoRecursos instance = new RegistoRecursos();
        instance.addRecurso(recurso1);
        int expResult = 0;
        int result = instance.indiceDeRecurso(recurso1);
        assertEquals(expResult, result);

    }

    /**
     * Test of contem method, of class RegistoRecursos.
     */
    @Test
    public void testContem() {
        System.out.println("contem");
        Recurso recurso1 = new Recurso("Agua");
        Recurso recurso2 = new Recurso("Agua");
        Recurso recurso3 = new Recurso("Agua");
        RegistoRecursos instance = new RegistoRecursos();
        RegistoRecursos registo = new RegistoRecursos();
        instance.addRecurso(recurso3);
        instance.addRecurso(recurso2);
        instance.addRecurso(recurso1);
        boolean expResult = true;
        boolean result = instance.contem(recurso1);
        assertEquals(expResult, result);
         
    }

    /**
     * Test of getRecurso method, of class RegistoRecursos.
     */
    @Test
    public void testGetRecurso() {
        System.out.println("getRecurso");
        
        Recurso recurso1 = new Recurso("Agua");
        
        RegistoRecursos instance = new RegistoRecursos();
         
        instance.addRecurso(recurso1);
        Recurso expResult = recurso1;
        Recurso result = instance.getRecurso(recurso1.getDescricao());
        assertEquals(expResult, result);
         
    }

    /**
     * Test of registaRecurso method, of class RegistoRecursos.
     */
    @Test
    public void testRegistaRecurso() {
        System.out.println("registaRecurso");
       Recurso recurso1 = new Recurso("Agua");
        RegistoRecursos instance = new RegistoRecursos();
        boolean expResult = true;
        boolean result = instance.registaRecurso(recurso1);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of validaRecurso method, of class RegistoRecursos.
     */
    @Test
    public void testValidaRecurso() {
        System.out.println("validaRecurso");
       Recurso recurso1 = new Recurso("Agua");
        RegistoRecursos instance = new RegistoRecursos();
        boolean expResult = true;
        boolean result = instance.validaRecurso(recurso1);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of countRecurso method, of class RegistoRecursos.
     */
    @Test
    public void testCountRecurso() {
        System.out.println("countRecurso");
        Recurso recurso1 = new Recurso("Agua");
        
        RegistoRecursos instance = new RegistoRecursos();
        instance.addRecurso(recurso1);
       
        int expResult = 1;
        int result = instance.countRecurso();
        assertEquals(expResult, result);
      
    }

}
