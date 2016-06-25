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
public class AtribuicaoTest {
    
    public AtribuicaoTest() {
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
     * Test of getFae method, of class Atribuicao.
     */
    @Test
    public void testGetFae() {
        System.out.println("getFae");
        Candidatura c=new Candidatura();
        FAE fae=new FAE(new Utilizador("Nome", "email", "Admin", "email"));
        Atribuicao instance = new Atribuicao(fae,c);
        
        FAE expResult = instance.getFae();
        FAE result = instance.getFae();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getCandidatura method, of class Atribuicao.
     */
    @Test
    public void testGetCandidatura() {
        System.out.println("getCandidatura");
        FAE fae=new FAE();
        Candidatura c=new Candidatura("Empresa", "Morada", 123456789, 89, 5);
        
        Atribuicao instance = new Atribuicao(fae,c);

        Candidatura expResult = instance.getCandidatura();
        Candidatura result = instance.getCandidatura();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getEstadoAtribuicao method, of class Atribuicao.
     */
    @Test
    public void testGetEstadoAtribuicao() {
        System.out.println("getEstadoAtribuicao");
        
        FAE fae=new FAE(new Utilizador("Nome", "email", "Admin", "email"));
        Candidatura c=new Candidatura("Empresa", "Morada", 123456789, 89, 5);
        Atribuicao instance = new Atribuicao(fae,c);
        
        boolean expResult =false;
        boolean result = instance.getEstadoAtribuicao();
        assertEquals(expResult, result);
        
    }



    /**
     * Test of toString method, of class Atribuicao.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        FAE fae=new FAE(new Utilizador("Nome", "email", "Admin", "email"));
        Candidatura c=new Candidatura("Empresa", "Morada", 123456789, 89, 5);
        Atribuicao instance = new Atribuicao(fae,c);
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}
