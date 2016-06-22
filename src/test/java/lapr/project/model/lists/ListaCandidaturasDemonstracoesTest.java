/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Candidatura;
import lapr.project.model.CandidaturaDemonstracao;
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
public class ListaCandidaturasDemonstracoesTest {
    
    CandidaturaDemonstracao c;
    Candidatura candexp;
    CandidaturaDemonstracao  c2;
    ListaCandidaturasDemonstracoes listaCandidaturasDemonstracoes;
    
    public ListaCandidaturasDemonstracoesTest() {
        listaCandidaturasDemonstracoes = new ListaCandidaturasDemonstracoes();
        candexp = new Candidatura();
        c= new CandidaturaDemonstracao(candexp);        
        listaCandidaturasDemonstracoes.addCandidaturaDemonstracao(c);
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
     * Test of registaCandidaturaDemonstracao method, of class ListaCandidaturasDemonstracoes.
     */
    @Test
    public void testRegistaCandidaturaDemonstracao() {
        System.out.println("registaCandidaturaDemonstracao");
        CandidaturaDemonstracao c = new CandidaturaDemonstracao(candexp);
        ListaCandidaturasDemonstracoes instance = new ListaCandidaturasDemonstracoes();
        ListaCandidaturasDemonstracoes teste = new ListaCandidaturasDemonstracoes();
        boolean expResult = teste.registaCandidaturaDemonstracao(c);
        boolean result = instance.registaCandidaturaDemonstracao(c);
        assertEquals(expResult, result);

    }

    /**
     * Test of addCandidaturaDemonstracao method, of class ListaCandidaturasDemonstracoes.
     */
    @Test
    public void testAddCandidaturaDemonstracao() {
        System.out.println("addCandidaturaDemonstracao");
        CandidaturaDemonstracao c = new CandidaturaDemonstracao(candexp);
        ListaCandidaturasDemonstracoes instance = new ListaCandidaturasDemonstracoes();
        boolean expResult = true;
        boolean result = instance.addCandidaturaDemonstracao(c);
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaCandidaturasDemonstracao method, of class ListaCandidaturasDemonstracoes.
     */
    @Test
    public void testGetListaCandidaturasDemonstracao() {
        System.out.println("getListaCandidaturasDemonstracao");
        ListaCandidaturasDemonstracoes instance = new ListaCandidaturasDemonstracoes();
        List<CandidaturaDemonstracao> lista = new ArrayList<>();
        List<CandidaturaDemonstracao> expResult = lista;
        List<CandidaturaDemonstracao> result = instance.getListaCandidaturasDemonstracao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCandidaturaDemonstracaoByNomeEmpresa method, of class ListaCandidaturasDemonstracoes.
     */
    @Test
    public void testGetCandidaturaDemonstracaoByNomeEmpresa() {
        System.out.println("getCandidaturaDemonstracaoByNomeEmpresa");
        String strNomeEmpresa = "";
        ListaCandidaturasDemonstracoes instance = new ListaCandidaturasDemonstracoes();
        ListaCandidaturasDemonstracoes teste = new ListaCandidaturasDemonstracoes();
        CandidaturaDemonstracao expResult = teste.getCandidaturaDemonstracaoByNomeEmpresa(strNomeEmpresa);
        CandidaturaDemonstracao result = instance.getCandidaturaDemonstracaoByNomeEmpresa(strNomeEmpresa);
        assertEquals(expResult, result);
    }

    /**
     * Test of alteraCandidaturaDemonstracao method, of class ListaCandidaturasDemonstracoes.
     */
    @Test
    public void testAlteraCandidaturaDemonstracao() {
        System.out.println("alteraCandidaturaDemonstracao");
        CandidaturaDemonstracao cOriginal = new CandidaturaDemonstracao(candexp);
        CandidaturaDemonstracao cClone = new CandidaturaDemonstracao(candexp);
        ListaCandidaturasDemonstracoes instance = new ListaCandidaturasDemonstracoes();
        ListaCandidaturasDemonstracoes teste = new ListaCandidaturasDemonstracoes();
        boolean expResult = teste.alteraCandidaturaDemonstracao(cClone, cOriginal);
        boolean result = instance.alteraCandidaturaDemonstracao(cOriginal, cClone);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCandidaturaDemonstracaoInfo method, of class ListaCandidaturasDemonstracoes.
     */
    @Test
    public void testGetCandidaturaDemonstracaoInfo() {
        System.out.println("getCandidaturaDemonstracaoInfo");
        String cNomeEmpresa = "";
        ListaCandidaturasDemonstracoes instance = new ListaCandidaturasDemonstracoes();
        ListaCandidaturasDemonstracoes teste = new ListaCandidaturasDemonstracoes();
        CandidaturaDemonstracao expResult = teste.getCandidaturaDemonstracaoInfo(cNomeEmpresa);
        CandidaturaDemonstracao result = instance.getCandidaturaDemonstracaoInfo(cNomeEmpresa);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ListaCandidaturasDemonstracoes.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ListaCandidaturasDemonstracoes instance = new ListaCandidaturasDemonstracoes();
        ListaCandidaturasDemonstracoes lista = new ListaCandidaturasDemonstracoes();
        String expResult = lista.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getArray method, of class ListaCandidaturasDemonstracoes.
     */
    @Test
    public void testGetArray() {
        System.out.println("getArray");
        ListaCandidaturasDemonstracoes instance = new ListaCandidaturasDemonstracoes();
        ListaCandidaturasDemonstracoes teste = new ListaCandidaturasDemonstracoes();
        teste.addCandidaturaDemonstracao(c);
        instance.addCandidaturaDemonstracao(c);
        CandidaturaDemonstracao[] expResult = teste.getArray();
        CandidaturaDemonstracao[] result = instance.getArray();
        assertArrayEquals(expResult, result);

    }
    
}
