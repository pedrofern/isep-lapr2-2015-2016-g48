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
 * @author Edu
 */
public class AlterarUtilizadorControllerTest {

    private CentroExposicoes ce;
    public AlterarUtilizadorControllerTest() {

        ce = new CentroExposicoes();
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
     * Test of alteraDados method, of class AlterarUtilizadorController.
     */
    @Test
    public void testAlteraDados() throws Exception {
        System.out.println("alteraDados");
        String strNome = "teste";
        String strUsername = "teste";
        String strPwd = "teste";
        String strEmail = "1151094@isep.ipp.pt";
        AlterarUtilizadorController instance = new AlterarUtilizadorController(ce);
         Utilizador ut1 = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", true, 15);
        instance.setUtilizador(ut1);
        boolean expResult = true;
        boolean result = instance.alteraDados(strNome, strUsername, strPwd, strEmail);
        assertEquals(expResult, result);
       
    }

}
