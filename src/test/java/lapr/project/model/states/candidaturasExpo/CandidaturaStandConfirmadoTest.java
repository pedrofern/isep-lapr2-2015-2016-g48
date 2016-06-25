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
public class CandidaturaStandConfirmadoTest {

    public CandidaturaStandConfirmadoTest() {
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
     * Test of valida method, of class CandidaturaStandConfirmado.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaStandConfirmado instance = new CandidaturaStandConfirmado();
        cand.setEstadoCandidatura(new CandidaturaStandAtribuido());
        boolean expResult = true;
        boolean result = instance.valida(cand);
        assertEquals(expResult, result);

    }

    /**
     * Test of setCandidaturaStandConfirmado method, of class
     * CandidaturaStandConfirmado.
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

}
