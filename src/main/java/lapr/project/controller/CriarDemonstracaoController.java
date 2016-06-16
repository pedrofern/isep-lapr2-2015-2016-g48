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
    private Organizador organizador;
    private Recurso recurso;
    private ListaDemonstracoes listaDemonstracao;

    public CriarDemonstracaoController(Organizador pOrganizador, CentroExposicoes ce) {
        this.ce = ce;
        this.organizador = pOrganizador;
          
    }

    public Demonstracao novaDemonstracao() {
      return demonstracao = new Demonstracao();
    }

    public Demonstracao registaDemonstracao(String descricao, String temaExposicao, Data inicio, Data fim) {

        demonstracao.setDados(descricao, temaExposicao, inicio, fim);

        return demonstracao;
    }

//    public void setCodigoUnico(int codigoUnico) {
//        demonstracao.setCod(codigoUnico);
//    }
//    
    public void setDescricao(String novaDescricao) {
        demonstracao.setDesc(novaDescricao);
    }

//    public void setListaRecursos(RegistoRecursos novaListaRecursos) {
//        demonstracao.setListaRecursos(novaListaRecursos);
//    }
    public RegistoRecursos getListaRecursos() {
        return ce.getRegistoRecursos();
    }
    
    public ListaRecursoDemonstracao getListaRecursosDemonstracao() {
        return demonstracao.getListaRecursosDemonstracao();
    }

    public void addRecursoDemonstracao(Recurso r) {
        demonstracao.addRecurso(r);
    }

    public RegistoExposicoes getListaExposicoes() {
        RegistoExposicoes le = new RegistoExposicoes();

        for (Exposicao e : registoExposicoes.getExposicoes()) {
            le.adicionarExposicao(e);
        }
        return le;
    }

//    public Demonstracao registaDemonstracao() {
//        if (exposicao.getListaDemonstracoes().registaDemonstracao(demonstracao)) {
//            return demonstracao;
//        }
//        return null;
//    }
    public void selectExposicao(Exposicao e) {
        this.exposicao = e;
    }

    public Demonstracao getDemonstracao() {
        return demonstracao;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setListaRecurso(RegistoRecursos recurso) {
        demonstracao.setRecurso(listaRecursos);
    }

//    public Demonstracao setDados(int cdgUnico, String strDescricao) {
//        demonstracao.setCod(cdgUnico);
//        demonstracao.setDesc(strDescricao);
//
//        if (exposicao.getRegistoDemonstracao().validaDemonstracao(demonstracao)) {
//            return demonstracao;
//        } else {
//            return null;
//        }
//    }
}
