/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Produto;
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
public class ListaProdutoTest {

    public ListaProdutoTest() {
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
     * Test of obterProduto method, of class ListaProduto.
     */
    @Test
    public void testObterProduto() {
        System.out.println("obterProduto");
        int indice = 0;
        ListaProduto instance = new ListaProduto();
        ListaProduto listaProduto = new ListaProduto();
        Produto p = new Produto("Mesa");
        Produto p2 = new Produto("Mesa");
        listaProduto.adicionarProduto(p2);
        instance.adicionarProduto(p);
        Produto expResult = listaProduto.obterProduto(0);
        Produto result = instance.obterProduto(indice);
        assertEquals(expResult, result);

    }

    /**
     * Test of getArray method, of class ListaProduto.
     */
    @Test
    public void testGetArray() {
        System.out.println("getArray");
        ListaProduto instance = new ListaProduto();
        List<Produto> listaProduto = new ArrayList<>();
        Produto p = new Produto("Mesa");
        Produto p2 = new Produto("Mesa");
        listaProduto.add(p2);
        listaProduto.add(p);
        instance.getListaProduto().add(p);
        instance.getListaProduto().add(p2);
        Produto[] expResult = listaProduto.toArray(new Produto[listaProduto.size()]);
        Produto[] result = instance.getArray();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of getListaProduto method, of class ListaProduto.
     */
    @Test
    public void testGetListaProduto() {
        System.out.println("getListaProduto");
        ListaProduto instance = new ListaProduto();
        Produto p1 = new Produto("Cadeira");
        Produto p2 = new Produto("Mesa");
        Produto p3 = new Produto("Mouse");
        Produto p4 = new Produto("Caneta");
        List<Produto> expResult = new ArrayList<>();
        expResult.add(p1);
        expResult.add(p2);
        expResult.add(p3);
        expResult.add(p4);
        List<Produto> result = instance.getListaProduto();
        result.add(p1);
        result.add(p2);
        result.add(p3);
        result.add(p4);

        assertEquals(expResult, result);

    }

    /**
     * Test of adicionarProduto method, of class ListaProduto.
     */
    @Test
    public void testAdicionarProduto() {
        System.out.println("adicionarProduto");
        Produto produto = new Produto("Cadeira");
        ListaProduto instance = new ListaProduto();
        boolean expResult = true;
        boolean result = instance.adicionarProduto(produto);
        assertEquals(expResult, result);

    }

    /**
     * Test of removerProduto method, of class ListaProduto.
     */
    @Test
    public void testRemoverProduto() {
        System.out.println("removerProduto");
        Produto produto = new Produto("Cadeira");
        ListaProduto instance = new ListaProduto();
        instance.adicionarProduto(produto);
        boolean expResult = true;
        boolean result = instance.removerProduto(produto);
        assertEquals(expResult, result);

    }

    /**
     * Test of tamanho method, of class ListaProduto.
     */
    @Test
    public void testTamanho() {
        System.out.println("tamanho");
        Produto p1 = new Produto("Cadeira");
        Produto p2 = new Produto("Mesa");
        Produto p3 = new Produto("Mouse");
        Produto p4 = new Produto("Caneta");
        List<Produto> listaProduto = new ArrayList<>();
        ListaProduto instance = new ListaProduto();
        listaProduto.add(p1);
        listaProduto.add(p2);
        listaProduto.add(p3);
        listaProduto.add(p4);
        instance.adicionarProduto(p1);
        instance.adicionarProduto(p2);
        instance.adicionarProduto(p3);
        instance.adicionarProduto(p4);
        int expResult = 4;
        int result = instance.tamanho();
        assertEquals(expResult, result);

    }

    /**
     * Test of indiceDeProduto method, of class ListaProduto.
     */
    @Test
    public void testIndiceDeProduto() {
        System.out.println("indiceDeProduto");
        Produto produto = new Produto("Cadeira");
        List<Produto> listaProduto = new ArrayList<>();
        ListaProduto instance = new ListaProduto();
        listaProduto.add(produto);
        int expResult = listaProduto.indexOf(0);
        int result = instance.indiceDeProduto(produto);
        assertEquals(expResult, result);

    }

    /**
     * Test of contem method, of class ListaProduto.
     */
    @Test
    public void testContem() {
        System.out.println("contem");
        Produto produto = new Produto("Cadeira");

        List<Produto> listaProduto = new ArrayList<>();
        ListaProduto instance = new ListaProduto();
        listaProduto.add(produto);
        instance.adicionarProduto(produto);
        boolean expResult = true;
        boolean result = instance.contem(produto);
        assertEquals(expResult, result);

    }

}
