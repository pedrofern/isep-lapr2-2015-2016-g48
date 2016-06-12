package lapr.project.controller;

import lapr.project.model.mechanisms.Atribuicao;
import java.util.*;
import lapr.project.model.*;
import lapr.project.model.lists.*;

/**
 *
 * @author Pedro Fernandes
 */
public class AtribuirCandidaturaController {

    private static CentroExposicoes m_ce;
    private static Exposicao m_exposicao;
    private static Utilizador m_user;
    private static Candidatura c_candidatura;
    private static Organizador organizador;
    private static RegistoExposicoes m_listaExposicoes;
    private static ListaFAE m_listaFAE;
    private static ListaCandidaturas c_listaCandidaturas;
    private static Atribuicao ac_novaAtribuicaoCandidatura;


    public AtribuirCandidaturaController(CentroExposicoes ce) {
        m_ce = ce;
    }

    public RegistoExposicoes iniciarAtribuicaoCandidatura() {
        return this.m_ce.getRegistoExposicoes();
    }

    public void novaAtribuicaoCandidatura() {
        ac_novaAtribuicaoCandidatura = m_ce.novaAtribuicaoCandidatura();
    }

    public Atribuicao setAtribuicao() {
        if (organizador.validaAtribuicaoCandidatura(ac_novaAtribuicaoCandidatura)) {
            return ac_novaAtribuicaoCandidatura;
        } else {
            return null;
        }
    }

    public boolean registarDecisao() {
        return organizador.registaAtribuicaoCandidatura(ac_novaAtribuicaoCandidatura);
    }

    public String getInfoResumo() {
        return this.ac_novaAtribuicaoCandidatura.getInfo();
    }

    public List<Candidatura> getListaCandidaturas() {
        List<Candidatura> lc = new ArrayList<Candidatura>();

        for (ListIterator<Candidatura> it = c_listaCandidaturas.getListaCandidaturas().listIterator(); it.hasNext();) {
            lc.add(it.next());
        }

        return lc;
    }

    public ListaFAE getListaFAE() {
        ListaFAE lf = new ListaFAE();

        for (FAE f : m_listaFAE.getListaFAE()) {
            lf.adicionarFAE(f);
        }
        return lf;
    }

    private void addFAE(FAE f) {
        m_listaFAE.adicionarFAE(f);
    }

    public boolean validaAtribuicaoCandidatura() {
        return organizador.validaAtribuicaoCandidatura(ac_novaAtribuicaoCandidatura);
    }

    public boolean registaAtribuicaoCandidatura() {
        return organizador.registaAtribuicaoCandidatura(ac_novaAtribuicaoCandidatura);
    }

}
