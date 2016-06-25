/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.model.states.candidaturasDemo.*;
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
public class CandidaturaDemonstracaoTest {
    
    Candidatura candExp;
    
    public CandidaturaDemonstracaoTest() {
        candExp = new Candidatura();
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
     * Test of getNomeEmpresaCD method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testGetNomeEmpresaCD() {
        System.out.println("getNomeEmpresaCD");
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        instance.setNomeEmpresaCD("nomeemp");
        String expResult = "nomeemp";
        String result = instance.getNomeEmpresaCD();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMoradaCD method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testGetMoradaCD() {
        System.out.println("getMoradaCD");
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        instance.setMoradaCD("morada");
        String expResult = "morada";
        String result = instance.getMoradaCD();
        assertEquals(expResult, result);

    }

    /**
     * Test of getTelemovelCD method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testGetTelemovelCD() {
        System.out.println("getTelemovelCD");
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        instance.setTelemovelCD(912345678);
        int expResult = 912345678;
        int result = instance.getTelemovelCD();
        assertEquals(expResult, result);

    }

    /**
     * Test of getAreaExposicaoCD method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testGetAreaExposicaoCD() {
        System.out.println("getAreaExposicaoCD");
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        instance.setAreaExposicaoCD(2);
                
        int expResult = 2;
        int result = instance.getAreaExposicaoCD();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getQuantidadeConvitesCD method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testGetQuantidadeConvitesCD() {
        System.out.println("getQuantidadeConvitesCD");
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        instance.setQuantidadeConvitesCD(3);
        int expResult = 3;
        int result = instance.getQuantidadeConvitesCD();
        assertEquals(expResult, result);

    }

    /**
     * Test of getInfoCD method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testGetInfoCD() {
        System.out.println("getInfoCD");
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        String expResult = instance.toString();
        String result = instance.getInfoCD();
        assertEquals(expResult, result);

    }

    /**
     * Test of getEstadoAtualCandidatura method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testGetEstadoAtualCandidatura() {
        System.out.println("getEstadoAtualCandidatura");
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        CandidaturaDemoEstado estadoCandidatura = new CandidaturaDemoEstado() {
            public boolean validaEstadoCandidaturaDemo() {
                return true;
            }
        };
        instance.setEstadoCandidaturaDemo(estadoCandidatura);
        CandidaturaDemoEstado expResult  = estadoCandidatura;
        CandidaturaDemoEstado result = instance.getEstadoAtualCandidatura();
        assertEquals(expResult, result);

    }

    /**
     * Test of setEstadoCandidaturaDemo method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testSetEstadoCandidaturaDemo() {
        System.out.println("setEstadoCandidaturaDemo");
        CandidaturaDemoEstado estadoCandidaturaDemo = new CandidaturaDemoEstado() {
            public boolean validaEstadoCandidaturaDemo() {
                return true;
            }
        };
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        instance.setEstadoCandidaturaDemo(estadoCandidaturaDemo);

    }

    /**
     * Test of setNomeEmpresaCD method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testSetNomeEmpresaCD() {
        System.out.println("setNomeEmpresaCD");
        String novoNomeEmpresa = "nome";
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        instance.setNomeEmpresaCD(novoNomeEmpresa);

    }

    /**
     * Test of setMoradaCD method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testSetMoradaCD() {
        System.out.println("setMoradaCD");
        String novaMorada = "morada";
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        instance.setMoradaCD(novaMorada);
 
    }

    /**
     * Test of setTelemovelCD method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testSetTelemovelCD() {
        System.out.println("setTelemovelCD");
        int novoTelemovel = 912345678;
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        instance.setTelemovelCD(novoTelemovel);

    }

    /**
     * Test of setAreaExposicaoCD method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testSetAreaExposicaoCD() {
        System.out.println("setAreaExposicaoCD");
        int novaAreaExposicao = 4;
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        instance.setAreaExposicaoCD(novaAreaExposicao);

    }

    /**
     * Test of setQuantidadeConvitesCD method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testSetQuantidadeConvitesCD() {
        System.out.println("setQuantidadeConvitesCD");
        int novaQuantidadeConvites = 6;
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        instance.setQuantidadeConvitesCD(novaQuantidadeConvites);

    }


    /**
     * Test of addProdutoDemonstracao method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testAddProdutoDemonstracao() {
        System.out.println("addProdutoDemonstracao");
        String nomeProduto = "";
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        Produto p = new Produto(nomeProduto);
        boolean expResult = true;
        boolean result = instance.addProdutoDemonstracao(nomeProduto);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of validaCandidaturaDemonstracao method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testValidaCandidaturaDemonstracao() {
        System.out.println("validaCandidaturaDemonstracao");
        Candidatura c = new Candidatura();
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        boolean expResult = false;
        boolean result = instance.validaCandidaturaDemonstracao(c);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of valida method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        boolean expResult = false;
        boolean result = instance.valida();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of validaNomeEmpresaDemonstracao method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testValidaNomeEmpresaDemonstracao() {
        System.out.println("validaNomeEmpresaDemonstracao");
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        instance.setNomeEmpresaCD("afs");
        boolean expResult = true;
        boolean result = instance.validaNomeEmpresaDemonstracao();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of validaMoradaDemonstracao method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testValidaMoradaDemonstracao() {
        System.out.println("validaMoradaDemonstracao");
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        instance.setMoradaCD("morada");
        boolean expResult = true;
        boolean result = instance.validaMoradaDemonstracao();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of validaTelemovelDemonstracao method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testValidaTelemovelDemonstracao() {
        System.out.println("validaTelemovelDemonstracao");
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        instance.setTelemovelCD(912345678);
        boolean expResult = true;
        boolean result = instance.validaTelemovelDemonstracao();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of validaAreaDemonstracao method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testValidaAreaDemonstracao() {
        System.out.println("validaAreaDemonstracao");
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        instance.setAreaExposicaoCD(1000);
        boolean expResult = false;
        boolean result = instance.validaAreaDemonstracao();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of validaContivesDemonstracao method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testValidaContivesDemonstracao() {
        System.out.println("validaContivesDemonstracao");
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        instance.setQuantidadeConvitesCD(1000);
        boolean expResult = false;
        boolean result = instance.validaContivesDemonstracao();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of toString method, of class CandidaturaDemonstracao.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CandidaturaDemonstracao instance = new CandidaturaDemonstracao(candExp);
        String expResult = null;
        String result = instance.toString();
        assertEquals(expResult, result);
      
    }

}
