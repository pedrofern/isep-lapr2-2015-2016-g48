/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.model.lists.ListaAvaliacoes;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.ListaKeywords;
import lapr.project.model.lists.ListaProduto;
import lapr.project.model.states.CandidaturaEstado;
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
public class CandidaturaTest {
    
    public CandidaturaTest() {
        
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
     * Test of getNomeEmpresa method, of class Candidatura.
     */
    @Test
    public void testGetNomeEmpresa() {
        System.out.println("getNomeEmpresa");
        Candidatura instance = new Candidatura();
        instance.setNomeEmpresa("nomeemp");
        String expResult = "nomeemp";
        String result = instance.getNomeEmpresa();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMorada method, of class Candidatura.
     */
    @Test
    public void testGetMorada() {
        System.out.println("getMorada");
        Candidatura instance = new Candidatura();
        instance.setMorada("morada");
        String expResult = "morada";
        String result = instance.getMorada();
        assertEquals(expResult, result);

    }

    /**
     * Test of getTelemovel method, of class Candidatura.
     */
    @Test
    public void testGetTelemovel() {
        System.out.println("getTelemovel");
        Candidatura instance = new Candidatura();
        instance.setTelemovel(912345678);
        int expResult = 912345678;
        int result = instance.getTelemovel();
        assertEquals(expResult, result);

    }

    /**
     * Test of getAreaExposicao method, of class Candidatura.
     */
    @Test
    public void testGetAreaExposicao() {
        System.out.println("getAreaExposicao");
        Candidatura instance = new Candidatura();
        instance.setAreaExposicao(1);
        int expResult = 1;
        int result = instance.getAreaExposicao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuantidadeConvites method, of class Candidatura.
     */
    @Test
    public void testGetQuantidadeConvites() {
        System.out.println("getQuantidadeConvites");
        Candidatura instance = new Candidatura();
        instance.setQuantidadeConvites(2);
        int expResult = 2;
        int result = instance.getQuantidadeConvites();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRepresentante method, of class Candidatura.
     */
    @Test
    public void testGetRepresentante() {
        System.out.println("getRepresentante");
        Candidatura instance = new Candidatura();
        Utilizador u = new Utilizador();
        instance.setRepresentante(u);
        Representante r = instance.getRepresentante();
        Representante expResult = r;
        Representante result = instance.getRepresentante();
        assertEquals(expResult, result);

    }

    /**
     * Test of getInfo method, of class Candidatura.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        Candidatura instance = new Candidatura();
        String expResult = instance.toString();
        String result = instance.getInfo();
        assertEquals(expResult, result);

    }


    /**
     * Test of getEstadoAtualCandidatura method, of class Candidatura.
     */
    @Test
    public void testGetEstadoAtualCandidatura() {
        System.out.println("getEstadoAtualCandidatura");
        Candidatura instance = new Candidatura();
        CandidaturaEstado estadoCandidatura = new CandidaturaEstado() {
            @Override
            public boolean validaEstadoCandidatura() {
                return true;
            }
        };
        instance.setEstadoCandidatura(estadoCandidatura);
        CandidaturaEstado expResult = estadoCandidatura;
        CandidaturaEstado result = instance.getEstadoAtualCandidatura();
        assertEquals(expResult, result);

    }

    /**
     * Test of setEstadoCandidatura method, of class Candidatura.
     */
    @Test
    public void testSetEstadoCandidatura() {
        System.out.println("setEstadoCandidatura");
        CandidaturaEstado estadoCandidatura = new CandidaturaEstado() {
            @Override
            public boolean validaEstadoCandidatura() {
                return true;
            }
        };
        Candidatura instance = new Candidatura();
        instance.setEstadoCandidatura(estadoCandidatura);
    }

    /**
     * Test of setNomeEmpresa method, of class Candidatura.
     */
    @Test
    public void testSetNomeEmpresa() {
        System.out.println("setNomeEmpresa");
        String novoNomeEmpresa = "nomenome";
        Candidatura instance = new Candidatura();
        instance.setNomeEmpresa(novoNomeEmpresa);

    }

    /**
     * Test of setMorada method, of class Candidatura.
     */
    @Test
    public void testSetMorada() {
        System.out.println("setMorada");
        String novaMorada = "morada";
        Candidatura instance = new Candidatura();
        instance.setMorada(novaMorada);
 
    }

    /**
     * Test of setTelemovel method, of class Candidatura.
     */
    @Test
    public void testSetTelemovel() {
        System.out.println("setTelemovel");
        int novoTelemovel = 912345678;
        Candidatura instance = new Candidatura();
        instance.setTelemovel(novoTelemovel);

    }

    /**
     * Test of setAreaExposicao method, of class Candidatura.
     */
    @Test
    public void testSetAreaExposicao() {
        System.out.println("setAreaExposicao");
        int novaAreaExposicao = 12;
        Candidatura instance = new Candidatura();
        instance.setAreaExposicao(novaAreaExposicao);
    }

    /**
     * Test of setQuantidadeConvites method, of class Candidatura.
     */
    @Test
    public void testSetQuantidadeConvites() {
        System.out.println("setQuantidadeConvites");
        int novaQuantidadeConvites = 3;
        Candidatura instance = new Candidatura();
        instance.setQuantidadeConvites(novaQuantidadeConvites);
     
    }

    /**
     * Test of setRepresentante method, of class Candidatura.
     */
    @Test
    public void testSetRepresentante() {
        System.out.println("setRepresentante");
        Utilizador u = new Utilizador();
        Candidatura instance = new Candidatura();
        instance.setRepresentante(u);

    }


    /**
     * Test of setListaProdutos method, of class Candidatura.
     */
    @Test
    public void testSetListaProdutos() {
        System.out.println("setListaProdutos");
        ListaProduto listaProdutos = new ListaProduto();
        Candidatura instance = new Candidatura();
        instance.setListaProdutos(listaProdutos);
    }


    /**
     * Test of setListaKeywords method, of class Candidatura.
     */
    @Test
    public void testSetListaKeywords() {
        System.out.println("setListaKeywords");
        ListaKeywords listaKeywords = new ListaKeywords();
        Candidatura instance = new Candidatura();
        instance.setListaKeywords(listaKeywords);

    }


    /**
     * Test of addProduto method, of class Candidatura.
     */
    @Test
    public void testAddProduto() {
        System.out.println("addProduto");
        String nomeProduto = "abc";
        Candidatura instance = new Candidatura();
        Produto produto = new Produto(nomeProduto);
        
        boolean expResult = true;
        boolean result = instance.addProduto(nomeProduto);
        assertEquals(expResult, result);
    }

    /**
     * Test of validaCandidatura method, of class Candidatura.
     */
    @Test
    public void testValidaCandidatura() {
        System.out.println("validaCandidatura");
        Candidatura c = new Candidatura();
        Candidatura instance = new Candidatura();
        boolean expResult = false;
        boolean result = instance.validaCandidatura(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of validaFAE method, of class Candidatura.
     */
    @Test
    public void testValidaFAE() {
        System.out.println("validaFAE");
        FAE f = new FAE();
        Candidatura instance = new Candidatura();
        boolean expResult = true;
        boolean result = instance.validaFAE(f);
        assertEquals(expResult, result);

    }

    /**
     * Test of valida method, of class Candidatura.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Candidatura instance = new Candidatura();
        boolean expResult = false;
        boolean result = instance.valida();
        assertEquals(expResult, result);

    }

    /**
     * Test of validaNomeEmpresa method, of class Candidatura.
     */
    @Test
    public void testValidaNomeEmpresa() {
        System.out.println("validaNomeEmpresa");
        Candidatura instance = new Candidatura();
        instance.setNomeEmpresa("afs");
        boolean expResult = true;
        boolean result = instance.validaNomeEmpresa();
        assertEquals(expResult, result);

    }

    /**
     * Test of validaMorada method, of class Candidatura.
     */
    @Test
    public void testValidaMorada() {
        System.out.println("validaMorada");
        Candidatura instance = new Candidatura();
        instance.setMorada("morada");
        boolean expResult = true;
        boolean result = instance.validaMorada();
        assertEquals(expResult, result);
    }

    /**
     * Test of validaTelemovel method, of class Candidatura.
     */
    @Test
    public void testValidaTelemovel() {
        System.out.println("validaTelemovel");
        Candidatura instance = new Candidatura();
        instance.setTelemovel(912345678);
        boolean expResult = true;
        boolean result = instance.validaTelemovel();
        assertEquals(expResult, result);

        
    }

    /**
     * Test of validaArea method, of class Candidatura.
     */
    @Test
    public void testValidaArea() {
        System.out.println("validaArea");
        Candidatura instance = new Candidatura();
        instance.setAreaExposicao(3);
        boolean expResult = true;
        boolean result = instance.validaArea();
        assertEquals(expResult, result);
 
    }

    /**
     * Test of validaContives method, of class Candidatura.
     */
    @Test
    public void testValidaContives() {
        System.out.println("validaContives");
        Candidatura instance = new Candidatura();
        instance.setQuantidadeConvites(5);
        boolean expResult = true;
        boolean result = instance.validaContives();
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class Candidatura.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Candidatura instance = new Candidatura();
        String expResult = null;
        String result = instance.toString();
        assertEquals(expResult, result);

    }

  

    /**
     * Test of getDecisao method, of class Candidatura.
     */
    @Test
    public void testGetDecisao() {
        System.out.println("getDecisao");
        Candidatura instance = new Candidatura();
        instance.setDecisao(true);
        boolean expResult = true;
        boolean result = instance.getDecisao();
        assertEquals(expResult, result);
         
    }

    /**
     * Test of getListaFAE method, of class Candidatura.
     */
    @Test
    public void testGetListaFAE() {
        System.out.println("getListaFAE");
        Candidatura instance = new Candidatura();
        ListaFAE expResult = instance.getListaFAE();
        ListaFAE result = instance.getListaFAE();
        assertEquals(expResult, result);
         
    }

    /**
     * Test of getListaAvaliacoes method, of class Candidatura.
     */
    @Test
    public void testGetListaAvaliacoes() {
        System.out.println("getListaAvaliacoes");
        Candidatura instance = new Candidatura();
        ListaAvaliacoes expResult = instance.getListaAvaliacoes();
        ListaAvaliacoes result = instance.getListaAvaliacoes();
        assertEquals(expResult, result);
         
    }


  

   

 


    
}
