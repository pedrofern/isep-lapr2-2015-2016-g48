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
public class CandidaturaEmAtribuicaoTest {
    
    public CandidaturaEmAtribuicaoTest() {
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
     * Test of valida method, of class CandidaturaEmAtribuicao.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
       Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        CandidaturaEmAtribuicao instance = new CandidaturaEmAtribuicao();
        cand.setEstadoCandidatura(new CandidaturaEmSubmissao());
        boolean expResult = true;
        boolean result = instance.valida(cand);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidaturaEmAtribuicao method, of class CandidaturaEmAtribuicao.
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
    
}
