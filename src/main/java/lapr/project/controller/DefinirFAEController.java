package lapr.project.controller;

import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.RegistoUtilizadores;
import java.util.*;
import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class DefinirFAEController {

    private final CentroExposicoes ce;
    private Exposicao exposicao;
    private FAE fae;
    private ListaFAE listaFaes;
    private RegistoUtilizadores m_registoUtilizadores;

    public DefinirFAEController(CentroExposicoes centroExposicoes) {
        ce = centroExposicoes;
    }
    
    //TEM DE SER NA EXPOSICAO
//    public void novoDefinirFAE() {
//        fae = ce.novoDefinirFAE();
//    }

    public void selectExposicao(Exposicao e) {
        this.exposicao = e;
    }

    public List<Exposicao> getListaExposicoes(String strId) {
        return ce.getRegistoExposicoes().getExposicaoOrganizador(strId);
    }

    public List<Utilizador> getListaUtilizadores() {
        return m_registoUtilizadores.getListaUtilizadores();
    }

    public FAE addMembroFAE(String strID) {
        Utilizador u = m_registoUtilizadores.getUtilizadorByID(strID);

        if (u != null) {
            return listaFaes.addMembroFAE(u);
        } else {
            return null;
        }
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

}
