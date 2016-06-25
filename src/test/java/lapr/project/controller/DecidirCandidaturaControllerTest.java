/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Candidatura;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaAvaliacoes;
import lapr.project.model.lists.ListaCandidaturas;
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
public class DecidirCandidaturaControllerTest {

    private static final String s1 = "19/11/2017", s2 = "20/11/2017", s3 = "11/11/2017", s4 = "12/11/2017", s5 = "15/11/2017",
            s6 = "16/11/2017", s7 = "13/11/2017", s8 = "17/11/2017", s9 = "18/11/2017", s10 = "14/11/2017";
    private static Data d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
    private CentroExposicoes ce;
    private Utilizador utilizador;

    public DecidirCandidaturaControllerTest() {
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
     * Test of getListaExposicoes method, of class DecidirCandidaturaController.
     */
    @Test
    public void testGetListaExposicoes() {
        System.out.println("getListaExposicoes");
        DecidirCandidaturaController instance = new DecidirCandidaturaController(ce, utilizador);
        RegistoExposicoes expResult = instance.getListaExposicoes();
        RegistoExposicoes result = instance.getListaExposicoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of getInformacaoDaCandidaturaPorDecidir method, of class
     * DecidirCandidaturaController.
     */
    @Test
    public void testGetInformacaoDaCandidaturaPorDecidir() {
        System.out.println("getInformacaoDaCandidaturaPorDecidir");
        DecidirCandidaturaController instance = new DecidirCandidaturaController(ce, utilizador);
        ListaCandidaturas expResult = instance.getInformacaoDaCandidaturaPorDecidir();
        ListaCandidaturas result = instance.getInformacaoDaCandidaturaPorDecidir();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaAvaliacoesFAE method, of class
     * DecidirCandidaturaController.
     */
    @Test
    public void testGetListaAvaliacoesFAE() {
        System.out.println("getListaAvaliacoesFAE");
        DecidirCandidaturaController instance = new DecidirCandidaturaController(ce, utilizador);
        ListaAvaliacoes expResult = instance.getListaAvaliacoesFAE();
        ListaAvaliacoes result = instance.getListaAvaliacoesFAE();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaCandidaturasPorDecidir method, of class
     * DecidirCandidaturaController.
     */
    @Test
    public void testGetListaCandidaturasPorDecidir() throws Exception {
        System.out.println("getListaCandidaturasPorDecidir");
        DecidirCandidaturaController instance = new DecidirCandidaturaController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        ListaCandidaturas expResult = instance.getListaCandidaturasPorDecidir();
        ListaCandidaturas result = instance.getListaCandidaturasPorDecidir();
        assertEquals(expResult, result);

    }

}
