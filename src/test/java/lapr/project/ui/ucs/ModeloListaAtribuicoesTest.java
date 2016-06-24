/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import lapr.project.model.Atribuicao;
import lapr.project.model.Candidatura;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaAtribuicoes;
import lapr.project.model.mechanisms.MecanismoAtribuicao;
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
public class ModeloListaAtribuicoesTest {
    
    private ListaAtribuicoes lista;
    public ModeloListaAtribuicoesTest() {
        
        lista=new ListaAtribuicoes();
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
     * Test of getAtribuicoes method, of class ModeloListaAtribuicoes.
     */
    @Test
    public void testGetAtribuicoes() {
        System.out.println("getAtribuicoes");
        ModeloListaAtribuicoes instance = new ModeloListaAtribuicoes(lista);
        ListaAtribuicoes expResult = instance.getAtribuicoes();
        ListaAtribuicoes result = instance.getAtribuicoes();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getSize method, of class ModeloListaAtribuicoes.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        ModeloListaAtribuicoes instance = new ModeloListaAtribuicoes(lista);
        FAE fae=new FAE(new Utilizador("Teste", "Teste", "Teste", "Teste"));
        Candidatura can=new Candidatura("Teste", "Teste", 123456789, 888, 888);
        instance.addElement(new Atribuicao(fae, can));
        int expResult = 1;
        int result = instance.getSize();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getElementAt method, of class ModeloListaAtribuicoes.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int index = 0;
        ModeloListaAtribuicoes instance = new ModeloListaAtribuicoes(lista);
        FAE fae=new FAE(new Utilizador("Teste", "Teste", "Teste", "Teste"));
        Candidatura can=new Candidatura("Teste", "Teste", 123456789, 888, 888);
        instance.addElement(new Atribuicao(fae, can));
        Object expResult = instance.getElementAt(index);
        Object result = instance.getElementAt(index);
        assertEquals(expResult, result);
         
    }


    /**
     * Test of addAtribuicoesGeradas method, of class ModeloListaAtribuicoes.
     */
    @Test
    public void testAddAtribuicoesGeradas() {
        System.out.println("addAtribuicoesGeradas");
        ModeloListaAtribuicoes instance = new ModeloListaAtribuicoes(lista);
        FAE fae=new FAE(new Utilizador("Teste", "Teste", "Teste", "Teste"));
        Candidatura can=new Candidatura("Teste", "Teste", 123456789, 888, 888);
        instance.addElement(new Atribuicao(fae, can));
        boolean expResult = true;
        boolean result = instance.addAtribuicoesGeradas(lista);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of addElement method, of class ModeloListaAtribuicoes.
     */
    @Test
    public void testAddElement() {
        System.out.println("addElement");
        ModeloListaAtribuicoes instance = new ModeloListaAtribuicoes(lista);
        FAE fae=new FAE(new Utilizador("Teste", "Teste", "Teste", "Teste"));
        Candidatura can=new Candidatura("Teste", "Teste", 123456789, 888, 888);
        boolean expResult = true;
        boolean result =   instance.addElement(new Atribuicao(fae, can));
        assertEquals(expResult, result);
         
    }

    /**
     * Test of removeElement method, of class ModeloListaAtribuicoes.
     */
    @Test
    public void testRemoveElement() {
        System.out.println("removeElement");
        ModeloListaAtribuicoes instance = new ModeloListaAtribuicoes(lista);
        FAE fae=new FAE(new Utilizador("Teste", "Teste", "Teste", "Teste"));
        Candidatura can=new Candidatura("Teste", "Teste", 123456789, 888, 888);
        Atribuicao atribuicao=new Atribuicao(fae, can);
        instance.addElement(atribuicao);
        boolean expResult = true;
        boolean result = instance.removeElement(atribuicao);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of removeAll method, of class ModeloListaAtribuicoes.
     */
    @Test
    public void testRemoveAll() {
        System.out.println("removeAll");
        ModeloListaAtribuicoes instance = new ModeloListaAtribuicoes(lista);
        FAE fae=new FAE(new Utilizador("Teste", "Teste", "Teste", "Teste"));
        Candidatura can=new Candidatura("Teste", "Teste", 123456789, 888, 888);
        Atribuicao atribuicao=new Atribuicao(fae, can);
        instance.addElement(atribuicao);
        boolean expResult = true;
        boolean result = instance.removeAll();
        assertEquals(expResult, result);
         
    }
    
}
