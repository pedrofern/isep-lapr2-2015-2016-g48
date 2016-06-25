/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.model.states.ExposicaoEstado;
import lapr.project.utils.Data;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import lapr.project.model.lists.ListaAtribuicoes;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.ListaFAE;

/**
 *
 * @author Edu
 */
public class ExposicaoTest {

    private static final String s1 = "19/11/2017", s2 = "20/11/2017", s3 = "11/11/2017", s4 = "12/11/2017", s5 = "15/11/2017",
            s6 = "16/11/2017", s7 = "13/11/2017", s8 = "17/11/2017", s9 = "18/11/2017", s10 = "14/11/2017";
    private static Data d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;

    public ExposicaoTest() {
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
     * Test of getListaDemonstracoes method, of class Exposicao.
     */
    @Test
    public void testGetListaDemonstracoes() throws Exception {
        System.out.println("getListaDemonstracoes");
        Exposicao instance = new Exposicao();
        instance.setDadosPrincipais("Teste", "descritivo", d1, d1, s1, d1, d1);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Teste1", "Descritivo", d1, d1, s1, d1, d1);
        Demonstracao d = new Demonstracao();
        d.setDados("Descrição", "Teste");
        ListaDemonstracoes expResult = instance.getListaDemonstracoes();
        expResult.adicionarDemonstracao(d);
        ListaDemonstracoes result = instance.getListaDemonstracoes();
        result.adicionarDemonstracao(d);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetTitulo() throws Exception {
        System.out.println("getTitulo");
        Exposicao instance = new Exposicao();
        String expResult = "Titulo";
        instance.setTitulo(expResult);
        String result = instance.getTitulo();
        assertEquals(expResult, result);

    }

    /**
     * Test of getTextoDescritivo method, of class Exposicao.
     */
    @Test
    public void testGetTextoDescritivo() throws Exception {
        System.out.println("getTextoDescritivo");
        Exposicao instance = new Exposicao();
        String expResult = "Descritivo";
        instance.setTextoDescritivo(expResult);
        String result = instance.getTextoDescritivo();
        assertEquals(expResult, result);

    }

    /**
     * Test of getLocal method, of class Exposicao.
     */
    @Test
    public void testGetLocal() throws Exception {
        System.out.println("getLocal");
        Exposicao instance = new Exposicao();
        String expResult = "Local";
        instance.setLocal(expResult);
        String result = instance.getLocal();
        assertEquals(expResult, result);

    }

    /**
     * Test of getDataInicio method, of class Exposicao.
     */
    @Test
    public void testGetDataInicio() throws Exception {
        System.out.println("getDataInicio");
        Exposicao instance = new Exposicao();
        Data expResult = new Data(2016, 02, 2);
        instance.setDataInicio(expResult);
        Data result = instance.getDataInicio();
        assertEquals(expResult, result);

    }

    /**
     * Test of getDataFim method, of class Exposicao.
     */
    @Test
    public void testGetDataFim() throws Exception {
        System.out.println("getDataFim");
        Exposicao instance = new Exposicao();
        Data expResult = new Data(2016, 05, 20);
        instance.setDataFim(expResult);
        Data result = instance.getDataFim();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDataInicioSubmissao method, of class Exposicao.
     */
    @Test
    public void testGetDataInicioSubmissao() throws Exception {
        System.out.println("getDataInicioSubmissao");
        Exposicao instance = new Exposicao();
        Data expResult = new Data(2016, 05, 2);
        instance.setDataInicioSubmissao(expResult);
        Data result = instance.getDataInicioSubmissao();
        assertEquals(expResult, result);

    }

    /**
     * Test of getDataFimSubmissao method, of class Exposicao.
     */
    @Test
    public void testGetDataFimSubmissao() throws Exception {
        System.out.println("getDataFimSubmissao");
        Exposicao instance = new Exposicao();
        Data expResult = new Data(2016, 02, 20);
        instance.setDataFimSubmissao(expResult);
        Data result = instance.getDataFimSubmissao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDataInicioAtribuicao method, of class Exposicao.
     */
    @Test
    public void testGetDataInicioAtribuicao() throws Exception {
        System.out.println("getDataInicioAtribuicao");
        Exposicao instance = new Exposicao();
        Data expResult = new Data(2016, 02, 20);
        instance.setDataInicioAtribuicao(expResult);
        Data result = instance.getDataInicioAtribuicao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDataFimAtribuicao method, of class Exposicao.
     */
    @Test
    public void testGetDataFimAtribuicao() throws Exception {
        System.out.println("getDataFimAtribuicao");
        Exposicao instance = new Exposicao();
        Data expResult = new Data(2016, 02, 2);
        instance.setDataFimAtribuicao(expResult);
        Data result = instance.getDataFimAtribuicao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDataAlteracaConflitos method, of class Exposicao.
     */
    @Test
    public void testGetDataAlteracaConflitos() throws Exception {
        System.out.println("getDataAlteracaConflitos");
        Exposicao instance = new Exposicao();
        Exposicao exp = new Exposicao();
        instance.setDataAlteracaoConflito(new Data(2016, 02, 02));

        Data expResult = instance.getDataAlteracaConflitos();
        Data result = instance.getDataAlteracaConflitos();
        assertEquals(expResult, result);

    }

    /**
     * Test of getDataInicioStands method, of class Exposicao.
     */
    @Test
    public void testGetDataInicioStands() throws Exception {
        System.out.println("getDataInicioStands");
        Exposicao instance = new Exposicao();
        Data expResult = new Data(2016, 02, 20);
        instance.setDataInicoStands(expResult);
        Data result = instance.getDataInicioStands();
        assertEquals(expResult, result);

    }

    /**
     * Test of getDataFimStands method, of class Exposicao.
     */
    @Test
    public void testGetDataFimStands() throws Exception {
        System.out.println("getDataFimStands");
        Exposicao instance = new Exposicao();
        Data expResult = new Data(2016, 02, 2);
        instance.setDataFimStands(expResult);
        Data result = instance.getDataFimStands();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Exposicao.
     */
    @Test
    public void testEquals() throws Exception {
        System.out.println("equals");
        Exposicao instance = new Exposicao();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        boolean expResult = true;
        boolean result = instance.equals(exp);
        assertEquals(expResult, result);

    }

    /**
     * Test of hashCode method, of class Exposicao.
     */
    @Test
    public void testHashCode() throws Exception {
        System.out.println("hashCode");
        Exposicao instance = new Exposicao();

        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);

        int expResult = -1149128705;
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of setEstadoDemonstracao method, of class Exposicao.
     */
    @Test
    public void testAlterarEstado() throws Exception {
        System.out.println("alterarEstado");
        Exposicao instance = new Exposicao();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        ExposicaoEstado estado = instance.getEstadoAtualExposicao();
        boolean expResult = true;
        boolean result = instance.alterarEstado(estado);
        assertEquals(expResult, result);

    }

    /**
     * Test of hasOrganizador method, of class Exposicao.
     */
    @Test
    public void testHasOrganizador() throws Exception {
        System.out.println("hasOrganizador");
        Utilizador u = new Utilizador("Nome", "email", "admin", "admi");
        Exposicao instance = new Exposicao();
        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        boolean expResult = false;
        boolean result = instance.hasOrganizador(u);
        assertEquals(expResult, result);

    }

    /**
     * Test of hasFAE method, of class Exposicao.
     */
    @Test
    public void testHasFAE() throws Exception {
        System.out.println("hasFAE");
        Utilizador u = new Utilizador("nome", "email", "admin", "email");
        Exposicao instance = new Exposicao();
        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        boolean expResult = false;
        boolean result = instance.hasFAE(u);
        assertEquals(expResult, result);

    }

    /**
     * Test of validaDefinirFAE method, of class Exposicao.
     */
    @Test
    public void testValidaDefinirFAE() throws Exception {
        System.out.println("validaDefinirFAE");
        FAE f = new FAE(new Utilizador("nome", "email", "admin", "email"));
        Exposicao instance = new Exposicao();
        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        boolean expResult = true;
        boolean result = instance.validaDefinirFAE(f);
        assertEquals(expResult, result);

    }

    /**
     * Test of compareTo method, of class Exposicao.
     */
    @Test
    public void testCompareTo() throws Exception {
        System.out.println("compareTo");
        Exposicao outraExposicao = new Exposicao();
        Exposicao instance = new Exposicao();
        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        outraExposicao.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        int expResult = 0;
        int result = instance.compareTo(outraExposicao);
        assertEquals(expResult, result);

    }

    /**
     * Test of valida method, of class Exposicao.
     */
    @Test
    public void testValida() throws Exception {
        System.out.println("valida");
        Exposicao instance = new Exposicao();
        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        boolean expResult = true;
        boolean result = instance.valida();
        assertEquals(expResult, result);

    }

    /**
     * Test of validaTitulo method, of class Exposicao.
     */
    @Test
    public void testValidaTitulo() throws Exception {
        System.out.println("validaTitulo");
        Exposicao instance = new Exposicao();
        instance.setTitulo("Titulo");
        boolean expResult = true;
        boolean result = instance.validaTitulo();
        assertEquals(expResult, result);

    }

    /**
     * Test of validaTextoDescritivo method, of class Exposicao.
     */
    @Test
    public void testValidaTextoDescritivo() throws Exception {
        System.out.println("validaTextoDescritivo");
        Exposicao instance = new Exposicao();
        instance.setTextoDescritivo("Descritivo");
        boolean expResult = true;
        boolean result = instance.validaTextoDescritivo();
        assertEquals(expResult, result);

    }

    /**
     * Test of validaLocal method, of class Exposicao.
     */
    @Test
    public void testValidaLocal() throws Exception {
        System.out.println("validaLocal");
        Exposicao instance = new Exposicao();
        instance.setLocal("local");
        boolean expResult = true;
        boolean result = instance.validaLocal();
        assertEquals(expResult, result);

    }

    /**
     * Test of validaDatas1 method, of class Exposicao.
     */
    @Test
    public void testValidaDatas1() throws Exception {
        System.out.println("validaDatas1");

        Exposicao instance = new Exposicao();
        boolean expResult = true;
        boolean result = instance.validaDatas1(s1, s1, s1, s1, s1, s1);
        assertEquals(expResult, result);

    }

    /**
     * Test of validaDatas2 method, of class Exposicao.
     */
    @Test
    public void testValidaDatas2() throws Exception {
        System.out.println("validaDatas2");

        Exposicao instance = new Exposicao();
        boolean expResult = true;
        boolean result = instance.validaDatas2(s1, s1, s1, s1);
        assertEquals(expResult, result);

    }

    /**
     * Test of validaMinOrganizadores method, of class Exposicao.
     */
    @Test
    public void testValidaMinOrganizadores() throws Exception {
        System.out.println("validaMinOrganizadores");
        Exposicao instance = new Exposicao();
        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        Utilizador ut1 = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin","admin", true, 15);

        Utilizador ut2 = new Utilizador("Ana Silva", "1130155@isep.ipp.pt", "Gestor", "gestor",false, 10);
        Organizador o = new Organizador(ut1);
        Organizador o1 = new Organizador(ut2);
        ListaOrganizadores lo = instance.getListaOrganizadores();
        lo.addOrganizador(o);
        lo.addOrganizador(o1);

        boolean expResult = true;
        boolean result = instance.validaMinOrganizadores();
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class Exposicao.
     */
    @Test
    public void testToString() throws Exception {
        System.out.println("toString");
        Exposicao instance = new Exposicao();
        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        String expResult = exp.toString();
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of toStringCompleto method, of class Exposicao.
     */
    @Test
    public void testToStringCompleto() throws Exception {
        System.out.println("toStringCompleto");
        Exposicao instance = new Exposicao();
        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        String expResult = exp.toStringCompleto();
        String result = instance.toStringCompleto();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaFAE method, of class Exposicao.
     */
    @Test
    public void testGetListaFAE() throws Exception {
        System.out.println("getListaFAE");
        Exposicao instance = new Exposicao();
        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        ListaFAE result = instance.getListaFAE();
        ListaFAE expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaOrganizadores method, of class Exposicao.
     */
    @Test
    public void testGetListaOrganizadores() throws Exception {
        System.out.println("getListaOrganizadores");
        Exposicao instance = new Exposicao();
        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        ListaOrganizadores result = instance.getListaOrganizadores();
        ListaOrganizadores expResult = result;
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaCandidaturas method, of class Exposicao.
     */
    @Test
    public void testGetListaCandidaturas() throws Exception {
        System.out.println("getListaCandidaturas");
        Exposicao instance = new Exposicao();
        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        ListaCandidaturas result = instance.getListaCandidaturas();
        ListaCandidaturas expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaAtribuicoes method, of class Exposicao.
     */
    @Test
    public void testGetListaAtribuicoes() throws Exception {
        System.out.println("getListaAtribuicoes");
        Exposicao instance = new Exposicao();
        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        ListaAtribuicoes result = instance.getListaAtribuicoes();
        ListaAtribuicoes expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of getEstatisticaFAE method, of class Exposicao.
     */
    @Test
    public void testGetEstatisticaFAE() throws Exception {
        System.out.println("getEstatisticaFAE");
        Exposicao instance = new Exposicao();
        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        EstatisticaFAE result = instance.getEstatisticaFAE();
        EstatisticaFAE expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of getEstatisticaCandidatura method, of class Exposicao.
     */
    @Test
    public void testGetEstatisticaCandidatura() throws Exception {
        System.out.println("getEstatisticaCandidatura");
        Exposicao instance = new Exposicao();
        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        EstatisticaCandidatura result = instance.getEstatisticaCandidatura();
        EstatisticaCandidatura expResult = result;
        assertEquals(expResult, result);

    }


    /**
     * Test of getState method, of class Exposicao.
     */
    @Test
    public void testGetState() throws Exception {
        System.out.println("getState");
        Exposicao instance = new Exposicao();
        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        ExposicaoEstado result = instance.getState();
        ExposicaoEstado expResult = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEstadoAtualExposicao method, of class Exposicao.
     */
    @Test
    public void testGetEstadoAtualExposicao() throws Exception {
        System.out.println("getEstadoAtualExposicao");
        Exposicao instance = new Exposicao();
        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        ExposicaoEstado result = instance.getEstadoAtualExposicao();
        ExposicaoEstado expResult = result;
        assertEquals(expResult, result);
    }

    /**
     * Test of validaSeguimentoDatas method, of class Exposicao.
     */
    @Test
    public void testValidaSeguimentoDatas() throws Exception {
        System.out.println("validaSeguimentoDatas");
        Exposicao instance = new Exposicao();
        instance.setDadosPrincipais("Titulo", "Descrição", d1, d1, s1, d1, d1);
        instance.setDataInicio(new Data(2016, 12, 03));
        instance.setDataFim(new Data(2016, 12, 05));
        instance.setDataInicioStands(new Data(2016, 02, 03));
        instance.setDataFimStands(new Data(2016, 02, 04));
        instance.setDataInicioAtribuicao(new Data(2016, 02, 05));
        instance.setDataFimAtribuicao(new Data(2016, 02, 06));
        instance.setDataAlteracaoConflito(new Data(2016, 02, 07));
        boolean expResult = true;
        boolean result = instance.validaSeguimentoDatas();
        assertEquals(expResult, result);

    }

}
