/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import lapr.project.model.Exposicao;
import lapr.project.model.Organizador;
import lapr.project.model.Utilizador;
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
    
    public ModeloListaOrganizadoresTest() {
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
        Organizador o=new Organizador(u);
        Exposicao e=new Exposicao();
        
        ModeloListaOrganizadores instance = new ModeloListaOrganizadores(e.getListaOrganizadores());
        instance.addElement(o);
      
        Organizador teste=e.getListaOrganizadores().getListaOrganizadores().get(0);

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
        Exposicao e=new Exposicao();
        Organizador o=new Organizador(u);
        
        ModeloListaOrganizadores instance = new ModeloListaOrganizadores(e.getListaOrganizadores());
        instance.addElement(o);
        instance.getElementAt(0);
      
        Organizador teste=e.getListaOrganizadores().getListaOrganizadores().get(0);

        String result = teste.getUtilizador().getNome();
        assertEquals(expResult, result);
        
    }
}
