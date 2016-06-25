/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.mechanisms;

import lapr.project.controller.AlterarCandidaturaController;
import lapr.project.model.Candidatura;
import lapr.project.model.Exposicao;
import lapr.project.model.lists.ListaAtribuicoes;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaFAE;
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
public class MecanismoCargaTest {

    private static final String s1 = "19/11/2017", s2 = "20/11/2017", s3 = "11/11/2017", s4 = "12/11/2017", s5 = "15/11/2017",
            s6 = "16/11/2017", s7 = "13/11/2017", s8 = "17/11/2017", s9 = "18/11/2017", s10 = "14/11/2017";
    private static Data d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;

    public MecanismoCargaTest() {
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
     * Test of getListFaes method, of class MecanismoCarga.
     */
    @Test
    public void testGetListFaes() throws Exception {
        System.out.println("getListFaes");
        MecanismoCarga instance = new MecanismoCarga();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.setExposicao(new Exposicao());
        ListaFAE expResult = instance.getListFaes();
        ListaFAE result = instance.getListFaes();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListCandidaturas method, of class MecanismoCarga.
     */
    @Test
    public void testGetListCandidaturas() throws Exception {
        System.out.println("getListCandidaturas");
        MecanismoCarga instance = new MecanismoCarga();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.setExposicao(new Exposicao());
        ListaCandidaturas expResult = instance.getListCandidaturas();
        ListaCandidaturas result = instance.getListCandidaturas();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaAtribuicoes method, of class MecanismoCarga.
     */
    @Test
    public void testGetListaAtribuicoes() throws Exception {
        System.out.println("getListaAtribuicoes");
        MecanismoCarga instance = new MecanismoCarga();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.setExposicao(new Exposicao());
        ListaAtribuicoes expResult = instance.getListaAtribuicoes();
        ListaAtribuicoes result = instance.getListaAtribuicoes();
        assertEquals(expResult, result);
         
    }

    /**
     * Test of getListaAtribuicoesGeradas method, of class MecanismoCarga.
     */
    @Test
    public void testGetListaAtribuicoesGeradas() throws Exception {
        System.out.println("getListaAtribuicoesGeradas");
        MecanismoCarga instance = new MecanismoCarga();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.setExposicao(new Exposicao());
        ListaAtribuicoes expResult = instance.getListaAtribuicoesGeradas();
        ListaAtribuicoes result = instance.getListaAtribuicoesGeradas();
        assertEquals(expResult, result);
        
    }

 

    /**
     * Test of toString method, of class MecanismoCarga.
     */
    @Test
    public void testToString() throws Exception {
        System.out.println("toString");
        MecanismoCarga instance = new MecanismoCarga();
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        instance.setExposicao(new Exposicao());
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

}
