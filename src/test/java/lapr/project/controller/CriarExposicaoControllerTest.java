/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.CentroExposicoes;
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
        int expResult = 1;
        
        CentroExposicoes ce=new CentroExposicoes();
        CriarExposicaoController teste=new CriarExposicaoController(ce);   
        
        teste.criarExposicao();
        teste.setDados("titulo", "desc", Data.dataAtual(), Data.dataAtual(),"local",Data.dataAtual(),Data.dataAtual(),Data.dataAtual(),Data.dataAtual(),Data.dataAtual(), Data.dataAtual(),Data.dataAtual(),Data.dataAtual());
        teste.registaExposicao();
        
        int result = ce.getRegistoExposicoes().countExposicoes();
       
        assertEquals(expResult, result);        
    }

    
}
