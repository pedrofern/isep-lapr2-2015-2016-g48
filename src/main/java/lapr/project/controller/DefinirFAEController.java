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
    private Utilizador utilizador;
    private RegistoExposicoes listaExposicao;

    public DefinirFAEController(CentroExposicoes centroExposicao, Utilizador utilizador) {
        this.ce = centroExposicao;
        this.utilizador = utilizador;

    }
//    public List<Exposicao> getListaExposicaoOrganizadorSemFAEDefinidos(String email) {
//
//        return listaExposicao.getListaExposicaoOrganizadorSemFAEDefinidos(email);
//    }

    public RegistoUtilizadores getRegistoUTilizadores() {

        return ce.getRegistoUtilizadores();
    }

    public ListaFAE getListaFAE() {
        return exposicao.getListaFAEs();
    }

    public FAE getFAE() {
        
         for (int i = 0; i < listaFaes.getListaFAE().size(); i++) {
            
             return fae=listaFaes.getListaFAE().get(i);
        }
        return fae;
    }

    public void criarFAE(Utilizador utilizador) {
        listaFaes.criaFAE(utilizador);
    }

    public void removerFAE(FAE fae) {
        listaFaes.removerFAE(fae);
    }

    public void setListaFAE(ListaFAE lo) {
        exposicao.setListaFaes(lo);
    }

    public void selectExposicao(Exposicao e) {
        this.exposicao = e;
    }

    public boolean registaExposicao(FAE fae) {
        if (!getListaFAE().registaFAE(fae)) {
            return false;
        } else {
            return true;
        }

    }
   
}

