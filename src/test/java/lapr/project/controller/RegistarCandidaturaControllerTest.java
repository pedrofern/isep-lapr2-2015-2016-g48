/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Candidatura;
import lapr.project.model.CandidaturaDemonstracao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.model.Keyword;
import lapr.project.model.Produto;
import lapr.project.model.Representante;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.ListaKeywords;
import lapr.project.model.lists.ListaProduto;
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
 * @author Edu
 */
public class RegistarCandidaturaControllerTest {

    private static final String s1 = "19/11/2017", s2 = "20/11/2017", s3 = "11/11/2017", s4 = "12/11/2017", s5 = "15/11/2017",
            s6 = "16/11/2017", s7 = "13/11/2017", s8 = "17/11/2017", s9 = "18/11/2017", s10 = "14/11/2017";
    private static Data d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
    private CentroExposicoes ce;
    private Utilizador utilizador;
    private RegistoExposicoes registo;

    public RegistarCandidaturaControllerTest() {
        ce = new CentroExposicoes();
        utilizador = new Utilizador();
        registo = new RegistoExposicoes();
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
     * Test of getCandidaturaString method, of class
     * RegistarCandidaturaController.
     */
    @Test
    public void testGetCandidaturaString() throws Exception {
        System.out.println("getCandidaturaString");
        RegistarCandidaturaController instance = new RegistarCandidaturaController(ce, utilizador);
        String nomeEmpresa = "Empresa";
        String morada = "Morada";
        int telemovel = 123456780;
        int areaExposicao = 80;
        int quantidadeConvites = 80;
        ListaProduto listaProdutos = new ListaProduto();
        listaProdutos.adicionarProduto(new Produto("Produto"));
        ListaKeywords listaKeywords = new ListaKeywords();
        listaKeywords.adicionarKeyword(new Keyword("Palavra-chave"));
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        instance.novaCandidatura();
        instance.setAreaExposicao(areaExposicao);
        instance.setNomeEmpresa(nomeEmpresa);
        instance.setMorada(morada);
        instance.setTelemovel(telemovel);
        instance.setKeywords(listaKeywords);
        instance.setRepresentante(new Utilizador("Nome", "Admi", "Ad", "email"));
        String expResult = instance.getCandidaturaString();
        String result = instance.getCandidaturaString();
        assertEquals(expResult, result);

    }

    /**
     * Test of getExposicoes method, of class RegistarCandidaturaController.
     */
    @Test
    public void testGetExposicoes() {
        System.out.println("getExposicoes");
        RegistarCandidaturaController instance = new RegistarCandidaturaController(ce, utilizador);
        RegistoExposicoes expResult = instance.getExposicoes();
        RegistoExposicoes result = instance.getExposicoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaDemonstracoes method, of class
     * RegistarCandidaturaController.
     */
    @Test
    public void testGetListaDemonstracoes() throws Exception {
        System.out.println("getListaDemonstracoes");
        RegistarCandidaturaController instance = new RegistarCandidaturaController(new CentroExposicoes(), new Utilizador());
        String nomeEmpresa = "Empresa";
        String morada = "Morada";
        int telemovel = 123456780;
        int areaExposicao = 80;
        int quantidadeConvites = 80;
        ListaProduto listaProdutos = new ListaProduto();
        listaProdutos.adicionarProduto(new Produto("Produto"));
        ListaKeywords listaKeywords = new ListaKeywords();
        listaKeywords.adicionarKeyword(new Keyword("Palavra-chave"));
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        instance.novaCandidatura();
        ListaDemonstracoes expResult = instance.getListaDemonstracoes();
        Demonstracao d = new Demonstracao();
        d.setDados("Descrição", "tema");
        expResult.adicionarDemonstracao(d);
        ListaDemonstracoes result = instance.getListaDemonstracoes();
        result.adicionarDemonstracao(d);
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaProdutos method, of class RegistarCandidaturaController.
     */
    @Test
    public void testGetListaProdutos() {
        System.out.println("getListaProdutos");
        RegistarCandidaturaController instance = new RegistarCandidaturaController(ce, utilizador);
        ListaProduto expResult = instance.getListaProdutos();
        ListaProduto result = instance.getListaProdutos();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaKeywords method, of class RegistarCandidaturaController.
     */
    @Test
    public void testGetListaKeywords() throws Exception {
        System.out.println("getListaKeywords");
        String nomeEmpresa = "Empresa";
        String morada = "Morada";
        int telemovel = 123456780;
        int areaExposicao = 80;
        int quantidadeConvites = 80;
        ListaProduto listaProdutos = new ListaProduto();
        listaProdutos.adicionarProduto(new Produto("Produto"));
        RegistarCandidaturaController instance = new RegistarCandidaturaController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        instance.novaCandidatura();
        ListaKeywords expResult = instance.getListaKeywords();
        expResult.adicionarKeyword(new Keyword("Palavra-chave"));
        ListaKeywords result = instance.getListaKeywords();
        result.adicionarKeyword(new Keyword("Palavra-chave"));
        assertEquals(expResult, result);

    }

    /**
     * Test of getSelectedDemonstacao method, of class
     * RegistarCandidaturaController.
     */
    @Test
    public void testGetSelectedDemonstacao() {
        System.out.println("getSelectedDemonstacao");
        RegistarCandidaturaController instance = new RegistarCandidaturaController(ce, utilizador);
        ListaDemonstracoes expResult = instance.getSelectedDemonstacao();
        ListaDemonstracoes result = instance.getSelectedDemonstacao();
        assertEquals(expResult, result);

    }

    /**
     * Test of setNomeEmpresa method, of class RegistarCandidaturaController.
     */
    @Test
    public void testSetNomeEmpresa() throws Exception {
        System.out.println("setNomeEmpresa");
        String result = "Empresa";
        String nomeEmpresa = "Empresa";
        String morada = "Morada";
        int telemovel = 123456780;
        int areaExposicao = 80;
        int quantidadeConvites = 80;
        ListaProduto listaProdutos = new ListaProduto();
        listaProdutos.adicionarProduto(new Produto("Produto"));
        RegistarCandidaturaController instance = new RegistarCandidaturaController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        instance.novaCandidatura();
        instance.setNomeEmpresa(result);
        String expResult = instance.getCandidatura().getNomeEmpresa();
        assertEquals(expResult, result);

    }

    /**
     * Test of setMorada method, of class RegistarCandidaturaController.
     */
    @Test
    public void testSetMorada() throws Exception {
        System.out.println("setMorada");
        String result = "Morada";
        String nomeEmpresa = "Empresa";
        String morada = "Morada";
        int telemovel = 123456780;
        int areaExposicao = 80;
        int quantidadeConvites = 80;
        ListaProduto listaProdutos = new ListaProduto();
        listaProdutos.adicionarProduto(new Produto("Produto"));
        RegistarCandidaturaController instance = new RegistarCandidaturaController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        instance.novaCandidatura();
        instance.setMorada(result);
        String expResutl = instance.getCandidatura().getMorada();
        assertEquals(expResutl, result);

    }

    /**
     * Test of setTelemovel method, of class RegistarCandidaturaController.
     */
    @Test
    public void testSetTelemovel() throws Exception {
        System.out.println("setTelemovel");
        String nomeEmpresa = "Empresa";
        String morada = "Morada";
        int result = 123456780;
        int areaExposicao = 80;
        int quantidadeConvites = 80;
        ListaProduto listaProdutos = new ListaProduto();
        listaProdutos.adicionarProduto(new Produto("Produto"));
        RegistarCandidaturaController instance = new RegistarCandidaturaController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        instance.novaCandidatura();
        instance.setTelemovel(result);
        int expResult = instance.getCandidatura().getTelemovel();
        assertEquals(expResult, result);

    }

    /**
     * Test of setAreaExposicao method, of class RegistarCandidaturaController.
     */
    @Test
    public void testSetAreaExposicao() throws Exception {
        System.out.println("setAreaExposicao");
        String nomeEmpresa = "Empresa";
        String morada = "Morada";
        int telemovel = 123456780;
        int result = 80;
        int quantidadeConvites = 80;
        ListaProduto listaProdutos = new ListaProduto();
        listaProdutos.adicionarProduto(new Produto("Produto"));
        RegistarCandidaturaController instance = new RegistarCandidaturaController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        instance.novaCandidatura();
        instance.setAreaExposicao(result);
        int expResult = instance.getCandidatura().getAreaExposicao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuantidadeConvites method, of class
     * RegistarCandidaturaController.
     */
    @Test
    public void testSetQuantidadeConvites() throws Exception {
        System.out.println("setQuantidadeConvites");
        String nomeEmpresa = "Empresa";
        String morada = "Morada";
        int telemovel = 123456780;
        int areaExposicao = 80;
        int result = 80;
        ListaProduto listaProdutos = new ListaProduto();
        listaProdutos.adicionarProduto(new Produto("Produto"));
        RegistarCandidaturaController instance = new RegistarCandidaturaController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        instance.novaCandidatura();
        instance.setQuantidadeConvites(result);
        int expResult = instance.getCandidatura().getQuantidadeConvites();
        assertEquals(expResult, result);
    }

  

    /**
     * Test of setRepresentante method, of class RegistarCandidaturaController.
     */
    @Test
    public void testSetRepresentante() throws Exception {
        System.out.println("setRepresentante");
        String nomeEmpresa = "Empresa";
        String morada = "Morada";
        int telemovel = 123456780;
        int areaExposicao = 80;
        int quantidadeConvites = 80;
        ListaProduto listaProdutos = new ListaProduto();
        listaProdutos.adicionarProduto(new Produto("Produto"));
        ListaKeywords lista = new ListaKeywords();
        lista.adicionarKeyword(new Keyword("Palavra-chave"));
        RegistarCandidaturaController instance = new RegistarCandidaturaController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        instance.novaCandidatura();
        Utilizador result = new Utilizador("Nome", "Admin", "Ad", "Email");
        instance.setRepresentante(result);
        Utilizador expResutl = instance.getCandidatura().getRepresentante().getRepresentante();
        assertEquals(expResutl, result);
    }

  

    /**
     * Test of valida method, of class RegistarCandidaturaController.
     */
    @Test
    public void testValida() throws Exception {
        System.out.println("valida");
        String nomeEmpresa = "Empresa";
        String morada = "Morada";
        int telemovel = 123456780;
        int areaExposicao = 80;
        int quantidadeConvites = 80;
        ListaProduto listaProdutos = new ListaProduto();
        listaProdutos.adicionarProduto(new Produto("Produto"));
        ListaKeywords listaKeywords = new ListaKeywords();
        listaKeywords.adicionarKeyword(new Keyword("Palavra-chave"));
        RegistarCandidaturaController instance = new RegistarCandidaturaController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        instance.novaCandidatura();
        Candidatura cand = instance.registaCandidatura(nomeEmpresa, morada, telemovel, areaExposicao, quantidadeConvites, listaProdutos, listaKeywords);
        boolean expResult = false;
        boolean result = instance.valida();
        assertEquals(expResult, result);

    }

    /**
     * Test of addProduto method, of class RegistarCandidaturaController.
     */
    @Test
    public void testAddProduto() throws Exception {
        System.out.println("addProduto");
        Produto nomeProduto = new Produto("Produto");
        RegistarCandidaturaController instance = new RegistarCandidaturaController(ce, utilizador);
        String nomeEmpresa = "Empresa";
        String morada = "Morada";
        int telemovel = 123456780;
        int areaExposicao = 80;
        int quantidadeConvites = 80;
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        instance.novaCandidatura();
        instance.getListaProdutos();
        boolean expResult = true;
        boolean result = instance.addProduto(nomeProduto);
        assertEquals(expResult, result);

    }

    /**
     * Test of addKeyword method, of class RegistarCandidaturaController.
     */
    @Test
    public void testAddKeyword() throws Exception {
        System.out.println("addKeyword");
        Keyword keyword = new Keyword("Palavra-Chave");
        String nomeEmpresa = "Empresa";
        String morada = "Morada";
        int telemovel = 123456780;
        int areaExposicao = 80;
        int quantidadeConvites = 80;
        ListaProduto listaProdutos = new ListaProduto();
        listaProdutos.adicionarProduto(new Produto("Produto"));
        RegistarCandidaturaController instance = new RegistarCandidaturaController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        instance.novaCandidatura();
        ListaKeywords listaKeywords = instance.getListaKeywords();
        boolean expResult = true;
        boolean result = instance.addKeyword(keyword);
        assertEquals(expResult, result);

    }

    /**
     * Test of getCandidatura method, of class RegistarCandidaturaController.
     */
    @Test
    public void testGetCandidatura() throws Exception {
        System.out.println("getCandidatura");
        String nomeEmpresa = "Empresa";
        String morada = "Morada";
        int telemovel = 123456780;
        int areaExposicao = 80;
        int quantidadeConvites = 80;
        ListaProduto listaProdutos = new ListaProduto();
        listaProdutos.adicionarProduto(new Produto("Produto"));
        ListaKeywords listaKeywords = new ListaKeywords();
        listaKeywords.adicionarKeyword(new Keyword("Palavra-chave"));
        RegistarCandidaturaController instance = new RegistarCandidaturaController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        instance.novaCandidatura();
        Candidatura expResult = instance.getCandidatura();
        Candidatura result = instance.getCandidatura();
        assertEquals(expResult, result);

    }



}
