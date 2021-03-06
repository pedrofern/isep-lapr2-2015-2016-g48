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
public class DemonstracaoStateTest {

    public DemonstracaoStateTest() {
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
     * Test of valida method, of class DemonstracaoState.
     */
    @Test
    public void testValida() throws Exception {
        System.out.println("valida");
        Demonstracao demonstracao = new Demonstracao();
        demonstracao.setDados("teste", "teste");
        DemonstracaoState instance = new DemonstracaoStateImpl();
        boolean expResult = false;
        boolean result = instance.valida(demonstracao);
        assertEquals(expResult, result);

    }

    /**
     * Test of setDemonstracaoCriada method, of class DemonstracaoState.
     */
    @Test
    public void testSetDemonstracaoCriada() throws Exception {
        System.out.println("setDemonstracaoCriada");
        Demonstracao demonstracao = new Demonstracao();
        demonstracao.setDados("teste", "teste");
        DemonstracaoState instance = new DemonstracaoStateImpl();
        boolean expResult = false;
        boolean result = instance.setDemonstracaoCriada(demonstracao);
        assertEquals(expResult, result);

    }

    /**
     * Test of setDemonstracaoRegistada method, of class DemonstracaoState.
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

    /**
     * Test of setDemonstracaoEmInteresse method, of class DemonstracaoState.
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

    /**
     * Test of setDemonstracaoDecididas method, of class DemonstracaoState.
     */
    @Test
    public void testSetDemonstracaoDecididas() throws Exception {
        System.out.println("setDemonstracaoDecididas");
        Demonstracao demonstracao = new Demonstracao();
        demonstracao.setDados("teste", "teste");
        DemonstracaoDecididas instance = new DemonstracaoDecididas();
        demonstracao.setEstadoDemonstracao(new DemonstracaoEmInteresse());
        boolean expResult = true;
        boolean result = instance.setDemonstracaoDecididas(demonstracao);
        assertEquals(expResult, result);
    }

    /**
     * Test of setDemonstracaoEmAberto method, of class DemonstracaoState.
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


/**
 * Test of setDemonstracaoFechadas method, of class DemonstracaoState.
 */
@Test
        public void testSetDemonstracaoFechadas() throws Exception {
       Demonstracao demonstracao = new Demonstracao();
        demonstracao.setDados("teste", "teste");
        DemonstracaoFechadas instance = new DemonstracaoFechadas();
        demonstracao.setEstadoDemonstracao(new DemonstracaoEmAberto());
        boolean expResult = true;
        boolean result = instance.setDemonstracaoFechadas(demonstracao);
        assertEquals(expResult, result);

}

    public class DemonstracaoStateImpl implements DemonstracaoState {

    public boolean valida(Demonstracao d) {
        return false;
    }

    public boolean setDemonstracaoCriada(Demonstracao d) {
        return false;
    }

    public boolean setDemonstracaoRegistada(Demonstracao d) {
        return false;
    }

    public boolean setDemonstracaoEmInteresse(Demonstracao d) {
        return false;
    }

    public boolean setDemonstracaoDecididas(Demonstracao d) {
        return false;
    }

    public boolean setDemonstracaoEmAberto(Demonstracao d) {
        return false;
    }

    public boolean setDemonstracaoFechadas(Demonstracao d) {
        return false;
    }
}

}
