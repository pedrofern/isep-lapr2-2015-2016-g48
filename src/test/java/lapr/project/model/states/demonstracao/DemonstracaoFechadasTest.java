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
public class DemonstracaoFechadasTest {
    
    public DemonstracaoFechadasTest() {
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
     * Test of valida method, of class DemonstracaoFechadas.
     */
    @Test
    public void testValida() throws Exception {
        System.out.println("valida");
         Demonstracao demonstracao = new Demonstracao();
        demonstracao.setDados("teste", "teste");
        DemonstracaoFechadas instance = new DemonstracaoFechadas();
        demonstracao.setEstadoDemonstracao(new DemonstracaoEmAberto());
        boolean expResult = true;
        boolean result = instance.valida(demonstracao);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDemonstracaoFechadas method, of class DemonstracaoFechadas.
     */
    @Test
    public void testSetDemonstracaoFechadas() throws Exception {
        System.out.println("setDemonstracaoFechadas");
        Demonstracao demonstracao = new Demonstracao();
        demonstracao.setDados("teste", "teste");
        DemonstracaoFechadas instance = new DemonstracaoFechadas();
        demonstracao.setEstadoDemonstracao(new DemonstracaoEmAberto());
        boolean expResult = true;
        boolean result = instance.setDemonstracaoFechadas(demonstracao);
        assertEquals(expResult, result);
      
    }
    
}
