/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.List;
import lapr.project.model.Criterio;
import lapr.project.model.Questao;
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
public class ListaQuestoesTest {
    
    public ListaQuestoesTest() {
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
     * Test of getListaQuestoes method, of class ListaQuestoes.
     */
    @Test
    public void testGetListaQuestoes() {
        System.out.println("getListaQuestoes");
        ListaQuestoes instance = new ListaQuestoes();
        List<Questao> expResult = instance.getListaQuestoes();
        Questao q =new Questao();
        q.setPergunta(Criterio.CONHECIMENTO);
        expResult.add(q);
        List<Questao> result = instance.getListaQuestoes();
        result.add(q);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of criarQuestao method, of class ListaQuestoes.
     */
    @Test
    public void testCriarQuestao() {
        System.out.println("criarQuestao");
        Questao novaQuestao = new Questao();
        novaQuestao.setPergunta(Criterio.CONHECIMENTO);
        novaQuestao.setResposta(2);
        novaQuestao.setText("Quem?");
        ListaQuestoes instance = new ListaQuestoes();
        boolean expResult = true;
        boolean result = instance.criarQuestao(novaQuestao);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of calcularMedia method, of class ListaQuestoes.
     */
    @Test
    public void testCalcularMedia() {
        System.out.println("calcularMedia");
        ListaQuestoes instance = new ListaQuestoes();
        Questao novaQuestao = new Questao();
        novaQuestao.setPergunta(Criterio.CONHECIMENTO);
        novaQuestao.setResposta(2);
        novaQuestao.setText("Quem?");
        instance.getListaQuestoes().add(novaQuestao);
        double expResult = 2.0;
        double result = instance.calcularMedia();
        assertEquals(expResult, result, 2.0);
         
    }
    
}
