/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

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
public class ListaRecursoDemonstracaoTest {
    
    public ListaRecursoDemonstracaoTest() {
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
     * Test of addRecursoDemonstracao method, of class ListaRecursoDemonstracao.
     */
    @Test
    public void testAddRecursoDemonstracao() {
        System.out.println("addRecursoDemonstracao");
        Recurso result = new Recurso("Agua");
        ListaRecursoDemonstracao instance = new ListaRecursoDemonstracao();
        instance.addRecursoDemonstracao(result);
        Recurso expResult=instance.getListaRecursoDemonstracao().get(0);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getListaRecursoDemonstracao method, of class ListaRecursoDemonstracao.
     */
    @Test
    public void testGetListaRecursoDemonstracao() {
        System.out.println("getListaRecursoDemonstracao");
        ListaRecursoDemonstracao instance = new ListaRecursoDemonstracao();
        List<Recurso> expResult = instance.getListaRecursoDemonstracao();
        expResult.add(new Recurso("Agua"));
        List<Recurso> result = instance.getListaRecursoDemonstracao();
        result.add(new Recurso("Agua"));
        assertEquals(expResult, result);
         
    }

    /**
     * Test of criaRecursoDemonstracao method, of class ListaRecursoDemonstracao.
     */
    @Test
    public void testCriaRecursoDemonstracao() {
        System.out.println("criaRecursoDemonstracao");
        String recurso = "Result";
        ListaRecursoDemonstracao instance = new ListaRecursoDemonstracao();
        instance.criaRecursoDemonstracao(recurso);
        Recurso expResutl=instance.getListaRecursoDemonstracao().get(0);
        Recurso result=instance.getListaRecursoDemonstracao().get(0);
        assertEquals(expResutl, result);
         
    }

    /**
     * Test of valida method, of class ListaRecursoDemonstracao.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Recurso r = new Recurso("Recurso");
        ListaRecursoDemonstracao instance = new ListaRecursoDemonstracao();
        boolean expResult = true;
        boolean result = instance.valida(r);
        assertEquals(expResult, result);
         
    }

    

    /**
     * Test of contem method, of class ListaRecursoDemonstracao.
     */
    @Test
    public void testContem() {
        System.out.println("contem");
        Recurso recurso = new Recurso("Teste");
        ListaRecursoDemonstracao instance = new ListaRecursoDemonstracao();
        instance.addRecursoDemonstracao(recurso);
        boolean expResult = true;
        boolean result = instance.contem(recurso);
        assertEquals(expResult, result);
       
    }
    
}
