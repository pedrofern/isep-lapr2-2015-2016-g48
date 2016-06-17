/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.List;
import lapr.project.controller.DefinirFAEController;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.RegistoUtilizadores;
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
public class FAETest {
    
    private DefinirFAEController controller;
    private ListaFAE listaFAE;
    private Exposicao exposicao;
    private RegistoUtilizadores utilizador;
    public FAETest() {
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
     * Test of setUtilizador method, of class FAE.
     */
    @Test
    public void testSetUtilizador() {
        System.out.println("setUtilizador");
        Utilizador u = null;
        FAE instance = new FAE();
        instance.setUtilizador(u);
        assertEquals(utilizador.getListaUtilizadores().get(0), u);
    }

    /**
     * Test of validaMenbroFAE method, of class FAE.
     */
    @Test
    public void testValidaMenbroFAE() {
        System.out.println("validaMenbroFAE");
        FAE instance = new FAE();
        boolean expResult = false;
        boolean result = instance.validaMenbroFAE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valida method, of class FAE.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        FAE instance = new FAE();
        boolean expResult = false;
        boolean result = instance.valida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class FAE.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        FAE instance = new FAE();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUtilizador method, of class FAE.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        FAE instance = new FAE();
        Utilizador expResult = null;
        Utilizador result = instance.getUtilizador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumeroFAEs method, of class FAE.
     */
    @Test
    public void testGetNumeroFAEs() {
        System.out.println("getNumeroFAEs");
        int expResult = 0;
        int result = FAE.getNumeroFAEs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class FAE.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FAE instance = new FAE();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaAvaliacao method, of class FAE.
     */
    @Test
    public void testValidaAvaliacao() {
        System.out.println("validaAvaliacao");
        Avaliacao ava = null;
        FAE instance = new FAE();
        boolean expResult = false;
        boolean result = instance.validaAvaliacao(ava);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of novaAvaliacao method, of class FAE.
     */
    @Test
    public void testNovaAvaliacao() {
        System.out.println("novaAvaliacao");
        FAE instance = new FAE();
        Avaliacao expResult = null;
        Avaliacao result = instance.novaAvaliacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registaAvaliacao method, of class FAE.
     */
    @Test
    public void testRegistaAvaliacao() {
        System.out.println("registaAvaliacao");
        Avaliacao ava = null;
        FAE instance = new FAE();
        boolean expResult = false;
        boolean result = instance.registaAvaliacao(ava);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class FAE.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        FAE instance = new FAE();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class FAE.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        FAE instance = new FAE();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaFAEDuplicado method, of class FAE.
     */
    @Test
    public void testValidaFAEDuplicado() {
        System.out.println("validaFAEDuplicado");
        List<FAE> listaFAE = null;
        FAE instance = new FAE();
        boolean expResult = false;
        boolean result = instance.validaFAEDuplicado(listaFAE);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class FAE.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = null;
        FAE instance = new FAE();
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class FAE.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        FAE instance = new FAE();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaFAE method, of class FAE.
     */
    @Test
    public void testGetListaFAE() {
        System.out.println("getListaFAE");
        FAE instance = new FAE();
        List<FAE> expResult = null;
        List<FAE> result = instance.getListaFAE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isUtilizador method, of class FAE.
     */
    @Test
    public void testIsUtilizador() {
        System.out.println("isUtilizador");
        Utilizador u = null;
        FAE instance = new FAE();
        boolean expResult = false;
        boolean result = instance.isUtilizador(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTempoServico method, of class FAE.
     */
    @Test
    public void testGetTempoServico() {
        System.out.println("getTempoServico");
        FAE instance = new FAE();
        int expResult = 0;
        int result = instance.getTempoServico();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class FAE.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        FAE o = null;
        FAE instance = new FAE();
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
