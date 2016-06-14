/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Organizador;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.ui.ucs.ModeloListaOrganizadores;
import lapr.project.utils.Data;
import lapr.project.utils.Utils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diana
 */
public class CriarExposicaoControllerTest {
    String s1="19/11/1111", s2="20/11/1111", s3="11/11/1111", s4="12/11/1111", s5="15/11/1111",
            s6="16/11/1111", s7="13/11/1111", s8="17/11/1111", s9="18/11/1111", s10="14/11/1111";
    Data d1,d2,d3,d4,d5,d6,d7,d8,d9,d10;
    CentroExposicoes ce;
    CriarExposicaoController teste;
    Utilizador u, u1;
    Organizador o, o1;
    ListaOrganizadores lo;
    
    public CriarExposicaoControllerTest() {
        ce=new CentroExposicoes();
        teste=new CriarExposicaoController(ce);  
               
         u=new Utilizador();
        u1=new Utilizador();
        u.setEmail("teste@isep.ipp.pt");
        u.setUsername("teste");
        u1.setEmail("teste1@isep.ipp.pt");
        u1.setEmail("teste1@isep.ipp.pt");
        o=new Organizador(u);
        o1=new Organizador(u1);
        lo=new ListaOrganizadores();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    /**
     * Test of registaExposicao method, of class CriarExposicaoController.
     */
    @Test
    public void testValidaMinOrg() {
        System.out.println("validaMinOrgs");
        boolean expResult = true;
        
        teste.criarExposicao();
        teste.criaOrganizador(u);
        teste.criaOrganizador(u1);
        lo.addOrganizador(new Organizador(u));
        lo.addOrganizador(new Organizador(u1));
        
        teste.setListaOrganizadores(lo);
 
        boolean result = teste.validaMinOrganizadores();
       
        assertEquals(expResult, result);        
    }
    
    
    /**
     * Test of registaExposicao method, of class CriarExposicaoController.
     */
    @Test
    public void testDataFimSuperiorInicio() {
        System.out.println("validaDataFimSuperiorInicio");
        boolean expResult = true;
        
        teste.criarExposicao();
      
        formarDatas();

        teste.setDados("teste", "teste", d1, d2, "teste", d3, d4, d5, d6, d7, d8, d9, d10);

        boolean result = teste.validaDataFimSuperiorInicio();
       
        assertEquals(expResult, result);        
    }
    
    /**
   
    
    /**
     * Test of registaExposicao method, of class CriarExposicaoController.
     */
    @Test
    public void testSeguimentoDatas() {
        System.out.println("valida Seguimento das Datas da Exposição");
        boolean expResult = true;
        
        teste.criarExposicao();
 
       formarDatas();
        
        teste.setDados("teste", "teste", d1, d2, "teste", d3, d4, d5, d6, d7, d8, d9, d10);

        boolean result = teste.validaSeguimentoDatas();
       
        assertEquals(expResult, result);        
    }
    
    
    /**
     * Test of registaExposicao method, of class CriarExposicaoController.
     */
    @Test
    public void testRegistaExposicao() {
        System.out.println("registaExposicao");
        int expResult = 1;
        
        teste.criarExposicao();
       
       formarDatas();
  
        lo.addOrganizador(o);
        lo.addOrganizador(o1);
        
        teste.setListaOrganizadores(lo);
        
        teste.setDados("teste", "teste", d1, d2, "teste", d3, d4,d5,d6,d7,d8,d9,d10);
        teste.getRegistoExposicoes().adicionarExposicao(teste.getExposicao());
       
        int result =   teste.getRegistoExposicoes().countExposicoes();
        assertEquals(expResult, result);        
    }
    
    /**
     * Test of registaExposicao method, of class CriarExposicaoController.
     */
    @Test
    public void testGetListaUtilizadores() {
        System.out.println("getUtilizadores");
        int expResult = 1;
        
        ce.getRegistoUtilizadores().addUtilizador(new Utilizador());
        
        int result = teste.getListaUtilizadores().countUtilizadores();
       
        assertEquals(expResult, result);        
    }
    
      /**
     * Test of registaExposicao method, of class CriarExposicaoController.
     */
    @Test
    public void testValidaDatas() {
        System.out.println("validaDatas");
        boolean expResult = true;
        
        teste.criarExposicao();
        
        formarDatas();
        
        boolean result =  teste.validaDatas(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10);
       
        assertEquals(expResult, result);        
    }
    
    private void formarDatas(){
        d1=Utils.converterStringParaData(s1);
        d2=Utils.converterStringParaData(s2);
        d3=Utils.converterStringParaData(s3);
        d4=Utils.converterStringParaData(s4);
        d5=Utils.converterStringParaData(s5);
        d6=Utils.converterStringParaData(s6);
        d7=Utils.converterStringParaData(s7);
        d8=Utils.converterStringParaData(s8);
        d9=Utils.converterStringParaData(s9);
        d10=Utils.converterStringParaData(s10);
    }
}
