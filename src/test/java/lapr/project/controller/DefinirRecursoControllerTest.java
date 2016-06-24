/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Recurso;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.RegistoRecursos;
import lapr.project.utils.Data;
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
public class DefinirRecursoControllerTest {
    
     private static final String s1 = "19/11/2017", s2 = "20/11/2017", s3 = "11/11/2017", s4 = "12/11/2017", s5 = "15/11/2017",
            s6 = "16/11/2017", s7 = "13/11/2017", s8 = "17/11/2017", s9 = "18/11/2017", s10 = "14/11/2017";
    private static Data d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
    private CentroExposicoes ce;
    public DefinirRecursoControllerTest() {
    
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
     * Test of getRegistoRecursos method, of class DefinirRecursoController.
     */
    @Test
    public void testGetRegistoRecursos() {
        System.out.println("getRegistoRecursos");
        DefinirRecursoController instance = new DefinirRecursoController(ce);
        RegistoRecursos expResult = instance.getRegistoRecursos();
        RegistoRecursos result = instance.getRegistoRecursos();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getRecurso method, of class DefinirRecursoController.
     */
    @Test
    public void testGetRecurso() {
        System.out.println("getRecurso");
        DefinirRecursoController instance = new DefinirRecursoController(ce);
        instance.novoRecurso();
        instance.setRecurso("Teste");
        instance.adicionarRecurso();
        String expResult = instance.getRecurso();
        String result = instance.getRecurso();
        assertEquals(expResult, result);
       
    }


    /**
     * Test of novoRecurso method, of class DefinirRecursoController.
     */
    @Test
    public void testNovoRecurso() {
        System.out.println("novoRecurso");
        DefinirRecursoController instance = new DefinirRecursoController(ce);
        Recurso expResult = instance.novoRecurso();
        expResult.setDescricao("teste");
        Recurso result = instance.novoRecurso();
        result.setDescricao("Teste");
        assertEquals(expResult, result);
        
    }

    /**
     * Test of adicionarRecurso method, of class DefinirRecursoController.
     */
    @Test
    public void testAdicionarRecurso() {
        System.out.println("adicionarRecurso");
        DefinirRecursoController instance = new DefinirRecursoController(ce);
        instance.novoRecurso();
        instance.setRecurso("Teste");
        instance.adicionarRecurso();
        String expResult=instance.getRecurso();
        String result=instance.getRecurso();
        assertEquals(expResult, result);
    }
    
}
