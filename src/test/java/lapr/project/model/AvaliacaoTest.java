/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.model.lists.ListaQuestoes;
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
public class AvaliacaoTest {

    public AvaliacaoTest() {
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
     * Test of getListaQuestoes method, of class Avaliacao.
     */
    @Test
    public void testGetListaQuestoes() {
        System.out.println("getListaQuestoes");
        Avaliacao instance = new Avaliacao();

        ListaQuestoes expResult = instance.getListaQuestoes();
        ListaQuestoes result = instance.getListaQuestoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of getAvaliacao method, of class Avaliacao.
     */
    @Test
    public void testGetAvaliacao() {
        System.out.println("getAvaliacao");
        Avaliacao instance = new Avaliacao();
        instance.setJustificacao("Justificação");
        instance.setResposta(true);
        boolean expResult = true;
        boolean result = instance.getAvaliacao();
        assertEquals(expResult, result);

    }

    /**
     * Test of getJustificacao method, of class Avaliacao.
     */
    @Test
    public void testGetJustificacao() {
        System.out.println("getJustificacao");
        Avaliacao instance = new Avaliacao();
        String expResult = "Justificação";
        instance.setJustificacao(expResult);
        String result = instance.getJustificacao();
        assertEquals(expResult, result);

    }

    /**
     * Test of getEstado method, of class Avaliacao.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Avaliacao instance = new Avaliacao();
        instance.setJustificacao("Justificação");
        instance.setResposta(true);
        boolean expResult = false;
        boolean result = instance.getEstado();
        assertEquals(expResult, result);

    }

    /**
     * Test of valida method, of class Avaliacao.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Avaliacao instance = new Avaliacao();
        instance.setJustificacao("Justificação");
        instance.setResposta(true);
        boolean expResult = true;
        boolean result = instance.valida();
        assertEquals(expResult, result);

    }

    /**
     * Test of getAvaliacaoString method, of class Avaliacao.
     */
    @Test
    public void testGetAvaliacaoString() {
        System.out.println("getAvaliacaoString");
        Avaliacao instance = new Avaliacao();
        instance.setJustificacao("Justificação");
        instance.setResposta(true);
        String expResult = "Aceite";
        String result = instance.getAvaliacaoString();
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class Avaliacao.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Avaliacao instance = new Avaliacao();
        instance.setJustificacao("Justificação");
        instance.setResposta(true);
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);

    }

}
