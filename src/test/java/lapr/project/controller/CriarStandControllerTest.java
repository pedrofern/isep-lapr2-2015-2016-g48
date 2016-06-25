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
     * Test of registaStand method, of class CriarStandController.
     */
    @Test
    public void testRegistaStand() {
        System.out.println("registaStand");
        String descricao = "teste";
        String area = "teste";
        CriarStandController instance = new CriarStandController(ce);
        instance.novoStand();
        Stand expResult = instance.registaStand(descricao, area);
        Stand result = instance.registaStand(descricao, area);
        assertEquals(expResult, result);

    }

    /**
     * Test of setDescricao method, of class CriarStandController.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String result = "teste";
        CriarStandController instance = new CriarStandController(ce);
        instance.novoStand();
        instance.setDescricao(result);
        String expResult=instance.getStand().getDescricao();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getListaStands method, of class CriarStandController.
     */
    @Test
    public void testGetListaStands() {
        System.out.println("getListaStands");
        CriarStandController instance = new CriarStandController(ce);
        instance.novoStand();
        RegistoStands expResult = instance.getListaStands();
        RegistoStands result = instance.getListaStands();
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
        Stand expResult = instance.getStand();
        Stand result = instance.getStand();
        assertEquals(expResult, result);
        
    }

}
