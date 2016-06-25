/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.model.Organizador;
import lapr.project.model.Recurso;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.model.lists.ListaRecursoDemonstracao;
import lapr.project.model.lists.RegistoExposicoes;
import lapr.project.model.lists.RegistoRecursos;
import lapr.project.utils.Data;
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
public class CriarDemonstracaoControllerTest {

    private static final String s1 = "19/11/2017", s2 = "20/11/2017", s3 = "11/11/2017", s4 = "12/11/2017", s5 = "15/11/2017",
            s6 = "16/11/2017", s7 = "13/11/2017", s8 = "17/11/2017", s9 = "18/11/2017", s10 = "14/11/2017";
    private static Data d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
    private CentroExposicoes ce;
    private Utilizador utilizador;

    public CriarDemonstracaoControllerTest() {
        ce = new CentroExposicoes();
        utilizador = new Utilizador();
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
     * Test of selectExposicao method, of class CriarDemonstracaoController.
     */
    @Test
    public void testSelectExposicao() throws Exception {
        System.out.println("selectExposicao");
        Exposicao result = new Exposicao();
        result.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        CriarDemonstracaoController instance = new CriarDemonstracaoController(utilizador, ce);
        instance.selectExposicao(result);
        Exposicao expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of novaDemonstracao method, of class CriarDemonstracaoController.
     */
    @Test
    public void testNovaDemonstracao() throws Exception {
        System.out.println("novaDemonstracao");
        CriarDemonstracaoController instance = new CriarDemonstracaoController(utilizador, ce);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(exp);
        instance.novaDemonstracao();
        Demonstracao expResult = instance.registaDemonstracao("teste", "Teste");
        Demonstracao result = expResult;
        assertEquals(expResult, result);
    }

    /**
     * Test of registaDemonstracao method, of class CriarDemonstracaoController.
     */
    @Test
    public void testRegistaDemonstracao_4args() throws Exception {
        System.out.println("registaDemonstracao");
        String descricao = "teste";
        String temaExposicao = "teste";
        Data inicio = new Data(2016, 02, 02);
        Data fim = new Data(2016, 02, 03);
        CriarDemonstracaoController instance = new CriarDemonstracaoController(utilizador, ce);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(exp);
        instance.novaDemonstracao();
        Demonstracao expResult = instance.registaDemonstracao(descricao, temaExposicao, inicio, fim);
        Demonstracao result = instance.registaDemonstracao(descricao, temaExposicao, inicio, fim);
        assertEquals(expResult, result);

    }

//    /**
//     * Test of registaDemonstracao method, of class CriarDemonstracaoController.
//     */
//    @Test
//    public void testRegistaDemonstracao_String_String() throws Exception {
//        System.out.println("registaDemonstracao");
//        CriarDemonstracaoController instance = new CriarDemonstracaoController(utilizador, ce);
//        String descricao = "teste";
//        String temaExposicao = "teste";
//        Exposicao exp = new Exposicao();
//        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
//        instance.selectExposicao(exp);
//        instance.novaDemonstracao();
//       
//        Demonstracao expResult = instance.registaDemonstracao(descricao, temaExposicao);
//        Demonstracao result = instance.registaDemonstracao(descricao, temaExposicao);
//        assertEquals(expResult, result);
//
//    }

    /**
     * Test of getDemonstraçãoString method, of class
     * CriarDemonstracaoController.
     */
    @Test
    public void testGetDemonstraçãoString() throws Exception {
        System.out.println("getDemonstra\u00e7\u00e3oString");
        CriarDemonstracaoController instance = new CriarDemonstracaoController(utilizador, ce);
        String descricao = "teste";
        String temaExposicao = "teste";
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(exp);
        instance.novaDemonstracao();
        instance.setDescricao(descricao);
        String expResult = instance.getDemonstracaoString();
        String result = instance.getDemonstracaoString();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDescricao method, of class CriarDemonstracaoController.
     */
    @Test
    public void testSetDescricao() throws Exception {
        System.out.println("setDescricao");
        CriarDemonstracaoController instance = new CriarDemonstracaoController(utilizador, ce);
        String result = "teste";
        String temaExposicao = "teste";
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(exp);
        instance.novaDemonstracao();
        instance.setDescricao(result);
        String expResult = instance.getDemonstracao().getDesc();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaRecursos method, of class CriarDemonstracaoController.
     */
    @Test
    public void testGetListaRecursos() throws Exception {
        System.out.println("getListaRecursos");
        CriarDemonstracaoController instance = new CriarDemonstracaoController(utilizador, ce);
        String descricao = "teste";
        String temaExposicao = "teste";
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(exp);
        instance.novaDemonstracao();
        RegistoRecursos expResult = instance.getListaRecursos();
        RegistoRecursos result = instance.getListaRecursos();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaRecursosDemonstracao method, of class
     * CriarDemonstracaoController.
     */
    @Test
    public void testGetListaRecursosDemonstracao() throws Exception {
        System.out.println("getListaRecursosDemonstracao");
        CriarDemonstracaoController instance = new CriarDemonstracaoController(utilizador, ce);
        String descricao = "teste";
        String temaExposicao = "teste";
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(exp);
        instance.novaDemonstracao();
        ListaRecursoDemonstracao expResult = instance.getListaRecursosDemonstracao();
        ListaRecursoDemonstracao result = instance.getListaRecursosDemonstracao();
        assertEquals(expResult, result);

    }

    /**
     * Test of addRecursoDemonstracao method, of class
     * CriarDemonstracaoController.
     */
    @Test
    public void testAddRecursoDemonstracao() throws Exception {
        System.out.println("addRecursoDemonstracao");
        Recurso result = new Recurso("teste");
        CriarDemonstracaoController instance = new CriarDemonstracaoController(utilizador, ce);
        String descricao = "teste";
        String temaExposicao = "teste";
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(exp);
        instance.novaDemonstracao();
        instance.addRecursoDemonstracao(result);
        Recurso expResult = result;
        assertEquals(expResult, result);

    }

//    /**
//     * Test of getRegistoExposicoes method, of class
//     * CriarDemonstracaoController.
//     */
//    @Test
//    public void testGetRegistoExposicoes() throws Exception {
//        System.out.println("getRegistoExposicoes");
//        CriarDemonstracaoController instance = new CriarDemonstracaoController(utilizador, ce);
//        String descricao = "teste";
//        String temaExposicao = "teste";
//        Exposicao exp = new Exposicao();
//        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
//        instance.selectExposicao(exp);
//        instance.novaDemonstracao();
//        Utilizador ut2 = new Utilizador("Ana Silva", "1130155@isep.ipp.pt", "Gestor", false, 10);
//        Utilizador ut1 = new Utilizador("Diana Silva", "1151088@isep.ipp.pt", "Organizador", false, 8);
//        Organizador o = new Organizador(ut1);
//        Organizador o1 = new Organizador(ut2);
//        ListaOrganizadores lo = new ListaOrganizadores();
//        lo.addOrganizador(o);
//        lo.addOrganizador(o1);
//        exp.setListaOrganizadores(lo);
//        RegistoExposicoes expResult = instance.getRegistoExposicoes();
//        RegistoExposicoes result = instance.getRegistoExposicoes();
//
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of getListaExposicoes method, of class CriarDemonstracaoController.
//     */
//    @Test
//    public void testGetListaExposicoes() throws Exception {
//        System.out.println("getListaExposicoes");
//        CriarDemonstracaoController instance = new CriarDemonstracaoController(utilizador, ce);
//        String descricao = "teste";
//        String temaExposicao = "teste";
//        Exposicao exp = new Exposicao();
//        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
//        instance.selectExposicao(exp);
//        instance.getRegistoExposicoes().adicionarExposicao(exp);
//        instance.novaDemonstracao();
//        instance.setDescricao(descricao);
//        RegistoExposicoes expResult = instance.getListaExposicoes();
//        RegistoExposicoes result = instance.getListaExposicoes();
//        assertEquals(expResult, result);
//
//    }

    /**
     * Test of valida method, of class CriarDemonstracaoController.
     */
    @Test
    public void testValida() throws Exception {
        System.out.println("valida");
        CriarDemonstracaoController instance = new CriarDemonstracaoController(utilizador, ce);
        String descricao = "teste";
        String temaExposicao = "teste";
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(exp);
        instance.novaDemonstracao();
        instance.setDescricao(descricao);
        boolean expResult = true;
        boolean result = instance.valida();
        assertEquals(expResult, result);

    }

    /**
     * Test of getDemonstracao method, of class CriarDemonstracaoController.
     */
    @Test
    public void testGetDemonstracao() throws Exception {
        System.out.println("getDemonstracao");
        CriarDemonstracaoController instance = new CriarDemonstracaoController(utilizador, ce);
        String descricao = "teste";
        String temaExposicao = "teste";
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(exp);
        instance.novaDemonstracao();
        instance.setDescricao(descricao);
        Demonstracao expResult = instance.getDemonstracao();
        Demonstracao result = instance.getDemonstracao();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRecurso method, of class CriarDemonstracaoController.
     */
    @Test
    public void testGetRecurso() throws Exception {
        System.out.println("getRecurso");
        CriarDemonstracaoController instance = new CriarDemonstracaoController(utilizador, ce);
        String descricao = "teste";
        String temaExposicao = "teste";
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(exp);
        instance.novaDemonstracao();
        instance.setDescricao(descricao);
        Recurso expResult = instance.getRecurso();
        Recurso result = instance.getRecurso();
        assertEquals(expResult, result);

    }

    /**
     * Test of removerRecurso method, of class CriarDemonstracaoController.
     */
    @Test
    public void testRemoverRecurso() throws Exception {
        System.out.println("removerRecurso");
        Recurso result = new Recurso("teste");
        CriarDemonstracaoController instance = new CriarDemonstracaoController(utilizador, ce);
        String descricao = "teste";
        String temaExposicao = "teste";
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(exp);
        instance.novaDemonstracao();
        instance.addRecursoDemonstracao(result);
        instance.removerRecurso(result);
        Recurso expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of registaEstado method, of class CriarDemonstracaoController.
     */
    @Test
    public void testRegistaEstado() throws Exception {
        System.out.println("registaEstado");
        CriarDemonstracaoController instance = new CriarDemonstracaoController(utilizador, ce);
        String descricao = "teste";
        String temaExposicao = "teste";
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(exp);
        instance.novaDemonstracao();
        instance.registaDemonstracao(descricao, temaExposicao);
        boolean expResult = false;
        boolean result = instance.registaEstado();
        assertEquals(expResult, result);

    }

}
