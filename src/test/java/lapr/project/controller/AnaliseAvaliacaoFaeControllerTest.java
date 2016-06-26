/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.model.Organizador;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.ListaOrganizadores;
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
public class AnaliseAvaliacaoFaeControllerTest {

    private static final String s1 = "19/11/2017", s2 = "20/11/2017", s3 = "11/11/2017", s4 = "12/11/2017", s5 = "15/11/2017",
            s6 = "16/11/2017", s7 = "13/11/2017", s8 = "17/11/2017", s9 = "18/11/2017", s10 = "14/11/2017";
    private static Data d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
    private CentroExposicoes ce;
    private Utilizador utilizador;
    Utilizador user = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", "admin", true, 15);

    public AnaliseAvaliacaoFaeControllerTest() {

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
     * Test of getExposicoesOrganizador method, of class
     * AnaliseAvaliacaoFaeController.
     */
    @Test
    public void testGetExposicoesOrganizador() throws Exception {
        System.out.println("getExposicoesOrganizador");
        AnaliseAvaliacaoFaeController instance = new AnaliseAvaliacaoFaeController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.setExposicao(exp);
        ListaFAE lista = exp.getListaFAE();
        lista.addFAE(new FAE(user));
        RegistoExposicoes result = instance.getExposicoes();
        RegistoExposicoes expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of getExposicoesOrganizadorAvaliadas method, of class
     * AnaliseAvaliacaoFaeController.
     */
    @Test
    public void testGetExposicoesOrganizadorAvaliadas() throws Exception {
        System.out.println("getExposicoesOrganizadorAvaliadas");
        AnaliseAvaliacaoFaeController instance = new AnaliseAvaliacaoFaeController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.setExposicao(exp);
        ListaOrganizadores lista = exp.getListaOrganizadores();
        lista.addOrganizador(new Organizador(user));
        RegistoExposicoes result = instance.getExposicoes();
        RegistoExposicoes expResult = result;
        assertEquals(expResult, result);

    }


    
    /**
     * Test of calcularVariancia method, of class AnaliseAvaliacaoFaeController.
     */
    @Test
    public void testCalcularVariancia() throws Exception {
        System.out.println("calcularVariancia");
        AnaliseAvaliacaoFaeController instance = new AnaliseAvaliacaoFaeController(ce, user);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.setExposicao(exp);
        double expResult = 0.0;
        double result = instance.calcularVariancia();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calcularDesvioPadrao method, of class
     * AnaliseAvaliacaoFaeController.
     */
    @Test
    public void testCalcularDesvioPadrao() throws Exception {
        System.out.println("calcularDesvioPadrao");
        AnaliseAvaliacaoFaeController instance = new AnaliseAvaliacaoFaeController(ce, user);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.setExposicao(exp);
        double expResult = 0.0;
        double result = instance.calcularDesvioPadrao();
        assertEquals(expResult, result, 0.0);

    }


}
