/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.List;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.model.Organizador;
import lapr.project.model.Utilizador;
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
public class RegistoExposicoesTest {

    private static final String s1 = "19/11/2017", s2 = "20/11/2017", s3 = "11/11/2017", s4 = "12/11/2017", s5 = "15/11/2017",
            s6 = "16/11/2017", s7 = "13/11/2017", s8 = "17/11/2017", s9 = "18/11/2017", s10 = "14/11/2017";
    private static Data d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
    Utilizador user = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin","admin", true, 15);

    public RegistoExposicoesTest() {
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
     * Test of novaExposicao method, of class RegistoExposicoes.
     */
    @Test
    public void testNovaExposicao() throws Exception {
        System.out.println("novaExposicao");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao expResult = instance.novaExposicao();
        expResult.setDadosPrincipais("teste", "teste", d1, d2, "teste", d3, d4);
        Exposicao result = instance.novaExposicao();
        result.setDadosPrincipais("teste", "teste", d1, d2, "teste", d3, d4);
        assertEquals(expResult, result);

    }

    /**
     * Test of adicionarExposicao method, of class RegistoExposicoes.
     */
    @Test
    public void testAdicionarExposicao() throws Exception {
        System.out.println("adicionarExposicao");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = instance.novaExposicao();
        exp.setDadosPrincipais("teste", "teste", d1, d2, "teste", d3, d4);
        boolean expResult = true;
        boolean result = instance.adicionarExposicao(exp);
        assertEquals(expResult, result);

    }

    /**
     * Test of registaExposicao method, of class RegistoExposicoes.
     */
    @Test
    public void testRegistaExposicao() throws Exception {
        System.out.println("registaExposicao");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = instance.novaExposicao();
        exp.setDadosPrincipais("teste", "teste", d1, d2, "teste", d3, d4);
        instance.adicionarExposicao(exp);
        boolean expResult = false;
        boolean result = instance.registaExposicao(exp);
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class RegistoExposicoes.
     */
    @Test
    public void testToString() throws Exception {
        System.out.println("toString");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = instance.novaExposicao();
        exp.setDadosPrincipais("teste", "teste", d1, d2, "teste", d3, d4);
        instance.adicionarExposicao(exp);
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of getExposicoes method, of class RegistoExposicoes.
     */
    @Test
    public void testGetExposicoes() {
        System.out.println("getExposicoes");
        RegistoExposicoes instance = new RegistoExposicoes();
        List<Exposicao> expResult = instance.getExposicoes();
        List<Exposicao> result = instance.getExposicoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of getArray method, of class RegistoExposicoes.
     */
    @Test
    public void testGetArray() throws Exception {
        System.out.println("getArray");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = instance.novaExposicao();
        exp.setDadosPrincipais("teste", "teste", d1, d2, "teste", d3, d4);
        Exposicao[] expResult = instance.getExposicoes().toArray(new Exposicao[instance.getExposicoes().size()]);
        Exposicao[] result = instance.getArray();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of countExposicoes method, of class RegistoExposicoes.
     */
    @Test
    public void testCountExposicoes() throws Exception {
        System.out.println("countExposicoes");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = instance.novaExposicao();
        exp.setDadosPrincipais("teste", "teste", d1, d2, "teste", d3, d4);
        instance.adicionarExposicao(exp);
        int expResult = 1;
        int result = instance.countExposicoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of getExposicao method, of class RegistoExposicoes.
     */
    @Test
    public void testGetExposicao_String() throws Exception {
        System.out.println("getExposicao");
        String titulo = "teste";
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = instance.novaExposicao();
        exp.setDadosPrincipais("teste", "teste", d1, d2, "teste", d3, d4);
        instance.adicionarExposicao(exp);
        Exposicao expResult = instance.getExposicao(titulo);
        Exposicao result = instance.getExposicao(titulo);
        assertEquals(expResult, result);

    }

    /**
     * Test of getExposicao method, of class RegistoExposicoes.
     */
    @Test
    public void testGetExposicao_Exposicao() throws Exception {
        System.out.println("getExposicao");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = instance.novaExposicao();
        exp.setDadosPrincipais("teste", "teste", d1, d2, "teste", d3, d4);
        Exposicao expResult = instance.getExposicao(exp);
        Exposicao result = instance.getExposicao(exp);
        assertEquals(expResult, result);

    }

    /**
     * Test of hasExposicao method, of class RegistoExposicoes.
     */
    @Test
    public void testHasExposicao() throws Exception {
        System.out.println("hasExposicao");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = instance.novaExposicao();
        exp.setDadosPrincipais("teste", "teste", d1, d2, "teste", d3, d4);
        instance.adicionarExposicao(exp);
        boolean expResult = true;
        boolean result = instance.hasExposicao(exp);
        assertEquals(expResult, result);

    }

    /**
     * Test of temFuncaoOrganizador method, of class RegistoExposicoes.
     */
    @Test
    public void testTemFuncaoOrganizador() throws Exception {
        System.out.println("temFuncaoOrganizador");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = instance.novaExposicao();
        exp.setDadosPrincipais("teste", "teste", d1, d2, "teste", d3, d4);
        instance.adicionarExposicao(exp);
        instance.getExposicao(exp).getListaOrganizadores().addOrganizador(new Organizador(new Utilizador("Nome", "Admin", "Adim", "ad")));
        instance.getExposicao(exp).hasOrganizador(new Utilizador("Nome", "Admin", "Adim", "ad"));
        boolean expResult = false;
        boolean result = instance.temFuncaoOrganizador(new Utilizador("Nome", "Admin", "Adim", "ad"));
        assertEquals(expResult, result);

    }

    /**
     * Test of temFuncaoFAE method, of class RegistoExposicoes.
     */
    @Test
    public void testTemFuncaoFAE() throws Exception {
        System.out.println("temFuncaoFAE");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = instance.novaExposicao();
        exp.setDadosPrincipais("teste", "teste", d1, d2, "teste", d3, d4);
        instance.adicionarExposicao(exp);
        instance.getExposicao(exp).getListaFAE().addFAE(new FAE(new Utilizador("Nome", "Admin", "Adim", "ad")));
        instance.getExposicao(exp).hasFAE(new Utilizador("Nome", "Admin", "Adim", "ad"));
        boolean expResult = false;
        boolean result = instance.temFuncaoFAE(new Utilizador("Nome", "Admin", "Adim", "ad"));
        assertEquals(expResult, result);

    }

    /**
     * Test of valida method, of class RegistoExposicoes.
     */
    @Test
    public void testValida() throws Exception {
        System.out.println("valida");
        System.out.println("temFuncaoFAE");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = instance.novaExposicao();
        exp.setDadosPrincipais("teste", "teste", d1, d2, "teste", d3, d4);
        instance.adicionarExposicao(exp);
        instance.getExposicao(exp).getListaFAE().addFAE(new FAE(new Utilizador("Nome", "Admin", "Adim", "ad")));
        instance.getExposicao(exp).hasFAE(new Utilizador("Nome", "Admin", "Adim", "ad"));
        boolean expResult = false;
        boolean result = instance.valida(exp);
        assertEquals(expResult, result);

    }

    /**
     * Test of getExposicoesDoFAE method, of class RegistoExposicoes.
     */
    @Test
    public void testGetExposicoesDoFAE() throws Exception {
        System.out.println("getExposicoesDoFAE");

        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        instance.adicionarExposicao(exp);
        RegistoExposicoes result = instance.getExposicoesDoFAE(user);
        RegistoExposicoes expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of getExposicoesOrganizador method, of class RegistoExposicoes.
     */
    @Test
    public void testGetExposicoesOrganizador() throws Exception {
        System.out.println("getExposicoesOrganizador");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        instance.adicionarExposicao(exp);
        RegistoExposicoes result = instance.getExposicoesOrganizador(user);
        RegistoExposicoes expResult = result;

        assertEquals(expResult, result);

    }

    /**
     * Test of getExposicoesEstadoCriada method, of class RegistoExposicoes.
     */
    @Test
    public void testGetExposicoesEstadoCriada() throws Exception {
        System.out.println("getExposicoesEstadoCriada");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        instance.adicionarExposicao(exp);
        RegistoExposicoes result = instance.getExposicoesEstadoCriada();
        RegistoExposicoes expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of getExposicoesFAESemDemonstracao method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetExposicoesFAESemDemonstracao() throws Exception {
        System.out.println("getExposicoesFAESemDemonstracao");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        instance.adicionarExposicao(exp);
        RegistoExposicoes result = instance.getExposicoesFAESemDemonstracao();
        RegistoExposicoes expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of getExposicoesDemonstracaoSemFae method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetExposicoesDemonstracaoSemFae() throws Exception {
        System.out.println("getExposicoesDemonstracaoSemFae");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaDemonstracoes lista = exp.getListaDemonstracoes();
        Demonstracao demo = new Demonstracao();
        demo.setDados("Teste", "Teste");
        lista.adicionarDemonstracao(demo);
        instance.adicionarExposicao(exp);
        RegistoExposicoes result = instance.getExposicoesDemonstracaoSemFae();
        RegistoExposicoes expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of getExposicoesCandidaturasAbertas method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetExposicoesCandidaturasAbertas() throws Exception {
        System.out.println("getExposicoesCandidaturasAbertas");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        instance.adicionarExposicao(exp);
        RegistoExposicoes result = instance.getExposicoesCandidaturasAbertas();
        RegistoExposicoes expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of getExposicoesConflitosDetetados method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetExposicoesConflitosDetetados() throws Exception {
        System.out.println("getExposicoesConflitosDetetados");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        instance.adicionarExposicao(exp);
        RegistoExposicoes result = instance.getExposicoesConflitosDetetados();
        RegistoExposicoes expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of getExposicoesConflitosAlterados method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetExposicoesConflitosAlterados() throws Exception {
        System.out.println("getExposicoesConflitosAlterados");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        instance.adicionarExposicao(exp);
        RegistoExposicoes result = instance.getExposicoesConflitosAlterados();
        RegistoExposicoes expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of getExposicoesCandidaturasEmAtribuicao method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetExposicoesCandidaturasEmAtribuicao() throws Exception {
        System.out.println("getExposicoesCandidaturasEmAtribuicao");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        instance.adicionarExposicao(exp);
        RegistoExposicoes result = instance.getExposicoesCandidaturasEmAtribuicao();
        RegistoExposicoes expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of getExposicoesCandidaturasAtribuidas method, of class
 RegistoExposicoes.
     */
    @Test
    public void testGetExposicoesCandidaturasEmAvaliacao() throws Exception {
        System.out.println("getExposicoesCandidaturasEmAvaliacao");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        instance.adicionarExposicao(exp);
        RegistoExposicoes result = instance.getExposicoesCandidaturasAtribuidas();
        RegistoExposicoes expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of getExposicoesCandidaturasDecididas method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetExposicoesCandidaturasDecididas() throws Exception {
        System.out.println("getExposicoesCandidaturasDecididas");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        instance.adicionarExposicao(exp);
        RegistoExposicoes result = instance.getExposicoesCandidaturasDecididas();
        RegistoExposicoes expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of getExposicoesStandsAtribuidos method, of class
 RegistoExposicoes.
     */
    @Test
    public void testGetExposicoesStandsAtribuiveis() throws Exception {
        System.out.println("getExposicoesStandsAtribuiveis");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        instance.adicionarExposicao(exp);
        RegistoExposicoes result = instance.getExposicoesStandsAtribuidos();
        RegistoExposicoes expResult = result;
        assertEquals(expResult, result);
    }

}
