/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.util.Date;
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
public class DataTest {
    
    Data d1;
    Data d2;
    Data d3;
    
    public DataTest() {
        d1 = new Data(2016, 5, 10);
        d2 = new Data(2016, 5, 10);
        d3 = new Data(2017, 6, 11);
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
     * Test of getAno method, of class Data.
     */
    @Test
    public void testGetAno() {
        System.out.println("getAno");
        Data instance = d1;
        int expResult = 2016;
        int result = instance.getAno();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMes method, of class Data.
     */
    @Test
    public void testGetMes() {
        System.out.println("getMes");
        Data instance = d1;
        int expResult = 5;
        int result = instance.getMes();
        assertEquals(expResult, result);
 
    }

    /**
     * Test of getDia method, of class Data.
     */
    @Test
    public void testGetDia() {
        System.out.println("getDia");
        Data instance = d1;
        int expResult = 10;
        int result = instance.getDia();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setData method, of class Data.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        int ano = 2016;
        int mes = 5;
        int dia = 10;
        Data instance = d1;
        instance.setData(ano, mes, dia);
      
    }

    /**
     * Test of toString method, of class Data.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Data instance = d1;
        String expResult = d1.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of equals method, of class Data.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = d2;
        Data instance = d1;
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);

    }

    /**
     * Test of hashCode method, of class Data.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Data instance = new Data();
        int expResult = 313726;
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of compareTo method, of class Data.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Data outraData = d2;
        Data instance = d1;
        int expResult = 0;
        int result = instance.compareTo(outraData);
        assertEquals(expResult, result);

    }

    /**
     * Test of diaDaSemana method, of class Data.
     */
    @Test
    public void testDiaDaSemana() {
        System.out.println("diaDaSemana");
        Data instance = d1;
        String expResult = d1.diaDaSemana();
        String result = instance.diaDaSemana();
        assertEquals(expResult, result);
 
    }

    /**
     * Test of toAnoMesDiaString method, of class Data.
     */
    @Test
    public void testToAnoMesDiaString() {
        System.out.println("toAnoMesDiaString");
        Data instance = d3;
        String expResult = d3.toAnoMesDiaString();
        String result = instance.toAnoMesDiaString();
        assertEquals(expResult, result);

    }

    /**
     * Test of toDiaMesAnoString method, of class Data.
     */
    @Test
    public void testToDiaMesAnoString() {
        System.out.println("toDiaMesAnoString");
        Data instance = d3;
        String expResult = d3.toDiaMesAnoString();
        String result = instance.toDiaMesAnoString();
        assertEquals(expResult, result);
 
    }

    /**
     * Test of isMaior method, of class Data.
     */
    @Test
    public void testIsMaior() {
        System.out.println("isMaior");
        Data outraData = d1;
        Data instance = d3;
        boolean expResult = true;
        boolean result = instance.isMaior(outraData);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of isAnoBissexto method, of class Data.
     */
    @Test
    public void testIsAnoBissexto() {
        System.out.println("isAnoBissexto");
        int ano = 2000;
        boolean expResult = true;
        boolean result = Data.isAnoBissexto(ano);
        assertEquals(expResult, result);

    }

    /**
     * Test of dataAtual method, of class Data.
     */
    @Test
    public void testDataAtual() {
        System.out.println("dataAtual");
        Data d = new Data();        
        Data expResult = d.dataAtual();
        Data result = Data.dataAtual();
        assertEquals(expResult, result);

    }

    /**
     * Test of converterParaDate method, of class Data.
     */
    @Test
    public void testConverterParaDate() {
        System.out.println("converterParaDate");
        Data instance = d1;
        Date expResult = d1.converterParaDate();
        Date result = instance.converterParaDate();
        assertEquals(expResult, result);

    }

    /**
     * Test of getDataAtualDate method, of class Data.
     */
    @Test
    public void testGetDataAtualDate() throws Exception {
        System.out.println("getDataAtualDate");
        Data instance = d2;
        Date expResult = d2.getDataAtualDate();
        Date result = instance.getDataAtualDate();
        assertEquals(expResult, result);

    }
    
}
