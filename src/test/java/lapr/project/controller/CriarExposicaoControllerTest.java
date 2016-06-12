/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Exposicao;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.RegistoExposicoes;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.utils.Data;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diana
 */
public class CriarExposicaoControllerTest {
    
    public CriarExposicaoControllerTest() {
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
     * Test of registaExposicao method, of class CriarExposicaoController.
     */
    @Test
    public void testRegistaExposicao() {
        System.out.println("registaExposicao");
        CriarExposicaoController instance = null;
        boolean expResult = true;
        boolean result = instance.registaExposicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
        
        
    }

    /**
     * Test of validaExposicao method, of class CriarExposicaoController.
     */
    @Test
    public void testValidaExposicao() {
        System.out.println("validaExposicao");
        CriarExposicaoController instance = null;
        boolean expResult = false;
        boolean result = instance.validaExposicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExposicaoString method, of class CriarExposicaoController.
     */
    @Test
    public void testGetExposicaoString() {
        System.out.println("getExposicaoString");
        CriarExposicaoController instance = null;
        String expResult = "";
        String result = instance.getExposicaoString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTimer method, of class CriarExposicaoController.
     */
    @Test
    public void testAddTimer() throws Exception {
        System.out.println("addTimer");
        CriarExposicaoController instance = null;
        instance.addTimer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
