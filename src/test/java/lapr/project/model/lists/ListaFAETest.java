/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
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
public class ListaFAETest {

    public ListaFAETest() {
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
     * Test of getListaFAE method, of class ListaFAE.
     */
    @Test
    public void testGetListaFAE() {
        System.out.println("getListaFAE");
        ListaFAE instance = new ListaFAE();
        Utilizador ut2 = new Utilizador("Ana Silva", "1130155@isep.ipp.pt", "Gestor", "gestor", false, 10);
        Utilizador ut3 = new Utilizador("Diana Silva", "1151088@isep.ipp.pt", "Organizador",  "admin",false, 8);
        Utilizador ut4 = new Utilizador("Eduângelo Ferreira", "1151094@isep.ipp.pt", "Organizador+Fae",  "admin",false, 6);
        Utilizador ut5 = new Utilizador("Pedro Fernandes", "1060503@isep.ipp.pt", "Fae", "admin", false, 3);
        FAE f1 = new FAE(ut2);
        FAE f2 = new FAE(ut3);
        FAE f4 = new FAE(ut4);
        FAE f5 = new FAE(ut5);
        List<FAE> expResult = new ArrayList<>();
        List<FAE> result = instance.getListaFAE();
        expResult.add(f1);
        expResult.add(f2);
        expResult.add(f4);
        expResult.add(f5);
        result.add(f1);
        result.add(f2);
        result.add(f4);
        result.add(f5);

        assertEquals(expResult, result);

    }

    /**
     * Test of addFAE method, of class ListaFAE.
     */
    @Test
    public void testCriaFAE() {
        System.out.println("criaFAE");
        Utilizador u = new Utilizador("Ana Silva", "1130155@isep.ipp.pt", "Gestor",  "admin",false, 10);
        ListaFAE instance = new ListaFAE();
        FAE expResult = new FAE(u);
        FAE result = instance.addFAE(u);
        assertEquals(expResult, result);

    }

    /**
     * Test of hasUtilizador method, of class ListaFAE.
     */
    @Test
    public void testHasUtilizador() {
        System.out.println("hasUtilizador");
        Utilizador u = new Utilizador("Ana Silva", "1130155@isep.ipp.pt", "Gestor", "admin", false, 10);
        ListaFAE instance = new ListaFAE();
        FAE fae = new FAE(u);
        instance.addFAE(fae);
        boolean expResult = true;
        boolean result = instance.hasUtilizador(u);
        assertEquals(expResult, result);

    }

    /**
     * Test of removerFAE method, of class ListaFAE.
     */
    @Test
    public void testRemoverFAE() {
        System.out.println("removerFAE");
        Utilizador u = new Utilizador("Ana Silva", "1130155@isep.ipp.pt", "Gestor", "admin", false, 10);
        ListaFAE instance = new ListaFAE();
        FAE fae = new FAE(u);
        instance.addFAE(fae);
        boolean expResult = true;
        boolean result = instance.removerFAE(fae);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ListaFAE.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ListaFAE instance = new ListaFAE();
        String expResult = "ListaFAE:" + "listaFAE=" + instance.getListaFAE();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasFAE method, of class ListaFAE.
     */
    @Test
    public void testHasFAE() {
        System.out.println("hasFAE");
        Utilizador u = new Utilizador("Ana Silva", "1130155@isep.ipp.pt", "Gestor", "admin", false, 10);
        ListaFAE instance = new ListaFAE();
        FAE fae = new FAE(u);
        instance.addFAE(fae);
        boolean expResult = true;
        boolean result = instance.hasFAE(fae);
        assertEquals(expResult, result);

    }

    /**
     * Test of addFAE method, of class ListaFAE.
     */
    @Test
    public void testAddFAE() {
        System.out.println("addFAE");
        Utilizador u = new Utilizador("Ana Silva", "1130155@isep.ipp.pt", "Gestor", "admin", false, 10);
        ListaFAE instance = new ListaFAE();
        FAE fae = new FAE(u);
        boolean expResult = true;
        boolean result = instance.addFAE(fae);
        assertEquals(expResult, result);

    }

    /**
     * Test of registaFAE method, of class ListaFAE.
     */
    @Test
    public void testRegistaFAE() {
        System.out.println("registaFAE");
        Utilizador u = new Utilizador("Ana Silva", "1130155@isep.ipp.pt", "Gestor", "admin", false, 10);
        ListaFAE instance = new ListaFAE();
        FAE fae = new FAE(u);
        instance.addFAE(fae);
        boolean expResult = true;
        boolean result = instance.registaFAE(fae);
        assertEquals(expResult, result);

    }

    /**
     * Test of toStringCompleto method, of class ListaFAE.
     */
    @Test
    public void testToStringCompleto() {
        System.out.println("toStringCompleto");
        ListaFAE instance = new ListaFAE();
        ListaFAE lista = new ListaFAE();
        Utilizador utilizador = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin",  "admin",true, 15);
        FAE fae = new FAE(utilizador);
        instance.getListaFAE().add(fae);
        lista.getListaFAE().add(fae);
        String expResult = lista.toStringCompleto();
        String result = instance.toStringCompleto();
        assertEquals(expResult, result);

    }

}
