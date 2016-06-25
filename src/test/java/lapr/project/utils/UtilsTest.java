/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.util.Calendar;
import javax.swing.JComboBox;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.RegistoExposicoes;
import lapr.project.model.lists.RegistoRecursos;
import lapr.project.model.lists.RegistoStands;
import lapr.project.model.lists.RegistoUtilizadores;
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
public class UtilsTest {

    public UtilsTest() {
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
     * Test of getdataAtual method, of class Utils.
     */
    @Test
    public void testGetdataAtual() {
        System.out.println("getdataAtual");
        Calendar hoje = Calendar.getInstance();
        int ano = hoje.get(Calendar.YEAR);
        int mes = hoje.get(Calendar.MONTH) + 1;
        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        Data expResult = new Data(dia, mes, ano);
        Data result = Utils.getdataAtual();
        assertEquals(expResult, result);

    }

    /**
     * Test of isEmailValido method, of class Utils.
     */
    @Test
    public void testIsEmailValido() {
        System.out.println("isEmailValido");
        String email = "1151094@isep.ipp.pt";
        boolean expResult = true;
        boolean result = Utils.isEmailValido(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of criarComboExpo method, of class Utils.
     */
    @Test
    public void testCriarComboExpo() {
        System.out.println("criarComboExpo");
        RegistoExposicoes lista_exposicao = new RegistoExposicoes();
        JComboBox result = Utils.criarComboExpo(lista_exposicao);
         JComboBox expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of criarComboCand method, of class Utils.
     */
    @Test
    public void testCriarComboCand() {
        System.out.println("criarComboCand");
        ListaCandidaturas lista_candidaturas = new ListaCandidaturas();
        JComboBox result = Utils.criarComboCand(lista_candidaturas);
         JComboBox expResult =result;
        assertEquals(expResult, result);

    }

    /**
     * Test of criarComboUser method, of class Utils.
     */
    @Test
    public void testCriarComboUser() {
        System.out.println("criarComboUser");
        RegistoUtilizadores lista_users = new RegistoUtilizadores();
        JComboBox result = Utils.criarComboUser(lista_users);
         JComboBox expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of criarComboDemo method, of class Utils.
     */
    @Test
    public void testCriarComboDemo() {
        System.out.println("criarComboDemo");
        ListaDemonstracoes lista_demo = new ListaDemonstracoes();
        JComboBox result = Utils.criarComboDemo(lista_demo);
         JComboBox expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of criarComboStand method, of class Utils.
     */
    @Test
    public void testCriarComboStand() {
        System.out.println("criarComboStand");
        RegistoStands lista_stands = new RegistoStands();
        JComboBox result = Utils.criarComboStand(lista_stands);
         JComboBox expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of criarComboRecurso method, of class Utils.
     */
    @Test
    public void testCriarComboRecurso() {
        System.out.println("criarComboRecurso");
        RegistoRecursos lista_recursos = new RegistoRecursos();
        JComboBox result = Utils.criarComboRecurso(lista_recursos);
        JComboBox expResult = result;
        assertEquals(expResult, result);

    }

    /**
     * Test of criarComboFaes method, of class Utils.
     */
    @Test
    public void testCriarComboFaes() {
        System.out.println("criarComboFaes");
        ListaFAE listaFaes = new ListaFAE();
        JComboBox result = Utils.criarComboFaes(listaFaes);
        JComboBox expResult = result;
        assertEquals(expResult, result);

    }


    /**
     * Test of validaDatasString method, of class Utils.
     */
    @Test
    public void testValidaDatasString() {
        System.out.println("validaDatasString");
        String data = "02/02/2016";
        boolean expResult = true;
        boolean result = Utils.validaDatasString(data);
        assertEquals(expResult, result);

    }

    /**
     * Test of encriptar method, of class Utils.
     */
    @Test
    public void testEncriptar() {
        System.out.println("encriptar");
        String texto = "teste";
        String expResult = "0!/0!";
        String result = Utils.encriptar(texto);
        assertEquals(expResult, result);

    }

    /**
     * Test of desencriptar method, of class Utils.
     */
    @Test
    public void testDesencriptar() {
        System.out.println("desencriptar");
        String textoCifrado = "teste";
        String expResult = "ZKYZK";
        String result = Utils.desencriptar(textoCifrado);
        assertEquals(expResult, result);

    }
}
