/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Avaliacao;
import lapr.project.model.Candidatura;
import lapr.project.model.CentroExposicoes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diana Silva
 */
public class AvaliarCandidaturaControllerTest {
    
    private CentroExposicoes m_ce;
    
    public AvaliarCandidaturaControllerTest() {
      m_ce=new CentroExposicoes();
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
     * Test of setResposta method, of class AvaliarCandidaturaController.
     */
    @Test
    public void testSetResposta() {
        System.out.println("Teste setResposta");
        int resposta = 4;
        AvaliarCandidaturaController m_controller_teste = new AvaliarCandidaturaController(m_ce);
        
        Candidatura m_candidatura=new Candidatura();
        
        m_controller_teste.setCandidatura(m_candidatura);
        
        m_controller_teste.criarAvaliacao();
        
        m_controller_teste.criarQuestao();
        
        m_controller_teste.adicionarQuestao();
        
        m_controller_teste.setPergunta1();
        
        m_controller_teste.setResposta(resposta);
        
        assertEquals(m_controller_teste.getResposta(), resposta);
        
        
    }
    
}
