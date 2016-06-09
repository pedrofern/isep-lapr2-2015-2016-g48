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

    private CentroExposicoes e_centroDeExposicoes;
    private Exposicao m_exposicao;
    private Candidatura c_candidatura;
    private Organizador organizador;
    private RegistoExposicoes m_listaExposicoes;
    private ListaFAE m_listaFAE;
    private ListaCandidaturas c_listaCandidaturas;
    private Atribuicao ac_novaAtribuicaoCandidatura;
    private CentroExposicoes m_centroDeExposicoes;

    public AtribuirCandidaturaController(CentroExposicoes centroDeExposicoes) {
        e_centroDeExposicoes = centroDeExposicoes;
    }

    public RegistoExposicoes iniciarAtribuicaoCandidatura() {
        return this.m_centroDeExposicoes.getListaExposicoes();
    }

    public void novaAtribuicaoCandidatura() {
        ac_novaAtribuicaoCandidatura = e_centroDeExposicoes.novaAtribuicaoCandidatura();
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
