/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states.candidaturasDemo;

import lapr.project.model.Candidatura;
import lapr.project.model.CandidaturaDemonstracao;
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
public class CandidaturaDemoEstadoTest {

    public CandidaturaDemoEstadoTest() {
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
     * Test of valida method, of class CandidaturaDemoEstado.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaDemonstracao candidatura = new CandidaturaDemonstracao(cand);
        CandidaturaDemoEstado instance = new CandidaturaDemoEstadoImpl();
        instance.setCandidaturaDemoCriada(candidatura);
        boolean expResult = false;
        boolean result = instance.valida(candidatura);
        assertEquals(expResult, result);

    }

    /**
     * Test of setCandidaturaDemoCriada method, of class CandidaturaDemoEstado.
     */
    @Test
    public void testSetCandidaturaDemoCriada() {
        System.out.println("setCandidaturaDemoCriada");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaDemonstracao candidatura = new CandidaturaDemonstracao(cand);
        CandidaturaDemoCriada instance = new CandidaturaDemoCriada();
        instance.setCandidaturaDemoCriada(candidatura);
        boolean expResult = false;
        boolean result = instance.setCandidaturaDemoCriada(candidatura);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaDemoRetirada method, of class
     * CandidaturaDemoEstado.
     */
    @Test
    public void testSetCandidaturaDemoRetirada() {
        System.out.println("setCandidaturaDemoRetirada");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaDemonstracao candidatura = new CandidaturaDemonstracao(cand);
        CandidaturaDemoRetirada instance = new CandidaturaDemoRetirada();
        candidatura.setEstadoCandidaturaDemo(new CandidaturaDemoCriada());
        boolean expResult = true;
        boolean result = instance.setCandidaturaDemoRetirada(candidatura);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaDemoEmInteresse method, of class
     * CandidaturaDemoEstado.
     */
    @Test
    public void testSetCandidaturaDemoEmInteresse() {
        System.out.println("setCandidaturaDemoEmInteresse");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaDemonstracao candidatura = new CandidaturaDemonstracao(cand);
        CandidaturaDemoEmInteresse instance = new CandidaturaDemoEmInteresse();
        candidatura.setEstadoCandidaturaDemo(new CandidaturaDemoCriada());
        boolean expResult = true;
        boolean result = instance.setCandidaturaDemoEmInteresse(candidatura);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaDemoAprovada method, of class
     * CandidaturaDemoEstado.
     */
    @Test
    public void testSetCandidaturaDemoAprovada() {
        System.out.println("setCandidaturaDemoAprovada");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaDemonstracao candidatura = new CandidaturaDemonstracao(cand);
        CandidaturaDemoAprovada instance = new CandidaturaDemoAprovada();
        candidatura.setEstadoCandidaturaDemo(new CandidaturaDemoEmInteresse());
        boolean expResult = true;
        boolean result = instance.setCandidaturaDemoAprovada(candidatura);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaDemoNaoAprovada method, of class
     * CandidaturaDemoEstado.
     */
    @Test
    public void testSetCandidaturaDemoNaoAprovada() {
        System.out.println("setCandidaturaDemoNaoAprovada");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaDemonstracao candidatura = new CandidaturaDemonstracao(cand);
        CandidaturaDemoNaoAprovada instance = new CandidaturaDemoNaoAprovada();
        candidatura.setEstadoCandidaturaDemo(new CandidaturaDemoEmInteresse());
        boolean expResult = true;
        boolean result = instance.setCandidaturaDemoNaoAprovada(candidatura);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaDemoSubmetida method, of class
     * CandidaturaDemoEstado.
     */
    @Test
    public void testSetCandidaturaDemoSubmetida() {
        System.out.println("setCandidaturaDemoSubmetida");
         Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaDemonstracao candidatura = new  CandidaturaDemonstracao(cand);
        CandidaturaDemoSubmetida instance = new CandidaturaDemoSubmetida();
        candidatura.setEstadoCandidaturaDemo(new CandidaturaDemoAprovada());
        boolean expResult = true;
        boolean result = instance.setCandidaturaDemoSubmetida(candidatura);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaDemoTerminada method, of class
     * CandidaturaDemoEstado.
     */
    @Test
    public void testSetCandidaturaDemoTerminada() {
        System.out.println("setCandidaturaDemoTerminada");
       Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaDemonstracao candidatura = new CandidaturaDemonstracao(cand);
        CandidaturaDemoTerminada instance = new CandidaturaDemoTerminada();
        candidatura.setEstadoCandidaturaDemo(new CandidaturaDemoSubmetida());
        boolean expResult = true;
        boolean result = instance.setCandidaturaDemoTerminada(candidatura);
        assertEquals(expResult, result);
    }

    public class CandidaturaDemoEstadoImpl extends CandidaturaDemoEstado {
    }

}
