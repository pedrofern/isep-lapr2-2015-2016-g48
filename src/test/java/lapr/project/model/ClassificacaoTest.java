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
public class ClassificacaoTest {
    
    public ClassificacaoTest() {
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
     * Test of getNumeroSubmissoes method, of class Classificacao.
     */
    @Test
    public void testGetNumeroSubmissoes() {
        System.out.println("getNumeroSubmissoes");
        Classificacao instance = new Classificacao();
        instance.incrementaNumeroSubmissoes();
        int expResult = 1;
        int result = instance.getNumeroSubmissoes();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getMediaClassificacoes method, of class Classificacao.
     */
    @Test
    public void testGetMediaClassificacoes() {
        System.out.println("getMediaClassificacoes");
        Classificacao instance = new Classificacao();
        for(int i=0; i<5; i++){
            instance.incrementaNumeroSubmissoes();
        }
        instance.setDecisaoAlerta(true);
        instance.setMediaDesvios(5);
        instance.setMediaClassificacoes(18);
        double expResult = 18.0;
        double result = instance.getMediaClassificacoes();
        assertEquals(expResult, result, 18.0);
        
    }

    /**
     * Test of getMediaDesvios method, of class Classificacao.
     */
    @Test
    public void testGetMediaDesvios() {
        System.out.println("getMediaDesvios");
        Classificacao instance = new Classificacao();
        instance.setMediaDesvios(5);
        double expResult = 5.0;
        double result = instance.getMediaDesvios();
        assertEquals(expResult, result, 5.0);
        
    }

    /**
     * Test of estaDecisaoAlerta method, of class Classificacao.
     */
    @Test
    public void testEstaDecisaoAlerta() {
        System.out.println("estaDecisaoAlerta");
        Classificacao instance = new Classificacao();
        instance.setDecisaoAlerta(true);
        boolean expResult = true;
        boolean result = instance.estaDecisaoAlerta();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setNumeroSubmissoes method, of class Classificacao.
     */
    @Test
    public void testSetNumeroSubmissoes() {
        System.out.println("setNumeroSubmissoes");
        int result = 2;
        Classificacao instance = new Classificacao();
        instance.incrementaNumeroSubmissoes();
        instance.incrementaNumeroSubmissoes();
        int expResult = instance.getNumeroSubmissoes();
        assertEquals(expResult, result);
    }


    /**
     * Test of setMediaDesvios method, of class Classificacao.
     */
    @Test
    public void testSetMediaDesvios() {
        System.out.println("setMediaDesvios");
        double result = 15.0;
        Classificacao instance = new Classificacao();
        instance.setMediaDesvios(result);
        double expResult = instance.getMediaDesvios();
        assertEquals(expResult, result, 15.0);
        
    }

    /**
     * Test of setDecisaoAlerta method, of class Classificacao.
     */
    @Test
    public void testSetDecisaoAlerta() {
        System.out.println("setDecisaoAlerta");
        boolean result = true;
        Classificacao instance = new Classificacao();
        instance.setDecisaoAlerta(result);
        boolean expResult = true;
        assertEquals(expResult, result);
    }
    
}
