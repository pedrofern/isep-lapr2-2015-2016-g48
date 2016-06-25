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
public class CandidaturaDemoSubmetidaTest {
    
    public CandidaturaDemoSubmetidaTest() {
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
     * Test of valida method, of class CandidaturaDemoSubmetida.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaDemonstracao candidatura = new  CandidaturaDemonstracao(cand);
        CandidaturaDemoSubmetida instance = new CandidaturaDemoSubmetida();
        candidatura.setEstadoCandidaturaDemo(new CandidaturaDemoAprovada());
        boolean expResult = true;
        boolean result = instance.valida(candidatura);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaDemoSubmetida method, of class CandidaturaDemoSubmetida.
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
    
}
