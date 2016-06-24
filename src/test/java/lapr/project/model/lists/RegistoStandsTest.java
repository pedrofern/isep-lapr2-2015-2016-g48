/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import lapr.project.model.Stand;
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
public class RegistoStandsTest {

    public RegistoStandsTest() {
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
     * Test of obterStand method, of class RegistoStands.
     */
    @Test
    public void testObterStand() {
        System.out.println("obterStand");
        int indice = 0;
        Stand st = new Stand();
        st.setDados("Descrição", "45");
        RegistoStands instance = new RegistoStands();
        instance.adicionarStand(st);
        Stand expResult = instance.getListaStands().get(0);
        Stand result = instance.obterStand(indice);
        assertEquals(expResult, result);

    }

    /**
     * Test of getArray method, of class RegistoStands.
     */
    @Test
    public void testGetArray() {
        System.out.println("getArray");
        Stand st = new Stand();
        st.setDados("Descrição", "45");
        RegistoStands instance = new RegistoStands();
        instance.adicionarStand(st);
        Stand[] expResult = instance.getListaStands().toArray(new Stand[instance.getListaStands().size()]);
        Stand[] result = instance.getArray();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of getListaStands method, of class RegistoStands.
     */
    @Test
    public void testGetListaStands() {
        System.out.println("getListaStands");
        Stand st = new Stand();
        st.setDados("Descrição", "45");
        RegistoStands instance = new RegistoStands();
        instance.adicionarStand(st);
        ArrayList<Stand> expResult = instance.getListaStands();
        ArrayList<Stand> result = instance.getListaStands();
        assertEquals(expResult, result);

    }

    /**
     * Test of adicionarStand method, of class RegistoStands.
     */
    @Test
    public void testAdicionarStand() {
        System.out.println("adicionarStand");
        Stand stand = new Stand();
        stand.setDados("Descrição", "45");
        RegistoStands instance = new RegistoStands();
        boolean expResult = true;
        boolean result = instance.adicionarStand(stand);
        assertEquals(expResult, result);

    }


    /**
     * Test of removerStand method, of class RegistoStands.
     */
    @Test
    public void testRemoverStand() {
        System.out.println("removerStand");
        Stand stand = new Stand();
        stand.setDados("Descrição", "45");
        RegistoStands instance = new RegistoStands();
        instance.adicionarStand(stand);
        boolean expResult = true;
        boolean result = instance.removerStand(stand);
        assertEquals(expResult, result);

    }

    /**
     * Test of tamanho method, of class RegistoStands.
     */
    @Test
    public void testTamanho() {
        System.out.println("tamanho");
        Stand stand = new Stand();
        stand.setDados("Descrição", "45");
        RegistoStands instance = new RegistoStands();
        instance.adicionarStand(stand);
        int expResult = 1;
        int result = instance.tamanho();
        assertEquals(expResult, result);

    }

    /**
     * Test of indiceDeStand method, of class RegistoStands.
     */
    @Test
    public void testIndiceDeStand() {
        System.out.println("indiceDeStand");
        Stand stand = new Stand();
        stand.setDados("Descrição", "45");
        RegistoStands instance = new RegistoStands();
        instance.adicionarStand(stand);
        int expResult = 0;
        int result = instance.indiceDeStand(stand);
        assertEquals(expResult, result);

    }

    /**
     * Test of contem method, of class RegistoStands.
     */
    @Test
    public void testContem() {
        System.out.println("contem");
        Stand stand=new Stand();
        Stand stand1=new Stand();
        stand.setDados("Descrição", "45");
        stand1.setDados("Descrição", "45");
        RegistoStands instance = new RegistoStands();
        instance.adicionarStand(stand);
        boolean expResult = true;
        boolean result = instance.contem(stand);
        assertEquals(expResult, result);
         
    }

}
