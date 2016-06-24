/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.List;
import lapr.project.model.Demonstracao;
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
public class ListaDemonstracoesTest {
    
    public ListaDemonstracoesTest() {
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
     * Test of obterDemonstracao method, of class ListaDemonstracoes.
     */
    @Test
    public void testObterDemonstracao() throws Exception {
        System.out.println("obterDemonstracao");
        int indice = 0;
        ListaDemonstracoes instance = new ListaDemonstracoes();
        Demonstracao d=new Demonstracao();
        d.setDados("Tema", "Descrição");
        instance.adicionarDemonstracao(d);
        Demonstracao expResult =instance.obterDemonstracao(indice);
        Demonstracao result = instance.obterDemonstracao(indice);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getArray method, of class ListaDemonstracoes.
     */
    @Test
    public void testGetArray() throws Exception {
        System.out.println("getArray");
        ListaDemonstracoes instance = new ListaDemonstracoes();
        Demonstracao d=new Demonstracao();
        d.setDados("Tema", "Descrição");
        instance.adicionarDemonstracao(d);
        Demonstracao[] expResult = instance.getListaDemonstracoes().toArray(new Demonstracao[instance.getListaDemonstracoes().size()]);
        Demonstracao[] result = instance.getArray();
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of getListaDemonstracoes method, of class ListaDemonstracoes.
     */
    @Test
    public void testGetListaDemonstracoes() throws Exception {
        System.out.println("getListaDemonstracoes");
        ListaDemonstracoes instance = new ListaDemonstracoes();
        Demonstracao d=new Demonstracao();
        d.setDados("Tema", "Descrição");
        List<Demonstracao> expResult = instance.getListaDemonstracoes();
        expResult.add(d);
        List<Demonstracao> result = instance.getListaDemonstracoes();
        result.add(d);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of adicionarDemonstracao method, of class ListaDemonstracoes.
     */
    @Test
    public void testAdicionarDemonstracao() throws Exception {
        System.out.println("adicionarDemonstracao");
        
        ListaDemonstracoes instance = new ListaDemonstracoes();
        Demonstracao d=new Demonstracao();
        d.setDados("Tema", "Descrição");
        boolean expResult = true;
        boolean result = instance.adicionarDemonstracao(d);
        assertEquals(expResult, result);
         
    }

    /**
     * Test of removerDemonstracao method, of class ListaDemonstracoes.
     */
    @Test
    public void testRemoverDemonstracao() throws Exception {
        System.out.println("removerDemonstracao");
        ListaDemonstracoes instance = new ListaDemonstracoes();
        Demonstracao d=new Demonstracao();
        d.setDados("Tema", "Descrição");
        instance.adicionarDemonstracao(d);
        boolean expResult = true;
        boolean result = instance.removerDemonstracao(d);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of tamanho method, of class ListaDemonstracoes.
     */
    @Test
    public void testTamanho() throws Exception {
        System.out.println("tamanho");
        ListaDemonstracoes instance = new ListaDemonstracoes();
        Demonstracao d=new Demonstracao();
        d.setDados("Tema", "Descrição");
        instance.adicionarDemonstracao(d);
        int expResult = 1;
        int result = instance.tamanho();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of indiceDeDemonstracao method, of class ListaDemonstracoes.
     */
    @Test
    public void testIndiceDeDemonstracao() throws Exception {
        System.out.println("indiceDeDemonstracao");
        ListaDemonstracoes instance = new ListaDemonstracoes();
        Demonstracao d=new Demonstracao();
        d.setDados("Tema", "Descrição");
        instance.adicionarDemonstracao(d);
        int expResult = 0;
        int result = instance.indiceDeDemonstracao(d);
        assertEquals(expResult, result);
         
    }

    /**
     * Test of contem method, of class ListaDemonstracoes.
     */
    @Test
    public void testContem() throws Exception {
        System.out.println("contem");
        ListaDemonstracoes instance = new ListaDemonstracoes();
        Demonstracao d=new Demonstracao();
        d.setDados("Tema", "Descrição");
        instance.adicionarDemonstracao(d);
        boolean expResult = true;
        boolean result = instance.contem(d);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toStringCompleto method, of class ListaDemonstracoes.
     */
    @Test
    public void testToStringCompleto() throws Exception {
        System.out.println("toStringCompleto");
        ListaDemonstracoes instance = new ListaDemonstracoes();
        Demonstracao d=new Demonstracao();
        d.setDados("Tema", "Descrição");
        instance.adicionarDemonstracao(d);
        String expResult = instance.toStringCompleto();
        String result = instance.toStringCompleto();
        assertEquals(expResult, result);
       
    }
    
}
