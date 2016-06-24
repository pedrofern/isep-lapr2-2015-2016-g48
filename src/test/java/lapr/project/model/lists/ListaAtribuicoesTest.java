/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.List;
import lapr.project.model.Atribuicao;
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
public class ListaAtribuicoesTest {

    public ListaAtribuicoesTest() {
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
     * Test of createAtribuicao method, of class ListaAtribuicoes.
     */
    @Test
    public void testCreateAtribuicao() {
        System.out.println("createAtribuicao");
        FAE f = new FAE(new Utilizador("Teste", "Teste", "Teste", "Teste"));
        Candidatura c = new Candidatura("Teste", "Teste", 123456789, 123, 123);
        ListaAtribuicoes instance = new ListaAtribuicoes();
        boolean expResult = true;
        boolean result = instance.createAtribuicao(f, c);
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaAtribuicoes method, of class ListaAtribuicoes.
     */
    @Test
    public void testGetListaAtribuicoes() {
        System.out.println("getListaAtribuicoes");
        ListaAtribuicoes instance = new ListaAtribuicoes();
        List<Atribuicao> expResult = instance.getListaAtribuicoes();
        List<Atribuicao> result = instance.getListaAtribuicoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of tamanho method, of class ListaAtribuicoes.
     */
    @Test
    public void testTamanho() {
        System.out.println("tamanho");
        ListaAtribuicoes instance = new ListaAtribuicoes();
        int expResult = 0;
        int result = instance.tamanho();
        assertEquals(expResult, result);

    }

    /**
     * Test of obterAtribuicao method, of class ListaAtribuicoes.
     */
    @Test
    public void testObterAtribuicao() {
        System.out.println("obterAtribuicao");
        int indice = 0;
        ListaAtribuicoes instance = new ListaAtribuicoes();
        FAE f = new FAE(new Utilizador("Teste", "Teste", "Teste", "Teste"));
        Candidatura c = new Candidatura("Teste", "Teste", 123456789, 123, 123);
        Atribuicao atribuicao = new Atribuicao(f, c);
        instance.adicionarAtribuicao(atribuicao);
        Atribuicao expResult = instance.obterAtribuicao(indice);
        Atribuicao result = instance.obterAtribuicao(indice);
        assertEquals(expResult, result);

    }

    /**
     * Test of adicionarAtribuicao method, of class ListaAtribuicoes.
     */
    @Test
    public void testAdicionarAtribuicao() {
        System.out.println("adicionarAtribuicao");
        ListaAtribuicoes instance = new ListaAtribuicoes();
        FAE f = new FAE(new Utilizador("Teste", "Teste", "Teste", "Teste"));
        Candidatura c = new Candidatura("Teste", "Teste", 123456789, 123, 123);
        Atribuicao atribuicao = new Atribuicao(f, c);
        boolean expResult = true;
        boolean result = instance.adicionarAtribuicao(atribuicao);
        assertEquals(expResult, result);

    }


    /**
     * Test of removerAtribuicao method, of class ListaAtribuicoes.
     */
    @Test
    public void testRemoverAtribuicao_Atribuicao() {
        System.out.println("removerAtribuicao");
        ListaAtribuicoes instance = new ListaAtribuicoes();
        FAE f = new FAE(new Utilizador("Teste", "Teste", "Teste", "Teste"));
        Candidatura c = new Candidatura("Teste", "Teste", 123456789, 123, 123);
        Atribuicao atribuicao = new Atribuicao(f, c);
        instance.adicionarAtribuicao(atribuicao);
        boolean expResult = true;
        boolean result = instance.removerAtribuicao(atribuicao);
        assertEquals(expResult, result);

    }

    /**
     * Test of removerTodasAtribuicoes method, of class ListaAtribuicoes.
     */
    @Test
    public void testRemoverTodasAtribuicoes() {
        System.out.println("removerTodasAtribuicoes");
        ListaAtribuicoes instance = new ListaAtribuicoes();
        FAE f = new FAE(new Utilizador("Teste", "Teste", "Teste", "Teste"));
        Candidatura c = new Candidatura("Teste", "Teste", 123456789, 123, 123);
        Atribuicao atribuicao = new Atribuicao(f, c);
        instance.adicionarAtribuicao(atribuicao);
        ListaAtribuicoes lista = new ListaAtribuicoes();
        lista.adicionarAtribuicao(atribuicao);
        boolean expResult = true;
        boolean result = instance.removerTodasAtribuicoes(lista);
        assertEquals(expResult, result);

    }

    /**
     * Test of obterIndiceAtribuicao method, of class ListaAtribuicoes.
     */
    @Test
    public void testObterIndiceAtribuicao() {
        System.out.println("obterIndiceAtribuicao");
        ListaAtribuicoes instance = new ListaAtribuicoes();
        FAE f = new FAE(new Utilizador("Teste", "Teste", "Teste", "Teste"));
        Candidatura c = new Candidatura("Teste", "Teste", 123456789, 123, 123);
        Atribuicao atribuicao = new Atribuicao(f, c);
        instance.adicionarAtribuicao(atribuicao);
        int expResult = 0;
        int result = instance.obterIndiceAtribuicao(atribuicao);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of adicionharListaAtribuicoes method, of class ListaAtribuicoes.
     */
    @Test
    public void testAdicionharListaAtribuicoes() {
        System.out.println("adicionharListaAtribuicoes");
         ListaAtribuicoes instance = new ListaAtribuicoes();
        FAE f = new FAE(new Utilizador("Teste", "Teste", "Teste", "Teste"));
        Candidatura c = new Candidatura("Teste", "Teste", 123456789, 123, 123);
        Atribuicao atribuicao = new Atribuicao(f, c);
        instance.adicionarAtribuicao(atribuicao);
        ListaAtribuicoes lista = new ListaAtribuicoes();
        lista.adicionarAtribuicao(atribuicao);
        boolean expResult = true;
        boolean result = instance.adicionharListaAtribuicoes(lista);
        assertEquals(expResult, result);
         
    }

}
