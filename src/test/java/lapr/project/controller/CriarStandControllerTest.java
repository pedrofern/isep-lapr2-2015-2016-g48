/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Stand;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.RegistoStands;
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
public class CriarStandControllerTest {

    private CentroExposicoes ce;
    private Utilizador utilizador;

    public CriarStandControllerTest() {

        ce = new CentroExposicoes();
        utilizador = new Utilizador();
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
     * Test of getListaStands method, of class CriarStandController.
     */
    @Test
    public void testGetListaStands() {
        System.out.println("getListaStands");
        CriarStandController instance = new CriarStandController(ce);
        instance.novoStand();
        RegistoStands expResult = instance.getRegistoStands();
        RegistoStands result = instance.getRegistoStands();
        assertEquals(expResult, result);

    }

    /**
     * Test of getStand method, of class CriarStandController.
     */
    @Test
    public void testGetStand() {
        System.out.println("getStand");
        CriarStandController instance = new CriarStandController(ce);
        instance.novoStand();
        String expResult = instance.getStand();
        String result = instance.getStand();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRegistoStands method, of class CriarStandController.
     */
    @Test
    public void testGetRegistoStands() {
        System.out.println("getRegistoStands");
        CriarStandController instance = new CriarStandController(ce);
        RegistoStands expResult = instance.getRegistoStands();
        RegistoStands result = instance.getRegistoStands();
        assertEquals(expResult, result);

    }

    /**
     * Test of novoStand method, of class CriarStandController.
     */
    @Test
    public void testNovoStand() {
        System.out.println("novoStand");
        CriarStandController instance = new CriarStandController(ce);
        instance.novoStand();
        String expResult = instance.getStand();
        String result = instance.getStand();
        assertEquals(expResult, result);

    }

}
