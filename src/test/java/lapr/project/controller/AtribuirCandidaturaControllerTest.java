/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Candidatura;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.model.Organizador;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaAtribuicoes;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.model.lists.RegistoExposicoes;
import lapr.project.model.states.CandidaturaEmAtribuicaoFAE;
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
 * @author Worten
 */
public class AtribuirCandidaturaControllerTest {
    private final CentroExposicoes ce;
    private final Utilizador ut1, ut2;
     private static final String s1 = "19/11/2017", s2 = "20/11/2017", s3 = "11/11/2017", s4 = "12/11/2017", s5 = "15/11/2017",
            s6 = "16/11/2017", s7 = "13/11/2017", s8 = "17/11/2017", s9 = "18/11/2017", s10 = "14/11/2017";
    private static Data d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
    private Exposicao e;
    
    public AtribuirCandidaturaControllerTest() throws Exception {
        ce= new CentroExposicoes();
        ut1= new Utilizador();
        ut2= new Utilizador();
        
        Organizador o = new Organizador(ut1);
        Organizador o1 = new Organizador(ut2);
        ListaOrganizadores lo = new ListaOrganizadores();
        e = ce.getRegistoExposicoes().novaExposicao();
        
        e.setListaOrganizadores(lo);
        
        FAE f1=new FAE();
        FAE f2=new FAE();
        
        f1.setUtilizador(ut1);
        f2.setUtilizador(ut2); 
        
        ListaFAE lf=new ListaFAE();

        lf.addFAE(f1);
        lf.addFAE(f2);
        
        formarDatas();
        
        e.setListaFaes(lf);
        e.setDadosPrincipais("teste", "teste", d1, d2, "teste", d3, d4);
        e.setDadosData(d5, d6, d7, d8, d9, d10);
        e.setCriada();
        ce.getRegistoExposicoes().adicionarExposicao(e);
        Candidatura c1=new Candidatura();
        c1.setNomeEmpresa("Candidatura1");
        Candidatura c2=new Candidatura();
        c2.setNomeEmpresa("Candidatura2");
        
        e.getListaCandidaturas().addCandidatura(c1);
        e.getListaCandidaturas().addCandidatura(c2);
        
        c1.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c1));
        c2.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c2));
        
        e.getListaCandidaturas().addCandidatura(c1);
        e.getListaCandidaturas().addCandidatura(c2);
        
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
     * Test of getListaExposicoes method, of class AtribuirCandidaturaController.
     */
    @Test
    public void testGetListaExposicoes() {
        System.out.println("getListaExposicoes");
       
        AtribuirCandidaturaController instance = new AtribuirCandidaturaController(ce, ut1);
        
        int expResult = 0;
        int result = instance.getListaExposicoes().countExposicoes();
        assertEquals(expResult, result);
    }
    
     private static void formarDatas() {
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
    
}
