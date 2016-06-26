/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states.exposicao;

import lapr.project.model.Exposicao;
import lapr.project.utils.Data;
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
public class ExposicaoStateTest {
    
       private static final String s1 = "19/11/2017", s2 = "20/11/2017", s3 = "11/11/2017", s4 = "12/11/2017", s5 = "15/11/2017",
            s6 = "16/11/2017", s7 = "13/11/2017", s8 = "17/11/2017", s9 = "18/11/2017", s10 = "14/11/2017";
    private static Data d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
    public ExposicaoStateTest() {
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
     * Test of valida method, of class ExposicaoState.
     */
    @Test
    public void testValida() throws Exception {
        System.out.println("valida");
         Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ExposicaoState instance = new ExposicaoStateImpl();
        boolean expResult = false;
        boolean result = instance.valida(exp);
        assertEquals(expResult, result);
         
    }

    /**
     * Test of setExposicaoEstadoInicial method, of class ExposicaoEstado.
     */
    @Test
    public void testSetExposicaoEstadoInicial() throws Exception {
        System.out.println("setExposicaoEstadoInicial");
       Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ExposicaoEstado instance = new ExposicaoEstado();
        boolean expResult = false;
        boolean result = instance.setExposicaoEstadoInicial(exp);
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicaoCriada method, of class ExposicaoEstado.
     */
    @Test
    public void testSetExposicaoCriada() throws Exception {
        System.out.println("setExposicaoCriada");
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ExposicaoCriada instance = new ExposicaoCriada();
        exp.alterarEstado(new ExposicaoEstadoInicial());
        boolean expResult = true;
        boolean result = instance.setExposicaoCriada(exp);
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicaoFAESemDemonstracao method, of class ExposicaoEstado.
     */
    @Test
    public void testSetExposicaoFAESemDemonstracao() throws Exception {
        System.out.println("setExposicaoFAESemDemonstracao");
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ExposicaoFAESemDemonstracao instance = new ExposicaoFAESemDemonstracao();
        exp.alterarEstado(new ExposicaoCriada());
        boolean expResult = true;
        boolean result = instance.setExposicaoFAESemDemonstracao(exp);
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicaoDemonstracaoSemFAE method, of class ExposicaoEstado.
     */
    @Test
    public void testSetExposicaoDemonstracaoSemFAE() throws Exception {
        System.out.println("setExposicaoDemonstracaoSemFAE");
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ExposicaoDemonstracaoSemFAE instance = new ExposicaoDemonstracaoSemFAE();
        exp.alterarEstado(new ExposicaoCriada());
        boolean expResult = true;
        boolean result = instance.setExposicaoDemonstracaoSemFAE(exp);
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicaoCompleta method, of class ExposicaoEstado.
     */
    @Test
    public void testSetExposicaoCompleta() throws Exception {
        System.out.println("setExposicaoCompleta");
         Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ExposicaoCompleta instance = new ExposicaoCompleta();
        exp.alterarEstado(new ExposicaoDemonstracaoSemFAE());
        boolean expResult = true;
        boolean result = instance.setExposicaoCompleta(exp);
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicaoCandidaturasAberta method, of class ExposicaoEstado.
     */
    @Test
    public void testSetExposicaoCandidaturasAberta() throws Exception {
        System.out.println("setExposicaoCandidaturasAberta");
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ExposicaoCandidaturasAberta instance = new ExposicaoCandidaturasAberta();
        exp.alterarEstado(new ExposicaoCompleta());
        boolean expResult = true;
        boolean result = instance.setExposicaoCandidaturasAberta(exp);
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicaoCandidaturasFechadas method, of class ExposicaoEstado.
     */
    @Test
    public void testSetExposicaoCandidaturasFechadas() throws Exception {
        System.out.println("setExposicaoCandidaturasFechadas");
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ExposicaoCandidaturasFechadas instance = new ExposicaoCandidaturasFechadas();
        exp.alterarEstado(new ExposicaoCandidaturasAberta());
        boolean expResult = true;
        boolean result = instance.setExposicaoCandidaturasFechadas(exp);
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicaoConflitosDetetados method, of class ExposicaoEstado.
     */
    @Test
    public void testSetExposicaoConflitosDetetados() throws Exception {
        System.out.println("setExposicaoConflitosDetetados");
          Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ExposicaoConflitosDetetados instance = new ExposicaoConflitosDetetados();
        exp.alterarEstado(new ExposicaoCandidaturasFechadas());
        boolean expResult = true;
        boolean result = instance.setExposicaoConflitosDetetados(exp);
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicaoConflitosAlterados method, of class ExposicaoEstado.
     */
    @Test
    public void testSetExposicaoConflitosAlterados() throws Exception {
        System.out.println("setExposicaoConflitosAlterados");
         Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ExposicaoConflitosAlterados instance = new ExposicaoConflitosAlterados();
        exp.alterarEstado(new ExposicaoConflitosDetetados());
        boolean expResult = true;
        boolean result = instance.setExposicaoConflitosAlterados(exp);
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicaoCandidaturasEmAtribuicao method, of class ExposicaoEstado.
     */
    @Test
    public void testSetExposicaoCandidaturasEmAtribuicao() throws Exception {
        System.out.println("setExposicaoCandidaturasEmAtribuicao");
         Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ExposicaoCandidaturasEmAtribuicao instance = new ExposicaoCandidaturasEmAtribuicao();
        exp.alterarEstado(new ExposicaoConflitosAlterados());
        boolean expResult = true;
        boolean result = instance.setExposicaoCandidaturasEmAtribuicao(exp);
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicaoCandidaturasAtribuidas method, of class ExposicaoEstado.
     */
    @Test
    public void testSetExposicaoCandidaturasAtribuidas() throws Exception {
        System.out.println("setExposicaoCandidaturasAtribuidas");
         Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ExposicaoCandidaturasAtribuidas instance = new ExposicaoCandidaturasAtribuidas();
        exp.alterarEstado(new ExposicaoCandidaturasEmAtribuicao());
        boolean expResult = true;
        boolean result = instance.setExposicaoCandidaturasAtribuidas(exp);
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicaoCandidaturasAvaliadas method, of class ExposicaoEstado.
     */
    @Test
    public void testSetExposicaoCandidaturasAvaliadas() throws Exception {
        System.out.println("setExposicaoCandidaturasAvaliadas");
         Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ExposicaoCandidaturasAvaliadas instance = new ExposicaoCandidaturasAvaliadas();
        exp.alterarEstado(new ExposicaoCandidaturasAtribuidas());
        boolean expResult = true;
        boolean result = instance.setExposicaoCandidaturasAvaliadas(exp);
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicaoCandidaturasDecididas method, of class ExposicaoEstado.
     */
    @Test
    public void testSetExposicaoCandidaturasDecididas() throws Exception {
        System.out.println("setExposicaoCandidaturasDecididas");
       Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ExposicaoCandidaturasDecididas instance = new ExposicaoCandidaturasDecididas();
        exp.alterarEstado(new ExposicaoCandidaturasAvaliadas());
        boolean expResult = true;
        boolean result = instance.setExposicaoCandidaturasDecididas(exp);
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicaoStandsAtribuidos method, of class ExposicaoEstado.
     */
    @Test
    public void testSetExposicaoStandsAtribuidos() throws Exception {
        System.out.println("setExposicaoStandsAtribuidos");
         Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ExposicaoCandidaturasAtribuidas instance = new ExposicaoCandidaturasAtribuidas();
        exp.alterarEstado(new ExposicaoCandidaturasEmAtribuicao());
        boolean expResult = true;
        boolean result = instance.setExposicaoCandidaturasAtribuidas(exp);
    }

    /**
     * Test of setExposicaoTerminada method, of class ExposicaoEstado.
     */
    @Test
    public void testSetExposicaoTerminada() throws Exception {
        System.out.println("setExposicaoTerminada");
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ExposicaoTerminada instance = new ExposicaoTerminada();
        exp.alterarEstado(new ExposicaoStandsAtribuidos());
        boolean expResult = true;
        boolean result = instance.setExposicaoTerminada(exp);
        assertEquals(expResult, result);
    }
    public class ExposicaoStateImpl implements ExposicaoState {

        public boolean valida(Exposicao e) {
            return false;
        }

        public boolean setExposicaoEstadoInicial(Exposicao e) {
            return false;
        }

        public boolean setExposicaoCriada(Exposicao e) {
            return false;
        }

        public boolean setExposicaoFAESemDemonstracao(Exposicao e) {
            return false;
        }

        public boolean setExposicaoDemonstracaoSemFAE(Exposicao e) {
            return false;
        }

        public boolean setExposicaoCompleta(Exposicao e) {
            return false;
        }

        public boolean setExposicaoCandidaturasAberta(Exposicao e) {
            return false;
        }

        public boolean setExposicaoCandidaturasFechadas(Exposicao e) {
            return false;
        }

        public boolean setExposicaoConflitosDetetados(Exposicao e) {
            return false;
        }

        public boolean setExposicaoConflitosAlterados(Exposicao e) {
            return false;
        }

        public boolean setExposicaoCandidaturasEmAtribuicao(Exposicao e) {
            return false;
        }

        public boolean setExposicaoCandidaturasAtribuidas(Exposicao e) {
            return false;
        }

        public boolean setExposicaoCandidaturasAvaliadas(Exposicao e) {
            return false;
        }

        public boolean setExposicaoCandidaturasDecididas(Exposicao e) {
            return false;
        }

        public boolean setExposicaoStandsAtribuidos(Exposicao e) {
            return false;
        }

        public boolean setExposicaoTerminada(Exposicao e) {
            return false;
        }
    }
    
}
