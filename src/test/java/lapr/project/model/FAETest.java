/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.List;
import lapr.project.controller.DefinirFAEController;
import lapr.project.model.lists.*;
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

   
    private Utilizador u = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", true, 15);

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
        FAE instance = new FAE();
        instance.setUtilizador(u);
        assertEquals(u, instance.getUtilizador());
    }

    /**
     * Test of validaMenbroFAE method, of class FAE.
     */
    @Test
    public void testValidaMenbroFAE() {
        System.out.println("validaMenbroFAE");
        FAE instance = new FAE(u);
        boolean expResult = true;
        boolean result = instance.validaMenbroFAE();
        assertEquals(expResult, result);

    }

    /**
     * Test of getNome method, of class FAE.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        FAE instance = new FAE(u);
        String expResult = u.getNome();
        String result = instance.getNome();
        assertEquals(expResult, result);

    }

    /**
     * Test of getUtilizador method, of class FAE.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        FAE instance = new FAE();
        instance.setUtilizador(u);
        Utilizador expResult = u;
        Utilizador result = instance.getUtilizador();
        assertEquals(expResult, result);

    }


    /**
     * Test of toString method, of class FAE.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FAE fae = new FAE(u);
        FAE instance = new FAE(u);
        String expResult = fae.toString();
        String result = instance.toString();
        assertEquals(expResult, result);

    }
//
//    /**
//     * Test of validaAvaliacao method, of class FAE.
//     */
//    @Test
//    public void testValidaAvaliacao() {
//        System.out.println("validaAvaliacao");
//        Avaliacao ava = new Avaliacao(true, "Resposta");
//        FAE instance = new FAE(u);
//        boolean expResult = true;
//        boolean result = instance.validaAvaliacao(ava);
//        assertEquals(expResult, result);
//
//    }



    /**
     * Test of getUsername method, of class FAE.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        FAE instance = new FAE(u);
        String expResult = u.getUsername();
        String result = instance.getUsername();
        assertEquals(expResult, result);

    }

    /**
     * Test of getEmail method, of class FAE.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        FAE instance = new FAE(u);
        String expResult = u.getEmail();
        String result = instance.getEmail();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class FAE.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        FAE instance = new FAE(u);
        FAE f = new FAE(u);
        boolean expResult = true;
        boolean result = instance.equals(f);
        assertEquals(expResult, result);

    }

    /**
     * Test of hashCode method, of class FAE.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        FAE instance = new FAE(u);
        int expResult = 217;
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of isUtilizador method, of class FAE.
     */
    @Test
    public void testIsUtilizador() {
        System.out.println("isUtilizador");
        FAE instance = new FAE();
        FAE fae = new FAE();
        boolean expResult = fae.isUtilizador(u);
        boolean result = instance.isUtilizador(u);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTempoServico method, of class FAE.
     */
    @Test
    public void testGetTempoServico() {
        System.out.println("getTempoServico");
        FAE instance = new FAE(u);
        int expResult = 15;
        int result = instance.getTempoServico();
        assertEquals(expResult, result);

    }

    /**
     * Test of compareTo method, of class FAE.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        FAE instance = new FAE(u);
        FAE fae = new FAE(u);
        int expResult = 0;
        int result = instance.compareTo(fae);
        assertEquals(expResult, result);

    }

}
