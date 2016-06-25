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
public class UtilizadorTest {

    public UtilizadorTest() {
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
     * Test of cloneUtilizador method, of class Utilizador.
     */
    @Test
    public void testCloneUtilizador() {
        System.out.println("cloneUtilizador");
        Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", "admin", true, 15);
        Utilizador expResult = instance;
        Utilizador result = instance.cloneUtilizador();
        assertEquals(expResult, result);

    }

    /**
     * Test of getID method, of class Utilizador.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", "admin", true, 15);
        String expResult = "Admin";
        String result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasID method, of class Utilizador.
     */
    @Test
    public void testHasID() {
        System.out.println("hasID");
        String strId = "Admin";
        Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", "admin", true, 15);
        boolean expResult = true;
        boolean result = instance.hasID(strId);
        assertEquals(expResult, result);

    }

    /**
     * Test of hasEmail method, of class Utilizador.
     */
    @Test
    public void testHasEmail() {
        System.out.println("hasEmail");
        String email = "nmb@isep.ipp.pt";
        Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", "admin", true, 15);
        boolean expResult = true;
        boolean result = instance.hasEmail(email);
        assertEquals(expResult, result);

    }

    /**
     * Test of getNome method, of class Utilizador.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", "admin", true, 15);
        String expResult = "Nuno Bettencourt";
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class Utilizador.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String result = "Nuno Bettencourt";
        Utilizador instance = new Utilizador();
        instance.setNome(result);
        String expResult = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Utilizador.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", "admin", true, 15);
        String expResult = "nmb@isep.ipp.pt";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class Utilizador.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String result = "nmb@isep.ipp.pt";
        Utilizador instance = new Utilizador();
        instance.setEmail(result);
        String expResult = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class Utilizador.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Utilizador instance = new Utilizador();
        String expResult = "Password do utilizador não registado";
        String result = instance.getPassword();
        assertEquals(expResult, result);
         
    }

    /**
     * Test of setPassword method, of class Utilizador.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String result = "Password";
        Utilizador instance = new Utilizador();
        instance.setPassword(result);
         String expResult = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class Utilizador.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin",  "admin",true, 15);
        String expResult = "Admin";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Utilizador.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String result = "Admin";
        Utilizador instance = new Utilizador();
        instance.setUsername(result);
        String expResult = instance.getUsername();

        assertEquals(expResult, result);
    }

    /**
     * Test of getRegistado method, of class Utilizador.
     */
    @Test
    public void testGetRegistado() {
        System.out.println("getRegistado");
       Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", "admin", true, 15);
        Boolean expResult = true;
        Boolean result = instance.getRegistado();
        assertEquals(expResult, result);

    }

    /**
     * Test of setRegistado method, of class Utilizador.
     */
    @Test
    public void testSetRegistado() {
        System.out.println("setRegistado");
        Boolean result = true;
        Utilizador instance = new Utilizador();
        instance.setRegistado(result);
        Boolean expResult = instance.getRegistado();
        assertEquals(expResult, result);
    }

    /**
     * Test of valida method, of class Utilizador.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
          Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", "admin", true, 15);
        boolean expResult = true;
        boolean result = instance.valida();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of validaNome method, of class Utilizador.
     */
    @Test
    public void testValidaNome() {
        System.out.println("validaNome");
         Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", "admin", true, 15);
        boolean expResult = true;
        boolean result = instance.validaNome();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of validaUsername method, of class Utilizador.
     */
    @Test
    public void testValidaUsername() {
        System.out.println("validaUsername");
          Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin",  "admin",true, 15);
        boolean expResult = true;
        boolean result = instance.validaUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of validaPassword method, of class Utilizador.
     */
    @Test
    public void testValidaPassword() {
        System.out.println("validaPassword");
        Utilizador instance = new Utilizador();
        boolean expResult = true;
        boolean result = instance.validaPassword();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of validaEmail method, of class Utilizador.
     */
    @Test
    public void testValidaEmail() {
        System.out.println("validaEmail");
         Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin",  "admin",true, 15);
        boolean expResult = true;
        boolean result = instance.validaEmail();
        assertEquals(expResult, result);
         
    }

    /**
     * Test of mostraSimples method, of class Utilizador.
     */
    @Test
    public void testMostraSimples() {
        System.out.println("mostraSimples");
         Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", "admin", true, 15);
        String expResult = instance.getUsername()+"-"+instance.getNome();
        String result = instance.mostraSimples();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toString method, of class Utilizador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", "admin", true, 15);
         String expResult=instance.getNome()+":"+instance.getEmail();
        String result = instance.toString();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of toStringGeral method, of class Utilizador.
     */
    @Test
    public void testToStringGeral() {
        System.out.println("toStringGeral");
       Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin",  "admin",true, 15);
               String expResult ="Utilizador:\n"+
         "\tNome: " + instance.getNome() + "\n"+
        "\tUsername: " + instance.getUsername()+ "\n"+
        "\tPassword: " + instance.getPassword() + "\n"+
        "\tEmail: " + instance.getEmail()+ "\n";
        String result = instance.toStringGeral();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Utilizador.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto =  new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", "admin", true, 15);
        Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", "admin", true, 15);
        boolean expResult = true;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of hashCode method, of class Utilizador.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
   Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin",  "admin",true, 15);
        int expResult = -550082158;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getTempoServico method, of class Utilizador.
     */
    @Test
    public void testGetTempoServico() {
        System.out.println("getTempoServico");
         Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin",  "admin",true, 15);
        int expResult = 15;
        int result = instance.getTempoServico();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of compareTo method, of class Utilizador.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Utilizador outroUtilizador = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", "admin", true, 15);
         Utilizador instance = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin",  "admin",true, 15);
        int expResult = 0;
        int result = instance.compareTo(outroUtilizador);
        assertEquals(expResult, result);
       
    }

}
