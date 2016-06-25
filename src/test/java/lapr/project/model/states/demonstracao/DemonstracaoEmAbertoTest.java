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
public class DemonstracaoEmAbertoTest {

    public DemonstracaoEmAbertoTest() {
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
     * Test of valida method, of class DemonstracaoEmAberto.
     */
    @Test
    public void testValida() throws Exception {
        System.out.println("valida");
        Demonstracao demonstracao = new Demonstracao();
        demonstracao.setDados("teste", "teste");
        DemonstracaoEmAberto instance = new DemonstracaoEmAberto();
        demonstracao.setEstadoDemonstracao(new DemonstracaoDecididas());
        boolean expResult = true;
        boolean result = instance.valida(demonstracao);
        assertEquals(expResult, result);
    }

    /**
     * Test of setDemonstracaoEmAberto method, of class DemonstracaoEmAberto.
     */
    @Test
    public void testSetDemonstracaoEmAberto() throws Exception {
        System.out.println("setDemonstracaoEmAberto");
        Demonstracao demonstracao = new Demonstracao();
        demonstracao.setDados("teste", "teste");
        DemonstracaoEmAberto instance = new DemonstracaoEmAberto();
        demonstracao.setEstadoDemonstracao(new DemonstracaoDecididas());
        boolean expResult = true;
        boolean result = instance.setDemonstracaoEmAberto(demonstracao);
        assertEquals(expResult, result);
    }

}
