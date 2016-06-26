/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states.exposicao;

import lapr.project.model.Exposicao;
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
public class ExposicaoDemonstracaoSemFAETest {
    
     private static final String s1 = "19/11/2017", s2 = "20/11/2017", s3 = "11/11/2017", s4 = "12/11/2017", s5 = "15/11/2017",
            s6 = "16/11/2017", s7 = "13/11/2017", s8 = "17/11/2017", s9 = "18/11/2017", s10 = "14/11/2017";
    private static Data d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
    public ExposicaoDemonstracaoSemFAETest() {
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
     * Test of valida method, of class ExposicaoDemonstracaoSemFAE.
     */
    @Test
    public void testValida() throws Exception {
        System.out.println("valida");
        Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ExposicaoDemonstracaoSemFAE instance = new ExposicaoDemonstracaoSemFAE();
        exp.alterarEstado(new ExposicaoCriada());
        boolean expResult = true;
        boolean result = instance.valida(exp);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setExposicaoDemonstracaoSemFAE method, of class ExposicaoDemonstracaoSemFAE.
     */
    @Test
    public void testSetExposicaoDemonstracaoSemFAE() throws Exception {
        System.out.println("setExposicaoDemonstracaoSemFAE");
       Exposicao exp = new Exposicao();
        exp.setDadosPrincipais("Titulo", "Descrição", d1, d2, "Local", d3, d4);
        ExposicaoDemonstracaoSemFAE instance = new ExposicaoDemonstracaoSemFAE();
        exp.alterarEstado(new ExposicaoCriada());
        boolean expResult = true;
        boolean result = instance.setExposicaoDemonstracaoSemFAE(exp);
        assertEquals(expResult, result);
    }
    
}
