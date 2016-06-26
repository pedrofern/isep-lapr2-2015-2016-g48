/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Utilizador;
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
public class RegistoUtilizadoresTest {

    private Utilizador u = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", "admin", true, 15);

    public RegistoUtilizadoresTest() {
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
     * Test of novoUtilizador method, of class RegistoUtilizadores.
     */
    @Test
    public void testNovoUtilizador() {
        System.out.println("novoUtilizador");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        Utilizador expResult = new Utilizador();
        Utilizador result = instance.novoUtilizador();
        assertEquals(expResult, result);
    }

    /**
     * Test of registaUtilizador method, of class RegistoUtilizadores.
     */
    @Test
    public void testRegistaUtilizador() {
        System.out.println("registaUtilizador");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        boolean expResult = true;
        boolean result = instance.registaUtilizador(u);
        assertEquals(expResult, result);

    }

    /**
     * Test of addUtilizador method, of class RegistoUtilizadores.
     */
    @Test
    public void testAddUtilizador() {
        System.out.println("addUtilizador");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        boolean expResult = true;
        boolean result = instance.addUtilizador(u);
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaUtilizadores method, of class RegistoUtilizadores.
     */
    @Test
    public void testGetListaUtilizadores() {
        System.out.println("getListaUtilizadores");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        List<Utilizador> expResult = new ArrayList<Utilizador>();
        List<Utilizador> result = instance.getListaUtilizadores();
        assertEquals(expResult, result);

    }

    /**
     * Test of getUtilizadorByID method, of class RegistoUtilizadores.
     */
    @Test
    public void testGetUtilizadorByID() {
        System.out.println("getUtilizadorByID");
        String strId = "Admin";
        RegistoUtilizadores instance = new RegistoUtilizadores();
        RegistoUtilizadores re = new RegistoUtilizadores();
        Utilizador expResult = re.getUtilizadorByID(u.getID());
        Utilizador result = instance.getUtilizadorByID(strId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUtilizadorByEmail method, of class RegistoUtilizadores.
     */
    @Test
    public void testGetUtilizadorByEmail() {
        System.out.println("getUtilizadorByEmail");
        String strEmail = "nmb@isep.ipp.pt";
        RegistoUtilizadores instance = new RegistoUtilizadores();
        RegistoUtilizadores re = new RegistoUtilizadores();
        Utilizador expResult = re.getUtilizadorByID(u.getEmail());
        Utilizador result = instance.getUtilizadorByEmail(strEmail);
        assertEquals(expResult, result);

    }

    /**
     * Test of alteraUtilizador method, of class RegistoUtilizadores.
     */
    @Test
    public void testAlteraUtilizador() {
        System.out.println("alteraUtilizador");
        Utilizador uOriginal = u;
        Utilizador uClone = new Utilizador("Ana Silva", "1130155@isep.ipp.pt", "Gestor",  "admin",true, 10);
        RegistoUtilizadores instance = new RegistoUtilizadores();
        boolean expResult = true;
        boolean result = instance.alteraUtilizador(uOriginal, uClone);
        assertEquals(expResult, result);

    }

    /**
     * Test of getUtilizadorInfo method, of class RegistoUtilizadores.
     */
    @Test
    public void testGetUtilizadorInfo() {
        System.out.println("getUtilizadorInfo");
        String uId = "Admin";
        RegistoUtilizadores instance = new RegistoUtilizadores();
        instance.addUtilizador(u);
        Utilizador expResult =u;
        Utilizador result = instance.getUtilizadorInfo(uId);
        assertEquals(expResult, result);

    }

    /**
     * Test of hasUtilizador method, of class RegistoUtilizadores.
     */
    @Test
    public void testHasUtilizador() {
        System.out.println("hasUtilizador");
        String email = u.getEmail();
        String id = u.getID();
        RegistoUtilizadores instance = new RegistoUtilizadores();
        boolean expResult = false;
        boolean result = instance.hasUtilizador(email, id);
        assertEquals(expResult, result);

    }

    /**
     * Test of tamanho method, of class RegistoUtilizadores.
     */
    @Test
    public void testTamanho() {
        System.out.println("tamanho");
        Utilizador ut2 = new Utilizador("Ana Silva", "1130155@isep.ipp.pt", "Gestor", "admin", false, 10);
        Utilizador ut3 = new Utilizador("Diana Silva", "1151088@isep.ipp.pt", "Organizador", "admin", false, 8);
        Utilizador ut4 = new Utilizador("Eduângelo Ferreira", "1151094@isep.ipp.pt", "Organizador+Fae", "admin", false, 6);
        Utilizador ut5 = new Utilizador("Pedro Fernandes", "1060503@isep.ipp.pt", "Fae", "admin", false, 3);
        RegistoUtilizadores instance = new RegistoUtilizadores();
        instance.addUtilizador(ut2);
        instance.addUtilizador(ut3);
        instance.addUtilizador(ut4);
        instance.addUtilizador(ut5);
        int expResult = 4;
        int result = instance.tamanho();
        assertEquals(expResult, result);

    }

    /**
     * Test of removerUtilizador method, of class RegistoUtilizadores.
     */
    @Test
    public void testRemoverUtilizador() {
        System.out.println("removerUtilizador");

        Utilizador ut2 = new Utilizador("Ana Silva", "1130155@isep.ipp.pt", "Gestor", "admin", false, 10);
        RegistoUtilizadores instance = new RegistoUtilizadores();
        instance.addUtilizador(ut2);
        boolean expResult = true;
        boolean result = instance.removerUtilizador(ut2);
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class RegistoUtilizadores.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        String expResult = "RegistoUtilizadores:" + "m_listaUtilizadores=" + instance.getListaUtilizadores();
        String result = instance.toString();
        assertEquals(expResult, result);
    
    }

    /**
     * Test of getArray method, of class RegistoUtilizadores.
     */
    @Test
    public void testGetArray() {
        System.out.println("getArray");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        Utilizador ut2 = new Utilizador("Ana Silva", "1130155@isep.ipp.pt", "Gestor", "admin", false, 10);
        Utilizador ut3 = new Utilizador("Diana Silva", "1151088@isep.ipp.pt", "Organizador",  "admin",false, 8);
        Utilizador ut4 = new Utilizador("Eduângelo Ferreira", "1151094@isep.ipp.pt", "Organizador+Fae", "admin", false, 6);
        Utilizador ut5 = new Utilizador("Pedro Fernandes", "1060503@isep.ipp.pt", "Fae", "admin", false, 3);
        instance.addUtilizador(ut2);
        instance.addUtilizador(ut3);
        instance.addUtilizador(ut4);
        instance.addUtilizador(ut5);
         List<Utilizador> listaUtilizadores = new ArrayList<>();
        listaUtilizadores.add(ut2);
        listaUtilizadores.add(ut3);
        listaUtilizadores.add(ut4);
        listaUtilizadores.add(ut5);
      
        Utilizador[] expResult =listaUtilizadores.toArray(new Utilizador[listaUtilizadores.size()]);
        Utilizador[] result = instance.getArray();
        assertArrayEquals(expResult, result);
       
    }

    /**
     * Test of countUtilizadores method, of class RegistoUtilizadores.
     */
    @Test
    public void testCountUtilizadores() {
        System.out.println("countUtilizadores");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        Utilizador ut2 = new Utilizador("Ana Silva", "1130155@isep.ipp.pt", "Gestor", "admin", false, 10);
        Utilizador ut3 = new Utilizador("Diana Silva", "1151088@isep.ipp.pt", "Organizador", "admin", false, 8);
        Utilizador ut4 = new Utilizador("Eduângelo Ferreira", "1151094@isep.ipp.pt", "Organizador+Fae", "admin", false, 6);
        Utilizador ut5 = new Utilizador("Pedro Fernandes", "1060503@isep.ipp.pt", "Fae", "admin", false, 3);
        instance.addUtilizador(ut2);
        instance.addUtilizador(ut3);
        instance.addUtilizador(ut4);
        instance.addUtilizador(ut5);
        int expResult = 4;
        int result = instance.countUtilizadores();
        assertEquals(expResult, result);
       
    }

//    /**
//     * Test of getUtilizadoresPend method, of class RegistoUtilizadores.
//     */
//    @Test
//    public void testGetUtilizadoresPend() {
//        System.out.println("getUtilizadoresPend");
//         System.out.println("getUtilizadoresNaoRegistados");
//        Utilizador ut2 = new Utilizador("Ana Silva", "1130155@isep.ipp.pt", "Gestor", false, 10);
//        Utilizador ut3 = new Utilizador("Diana Silva", "1151088@isep.ipp.pt", "Organizador", false, 8);
//        Utilizador ut4 = new Utilizador("Eduângelo Ferreira", "1151094@isep.ipp.pt", "Organizador+Fae", false, 6);
//        Utilizador ut5 = new Utilizador("Pedro Fernandes", "1060503@isep.ipp.pt", "Fae", false, 3);
//        RegistoUtilizadores instance = new RegistoUtilizadores();
//        instance.addUtilizador(ut2);
//        instance.addUtilizador(ut3);
//        instance.addUtilizador(ut4);
//        instance.addUtilizador(ut5);
//
//        RegistoUtilizadores teste = new RegistoUtilizadores();
//        teste.addUtilizador(ut2);
//        teste.addUtilizador(ut3);
//        teste.addUtilizador(ut4);
//        teste.addUtilizador(ut5);
//        RegistoUtilizadores expResult = teste.getUtilizadoresPend();
//        RegistoUtilizadores result = instance.getUtilizadoresPend();
//        assertEquals(expResult, result);
//        
//    }

    /**
     * Test of getUtilizadorAtravesString method, of class RegistoUtilizadores.
     */
    @Test
    public void testGetUtilizadorAtravesString() {
        System.out.println("getUtilizadorAtravesString");
        String id = u.getID();
        String email = u.getEmail();
        RegistoUtilizadores instance = new RegistoUtilizadores();
         RegistoUtilizadores registo = new RegistoUtilizadores();
        Utilizador expResult =registo.getUtilizadorAtravesString(id, email);
        Utilizador result = instance.getUtilizadorAtravesString(id, email);
        assertEquals(expResult, result);
       
    }

}
