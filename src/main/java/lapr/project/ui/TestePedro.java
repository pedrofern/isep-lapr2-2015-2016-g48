/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.FileNotFoundException;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Organizador;
import lapr.project.model.Recurso;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.*;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.ui.ucs.AtribuirCandidaturaUI;
import lapr.project.ui.ucs.*;
import lapr.project.utils.Data;
import lapr.project.utils.Utils;

/**
 *
 * @author DianaSilva
 */
public class TestePedro {

    private static final String s1 = "19/11/1111", s2 = "20/11/1111", s3 = "11/11/1111", s4 = "12/11/1111", s5 = "15/11/1111",
            s6 = "16/11/1111", s7 = "13/11/1111", s8 = "17/11/1111", s9 = "18/11/1111", s10 = "14/11/1111";
    private static Data d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, Exception {
        // TODO code application logic here
        CentroExposicoes ce = new CentroExposicoes();
        Utilizador user = new Utilizador();
        Utilizador ut1 = new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", true, 15);

        Utilizador ut2 = new Utilizador("Ana Silva", "1130155@isep.ipp.pt", "Gestor", true, 10);
        Utilizador ut3 = new Utilizador("Diana Silva", "1151088@isep.ipp.pt", "Organizador", true, 8);
        Utilizador ut4 = new Utilizador("Eduângelo Ferreira", "1151094@isep.ipp.pt", "Organizador+Fae", true, 6);
        Utilizador ut5 = new Utilizador("Pedro Fernandes", "1060503@isep.ipp.pt", "Fae", true, 3);
        Utilizador ut6 = new Utilizador("Tomás Magalhães", "1151182@isep.ipp.pt", "Representante", true, 1);

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

        e.setListaOrganizadores(lo);
        formarDatas();
        e.setDados("teste", "teste", d1, d2, "teste", d3, d4, d5, d6, d7, d8, d9, d10);

        ce.getRegistoExposicoes().adicionarExposicao(e);

        Exposicao e1 = ce.getRegistoExposicoes().novaExposicao();

        ListaOrganizadores lo1 = new ListaOrganizadores();
        e1.setListaOrganizadores(lo);
        formarDatas();
        e1.setDados("teste1", "teste1", d1, d2, "teste1", d3, d4, d5, d6, d7, d8, d9, d10);

        ce.getRegistoExposicoes().adicionarExposicao(e1);

        //AtribuirCandidaturaUI a=new AtribuirCandidaturaUI(ce,ut1);
//        CriarExposicaoUI c=new CriarExposicaoUI(ce);
//        DefinirFAEUI fa=new DefinirFAEUI(ce, user);
        //CriarDemonstracaoUI d = new CriarDemonstracaoUI(ce, user);
        //ListarCandidaturaRetiradaUI r = new ListarCandidaturaRetiradaUI(ce, user);
        RegistarCandidaturaUI r = new RegistarCandidaturaUI(ce, user);
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
