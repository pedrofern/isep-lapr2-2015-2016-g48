/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Candidatura;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro Fernandes
 */
public class ListaCandidaturasTest {
    
    Candidatura c;
    Candidatura c2;
    ListaCandidaturas listaCandidaturas;
    
    public ListaCandidaturasTest() {
        listaCandidaturas = new ListaCandidaturas();
        c= new Candidatura();        
        listaCandidaturas.addCandidatura(c);
        
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
     * Test of registaCandidaturas method, of class ListaCandidaturas.
     */
    @Test
    public void testRegistaCandidaturas() {
        System.out.println("registaCandidaturas");
        Candidatura c = new Candidatura();
        ListaCandidaturas instance = new ListaCandidaturas();
        ListaCandidaturas teste = new ListaCandidaturas();
        boolean expResult = teste.registaCandidaturas(c);
        boolean result = instance.registaCandidaturas(c);
        assertEquals(expResult, result);

    }

    /**
     * Test of addCandidatura method, of class ListaCandidaturas.
     */
    @Test
    public void testAddCandidatura() {
        System.out.println("addCandidatura");
        Candidatura c = new Candidatura();
        ListaCandidaturas instance = new ListaCandidaturas();
        boolean expResult = true;
        boolean result = instance.addCandidatura(c);
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaCandidaturas method, of class ListaCandidaturas.
     */
    @Test
    public void testGetListaCandidaturas() {
        System.out.println("getListaCandidaturas");
        ListaCandidaturas instance = new ListaCandidaturas();
        List<Candidatura> lista = new ArrayList<>();
        List<Candidatura> expResult = lista;
        List<Candidatura> result = instance.getListaCandidaturas();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCandidaturaByNomeEmpresa method, of class ListaCandidaturas.
     */
    @Test
    public void testGetCandidaturaByNomeEmpresa() {
        System.out.println("getCandidaturaByNomeEmpresa");
        String strNomeEmpresa = "";
        ListaCandidaturas instance = new ListaCandidaturas();
        ListaCandidaturas teste = new ListaCandidaturas();
        Candidatura expResult = teste.getCandidaturaByNomeEmpresa(strNomeEmpresa);
        Candidatura result = instance.getCandidaturaByNomeEmpresa(strNomeEmpresa);
        assertEquals(expResult, result);

    }

    /**
     * Test of alteraCandidatura method, of class ListaCandidaturas.
     */
    @Test
    public void testAlteraCandidatura() {
        System.out.println("alteraCandidatura");
        Candidatura cOriginal = new Candidatura();
        Candidatura cClone =  new Candidatura();
        ListaCandidaturas instance = new ListaCandidaturas();
        ListaCandidaturas teste = new ListaCandidaturas();
        boolean expResult = teste.alteraCandidatura(cClone, cOriginal);
        boolean result = instance.alteraCandidatura(cOriginal, cClone);
        assertEquals(expResult, result);

    }

    /**
     * Test of getCandidaturaInfo method, of class ListaCandidaturas.
     */
    @Test
    public void testGetCandidaturaInfo() {
        System.out.println("getCandidaturaInfo");
        String cNomeEmpresa = "";
        ListaCandidaturas instance = new ListaCandidaturas();
        ListaCandidaturas teste = new ListaCandidaturas();
        Candidatura expResult = teste.getCandidaturaInfo(cNomeEmpresa);
        Candidatura result = instance.getCandidaturaInfo(cNomeEmpresa);
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class ListaCandidaturas.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ListaCandidaturas instance = new ListaCandidaturas();
        ListaCandidaturas lista = new ListaCandidaturas();
        Candidatura cc= new Candidatura();
        lista.addCandidatura(c);
        instance.addCandidatura(c);
        String expResult = lista.toString();
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of getArray method, of class ListaCandidaturas.
     */
    @Test
    public void testGetArray() {
        System.out.println("getArray");
        ListaCandidaturas instance = new ListaCandidaturas();
        ListaCandidaturas teste = new ListaCandidaturas();
        teste.addCandidatura(c);
        instance.addCandidatura(c);
        Candidatura[] expResult = teste.getArray();
        Candidatura[] result = instance.getArray();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of obterCandidatura method, of class ListaCandidaturas.
     */
    @Test
    public void testObterCandidatura() {
        System.out.println("obterCandidatura");
        int indice = 0;
        ListaCandidaturas instance = new ListaCandidaturas();
        ListaCandidaturas test = new ListaCandidaturas();
        Candidatura can= new Candidatura();  
        test.addCandidatura(can);
        instance.addCandidatura(can);
        Candidatura expResult = test.obterCandidatura(indice);
        Candidatura result = instance.obterCandidatura(indice);
        assertEquals(expResult, result);

    }

    /**
     * Test of removerCandidatura method, of class ListaCandidaturas.
     */
    @Test
    public void testRemoverCandidatura() {
        System.out.println("removerCandidatura");
        Candidatura candidatura = new Candidatura();
        ListaCandidaturas instance = new ListaCandidaturas();
        ListaCandidaturas teste = new ListaCandidaturas();
        boolean expResult = teste.removerCandidatura(candidatura);
        boolean result = instance.removerCandidatura(candidatura);
        assertEquals(expResult, result);

    }

    /**
     * Test of tamanho method, of class ListaCandidaturas.
     */
    @Test
    public void testTamanho() {
        System.out.println("tamanho");
        ListaCandidaturas instance = new ListaCandidaturas();
        Candidatura cand = new Candidatura();
        instance.addCandidatura(cand);
        int expResult = 1;
        int result = instance.tamanho();
        assertEquals(expResult, result);

    }

    /**
     * Test of indiceDeCandidatura method, of class ListaCandidaturas.
     */
    @Test
    public void testIndiceDeCandidatura() {
        System.out.println("indiceDeCandidatura");
        Candidatura candidatura = new Candidatura();
        ListaCandidaturas instance = new ListaCandidaturas();
        instance.addCandidatura(candidatura);
        int expResult = 0;
        int result = instance.indiceDeCandidatura(candidatura);
        assertEquals(expResult, result);

    }

    /**
     * Test of contem method, of class ListaCandidaturas.
     */
    @Test
    public void testContem() {
        System.out.println("contem");
        Candidatura candidatura = new Candidatura();
        ListaCandidaturas instance = new ListaCandidaturas();
        instance.addCandidatura(candidatura);
        boolean expResult = true;
        boolean result = instance.contem(candidatura);
        assertEquals(expResult, result);

    }
    
}
