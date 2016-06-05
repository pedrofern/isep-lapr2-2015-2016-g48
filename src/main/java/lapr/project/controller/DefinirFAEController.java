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

    private final CentroExposicoes m_centro_exposicoes;
    private Exposicao m_exposicao;
    private FAE m_FAE;
    private ListaFAE m_lstFaes;
    private RegistoUtilizadores m_registoUtilizadores;

    public DefinirFAEController(CentroExposicoes centro_exposicoes) {
        m_centro_exposicoes = centro_exposicoes;
    }
    
    //TEM DE SER NA EXPOSICAO
//    public void novoDefinirFAE() {
//        m_FAE = m_centro_exposicoes.novoDefinirFAE();
//    }

    public void selectExposicao(Exposicao e) {
        this.m_exposicao = e;
    }

    public List<Exposicao> getListaExposicoes(String strId) {
        return m_centro_exposicoes.getRegistoExposicoes().getExposicaoOrganizador(strId);
    }

    public List<Utilizador> getListaUtilizadores() {
        return m_registoUtilizadores.getListaUtilizadores();
    }

    public FAE addMembroFAE(String strID) {
        Utilizador u = m_registoUtilizadores.getUtilizadorByID(strID);

        if (u != null) {
            return m_lstFaes.addMembroFAE(u);
        } else {
            return null;
        }
    }

    //tem de ser na exposição
    
    
//    public FAE setUtilizador(List<Utilizador> lstUtz) {
//        for (Utilizador u : lstUtz) {
//            m_lstFaes.addFAE(u);
//        }
//
//        if (m_centro_exposicoes.validaDefinirFAE(m_FAE)) {
//            return m_FAE;
//        } else {
//            return null;
//        }
//    }
//
//    public boolean registaMembroFAE(FAE m_FAE) {
//
//        return m_centro_exposicoes.registaDefinirFAE(m_FAE);
//
//    }

}
