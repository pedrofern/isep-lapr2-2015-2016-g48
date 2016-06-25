/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.mechanisms;

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
public class MecanismoAtribuicaoTest {
    
    public MecanismoAtribuicaoTest() {
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
     * Test of atribui method, of class MecanismoAtribuicao.
     */
    @Test
    public void testAtribui() {
        System.out.println("atribui");
        MecanismoAtribuicao instance = new MecanismoAtribuicaoImpl();
        boolean expResult = false;
        boolean result = instance.atribui();
        assertEquals(expResult, result);
         
    }

    public class MecanismoAtribuicaoImpl implements MecanismoAtribuicao {

        public boolean atribui() {
            return false;
        }
    }
    
}
