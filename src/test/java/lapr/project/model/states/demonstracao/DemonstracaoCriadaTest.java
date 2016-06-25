/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states.demonstracao;

import lapr.project.model.Demonstracao;
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
public class DemonstracaoCriadaTest {
    
    public DemonstracaoCriadaTest() {
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
     * Test of valida method, of class DemonstracaoCriada.
     */
    @Test
    public void testValida() throws Exception {
        System.out.println("valida");
        Demonstracao demonstracao = new Demonstracao();
        demonstracao.setDados("teste", "teste");
        DemonstracaoCriada instance = new DemonstracaoCriada();
        boolean expResult = true;
        boolean result = instance.valida(demonstracao);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDemonstracaoCriada method, of class DemonstracaoCriada.
     */
    @Test
    public void testSetDemonstracaoCriada() throws Exception {
        System.out.println("setDemonstracaoCriada");
        Demonstracao demonstracao = new Demonstracao();
        demonstracao.setDados("teste", "teste");
        DemonstracaoCriada instance = new DemonstracaoCriada();
        boolean expResult = true;
        boolean result = instance.setDemonstracaoCriada(demonstracao);
        assertEquals(expResult, result);
        
    }
    
}
