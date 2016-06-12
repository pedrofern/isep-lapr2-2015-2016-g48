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

    private static CentroExposicoes ce;
    private static Exposicao exposicao;
    private static Utilizador user;
    private static Candidatura candidatura;
    private static Organizador organizador;
    private static RegistoExposicoes registoExposicoes;
    private static ListaFAE listaFAEs;
    private static ListaCandidaturas cListaCandidaturas;
    private static Atribuicao acNovaAtribuicaoCandidatura;


    public AtribuirCandidaturaController(CentroExposicoes centroExposicoes) {
        ce = centroExposicoes;
    }

    public RegistoExposicoes iniciarAtribuicaoCandidatura() {
        return this.ce.getRegistoExposicoes();
    }

    public void novaAtribuicaoCandidatura() {
        
        //quem faz atribuição é o mecanismo...
//        acNovaAtribuicaoCandidatura = ce.novaAtribuicaoCandidatura();
    }

    public Atribuicao setAtribuicao() {
        if (organizador.validaAtribuicaoCandidatura(acNovaAtribuicaoCandidatura)) {
            return acNovaAtribuicaoCandidatura;
        } else {
            return null;
        }
    }

    public boolean registarDecisao() {
        return organizador.registaAtribuicaoCandidatura(acNovaAtribuicaoCandidatura);
    }

    public String getInfoResumo() {
        return this.acNovaAtribuicaoCandidatura.getInfo();
    }

    public List<Candidatura> getListaCandidaturas() {
        List<Candidatura> lc = new ArrayList<Candidatura>();

        for (ListIterator<Candidatura> it = cListaCandidaturas.getListaCandidaturas().listIterator(); it.hasNext();) {
            lc.add(it.next());
        }

        return lc;
    }

    public ListaFAE getListaFAE() {
        ListaFAE lf = new ListaFAE();

        for (FAE f : listaFAEs.getListaFAE()) {
            lf.adicionarFAE(f);
        }
        return lf;
    }

    private void addFAE(FAE f) {
        listaFAEs.adicionarFAE(f);
    }

    public boolean validaAtribuicaoCandidatura() {
        return organizador.validaAtribuicaoCandidatura(acNovaAtribuicaoCandidatura);
    }

    public boolean registaAtribuicaoCandidatura() {
        return organizador.registaAtribuicaoCandidatura(acNovaAtribuicaoCandidatura);
    }

}
