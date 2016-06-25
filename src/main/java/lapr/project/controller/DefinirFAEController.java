package lapr.project.controller;

import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.*;
import lapr.project.model.*;
import lapr.project.model.states.exposicao.*;

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

    /**
     * Cria nova instancia de Fae
     * @param centroExposicao
     * @param utilizador 
     */
    public DefinirFAEController(CentroExposicoes centroExposicao, Utilizador utilizador) {
        this.ce = centroExposicao;
        this.utilizador = utilizador;

    }
//    public List<Exposicao> getListaExposicaoOrganizadorSemFAEDefinidos(String email) {
//
//        return listaExposicao.getListaExposicaoOrganizadorSemFAEDefinidos(email);
//    }
/**
 * Altera registo de utilizadores
 */
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
/**
 * Devolve lista de utilizadores Fae
 * @return lista de utilizadores Fae
 */
    public RegistoUtilizadores getRegistoUtilizadoresFAE() {
        return m_registoUtilizadores;
    }
/**
 * Devolve a lista de Faes
 * @return lista de Faes
 */
    public ListaFAE getListaFAE() {

        return listaFaes;
    }
/**
 * Adiciona Fae
 * @param utilizador 
 */
    public void addFAE(Utilizador utilizador) {
        fae = listaFaes.addFAE(utilizador);

    }
/**
 * Valida o numero de faes minimo
 * @return true se valido, false se nao
 */
    public boolean validaMinFAE() {
        return listaFaes.validaMinFAE();
    }
/**
 * remove fae
 * @param fae 
 */
    public void removerFAE(FAE fae) {
        listaFaes.removerFAE(fae);
    }
/**
 * Altera lista de fae
 * @param lo 
 */
    public void setListaFAE(ListaFAE lo) {
        exposicao.setListaFaes(lo);
    }
/**
 * Seleciona exposicao
 * @param e 
 */
    public void selectExposicao(Exposicao e) {
        this.exposicao = e;
        listaFaes = exposicao.getListaFAE();
        listaOrganizadores = exposicao.getListaOrganizadores();
    }
/**
 * Devolve os dados do Fae como String
 * @return 
 */
    public String getFAEString() {
        return this.listaFaes.toStringCompleto();
    }
/**
 * Adiciona fae a lista de faes
 */
    public void adicionarFAE() {
        listaFaes.addFAE(fae);
    }
/**
 * Devolve lista de exposicoes
 * @return 
 */
    public RegistoExposicoes getExposicoes() {
        return listaExposicao = ce.getRegistoExposicoes();
    }
/**
 * Valida fae
 * @return true se valido, false se nao
 */
    public boolean registaMembroFAE() {

        if (fae.validaMenbroFAE()) {
            return true;
        }
        return false;

    }
/**
 * Actualiza estado da exposicao
 */
    public void atualizaExposicao() {
        ExposicaoEstado estado = exposicao.getEstadoAtualExposicao();
        exposicao.alterarEstado(estado);
    }

}
