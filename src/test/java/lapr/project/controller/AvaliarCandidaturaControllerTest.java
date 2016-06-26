/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Atribuicao;
import lapr.project.model.Candidatura;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaAvaliacoes;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.RegistoExposicoes;
import lapr.project.utils.Data;
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

    private static final String s1 = "19/11/2017", s2 = "20/11/2017", s3 = "11/11/2017", s4 = "12/11/2017", s5 = "15/11/2017",
            s6 = "16/11/2017", s7 = "13/11/2017", s8 = "17/11/2017", s9 = "18/11/2017", s10 = "14/11/2017";
    private static Data d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
    Utilizador user = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", "admin", true, 15);
    private CentroExposicoes m_ce;

    public AvaliarCandidaturaControllerTest() {
        m_ce = new CentroExposicoes();
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
        AvaliarCandidaturaController m_controller_teste = new AvaliarCandidaturaController(m_ce,user);

        Candidatura m_candidatura = new Candidatura();

        m_controller_teste.setCandidatura(m_candidatura);

        m_controller_teste.criarAvaliacao();

        m_controller_teste.criarQuestao();

        m_controller_teste.adicionarQuestao();

        m_controller_teste.setPergunta1();

        m_controller_teste.setResposta(resposta);

        assertEquals(m_controller_teste.getResposta(), resposta);

    }

    /**
     * Test of getExposicoesAtribuidasFAE method, of class
     * AvaliarCandidaturaController.
     */
    @Test
    public void testGetExposicoesAtribuidasFAE() throws Exception {
        System.out.println("getExposicoesAtribuidasFAE");
        AvaliarCandidaturaController instance = new AvaliarCandidaturaController(m_ce,user);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        instance.getExposicoesAtribuidasFAE().adicionarExposicao(exp);
        RegistoExposicoes result = instance.getExposicoesAtribuidasFAE();
        RegistoExposicoes expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaCandidaturas method, of class
     * AvaliarCandidaturaController.
     */
    @Test
    public void testGetListaCandidaturas() throws Exception {
        System.out.println("getListaCandidaturas");
        AvaliarCandidaturaController instance = new AvaliarCandidaturaController(m_ce,user);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        
        ListaFAE lista=exp.getListaFAE();
        FAE f=new FAE(user);
        exp.getListaFAE().addFAE(f);
        
        Candidatura c=new Candidatura();
        Atribuicao a=new Atribuicao(f,c);
        
        exp.getListaAtribuicoes().adicionarAtribuicao(a);
        
        instance.selectExposicao(exp);
        
        RegistoExposicoes expResult = instance.getExposicoesAtribuidasFAE();
        RegistoExposicoes result = instance.getExposicoesAtribuidasFAE();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaCandidaturaAvaliacoes method, of class
     * AvaliarCandidaturaController.
     */
    @Test
    public void testGetListaCandidaturaAvaliacoes() throws Exception {
        System.out.println("getListaCandidaturaAvaliacoes");
        AvaliarCandidaturaController instance = new AvaliarCandidaturaController(m_ce,user);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        instance.selectExposicao(exp);
        instance.criarAvaliacao();
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        instance.setCandidatura(cand);
        ListaAvaliacoes expResult = instance.getListaCandidaturaAvaliacoes();
        ListaAvaliacoes result = instance.getListaCandidaturaAvaliacoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of getResposta method, of class AvaliarCandidaturaController.
     */
    @Test
    public void testGetResposta() throws Exception {
        System.out.println("getResposta");
        AvaliarCandidaturaController instance = new AvaliarCandidaturaController(m_ce,user);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        instance.selectExposicao(exp);
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        instance.criarAvaliacao();
        instance.criarQuestao();
        int expResult = 0;
        instance.setResposta(expResult);
        int result = instance.getResposta();
        assertEquals(expResult, result);

    }

    /**
     * Test of getPergunta method, of class AvaliarCandidaturaController.
     */
    @Test
    public void testGetPergunta() throws Exception {
        System.out.println("getPergunta");
        AvaliarCandidaturaController instance = new AvaliarCandidaturaController(m_ce,user);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        instance.selectExposicao(exp);
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        instance.criarAvaliacao();
        instance.criarQuestao();
        String expResult = "Conhecimento do FAE sobre o tema da exposição:";
        instance.setPergunta1();
        String result = instance.getPergunta();
        assertEquals(expResult, result);

    }

    /**
     * Test of registarDecisao method, of class AvaliarCandidaturaController.
     */
    @Test
    public void testRegistarDecisao() throws Exception {
        System.out.println("registarDecisao");
        AvaliarCandidaturaController instance = new AvaliarCandidaturaController(m_ce,user);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        instance.selectExposicao(exp);
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        instance.criarAvaliacao();
        boolean expResult = true;
        instance.setCandidatura(cand);
        boolean result = instance.registarDecisao();
        assertEquals(expResult, result);

    }

    /**
     * Test of getInfoResumo method, of class AvaliarCandidaturaController.
     */
    @Test
    public void testGetInfoResumo() throws Exception {
        System.out.println("getInfoResumo");
        AvaliarCandidaturaController instance = new AvaliarCandidaturaController(m_ce, user);
        instance.criarAvaliacao();
        instance.criarQuestao();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        instance.selectExposicao(exp);
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        instance.setCandidatura(cand);
        String expResult = instance.getInfoResumo();
        String result = instance.getInfoResumo();
        assertEquals(expResult, result);

    }

    /**
     * Test of getInfoAvaliacao method, of class AvaliarCandidaturaController.
     */
    @Test
    public void testGetInfoAvaliacao() throws Exception {
        System.out.println("getInfoAvaliacao");
        AvaliarCandidaturaController instance = new AvaliarCandidaturaController(m_ce, user);
        instance.criarAvaliacao();
        instance.criarQuestao();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        instance.selectExposicao(exp);
        Candidatura cand = new Candidatura("teste", "teste", 123456780, 850, 850);
        instance.setCandidatura(cand);
        String expResult = instance.getInfoAvaliacao();
        String result = instance.getInfoAvaliacao();
        assertEquals(expResult, result);

    }

}
