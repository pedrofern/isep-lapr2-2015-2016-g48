/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.List;
import lapr.project.model.Avaliacao;
import lapr.project.model.Candidatura;
import lapr.project.model.FAE;
import lapr.project.model.Utilizador;
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
public class ListaAvaliacoesTest {

    public ListaAvaliacoesTest() {
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
     * Test of valida method, of class ListaAvaliacoes.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Avaliacao avaliacao = new Avaliacao(true, "Teste");
        ListaAvaliacoes instance = new ListaAvaliacoes();
        instance.add(avaliacao);
        boolean expResult = true;
        boolean result = instance.valida(avaliacao);
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class ListaAvaliacoes.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Avaliacao avaliacao = new Avaliacao(true, "Teste");
        ListaAvaliacoes instance = new ListaAvaliacoes();
        boolean expResult = true;
        boolean result = instance.add(avaliacao);
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class ListaAvaliacoes.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Avaliacao avaliacao = new Avaliacao(true, "Teste");
        ListaAvaliacoes instance = new ListaAvaliacoes();
        ListaAvaliacoes lista = new ListaAvaliacoes();
        instance.add(avaliacao);
        lista.add(avaliacao);
        boolean expResult = true;
        boolean result = instance.equals(lista);
        assertEquals(expResult, result);

    }

      /**
     * Test of getListaAvaliacoes method, of class ListaAvaliacoes.
     */
    @Test
    public void testGetListaAvaliacoes() {
        System.out.println("getListaAvaliacoes");
        ListaAvaliacoes instance = new ListaAvaliacoes();
        List<Avaliacao> expResult = instance.getListaAvaliacoes();
        List<Avaliacao> result = instance.getListaAvaliacoes();
        assertEquals(expResult, result);
         
    }

    /**
     * Test of validaAvaliacaoCandidatura method, of class ListaAvaliacoes.
     */
    @Test
    public void testValidaAvaliacaoCandidatura() {
        System.out.println("validaAvaliacaoCandidatura");
        Candidatura c = new Candidatura("Teste", "Teste",123456789 , 878, 858);
        ListaAvaliacoes instance = new ListaAvaliacoes();
        boolean expResult = false;
        boolean result = instance.validaAvaliacaoCandidatura(c);
        assertEquals(expResult, result);
         
    }

    /**
     * Test of validaAvaliacaoFae method, of class ListaAvaliacoes.
     */
    @Test
    public void testValidaAvaliacaoFae() {
        System.out.println("validaAvaliacaoFae");
        FAE f = new FAE(new Utilizador("Teste", "Teste","Teste","Teste"));
        ListaAvaliacoes instance = new ListaAvaliacoes();
        boolean expResult = true;
        boolean result = instance.validaAvaliacaoFae(f);
        assertEquals(expResult, result);
      
    }

}
