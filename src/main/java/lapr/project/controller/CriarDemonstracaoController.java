package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.lists.*;

import lapr.project.utils.Data;

/**
 *
 * @author Pedro Fernandes
 */
public class CriarDemonstracaoController {

    private CentroExposicoes ce;
    private Demonstracao demonstracao;
    private RegistoExposicoes registoExposicoes;
    private Exposicao exposicao;
    private RegistoRecursos listaRecursos;
    private Utilizador utilizador;
    private Recurso recurso;
    private ListaDemonstracoes listaDemonstracao;
    private ListaRecursoDemonstracao listaRecursoDemonstracao;

    /**
     * Cria uma instancia ce criarDemonstracaoController
     * @param utilizador
     * @param ce 
     */
    public CriarDemonstracaoController(Utilizador utilizador, CentroExposicoes ce) {
        this.ce = ce;
        this.utilizador = utilizador;

    }
/**
 * Seleciona uma exposicao de uma lista
 * @param e 
 */
    public void selectExposicao(Exposicao e) {
        this.exposicao = e;
        listaDemonstracao = exposicao.getListaDemonstracoes();
    }
/**
 * Cria uma nova demonstracao
 * @throws Exception 
 */
    public void novaDemonstracao() throws Exception {
        demonstracao = listaDemonstracao.novaDemonstracao();
        listaRecursoDemonstracao = demonstracao.getListaRecursosDemonstracao();
        listaRecursos=ce.getRegistoRecursos();
    }
/**
 * Regista os dados de uma demonstracao
 * @param descricao
 * @param temaExposicao
 * @param inicio
 * @param fim
 * @return dados da demonstracao
 */
    public Demonstracao registaDemonstracao(String descricao, String temaExposicao, Data inicio, Data fim) {

        demonstracao.setDados(descricao, temaExposicao, inicio, fim);

        return demonstracao;
    }
/**
 * Regista descricao e tema da demonstracao
 * @param descricao
 * @param temaExposicao
 * @return descricao e tema da demonstracao
 */
    public Demonstracao registaDemonstracao(String descricao, String temaExposicao) {

        demonstracao.setDados(descricao, temaExposicao);
        if (listaDemonstracao.adicionarDemonstracao(demonstracao)) {
            return demonstracao;
        } else {

            return null;
        }

    }
/**
 * Devolve a demonstracao como string
 * @return a demonstracao como string
 */
    public String getDemonstracaoString() {
        return this.listaDemonstracao.toStringCompleto();
    }
/**
 * Altera a descricao
 * @param novaDescricao 
 */
    public void setDescricao(String novaDescricao) {
        this.demonstracao.setDesc(novaDescricao);
    }
/**
 * Devolve a lista de recursos
 * @return a lista de recursos
 */
    public RegistoRecursos getListaRecursos() {
        return listaRecursos;
    }
/**
 * Devolve a lista de recursos a demonstracao
 * @return a lista de recursos a demonstracao
 */
    public ListaRecursoDemonstracao getListaRecursosDemonstracao() {
        return demonstracao.getListaRecursosDemonstracao();
    }
/**
 * Adiciona recurso a demonstracao
 * @param r 
 */
    public void addRecursoDemonstracao(Recurso r) {
        this.demonstracao.addRecurso(r);
    }
/**
 * Devolve a lista de exposicoes do organizador
 * @return a lista de expsosicoes do organizador
 */
    public RegistoExposicoes getRegistoExposicoes() {

        return (registoExposicoes = ce.getRegistoExposicoes().getExposicoesOrganizador(utilizador));
    }
/**
 * Devolve a lista de exposicoes
 * @return a lista de exposicoes
 */
    public RegistoExposicoes getListaExposicoes() {
        RegistoExposicoes le = new RegistoExposicoes();

        for (Exposicao e : registoExposicoes.getExposicoes()) {
            le.adicionarExposicao(e);
        }
        return le;
    }
/**
 * Valida demonstracao
 * @return true se valida, false se nao
 */
    public boolean valida() {
        if (demonstracao.valida() == false) {
            return false;
        }
        return true;

    }
/**
 * Devolve a demonstracao
 * @return a demonstracao
 */
    public Demonstracao getDemonstracao() {
        return demonstracao;
    }
/**
 * Devolve o recurso
 * @return o recurso
 */
    public Recurso getRecurso() {
        return recurso;
    }
/**
 * Remove o recurso
 * @param recurso 
 */
    public void removerRecurso(Recurso recurso) {
        listaRecursoDemonstracao.removerRecurso(recurso);
    }
/**
 * Altera a lista de recursos a demonstracao
 * @param listarecursodemonstracao 
 */
    public void setListaRecursoDemonstracao(ListaRecursoDemonstracao listarecursodemonstracao) {
        this.demonstracao.setRecursoDemonstracao(listarecursodemonstracao);
    }
/**
 * Verifica se a demonstracao e valida
 * @return true se for valida, false se nao
 */
    public boolean registaEstado() {
       
        if (demonstracao.valida())  {
            return false;
        }
        return true;

    }

}
