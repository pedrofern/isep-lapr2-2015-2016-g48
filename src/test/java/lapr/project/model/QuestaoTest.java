/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

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
public class QuestaoTest {
    
    public QuestaoTest() {
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
     * Test of setText method, of class Questao.
     */
    @Test
    public void testSetText() {
        System.out.println("setText");
        String result = "Pergunta";
        Questao instance = new Questao();
        instance.setText(result);
        String expResult=instance.getPergunta();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setPergunta method, of class Questao.
     */
    @Test
    public void testSetPergunta() {
        System.out.println("setPergunta");
        Criterio result = Criterio.ADEQUACAO_CANDIDATURA;
        Questao instance = new Questao();
        instance.setPergunta(result);
        Criterio expResult=result;
        assertEquals(expResult, result);
       
    }


    /**
     * Test of getPergunta method, of class Questao.
     */
    @Test
    public void testGetPergunta() {
        System.out.println("getPergunta");
        Questao instance = new Questao();
        String expResult = "Pergunta";
        instance.setText(expResult);
        String result = instance.getPergunta();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getResposta method, of class Questao.
     */
    @Test
    public void testGetResposta() {
        System.out.println("getResposta");
        Questao instance = new Questao();
        int expResult = 2;
        instance.setResposta(2);
        int result = instance.getResposta();
        assertEquals(expResult, result);
         
    }

    /**
     * Test of display method, of class Questao.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        Questao instance = new Questao();
        instance.setPergunta(Criterio.CONHECIMENTO);
        instance.setResposta(2);
        String expResult = instance.display();
        String result = instance.display();
        assertEquals(expResult, result);
         
    }
    
}
