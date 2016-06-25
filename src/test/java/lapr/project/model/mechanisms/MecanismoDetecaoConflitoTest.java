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
public class MecanismoDetecaoConflitoTest {
    
    public MecanismoDetecaoConflitoTest() {
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
     * Test of detetarConflito method, of class MecanismoDetecaoConflito.
     */
    @Test
    public void testDetetarConflito() {
        System.out.println("detetarConflito");
        MecanismoDetecaoConflito instance = new MecanismoDetecaoConflito();
        boolean expResult = true;
        boolean result = instance.detetarConflito();
        assertEquals(expResult, result);
      
    }
    
}
