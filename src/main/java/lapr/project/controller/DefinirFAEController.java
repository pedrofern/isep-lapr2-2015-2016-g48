package lapr.project.controller;

import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.*;
import java.util.*;
import lapr.project.model.*;
import lapr.project.model.states.ExposicaoEstado;
import lapr.project.model.states.*;

/**
 *
 * @author Eduângelo Ferreira Nºaluno 1151094 <1151094@isep.ipp.pt>
 */
public class DefinirFAEController {

    private CentroExposicoes ce;
    private Exposicao exposicao;
    private FAE fae;
    private ListaFAE listaFaes;
    private ListaOrganizadores listaOrganizadores;
    private RegistoUtilizadores m_registoUtilizadores;
    private Utilizador utilizador;
    private RegistoExposicoes listaExposicao;
    private RegistoUtilizadores listaUtilizador;

    public DefinirFAEController(CentroExposicoes centroExposicao, Utilizador utilizador) {
        this.ce = centroExposicao;
        this.utilizador = utilizador;

    }
//    public List<Exposicao> getListaExposicaoOrganizadorSemFAEDefinidos(String email) {
//
//        return listaExposicao.getListaExposicaoOrganizadorSemFAEDefinidos(email);
//    }

    public void setRegistoUTilizadores() {
        m_registoUtilizadores = ce.getRegistoUtilizadoresRegistados();
        listaUtilizador = new RegistoUtilizadores();
        Organizador organizador=new Organizador();
        for (Utilizador u : m_registoUtilizadores.getListaUtilizadores()) {

            for (Organizador o : listaOrganizadores.getListaOrganizadores()) {
                if (!(u.getUsername().equals(o.getUtilizador().getUsername()))) {
                    if (!(u.getUsername().equals("Organizador"))) {
                            listaUtilizador.addUtilizador(u);
                    }

                }
            }

        }

        m_registoUtilizadores = listaUtilizador;
    }

    public RegistoUtilizadores getRegistoUtilizadoresFAE() {
        return m_registoUtilizadores;
    }

    public ListaFAE getListaFAE() {

        return listaFaes;
    }

    public void addFAE(Utilizador utilizador) {
        fae = listaFaes.addFAE(utilizador);

    }

    public boolean validaMinFAE() {
        return listaFaes.validaMinFAE();
    }

    public void removerFAE(FAE fae) {
        listaFaes.removerFAE(fae);
    }

    public void setListaFAE(ListaFAE lo) {
        exposicao.setListaFaes(lo);
    }

    public void selectExposicao(Exposicao e) {
        this.exposicao = e;
        listaFaes = exposicao.getListaFAE();
        listaOrganizadores = exposicao.getListaOrganizadores();
    }

    public String getFAEString() {
        return this.listaFaes.toStringCompleto();
    }

    public void adicionarFAE() {
        listaFaes.addFAE(fae);
    }

    public RegistoExposicoes getExposicoes() {
        return listaExposicao = ce.getRegistoExposicoes();
    }

    public boolean registaMembroFAE() {

        if (fae.validaMenbroFAE()) {
            return true;
        }
        return false;

    }

    public boolean atualizaExposicao() {
        ExposicaoEstado estado = exposicao.getEstadoAtualExposicao();
        exposicao.alterarEstado(estado);
        return !((estado instanceof ExposicaoEstadoCriada) || (estado instanceof ExposicaoDemonstracaoSemFAE));

    }

}
