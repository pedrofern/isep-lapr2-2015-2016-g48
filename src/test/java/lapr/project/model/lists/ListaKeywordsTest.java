/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.List;
import lapr.project.model.Keyword;
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
public class ListaKeywordsTest {

    public ListaKeywordsTest() {
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
     * Test of obterKeyword method, of class ListaKeywords.
     */
    @Test
    public void testObterKeyword() {
        System.out.println("obterKeyword");
        int indice = 0;
        ListaKeywords instance = new ListaKeywords();
        ListaKeywords listaKeywords = new ListaKeywords();
        Keyword palavra = new Keyword("Produto");
        instance.adicionarKeyword(palavra);
        listaKeywords.adicionarKeyword(palavra);
        Keyword expResult = listaKeywords.obterKeyword(0);
        Keyword result = instance.obterKeyword(indice);
        assertEquals(expResult, result);

    }

    /**
     * Test of getArray method, of class ListaKeywords.
     */
    @Test
    public void testGetArray() {
        System.out.println("getArray");
        ListaKeywords instance = new ListaKeywords();
        ListaKeywords listaKeywords = new ListaKeywords();
        Keyword palavra = new Keyword("Produto");
        instance.adicionarKeyword(palavra);
        listaKeywords.adicionarKeyword(palavra);
        Keyword[] expResult = listaKeywords.getListaKeyword().toArray(new Keyword[listaKeywords.getListaKeyword().size()]);
        Keyword[] result = instance.getArray();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of getListaKeyword method, of class ListaKeywords.
     */
    @Test
    public void testGetListaKeyword() {
        System.out.println("getListaKeyword");
        ListaKeywords instance = new ListaKeywords();
        ListaKeywords listaKeywords = new ListaKeywords();
        Keyword palavra = new Keyword("Produto");
        instance.adicionarKeyword(palavra);
        listaKeywords.adicionarKeyword(palavra);
        List<Keyword> expResult = listaKeywords.getListaKeyword();
        List<Keyword> result = instance.getListaKeyword();
        assertEquals(expResult, result);

    }

    /**
     * Test of adicionarKeyword method, of class ListaKeywords.
     */
    @Test
    public void testAdicionarKeyword() {
        System.out.println("adicionarKeyword");
        ListaKeywords instance = new ListaKeywords();
        Keyword palavra = new Keyword("Produto");
        instance.adicionarKeyword(palavra);
        boolean expResult = false;
        boolean result = instance.adicionarKeyword(palavra);
        assertEquals(expResult, result);

    }

    /**
     * Test of removerKeyword method, of class ListaKeywords.
     */
    @Test
    public void testRemoverKeyword() {
        System.out.println("removerKeyword");
        ListaKeywords instance = new ListaKeywords();
        Keyword palavra = new Keyword("Produto");
        instance.adicionarKeyword(palavra);
        boolean expResult = true;
        boolean result = instance.removerKeyword(palavra);
        assertEquals(expResult, result);

    }

    /**
     * Test of tamanho method, of class ListaKeywords.
     */
    @Test
    public void testTamanho() {
        System.out.println("tamanho");
        ListaKeywords instance = new ListaKeywords();
        Keyword palavra = new Keyword("Produto");
        instance.adicionarKeyword(palavra);
        int expResult = 1;
        int result = instance.tamanho();
        assertEquals(expResult, result);
    }

    /**
     * Test of indiceDeKeyword method, of class ListaKeywords.
     */
    @Test
    public void testIndiceDeKeyword() {
        System.out.println("indiceDeKeyword");
        ListaKeywords instance = new ListaKeywords();
        Keyword palavra = new Keyword("Produto");
        instance.adicionarKeyword(palavra);
        int expResult = 0;
        int result = instance.indiceDeKeyword(palavra);
        assertEquals(expResult, result);

    }

    /**
     * Test of contem method, of class ListaKeywords.
     */
    @Test
    public void testContem() {
        System.out.println("contem");
        ListaKeywords instance = new ListaKeywords();
         ListaKeywords listaKeywords = new ListaKeywords();
        Keyword palavra = new Keyword("Produto");
         Keyword key= new Keyword("Produto");
        instance.adicionarKeyword(palavra);
        listaKeywords.adicionarKeyword(key);
        boolean expResult = listaKeywords.contem(key);
        boolean result = instance.contem(palavra);
        assertEquals(expResult, result);

    }

}
