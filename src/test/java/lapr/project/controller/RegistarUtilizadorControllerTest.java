/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistarUtilizadorControllerTest {
    CentroExposicoes ce;
     Utilizador u0, u1, u2, u3;
    
    public RegistarUtilizadorControllerTest() {
        ce = new CentroExposicoes();
        u0=new Utilizador("nome1", "mail1@isep.pt", "u0", true, 10);
        u1=new Utilizador("nome2", "mail2@isep.pt", "u1", true, 10);
        u2=new Utilizador("nome3", "mail3@isep.pt", "u2", true, 20);
        u3=new Utilizador("nome4", "mail4@isep.pt", "u3", true, 5);
        
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
     * Test of novoUtilizador method, of class RegistarUtilizadorController.
     */
    @Test
    public void testNovoUtilizador() {
        System.out.println("novoUtilizador");
        RegistarUtilizadorController instance = new RegistarUtilizadorController(ce);
        instance.novoUtilizador();

    }

    /**
     * Test of getUtilizador method, of class RegistarUtilizadorController.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        RegistarUtilizadorController instance = new RegistarUtilizadorController(ce);
        Utilizador expResult = instance.getUtilizador();
        Utilizador result = instance.getUtilizador();
        assertEquals(expResult, result);

    }

    /**
     * Test of setUtilizador method, of class RegistarUtilizadorController.
     */
    @Test
    public void testSetUtilizador() {
        System.out.println("setUtilizador");
        Utilizador user = u0;
        RegistarUtilizadorController instance = new RegistarUtilizadorController(ce);
        instance.setUtilizador(user);

    }
    
}
