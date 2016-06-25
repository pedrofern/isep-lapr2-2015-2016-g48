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
public class DemonstracaoRegistadaTest {
    
    public DemonstracaoRegistadaTest() {
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
     * Test of valida method, of class DemonstracaoRegistada.
     */
    @Test
    public void testValida() throws Exception {
        System.out.println("valida");
         Demonstracao demonstracao = new Demonstracao();
        demonstracao.setDados("teste", "teste");
        DemonstracaoRegistada instance = new DemonstracaoRegistada();
        demonstracao.setEstadoDemonstracao(new DemonstracaoCriada());
        boolean expResult = true;
        boolean result = instance.valida(demonstracao);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDemonstracaoRegistada method, of class DemonstracaoRegistada.
     */
    @Test
    public void testSetDemonstracaoRegistada() throws Exception {
        System.out.println("setDemonstracaoRegistada");
        Demonstracao demonstracao = new Demonstracao();
        demonstracao.setDados("teste", "teste");
        DemonstracaoRegistada instance = new DemonstracaoRegistada();
        demonstracao.setEstadoDemonstracao(new DemonstracaoCriada());
        boolean expResult = true;
        boolean result = instance.setDemonstracaoRegistada(demonstracao);
        assertEquals(expResult, result);
         
    }
    
}
