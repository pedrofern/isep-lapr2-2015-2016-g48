package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.lists.*;
import lapr.project.model.states.*;
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

    public CriarDemonstracaoController(Utilizador utilizador, CentroExposicoes ce) {
        this.ce = ce;
        this.utilizador = utilizador;

    }

    public void selectExposicao(Exposicao e) {
        this.exposicao = e;
        listaDemonstracao = exposicao.getListaDemonstracoes();
    }

    public void novaDemonstracao() {
        demonstracao = listaDemonstracao.novaDemonstracao();
        listaRecursoDemonstracao = demonstracao.getListaRecursosDemonstracao();
        listaRecursos=ce.getRegistoRecursos();
    }

    public Demonstracao registaDemonstracao(String descricao, String temaExposicao, Data inicio, Data fim) {

        demonstracao.setDados(descricao, temaExposicao, inicio, fim);

        return demonstracao;
    }

    public Demonstracao registaDemonstracao(String descricao, String temaExposicao) {

        demonstracao.setDados(descricao, temaExposicao);
        if (listaDemonstracao.adicionarDemonstracao(demonstracao)) {
            return demonstracao;
        } else {

            return null;
        }

    }

    public String getDemonstraçãoString() {
        return this.listaDemonstracao.toStringCompleto();
    }

    public void setDescricao(String novaDescricao) {
        this.demonstracao.setDesc(novaDescricao);
    }

    public RegistoRecursos getListaRecursos() {
        return listaRecursos;
    }

    public ListaRecursoDemonstracao getListaRecursosDemonstracao() {
        return demonstracao.getListaRecursosDemonstracao();
    }

    public void addRecursoDemonstracao(Recurso r) {
        this.demonstracao.addRecurso(r);
    }

    public RegistoExposicoes getRegistoExposicoes() {

        return registoExposicoes = ce.getRegistoExposicoes();
    }

    public RegistoExposicoes getListaExposicoes() {
        RegistoExposicoes le = new RegistoExposicoes();

        for (Exposicao e : registoExposicoes.getExposicoes()) {
            le.adicionarExposicao(e);
        }
        return le;
    }

    public boolean valida() {
        if (demonstracao.valida() == false) {
            return false;
        }
        return true;

    }

    public Demonstracao getDemonstracao() {
        return demonstracao;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void removerRecurso(Recurso recurso) {
        listaRecursoDemonstracao.removerRecurso(recurso);
    }

    public void setListaRecursoDemonstracao(ListaRecursoDemonstracao listarecursodemonstracao) {
        this.demonstracao.setRecursoDemonstracao(listarecursodemonstracao);
    }

    public boolean registaEstado() {
       
        if (demonstracao.valida())  {
            return false;
        }
        return true;

    }

}
