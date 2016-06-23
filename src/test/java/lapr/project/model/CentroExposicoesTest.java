/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.model.lists.RegistoExposicoes;
import lapr.project.model.lists.RegistoMecanismosAtribuicao;
import lapr.project.model.lists.RegistoRecursos;
import lapr.project.model.lists.RegistoStands;
import lapr.project.model.lists.RegistoTipoConflitos;
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
public class CentroExposicoesTest {

    CentroExposicoes centro;

    public CentroExposicoesTest() {
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
     * Test of getRegistoUtilizadores method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoUtilizadores() {
        System.out.println("getRegistoUtilizadores");
        CentroExposicoes instance = new CentroExposicoes();
        RegistoUtilizadores expResult = instance.getRegistoUtilizadores();
        RegistoUtilizadores result = instance.getRegistoUtilizadores();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRegistoRecursos method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoRecursos() {
        System.out.println("getRegistoRecursos");
        CentroExposicoes instance = new CentroExposicoes();
        RegistoRecursos expResult = instance.getRegistoRecursos();
        RegistoRecursos result = instance.getRegistoRecursos();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRegistoExposicoes method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        CentroExposicoes instance = new CentroExposicoes();
        RegistoExposicoes expResult = instance.getRegistoExposicoes();
        RegistoExposicoes result = instance.getRegistoExposicoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRegistoStands method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoStands() {
        System.out.println("getRegistoStands");
        CentroExposicoes instance = new CentroExposicoes();
        RegistoStands expResult = instance.getRegistoStands();
        RegistoStands result = instance.getRegistoStands();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMecanismosAtribuicao method, of class CentroExposicoes.
     */
    @Test
    public void testGetMecanismosAtribuicao() {
        System.out.println("getMecanismosAtribuicao");
        CentroExposicoes instance = new CentroExposicoes();
        RegistoMecanismosAtribuicao expResult = instance.getMecanismosAtribuicao();
        RegistoMecanismosAtribuicao result = instance.getMecanismosAtribuicao();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRegistoTipoConflitos method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoTipoConflitos() {
        System.out.println("getRegistoTipoConflitos");
        CentroExposicoes instance = new CentroExposicoes();
        RegistoTipoConflitos expResult = instance.getRegistoTipoConflitos();
        RegistoTipoConflitos result = instance.getRegistoTipoConflitos();
        assertEquals(expResult, result);

    }

 
    /**
     * Test of toString method, of class CentroExposicoes.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CentroExposicoes instance = new CentroExposicoes();
        String expResult = "Empresa:" + "regUtilizadores=" + instance.getRegistoUtilizadores()
                + ", regExposicoes=" + instance.getRegistoExposicoes();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

}
