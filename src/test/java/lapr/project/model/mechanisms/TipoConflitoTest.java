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
public class TipoConflitoTest {

    public TipoConflitoTest() {
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
     * Test of getDescricao method, of class TipoConflito.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        TipoConflito instance = new TipoConflito();
        instance.setDescricao("Teste");
        String expResult = "Teste";
        String result = instance.getDescricao();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMecanismoDetecaoConflito method, of class TipoConflito.
     */
    @Test
    public void testGetMecanismoDetecaoConflito() {
        System.out.println("getMecanismoDetecaoConflito");
        TipoConflito instance = new TipoConflito();
        instance.setDescricao("Teste");
        MecanismoDetecaoConflito expResult = instance.getMecanismoDetecaoConflito();
        MecanismoDetecaoConflito result = instance.getMecanismoDetecaoConflito();
        assertEquals(expResult, result);

    }

    /**
     * Test of valida method, of class TipoConflito.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        TipoConflito instance = new TipoConflito();
        instance.setDescricao("Teste");
        instance.setMecanismoDetecaoConflito(new MecanismoDetecaoConflito());
        boolean expResult = true;
        boolean result = instance.valida();
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class TipoConflito.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TipoConflito instance = new TipoConflito();
        instance.setDescricao("Teste");
        instance.setMecanismoDetecaoConflito(new MecanismoDetecaoConflito());
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class TipoConflito.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        TipoConflito tipo = new TipoConflito();
        tipo.setDescricao("Teste");
        tipo.setMecanismoDetecaoConflito(new MecanismoDetecaoConflito());
        TipoConflito instance = new TipoConflito();
        instance.setDescricao("Teste1");
        instance.setMecanismoDetecaoConflito(new MecanismoDetecaoConflito());
        boolean expResult = false;
        boolean result = instance.equals(tipo);
        assertEquals(expResult, result);

    }

    /**
     * Test of hashCode method, of class TipoConflito.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        TipoConflito instance = new TipoConflito();
        instance.setDescricao("Teste");
        int expResult = 80699026;
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

}
