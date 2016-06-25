/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.RegistoExposicoes;
import lapr.project.model.lists.RegistoUtilizadores;
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
public class DefinirFAEControllerTest {

    private static final String s1 = "19/11/2017", s2 = "20/11/2017", s3 = "11/11/2017", s4 = "12/11/2017", s5 = "15/11/2017",
            s6 = "16/11/2017", s7 = "13/11/2017", s8 = "17/11/2017", s9 = "18/11/2017", s10 = "14/11/2017";
    private static Data d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
    private CentroExposicoes ce;
    private Utilizador utilizador;

    public DefinirFAEControllerTest() {
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
     * Test of setRegistoUTilizadores method, of class DefinirFAEController.
     */
    @Test
    public void testSetRegistoUTilizadores() throws Exception {
        System.out.println("setRegistoUTilizadores");
        DefinirFAEController instance = new DefinirFAEController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        instance.setRegistoUTilizadores();
        RegistoUtilizadores result = instance.getRegistoUtilizadoresFAE();
        RegistoUtilizadores expResutl = instance.getRegistoUtilizadoresFAE();
        assertEquals(expResutl, result);
    }

    /**
     * Test of getRegistoUtilizadoresFAE method, of class DefinirFAEController.
     */
    @Test
    public void testGetRegistoUtilizadoresFAE() throws Exception {
        System.out.println("getRegistoUtilizadoresFAE");
        DefinirFAEController instance = new DefinirFAEController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        instance.setRegistoUTilizadores();
        RegistoUtilizadores expResult = instance.getRegistoUtilizadoresFAE();
        RegistoUtilizadores result = instance.getRegistoUtilizadoresFAE();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaFAE method, of class DefinirFAEController.
     */
    @Test
    public void testGetListaFAE() throws Exception {
        System.out.println("getListaFAE");
        DefinirFAEController instance = new DefinirFAEController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        ListaFAE expResult = instance.getListaFAE();
        ListaFAE result = instance.getListaFAE();
        assertEquals(expResult, result);

    }

    /**
     * Test of validaMinFAE method, of class DefinirFAEController.
     */
    @Test
    public void testValidaMinFAE() throws Exception {
        System.out.println("validaMinFAE");
        DefinirFAEController instance = new DefinirFAEController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        ListaFAE lista = instance.getListaFAE();
        lista.addFAE(new FAE(new Utilizador("Nome", "Admin", "Ad", "Email")));
        lista.addFAE(new FAE(new Utilizador("Nome1", "Admin1", "Ad1", "Email1")));
        boolean expResult = true;
        boolean result = instance.validaMinFAE();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFAEString method, of class DefinirFAEController.
     */
    @Test
    public void testGetFAEString() throws Exception {
        System.out.println("getFAEString");
        DefinirFAEController instance = new DefinirFAEController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        ListaFAE lista = instance.getListaFAE();
        lista.addFAE(new FAE(new Utilizador("Nome", "Admin", "Ad", "Email")));
        String expResult = instance.getFAEString();
        String result = instance.getFAEString();
        assertEquals(expResult, result);

    }

    /**
     * Test of getExposicoes method, of class DefinirFAEController.
     */
    @Test
    public void testGetExposicoes() throws Exception {
        System.out.println("getExposicoes");
        DefinirFAEController instance = new DefinirFAEController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        ListaFAE lista = instance.getListaFAE();
        lista.addFAE(new FAE(new Utilizador("Nome", "Admin", "Ad", "Email")));
        RegistoExposicoes expResult = instance.getExposicoes();
        expResult.adicionarExposicao(exp);
        RegistoExposicoes result = instance.getExposicoes();
        result.adicionarExposicao(exp);
        assertEquals(expResult, result);

    }

    /**
     * Test of registaMembroFAE method, of class DefinirFAEController.
     */
    @Test
    public void testRegistaMembroFAE() throws Exception {
        System.out.println("registaMembroFAE");
        DefinirFAEController instance = new DefinirFAEController(ce, utilizador);
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.selectExposicao(new Exposicao());
        ListaFAE lista = instance.getListaFAE();
        instance.addFAE(new Utilizador("Nome", "Email","Admim", "Ad"));
        instance.adicionarFAE();
        boolean expResult = true;
        boolean result = instance.registaMembroFAE();
        assertEquals(expResult, result);

    }
}
