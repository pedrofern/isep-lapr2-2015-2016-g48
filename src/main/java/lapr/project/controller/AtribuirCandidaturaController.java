package lapr.project.controller;

import java.util.*;
import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class AtribuirCandidaturaController {

    private CentroExposicoes e_centroDeExposicoes;
    private Exposicao m_exposicao;
    private Candidatura c_candidatura;
    private Organizador organizador;
    private List<Exposicao> m_listaExposicoes;
    private List<FAE> m_listaFAE;
    private List<Candidatura> c_listaCandidaturas;
    private Atribuicao ac_novaAtribuicaoCandidatura;
    private CentroExposicoes m_centroDeExposicoes;

    public AtribuirCandidaturaController(CentroExposicoes centroDeExposicoes) {
        e_centroDeExposicoes = centroDeExposicoes;
    }

    public List<Exposicao> iniciarAtribuicaoCandidatura() {
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

        for (ListIterator<Candidatura> it = c_listaCandidaturas.listIterator(); it.hasNext();) {
            lc.add(it.next());
        }

        return lc;
    }

    public List<FAE> getListaFAE() {
        List<FAE> lf = new ArrayList<FAE>();

        for (FAE f : m_listaFAE) {
            lf.add(f);
        }
        return lf;
    }

    private void addFAE(FAE f) {
        m_listaFAE.add(f);
    }

    public boolean validaAtribuicaoCandidatura() {
        return organizador.validaAtribuicaoCandidatura(ac_novaAtribuicaoCandidatura);
    }

    public boolean registaAtribuicaoCandidatura() {
        return organizador.registaAtribuicaoCandidatura(ac_novaAtribuicaoCandidatura);
    }

}
