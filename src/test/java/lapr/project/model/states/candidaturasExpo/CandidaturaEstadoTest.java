/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states.candidaturasExpo;

import lapr.project.model.Candidatura;
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
public class CandidaturaEstadoTest {

    public CandidaturaEstadoTest() {
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
     * Test of valida method, of class CandidaturaEstado.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaEstado instance = new CandidaturaEstadoImpl();
        boolean expResult = false;
        boolean result = instance.valida(cand);
        assertEquals(expResult, result);

    }

    /**
     * Test of setCandidaturaCriada method, of class CandidaturaEstado.
     */
    @Test
    public void testSetCandidaturaCriada() {
        System.out.println("setCandidaturaCriada");
           Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaCriada instance = new CandidaturaCriada();
        boolean expResult = false;
        boolean result = instance.setCandidaturaCriada(cand);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaEmSubmissao method, of class CandidaturaEstado.
     */
    @Test
    public void testSetCandidaturaEmSubmissao() {
        System.out.println("setCandidaturaEmSubmissao");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaEmSubmissao instance = new CandidaturaEmSubmissao();
        cand.setEstadoCandidatura(new CandidaturaCriada());
        boolean expResult = true;
        boolean result = instance.setCandidaturaEmSubmissao(cand);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaEmAtribuicao method, of class CandidaturaEstado.
     */
    @Test
    public void testSetCandidaturaEmAtribuicao() {
        System.out.println("setCandidaturaEmAtribuicao");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaEmAtribuicao instance = new CandidaturaEmAtribuicao();
        cand.setEstadoCandidatura(new CandidaturaEmSubmissao());
        boolean expResult = true;
        boolean result = instance.setCandidaturaEmAtribuicao(cand);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaEmAvaliacao method, of class CandidaturaEstado.
     */
    @Test
    public void testSetCandidaturaEmAvaliacao() {
        System.out.println("setCandidaturaEmAvaliacao");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaEmAvaliacao instance = new CandidaturaEmAvaliacao();
        cand.setEstadoCandidatura(new CandidaturaEmAtribuicao());
        boolean expResult = true;
        boolean result = instance.setCandidaturaEmAvaliacao(cand);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaNaoAvaliada method, of class CandidaturaEstado.
     */
    @Test
    public void testSetCandidaturaNaoAvaliada() {
        System.out.println("setCandidaturaNaoAvaliada");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaNaoAvaliada instance = new CandidaturaNaoAvaliada();
        cand.setEstadoCandidatura(new CandidaturaEmAvaliacao());
        boolean expResult = true;
        boolean result = instance.setCandidaturaNaoAvaliada(cand);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaAvaliada method, of class CandidaturaEstado.
     */
    @Test
    public void testSetCandidaturaAvaliada() {
        System.out.println("setCandidaturaAvaliada");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaAvaliada instance = new CandidaturaAvaliada();
        cand.setEstadoCandidatura(new CandidaturaEmAvaliacao());
        boolean expResult = true;
        boolean result = instance.setCandidaturaAvaliada(cand);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaAceite method, of class CandidaturaEstado.
     */
    @Test
    public void testSetCandidaturaAceite() {
        System.out.println("setCandidaturaAceite");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaAceite instance = new CandidaturaAceite();
        cand.setEstadoCandidatura(new CandidaturaAvaliada());
        boolean expResult = true;
        boolean result = instance.setCandidaturaAceite(cand);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaRejeitada method, of class CandidaturaEstado.
     */
    @Test
    public void testSetCandidaturaRejeitada() {
        System.out.println("setCandidaturaRejeitada");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaRejeitada instance = new CandidaturaRejeitada();
        cand.setEstadoCandidatura(new CandidaturaAvaliada());
        boolean expResult = true;
        boolean result = instance.setCandidaturaRejeitada(cand);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaRetirada method, of class CandidaturaEstado.
     */
    @Test
    public void testSetCandidaturaRetirada() {
        System.out.println("setCandidaturaRetirada");
       Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaRetirada instance = new CandidaturaRetirada();
        cand.setEstadoCandidatura(new CandidaturaCriada());
        boolean expResult = true;
        boolean result = instance.setCandidaturaRetirada(cand);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaStandAtribuido method, of class CandidaturaEstado.
     */
    @Test
    public void testSetCandidaturaStandAtribuido() {
        System.out.println("setCandidaturaStandAtribuido");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaStandAtribuido instance = new CandidaturaStandAtribuido();
        cand.setEstadoCandidatura(new CandidaturaAceite());
        boolean expResult = true;
        boolean result = instance.setCandidaturaStandAtribuido(cand);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaStandConfirmado method, of class CandidaturaEstado.
     */
    @Test
    public void testSetCandidaturaStandConfirmado() {
        System.out.println("setCandidaturaStandConfirmado");
         Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaStandConfirmado instance = new CandidaturaStandConfirmado();
        cand.setEstadoCandidatura(new CandidaturaStandAtribuido());
        boolean expResult = true;
        boolean result = instance.setCandidaturaStandConfirmado(cand);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaTerminada method, of class CandidaturaEstado.
     */
    @Test
    public void testSetCandidaturaTerminada() {
        System.out.println("setCandidaturaTerminada");
         Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaEstado instance = new CandidaturaEstadoImpl();
        cand.setEstadoCandidatura(new CandidaturaStandConfirmado());
        boolean expResult = false;
        boolean result = instance.setCandidaturaTerminada(cand);
        assertEquals(expResult, result);
        
    }

    public class CandidaturaEstadoImpl extends CandidaturaEstado {
    }

}
