package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.lists.*;
import lapr.project.utils.Data;

/**
 *
 * @author Pedro Fernandes
 */
public class CriarDemonstracaoController {

    private Demonstracao demonstracao;
    private RegistoExposicoes registoExposicoes;
    private Exposicao exposicao;
    private RegistoRecursos listaRecursos;
    private Organizador organizador;
    
    public CriarDemonstracaoController(Organizador pOrganizador, Exposicao expo) {
        exposicao = expo;
        organizador=pOrganizador;
    }

    public void novaDemonstracao() {
        demonstracao = new Demonstracao();
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
        return listaRecursos;
    }
        
    public void addRecursoDemonstracao(Recurso r){
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
//        if (exposicao.getRegistoDemonstracao().registaDemonstracao(demonstracao)) {
//            return demonstracao;
//        }
//        return null;
//    }
    
    public Demonstracao getDemonstracao() {
        return demonstracao;
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
