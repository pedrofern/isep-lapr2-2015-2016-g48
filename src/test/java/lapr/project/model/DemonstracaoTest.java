/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.model.lists.ListaCandidaturasDemonstracoes;
import lapr.project.model.lists.ListaRecursoDemonstracao;
import lapr.project.model.lists.RegistoRecursos;
import lapr.project.model.states.DemonstracaoEstado;
import lapr.project.utils.Data;
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
public class DemonstracaoTest {

    private static final String s1 = "19/11/2017", s2 = "20/11/2017", s3 = "11/11/2017", s4 = "12/11/2017", s5 = "15/11/2017",
            s6 = "16/11/2017", s7 = "13/11/2017", s8 = "17/11/2017", s9 = "18/11/2017", s10 = "14/11/2017";
    public DemonstracaoTest() {
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
     * Test of getListaRecursos method, of class Demonstracao.
     */
    @Test
    public void testGetListaRecursos() throws Exception {
        System.out.println("getListaRecursos");
        Demonstracao instance = new Demonstracao();
        instance.setDados("des", "decisão");
        RegistoRecursos expResult = instance.getListaRecursos();
        expResult.addRecurso(new Recurso("Recurso"));
        RegistoRecursos result = instance.getListaRecursos();
        expResult.addRecurso(new Recurso("Recurso"));
        result.addRecurso(new Recurso("Recurso1"));

        assertEquals(expResult, result);

    }

    /**
     * Test of getListaRecursosDemonstracao method, of class Demonstracao.
     */
    @Test
    public void testGetListaRecursosDemonstracao() throws Exception {
        System.out.println("getListaRecursosDemonstracao");
        Demonstracao instance = new Demonstracao();
        instance.setDados("des", "decisão");
        ListaRecursoDemonstracao expResult = instance.getListaRecursosDemonstracao();
        expResult.addRecursoDemonstracao(new Recurso("Recurso"));
        ListaRecursoDemonstracao result = instance.getListaRecursosDemonstracao();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getListaCandidaturasDemonstracao method, of class Demonstracao.
     */
    @Test
    public void testGetListaCandidaturasDemonstracao() throws Exception {
        System.out.println("getListaCandidaturasDemonstracao");
        Demonstracao instance = new Demonstracao();
         instance.setDados("des", "decisão");
        ListaCandidaturasDemonstracoes expResult = instance.getListaCandidaturasDemonstracao();
        Candidatura c=new Candidatura("Empresa", "morada", 123456789, 9, 5);
        CandidaturaDemonstracao cd=new CandidaturaDemonstracao(c);
        expResult.addCandidaturaDemonstracao(cd);
        ListaCandidaturasDemonstracoes result = instance.getListaCandidaturasDemonstracao();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getCondigoUnico method, of class Demonstracao.
     */
    @Test
    public void testGetCondigoUnico() throws Exception {
        System.out.println("getCondigoUnico");
        Demonstracao d=new Demonstracao();
        String expResult = Demonstracao.getCondigoUnico();
        String result = Demonstracao.getCondigoUnico();
        assertEquals(expResult, result);
      
    }
    /**
     * Test of validaDescricao method, of class Demonstracao.
     */
    @Test
    public void testValidaDescricao() throws Exception {
        System.out.println("validaDescricao");
        String descricao = "Descrição";
        Demonstracao instance = new Demonstracao();
        instance.setDesc(descricao);
        boolean expResult = true;
        boolean result = instance.validaDescricao(descricao);
        assertEquals(expResult, result);

    }

    /**
     * Test of validaDatas method, of class Demonstracao.
     */
    @Test
    public void testValidaDatas() throws Exception {
        System.out.println("validaDatas");
   
        Demonstracao instance = new Demonstracao();
        boolean expResult = true;
        boolean result = instance.validaDatas(s1, s2);
        assertEquals(expResult, result);

    }

    /**
     * Test of setRecurso method, of class Demonstracao.
     */
    @Test
    public void testSetRecurso() throws Exception {
        System.out.println("setRecurso");
        Recurso r = new Recurso("Recurso");
        Demonstracao instance = new Demonstracao();
        Demonstracao demo=new Demonstracao();
        Recurso expResult = demo.setRecurso(r);
        Recurso result = instance.setRecurso(r);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setCandidaturaDemonstracao method, of class Demonstracao.
     */
    @Test
    public void testSetCandidaturaDemonstracao() throws Exception {
        System.out.println("setCandidaturaDemonstracao");
        Candidatura c=new Candidatura("Empresa", "Morada", 123456789, 80, 5);
        CandidaturaDemonstracao cd =  new CandidaturaDemonstracao(c);
        Demonstracao instance = new Demonstracao();
        Demonstracao demo=new Demonstracao();
        CandidaturaDemonstracao expResult = demo.setCandidaturaDemonstracao(cd);
        CandidaturaDemonstracao result = instance.setCandidaturaDemonstracao(cd);
        assertEquals(expResult, result);
   
    }

    /**
     * Test of validaRecurso method, of class Demonstracao.
     */
    @Test
    public void testValidaRecurso() throws Exception {
        System.out.println("validaRecurso");
        Recurso r = new Recurso("Recurso");
        Demonstracao instance = new Demonstracao();
        boolean expResult = true;
        boolean result = instance.validaRecurso(r);
        assertEquals(expResult, result);

    }

    /**
     * Test of getDesc method, of class Demonstracao.
     */
    @Test
    public void testGetDesc() throws Exception {
        System.out.println("getDesc");
        Demonstracao instance = new Demonstracao();
        String expResult = "Descrição";
        instance.setDesc(expResult);
        String result = instance.getDesc();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of addRecurso method, of class Demonstracao.
     */
    @Test
    public void testAddRecurso() throws Exception {
        System.out.println("addRecurso");
        Recurso r = new Recurso("Recurso");
        Demonstracao instance = new Demonstracao();
        boolean expResult = true;
        boolean result = instance.addRecurso(r);
        assertEquals(expResult, result);
   
    }

    /**
     * Test of registaRecurso method, of class Demonstracao.
     */
    @Test
    public void testRegistaRecurso() throws Exception {
        System.out.println("registaRecurso");
        Recurso r = new Recurso("Recurso");
        Demonstracao instance = new Demonstracao();
        boolean expResult = true;
        boolean result = instance.registaRecurso(r);
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class Demonstracao.
     */
    @Test
    public void testToString() throws Exception {
        System.out.println("toString");
        Demonstracao instance = new Demonstracao();
        instance.setDados("Tema", "Descrição");
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of toStringCompleto method, of class Demonstracao.
     */
    @Test
    public void testToStringCompleto() throws Exception {
        System.out.println("toStringCompleto");
        Demonstracao instance = new Demonstracao();
        instance.setDados("tema", "Descrição");
        String expResult = instance.toStringCompleto();
        String result = instance.toStringCompleto();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of valida method, of class Demonstracao.
     */
    @Test
    public void testValida() throws Exception {
        System.out.println("valida");
        Demonstracao instance = new Demonstracao();
        boolean expResult = false;
        boolean result = instance.valida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
