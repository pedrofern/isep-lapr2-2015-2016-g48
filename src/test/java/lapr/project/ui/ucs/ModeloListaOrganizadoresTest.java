/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Organizador;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.utils.Data;
import lapr.project.utils.Utils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diana
 */
public class ModeloListaOrganizadoresTest {

    private static final String s1 = "19/11/1111", s2 = "20/11/1111", s3 = "11/11/1111", s4 = "12/11/1111", s5 = "15/11/1111",
            s6 = "16/11/1111", s7 = "13/11/1111", s8 = "17/11/1111", s9 = "18/11/1111", s10 = "14/11/1111";
    private static Data d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
    private Exposicao e;

    public ModeloListaOrganizadoresTest() throws Exception {

        CentroExposicoes ce = new CentroExposicoes();

        e = ce.getRegistoExposicoes().novaExposicao();

        d1 = Utils.converterStringParaData(s1);
        d2 = Utils.converterStringParaData(s2);
        d3 = Utils.converterStringParaData(s3);
        d4 = Utils.converterStringParaData(s4);
        d5 = Utils.converterStringParaData(s5);
        d6 = Utils.converterStringParaData(s6);
        d7 = Utils.converterStringParaData(s7);
        d8 = Utils.converterStringParaData(s8);
        d9 = Utils.converterStringParaData(s9);
        d10 = Utils.converterStringParaData(s10);
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
     * Test of addElement method, of class ModeloListaOrganizadores.
     */
    @Test
    public void testAddElement() throws Exception {
        System.out.println("addElement ModeloListaOrganizadores");

        String expResult = "Diana";
        Utilizador u = new Utilizador();
        u.setNome("Diana");
        Organizador o = new Organizador(u);

        ModeloListaOrganizadores instance = new ModeloListaOrganizadores(e.getListaOrganizadores());
        instance.addElement(o);

        Organizador teste = e.getListaOrganizadores().getListaOrganizadores().get(0);

        String result = teste.getUtilizador().getNome();
        assertEquals(expResult, result);

    }

    /**
     * Test of getElement method, of class ModeloListaOrganizadores.
     */
    @Test
    public void testGetElement() throws Exception {
        System.out.println("getElement ModeloListaOrganizadores");

        String expResult = "Diana";
        Utilizador u = new Utilizador();
        u.setNome("Diana");
        Organizador o = new Organizador(u);

        ModeloListaOrganizadores instance = new ModeloListaOrganizadores(e.getListaOrganizadores());
        instance.addElement(o);
        instance.getElementAt(0);

        Organizador teste = e.getListaOrganizadores().getListaOrganizadores().get(0);

        String result = teste.getUtilizador().getNome();
        assertEquals(expResult, result);

    }

    /**
     * Test of getSize method, of class ModeloListaOrganizadores.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        ModeloListaOrganizadores instance = new ModeloListaOrganizadores(e.getListaOrganizadores());
        instance.addElement(new Organizador(new Utilizador("teste", "tese", "teste", "teste")));
        int expResult = 1;
        int result = instance.getSize();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRowCount method, of class ModeloListaOrganizadores.
     */
    @Test
    public void testGetRowCount() {
        System.out.println("getRowCount");
        ModeloListaOrganizadores instance = new ModeloListaOrganizadores(e.getListaOrganizadores());
        instance.addElement(new Organizador(new Utilizador("teste", "tese", "teste", "teste")));
        int expResult = 1;
        int result = instance.getRowCount();
        assertEquals(expResult, result);

    }

    /**
     * Test of removeElement method, of class ModeloListaOrganizadores.
     */
    @Test
    public void testRemoveElement() {
        System.out.println("removeElement");
        ModeloListaOrganizadores instance = new ModeloListaOrganizadores(e.getListaOrganizadores());
        Organizador o =new Organizador(new Utilizador("teste", "tese", "teste", "teste"));
        instance.addElement(o);
        boolean expResult = false;
        boolean result = instance.removeElement(o);

    }

    /**
     * Test of contains method, of class ModeloListaOrganizadores.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
         ModeloListaOrganizadores instance = new ModeloListaOrganizadores(e.getListaOrganizadores());
        Organizador o =new Organizador(new Utilizador("teste", "tese", "teste", "teste"));
        instance.addElement(o);
        boolean expResult = true;
        boolean result = instance.contains(o);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getListaOrganizadores method, of class ModeloListaOrganizadores.
     */
    @Test
    public void testGetListaOrganizadores() {
        System.out.println("getListaOrganizadores");
         ModeloListaOrganizadores instance = new ModeloListaOrganizadores(e.getListaOrganizadores());
        Organizador o =new Organizador(new Utilizador("teste", "tese", "teste", "teste"));
        instance.addElement(o);
        ListaOrganizadores expResult = instance.getListaOrganizadores();
        ListaOrganizadores result = instance.getListaOrganizadores();
        assertEquals(expResult, result);
        
    }
}
