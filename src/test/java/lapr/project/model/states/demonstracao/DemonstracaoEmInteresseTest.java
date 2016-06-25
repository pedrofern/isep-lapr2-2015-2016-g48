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
public class DemonstracaoEmInteresseTest {
    
    public DemonstracaoEmInteresseTest() {
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
     * Test of valida method, of class DemonstracaoEmInteresse.
     */
    @Test
    public void testValida() throws Exception {
        System.out.println("valida");
        Demonstracao demonstracao = new Demonstracao();
        demonstracao.setDados("teste", "teste");
        DemonstracaoEmInteresse instance = new DemonstracaoEmInteresse();
        demonstracao.setEstadoDemonstracao(new DemonstracaoRegistada());
        boolean expResult = true;
        boolean result = instance.valida(demonstracao);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDemonstracaoEmInteresse method, of class DemonstracaoEmInteresse.
     */
    @Test
    public void testSetDemonstracaoEmInteresse() throws Exception {
        System.out.println("setDemonstracaoEmInteresse");
         Demonstracao demonstracao = new Demonstracao();
        demonstracao.setDados("teste", "teste");
        DemonstracaoEmInteresse instance = new DemonstracaoEmInteresse();
        demonstracao.setEstadoDemonstracao(new DemonstracaoRegistada());
        boolean expResult = true;
        boolean result = instance.setDemonstracaoEmInteresse(demonstracao);
        assertEquals(expResult, result);
        
    }
    
}
