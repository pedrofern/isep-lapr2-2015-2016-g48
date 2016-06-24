/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.List;
import lapr.project.model.Organizador;
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
public class ListaOrganizadoresTest {

    public ListaOrganizadoresTest() {
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
     * Test of getListaOrganizadores method, of class ListaOrganizadores.
     */
    @Test
    public void testGetListaOrganizadores() {
        System.out.println("getListaOrganizadores");
        ListaOrganizadores instance = new ListaOrganizadores();
        List<Organizador> expResult = instance.getListaOrganizadores();
        List<Organizador> result = instance.getListaOrganizadores();
        assertEquals(expResult, result);

    }

    /**
     * Test of addOrganizador method, of class ListaOrganizadores.
     */
    @Test
    public void testAddOrganizador() {
        System.out.println("addOrganizador");
        Organizador o = new Organizador(new Utilizador("teste", "teste", "teste", "teste"));
        ListaOrganizadores instance = new ListaOrganizadores();
        boolean expResult = true;
        boolean result = instance.addOrganizador(o);
        assertEquals(expResult, result);

    }


    /**
     * Test of hasUtilizador method, of class ListaOrganizadores.
     */
    @Test
    public void testHasUtilizador() {
        System.out.println("hasUtilizador");
        ListaOrganizadores instance = new ListaOrganizadores();
        instance.addOrganizador(new Organizador(new Utilizador("teste", "teste", "teste", "teste")));
        boolean expResult = true;
        boolean result = instance.hasUtilizador(new Utilizador("teste", "teste", "teste", "teste"));
        assertEquals(expResult, result);

    }

    /**
     * Test of removerUtilizador method, of class ListaOrganizadores.
     */
    @Test
    public void testRemoverUtilizador() {
        System.out.println("removerUtilizador");
        ListaOrganizadores instance = new ListaOrganizadores();
        Organizador o = new Organizador(new Utilizador("teste", "teste", "teste", "teste"));
        instance.addOrganizador(o);
        boolean expResult = true;
        boolean result = instance.removerUtilizador(o);
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class ListaOrganizadores.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ListaOrganizadores instance = new ListaOrganizadores();
        Organizador o = new Organizador(new Utilizador("teste", "teste", "teste", "teste"));
        instance.addOrganizador(o);
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);

    }

}
