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
public class CandidaturaCriadaTest {

    public CandidaturaCriadaTest() {
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
     * Test of valida method, of class CandidaturaCriada.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaCriada instance = new CandidaturaCriada();
        instance.setCandidaturaCriada(cand);
        boolean expResult =false;
        boolean result = instance.valida(cand);
        assertEquals(expResult, result);

    }

    /**
     * Test of setCandidaturaCriada method, of class CandidaturaCriada.
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

}
