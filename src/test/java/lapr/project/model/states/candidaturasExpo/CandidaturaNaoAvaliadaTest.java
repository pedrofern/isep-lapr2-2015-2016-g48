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
public class CandidaturaNaoAvaliadaTest {
    
    public CandidaturaNaoAvaliadaTest() {
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
     * Test of valida method, of class CandidaturaNaoAvaliada.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaNaoAvaliada instance = new CandidaturaNaoAvaliada();
        cand.setEstadoCandidatura(new CandidaturaEmAvaliacao());
        boolean expResult = true;
        boolean result = instance.valida(cand);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setCandidaturaNaoAvaliada method, of class CandidaturaNaoAvaliada.
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
    
}
