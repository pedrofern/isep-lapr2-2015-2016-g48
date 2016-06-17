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
    private List<FAE> listfae;
    private RegistoUtilizadores m_registoUtilizadores;
    private Utilizador utilizador;
    private RegistoExposicoes listaExposicao;

    public DefinirFAEController(CentroExposicoes centroExposicao, Utilizador utilizador) {
        this.ce = centroExposicao;
        this.utilizador = utilizador;
        listaFaes = new ListaFAE();
    }
//    public List<Exposicao> getListaExposicaoOrganizadorSemFAEDefinidos(String email) {
//
//        return listaExposicao.getListaExposicaoOrganizadorSemFAEDefinidos(email);
//    }

    public RegistoUtilizadores getRegistoUTilizadores() {

        return ce.getRegistoUtilizadores();
    }

    public ListaFAE getListaFAE() {

        return listaFaes;
    }

    public FAE novaFAE() {
        return fae = new FAE();
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

    public String getFAEString() {
        return this.listaFaes.toStringCompleto();
    }

    public boolean registaFAE(FAE fae) {
        if (!getListaFAE().registaFAE(fae)) {
            return false;
        } else {
            return true;
        }

    }
    
    

}
