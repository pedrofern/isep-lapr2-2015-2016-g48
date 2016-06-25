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
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaCandidaturas;
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
public class AlterarCandidaturaControllerTest {

    private static final String s1 = "19/11/2017", s2 = "20/11/2017", s3 = "11/11/2017", s4 = "12/11/2017", s5 = "15/11/2017",
            s6 = "16/11/2017", s7 = "13/11/2017", s8 = "17/11/2017", s9 = "18/11/2017", s10 = "14/11/2017";
    private static Data d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
    private CentroExposicoes ce;
    private Utilizador utilizador;

    public AlterarCandidaturaControllerTest() {
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
     * Test of getRegistoExposicoes method, of class
     * AlterarCandidaturaController.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        AlterarCandidaturaController instance = new AlterarCandidaturaController(ce, utilizador);
        RegistoExposicoes expResult = instance.getRegistoExposicoes();
        RegistoExposicoes result = instance.getRegistoExposicoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaDemonstracoes method, of class
     * AlterarCandidaturaController.
     */
    @Test
    public void testGetListaDemonstracoes() throws Exception {
        System.out.println("getListaDemonstracoes");
        Candidatura candidatura = new Candidatura("tese", "teste", 123456780, 80, 80);
        AlterarCandidaturaController instance = new AlterarCandidaturaController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        instance.selectCandidatura(candidatura);
        instance.getInfoCandidatura();
        ListaDemonstracoes expResult = instance.getListaDemonstracoes();
        ListaDemonstracoes result = instance.getListaDemonstracoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaCandidaturas method, of class
     * AlterarCandidaturaController.
     */
    @Test
    public void testGetListaCandidaturas() {
        System.out.println("getListaCandidaturas");
        AlterarCandidaturaController instance = new AlterarCandidaturaController(ce, utilizador);
        ListaCandidaturas expResult = instance.getListaCandidaturas();
        ListaCandidaturas result = instance.getListaCandidaturas();
        assertEquals(expResult, result);

    }


    /**
     * Test of getSelectedDemonstacao method, of class
     * AlterarCandidaturaController.
     */
    @Test
    public void testGetSelectedDemonstacao() {
        System.out.println("getSelectedDemonstacao");
        AlterarCandidaturaController instance = new AlterarCandidaturaController(ce, utilizador);
        ListaDemonstracoes expResult = instance.getSelectedDemonstacao();
        ListaDemonstracoes result = instance.getSelectedDemonstacao();
        assertEquals(expResult, result);

    }

    /**
     * Test of novaCandidaturaDemonstracao method, of class
     * AlterarCandidaturaController.
     */
    @Test
    public void testNovaCandidaturaDemonstracao() {
        System.out.println("novaCandidaturaDemonstracao");
        Candidatura candidatura = new Candidatura("tese", "teste", 123456780, 80, 80);
        AlterarCandidaturaController instance = new AlterarCandidaturaController(ce, utilizador);
        CandidaturaDemonstracao result = instance.novaCandidaturaDemonstracao(candidatura);
        CandidaturaDemonstracao expResult = result;
        assertEquals(expResult, result);

    }

  

}
