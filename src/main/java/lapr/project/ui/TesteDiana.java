/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.FileNotFoundException;
import lapr.project.model.Avaliacao;
import lapr.project.model.Candidatura;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.model.Organizador;
import lapr.project.model.Recurso;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.*;
import lapr.project.model.lists.*;
import lapr.project.model.states.exposicao.ExposicaoCandidaturasDecididas;
import lapr.project.ui.ucs.AtribuirCandidaturaUI;
import lapr.project.ui.ucs.AnaliseAvaliacaoFaeUI;
import lapr.project.ui.ucs.DefinirFAEUI;
import lapr.project.ui.ucs.*;
import lapr.project.utils.Data;
import lapr.project.utils.*;
import lapr.project.ui.ucs.*;

/**
 *
 * @author DianaSilva
 */
public class TesteDiana {

    private static final String s1 = "19/11/2017", s2 = "20/11/2017", s3 = "11/11/2017", s4 = "12/11/2017", s5 = "15/11/2017",
            s6 = "16/11/2017", s7 = "13/11/2017", s8 = "17/11/2017", s9 = "18/11/2017", s10 = "14/11/2017";
    private static Data d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
    private static FichCentroExposicoes ficheiro;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, Exception {
        // TODO code application logic here
        // TODO code application logic here
        CentroExposicoes ce = new CentroExposicoes();
        Utilizador user = new Utilizador();
        Utilizador ut1=new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin","admin", true,15 );   
        Utilizador ut2= new Utilizador("Ana Silva", "1130155@isep.ipp.pt","Gestor","gestor",true,10);
        Utilizador ut3= new Utilizador("Diana Silva", "1151088@isep.ipp.pt","Organizador","organizador",true,8);
        Utilizador ut4= new Utilizador("Eduângelo Ferreira", "1151094@isep.ipp.pt","Organizador+Fae","orgfae",true, 6);
        Utilizador ut5= new Utilizador("Pedro Fernandes", "1060503@isep.ipp.pt","Fae","fae",true,3);
        Utilizador ut6 = new Utilizador("Tomás Magalhães", "1151182@isep.ipp.pt", "Representante","representante", true, 1);
        Utilizador ut7 = new Utilizador("User1", "1130155@isep.ipp.pt", "Gestor","gestor", false, 9);
        Utilizador ut8 = new Utilizador("User2", "1151088@isep.ipp.pt", "Organizador","organizador", false, 7);
        Utilizador ut9 = new Utilizador("User3", "1151094@isep.ipp.pt", "Organizador+Fae","orgfae", true, 2);
        Utilizador ut10 = new Utilizador("User4", "1060503@isep.ipp.pt", "Fae","fae", true, 4);


        RegistoUtilizadores lu = ce.getRegistoUtilizadores();
        lu.addUtilizador(ut1);
        lu.addUtilizador(ut2);
        lu.addUtilizador(ut3);
        lu.addUtilizador(ut4);
        lu.addUtilizador(ut5);
        Recurso r1 = new Recurso("Recurso 1");
        Recurso r2 = new Recurso("Recurso 2");
        Recurso r3 = new Recurso("Recurso 3");
        RegistoRecursos lr = ce.getRegistoRecursos();
        lr.addRecurso(r3);
        lr.addRecurso(r2);
        lr.addRecurso(r1);
        Organizador o = new Organizador(ut1);
        Organizador o1 = new Organizador(ut2);
        ListaOrganizadores lo = new ListaOrganizadores();
        Exposicao e = ce.getRegistoExposicoes().novaExposicao();
        lo.addOrganizador(o);
        lo.addOrganizador(o1);
        e.setListaOrganizadores(lo);

        FAE f1 = new FAE();
        FAE f2 = new FAE();
        FAE f3 = new FAE();
        FAE f4 = new FAE();
        FAE f5 = new FAE();
        FAE f6 = new FAE();
        FAE f7 = new FAE();
        FAE f8 = new FAE();
        FAE f9 = new FAE();
        FAE f10 = new FAE();

        f1.setUtilizador(ut1);
        f2.setUtilizador(ut2);
        f3.setUtilizador(ut3);
        f4.setUtilizador(ut4);
        f5.setUtilizador(ut5);
        f6.setUtilizador(ut6);
        f7.setUtilizador(ut7);
        f8.setUtilizador(ut8);
        f9.setUtilizador(ut9);
        f10.setUtilizador(ut10);

        ListaFAE lf = new ListaFAE();

        lf.addFAE(f1);
        lf.addFAE(f2);
        lf.addFAE(f3);
        lf.addFAE(f4);
        lf.addFAE(f5);
        lf.addFAE(f6);
        lf.addFAE(f7);
        lf.addFAE(f8);
        lf.addFAE(f9);
        lf.addFAE(f10);

        formarDatas();

        e.setListaFaes(lf);
        e.setDadosPrincipais("teste", "teste", d1, d2, "teste", d3, d4);
        e.setDadosData(d5, d6, d7, d8, d9, d10);
        e.setCriada();
        ce.getRegistoExposicoes().adicionarExposicao(e);
        Candidatura c1 = new Candidatura();
        c1.setNomeEmpresa("Candidatura1");
        Candidatura c2 = new Candidatura();
        c2.setNomeEmpresa("Candidatura2");
        Candidatura c3 = new Candidatura();
        c3.setNomeEmpresa("Candidatura3");
        Candidatura c4 = new Candidatura();
        c4.setNomeEmpresa("Candidatura4");
        Candidatura c5 = new Candidatura();
        c5.setNomeEmpresa("Candidatura5");
        Candidatura c6 = new Candidatura();
        c6.setNomeEmpresa("Candidatura6");
        Candidatura c7 = new Candidatura();
        c7.setNomeEmpresa("Candidatura7");
        Candidatura c8 = new Candidatura();
        c8.setNomeEmpresa("Candidatura8");
        Candidatura c9 = new Candidatura();
        c9.setNomeEmpresa("Candidatura9");
        Candidatura c10 = new Candidatura();
        c10.setNomeEmpresa("Candidatura10");
        Candidatura c11 = new Candidatura();
        c11.setNomeEmpresa("Candidatura11");
        Candidatura c12 = new Candidatura();
        c12.setNomeEmpresa("Candidatura12");
        Candidatura c13 = new Candidatura();
        c13.setNomeEmpresa("Candidatura13");
        Candidatura c14 = new Candidatura();
        c14.setNomeEmpresa("Candidatura14");
        Candidatura c15 = new Candidatura();
        c15.setNomeEmpresa("Candidatura15");
        Candidatura c16 = new Candidatura();
        c16.setNomeEmpresa("Candidatura16");
        Candidatura c17 = new Candidatura();
        c17.setNomeEmpresa("Candidatura17");
        Candidatura c18 = new Candidatura();
        c18.setNomeEmpresa("Candidatura18");
        Candidatura c19 = new Candidatura();
        c19.setNomeEmpresa("Candidatura19");
        Candidatura c20 = new Candidatura();
        c20.setNomeEmpresa("Candidatura20");
        Candidatura c21 = new Candidatura();
        c21.setNomeEmpresa("Candidatura21");
        Candidatura c22 = new Candidatura();
        c22.setNomeEmpresa("Candidatura22");
        Candidatura c23 = new Candidatura();
        c23.setNomeEmpresa("Candidatura23");
        Candidatura c24 = new Candidatura();
        c24.setNomeEmpresa("Candidatura24");
        Candidatura c25 = new Candidatura();
        c25.setNomeEmpresa("Candidatura25");
        Candidatura c26 = new Candidatura();
        c26.setNomeEmpresa("Candidatura26");
        Candidatura c27 = new Candidatura();
        c27.setNomeEmpresa("Candidatura27");
        Candidatura c28 = new Candidatura();
        c28.setNomeEmpresa("Candidatura28");
        Candidatura c29 = new Candidatura();
        c29.setNomeEmpresa("Candidatura29");
        Candidatura c30 = new Candidatura();
        c30.setNomeEmpresa("Candidatura30");
        
//        c1.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c1));
//        c2.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c2));
//        c3.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c3));
//        c4.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c4));
//        c5.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c5));
//        c6.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c6));
//        c7.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c7));
//        c8.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c8));
//        c9.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c9));
//        c10.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c10));
//        c11.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c11));
//        c12.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c12));
//        c13.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c13));
//        c14.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c14));
//        c15.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c15));
//        c16.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c16));
//        c17.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c17));
//        c18.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c18));
//        c19.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c19));
//        c20.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c20));
//        c21.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c21));
//        c22.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c22));
//        c23.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c23));
//        c24.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c24));
//        c25.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c25));
//        c26.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c26));
//        c27.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c27));
//        c28.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c28));
//        c29.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c29));
//        c30.setEstadoCandidatura(new CandidaturaEmAtribuicaoFAE(c30));   
        
        Avaliacao a1=new Avaliacao();
        
        a1.setJustificacao("Empresa de renome que revela enquadrar-se ao tema, apresentando produtos adequados.");
        a1.setResposta(true);
        a1.setAvaliada();
        a1.setMedia(3);
        c1.getListaAvaliacoes().add(a1);
        
        Avaliacao a2=new Avaliacao();
        a2.setJustificacao("Uma mais-valia para a exposição, sendo que o prestígio e a competência da empresa são pontos marcantes");
        a2.setResposta(true);
        a2.setAvaliada();
        a2.setMedia(1);
        c1.getListaAvaliacoes().add(a2);
        
        Avaliacao a3=new Avaliacao();
        a3.setJustificacao(("Poderia enquadrar melhor os produtos apresentados e verificar a quantidade de convites"));
        a3.setResposta(false);
        a3.setMedia(3);
        a3.setAvaliada();
        
        c1.setDecisao(true);
        c2.setDecisao(false);
        c3.setDecisao(true);
        
        c2.getListaAvaliacoes().add(a2);
        c2.getListaAvaliacoes().add(a1);
        
        c3.getListaAvaliacoes().add(a1);
        c3.getListaAvaliacoes().add(a3);
        e.getListaCandidaturas().addCandidatura(c1);
        e.getListaCandidaturas().addCandidatura(c2);
        e.getListaCandidaturas().addCandidatura(c3);
        e.getListaCandidaturas().addCandidatura(c4);
        e.getListaCandidaturas().addCandidatura(c5);
        e.getListaCandidaturas().addCandidatura(c6);
        e.getListaCandidaturas().addCandidatura(c7);
        e.getListaCandidaturas().addCandidatura(c8);
        e.getListaCandidaturas().addCandidatura(c9);
        e.getListaCandidaturas().addCandidatura(c10);
        e.getListaCandidaturas().addCandidatura(c11);
        e.getListaCandidaturas().addCandidatura(c12);
        e.getListaCandidaturas().addCandidatura(c13);
        e.getListaCandidaturas().addCandidatura(c14);
        e.getListaCandidaturas().addCandidatura(c15);
        e.getListaCandidaturas().addCandidatura(c16);
        e.getListaCandidaturas().addCandidatura(c17);
        e.getListaCandidaturas().addCandidatura(c18);
        e.getListaCandidaturas().addCandidatura(c19);
        e.getListaCandidaturas().addCandidatura(c20);
        e.getListaCandidaturas().addCandidatura(c21);
        e.getListaCandidaturas().addCandidatura(c22);
        e.getListaCandidaturas().addCandidatura(c23);
        e.getListaCandidaturas().addCandidatura(c24);
        e.getListaCandidaturas().addCandidatura(c25);
        e.getListaCandidaturas().addCandidatura(c26);
        e.getListaCandidaturas().addCandidatura(c27);
        e.getListaCandidaturas().addCandidatura(c28);
        e.getListaCandidaturas().addCandidatura(c29);
        e.getListaCandidaturas().addCandidatura(c30);
        e.alterarEstado(new ExposicaoCandidaturasDecididas());
        Exposicao e1 = ce.getRegistoExposicoes().novaExposicao();

        e1.setListaOrganizadores(lo);
        formarDatas();
        e1.setDadosPrincipais("teste1", "teste1", d1, d2, "teste", d3, d4);
        e1.setDadosData(d5, d6, d7, d8, d9, d10);
        e1.setCriada();
        e1.getListaCandidaturas().registaCandidaturas(c9);
        c9.getListaAvaliacoes().add(a1);
        c9.getListaAvaliacoes().add(a3);
        
        c9.setDecisao(true);
        ce.getRegistoExposicoes().adicionarExposicao(e1);

        ListaDemonstracoes lista = e.getListaDemonstracoes();
        Demonstracao demo=new Demonstracao();
        demo.setDados("Teste", "teste");
        lista.adicionarDemonstracao(demo);

//       FichCentroExposicoes fichCentroExposicoes = new FichCentroExposicoes();
//       
//       Login log = new Login(ce, fichCentroExposicoes);

        GerarEstatisticasCandidaturaUI gec=new GerarEstatisticasCandidaturaUI(ce, ut1);
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
