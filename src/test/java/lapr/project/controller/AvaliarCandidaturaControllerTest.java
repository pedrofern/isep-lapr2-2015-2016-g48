/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

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
        
        assertEquals(m_controller_teste.getResposta(), 4);
        
        
    }

//
//    /**
//     * Test of setAvaliacao method, of class AvaliarCandidaturaController.
//     */
//    @Test
//    public void testSetAvaliacao() {
//        System.out.println("setAvaliacao");
//        String strResposta = "";
//        String strJustificacao = "";
//        AvaliarCandidaturaController instance = null;
//        Avaliacao expResult = null;
//        Avaliacao result = instance.setAvaliacao(strResposta, strJustificacao);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPergunta method, of class AvaliarCandidaturaController.
//     */
//    @Test
//    public void testGetPergunta() {
//        System.out.println("getPergunta");
//        AvaliarCandidaturaController instance = null;
//        String expResult = "";
//        String result = instance.getPergunta();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of registarDecisao method, of class AvaliarCandidaturaController.
//     */
//    @Test
//    public void testRegistarDecisao() {
//        System.out.println("registarDecisao");
//        AvaliarCandidaturaController instance = null;
//        boolean expResult = false;
//        boolean result = instance.registarDecisao();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectExposicao method, of class AvaliarCandidaturaController.
//     */
//    @Test
//    public void testSelectExposicao() {
//        System.out.println("selectExposicao");
//        Exposicao e = null;
//        AvaliarCandidaturaController instance = null;
//        instance.selectExposicao(e);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getInfoResumo method, of class AvaliarCandidaturaController.
//     */
//    @Test
//    public void testGetInfoResumo() {
//        System.out.println("getInfoResumo");
//        AvaliarCandidaturaController instance = null;
//        String expResult = "";
//        String result = instance.getInfoResumo();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
    
//    /**
//     * Test of getRegistoExposicoes method, of class AvaliarCandidaturaController.
//     */
//    @Test
//    public void testGetRegistoExposicoes() {
//        System.out.println("getRegistoExposicoes");
//        AvaliarCandidaturaController instance = null;
//        RegistoExposicoes expResult = null;
//        RegistoExposicoes result = instance.getRegistoExposicoes();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getListaCandidaturas method, of class AvaliarCandidaturaController.
//     */
//    @Test
//    public void testGetListaCandidaturas() {
//        System.out.println("getListaCandidaturas");
//        AvaliarCandidaturaController instance = null;
//        ListaCandidaturas expResult = null;
//        ListaCandidaturas result = instance.getListaCandidaturas();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getListaCandidaturaAvaliacoes method, of class AvaliarCandidaturaController.
//     */
//    @Test
//    public void testGetListaCandidaturaAvaliacoes() {
//        System.out.println("getListaCandidaturaAvaliacoes");
//        AvaliarCandidaturaController instance = null;
//        ListaAvaliacoes expResult = null;
//        ListaAvaliacoes result = instance.getListaCandidaturaAvaliacoes();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of adicionarAvaliacao method, of class AvaliarCandidaturaController.
//     */
//    @Test
//    public void testAdicionarAvaliacao() {
//        System.out.println("adicionarAvaliacao");
//        AvaliarCandidaturaController instance = null;
//        instance.adicionarAvaliacao();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of criarAvaliacao method, of class AvaliarCandidaturaController.
//     */
//    @Test
//    public void testCriarAvaliacao() {
//        System.out.println("criarAvaliacao");
//        AvaliarCandidaturaController instance = null;
//        instance.criarAvaliacao();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setCandidatura method, of class AvaliarCandidaturaController.
//     */
//    @Test
//    public void testSetCandidatura() {
//        System.out.println("setCandidatura");
//        Candidatura c = null;
//        AvaliarCandidaturaController instance = null;
//        instance.setCandidatura(c);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of adicionarQuestao method, of class AvaliarCandidaturaController.
//     */
//    @Test
//    public void testAdicionarQuestao() {
//        System.out.println("adicionarQuestao");
//        AvaliarCandidaturaController instance = null;
//        instance.adicionarQuestao();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of criarQuestao method, of class AvaliarCandidaturaController.
//     */
//    @Test
//    public void testCriarQuestao() {
//        System.out.println("criarQuestao");
//        AvaliarCandidaturaController instance = null;
//        instance.criarQuestao();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPergunta1 method, of class AvaliarCandidaturaController.
//     */
//    @Test
//    public void testSetPergunta1() {
//        System.out.println("setPergunta1");
//        AvaliarCandidaturaController instance = null;
//        instance.setPergunta1();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPergunta2 method, of class AvaliarCandidaturaController.
//     */
//    @Test
//    public void testSetPergunta2() {
//        System.out.println("setPergunta2");
//        AvaliarCandidaturaController instance = null;
//        instance.setPergunta2();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPergunta3 method, of class AvaliarCandidaturaController.
//     */
//    @Test
//    public void testSetPergunta3() {
//        System.out.println("setPergunta3");
//        AvaliarCandidaturaController instance = null;
//        instance.setPergunta3();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPergunta4 method, of class AvaliarCandidaturaController.
//     */
//    @Test
//    public void testSetPergunta4() {
//        System.out.println("setPergunta4");
//        AvaliarCandidaturaController instance = null;
//        instance.setPergunta4();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPergunta5 method, of class AvaliarCandidaturaController.
//     */
//    @Test
//    public void testSetPergunta5() {
//        System.out.println("setPergunta5");
//        AvaliarCandidaturaController instance = null;
//        instance.setPergunta5();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
