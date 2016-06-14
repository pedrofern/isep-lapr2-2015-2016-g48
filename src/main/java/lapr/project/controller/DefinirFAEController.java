package lapr.project.controller;

import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.*;
import java.util.*;
import lapr.project.model.*;

/**
 *
 * @author Eduângelo Ferreira Nºaluno 1151094 <1151094@isep.ipp.pt>
 */
public class DefinirFAEController {

    private CentroExposicoes ce;
    private Exposicao exposicao;
    private FAE fae;
    private ListaFAE listaFaes;
    private RegistoUtilizadores m_registoUtilizadores;
    private Organizador organizador;
    private RegistoExposicoes listaExposicao;

    public DefinirFAEController(CentroExposicoes centroExposicao, Organizador organizador) {
        this.ce = centroExposicao;
        this.organizador = organizador;

    }
//    public List<Exposicao> getListaExposicaoOrganizadorSemFAEDefinidos(String email) {
//
//        return listaExposicao.getListaExposicaoOrganizadorSemFAEDefinidos(email);
//    }

    public RegistoUtilizadores getRegistoUTilizadores() {

        return ce.getRegistoUtilizadores();
    }

    public boolean registaMenbroFAE(FAE fae) {
        if (!getListaFAE().registaMenbroFAE(fae)) {
            return false;
        } else {
            return true;
        }

    }

    public ListaFAE getListaFAE() {
        return exposicao.getListaFAEs();
    }

    public boolean addFAE(Utilizador utilizador, Exposicao exposicao) {
        FAE fae = new FAE(utilizador);

        if (fae != null) {
            return listaFaes.addFAE(fae, exposicao);
        } else {
            return false;
        }
    }

    public String getFAEString() {
        return this.fae.toString();
    }

    public FAE getFAE() {
        return fae;
    }

//    public void setListaFAE(ListaFAE lo) {
//        exposicao.setListaFaes(lo);
//    }
//
//    public void selectExposicao(Exposicao e) {
//        this.exposicao = e;
//    }
//
//    public List<Exposicao> getListaExposicoes(String strId) {
//        return ce.getRegistoExposicoes().getExposicaoOrganizador(strId);
//    }
//
//    public List<Utilizador> getListaUtilizadores() {
//        return m_registoUtilizadores.getListaUtilizadores();
//    }
//
//    public FAE addMembroFAE(String strID) {
//        Utilizador u = m_registoUtilizadores.getUtilizadorByID(strID);
//
//        if (u != null) {
//            return listaFaes.addMembroFAE(u);
//        } else {
//            return null;
//        }
//    }
//
//    public void registaMenbroFAE(FAE fae) {
//        listaFaes.adicionarFAE(fae);
//    }
//
//    public FAE getFAE() {
//        return fae;
//    }
//    
}

    //tem de ser na exposição
//    public FAE setUtilizador(List<Utilizador> lstUtz) {
//        for (Utilizador u : lstUtz) {
//            listaFaes.addFAE(u);
//        }
//
//        if (ce.validaDefinirFAE(fae)) {
//            return fae;
//        } else {
//            return null;
//        }
//    }
//
//    public boolean registaMembroFAE(FAE fae) {
//
//        return ce.registaDefinirFAE(fae);
//
//    }
