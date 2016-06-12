package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.lists.*;
import lapr.project.utils.Data;

/**
 *
 * @author Pedro Fernandes
 */
public class CriarDemonstracaoController {

    private Demonstracao demonstravao;
    private RegistoExposicoes registoExposicoes;
    private Exposicao exposicao;
    private RegistoRecursos listaRecursos;
    private Organizador organizador;
    
    public CriarDemonstracaoController(Organizador pOrganizador, Exposicao expo) {
        exposicao = expo;
        organizador=pOrganizador;
    }

    public void novaDemonstracao() {
        exposicao.getListaDemonstracoes().novaDemonstracao();
    }

    public Demonstracao registaDemonstracao(String descricao, String temaExposicao, Data inicio, Data fim) {
       
        demonstravao.setDados(descricao, temaExposicao, inicio, fim);
        
        return demonstravao;
    }

//    public void setCodigoUnico(int codigoUnico) {
//        demonstravao.setCod(codigoUnico);
//    }
//    
    public void setDescricao(String novaDescricao) {
        demonstravao.setDesc(novaDescricao);
    }
    
//    public void setListaRecursos(RegistoRecursos novaListaRecursos) {
//        demonstravao.setListaRecursos(novaListaRecursos);
//    }
    
    public RegistoRecursos getListaRecursos() {
        return listaRecursos;
    }
        
    public void addRecursoDemonstracao(Recurso r){
        demonstravao.addRecurso(r);
    }
    
    public RegistoExposicoes getListaExposicoes() {
        RegistoExposicoes le = new RegistoExposicoes();

        for (Exposicao e : registoExposicoes.getExposicao()) {
            le.adicionarExposicao(e);
        }
        return le;
    }

//    public Demonstracao registaDemonstracao() {
//        if (exposicao.getRegistoDemonstracao().registaDemonstracao(demonstravao)) {
//            return demonstravao;
//        }
//        return null;
//    }
    
    public Demonstracao getDemonstracao() {
        return demonstravao;
    }
    
//    public Demonstracao setDados(int cdgUnico, String strDescricao) {
//        demonstravao.setCod(cdgUnico);
//        demonstravao.setDesc(strDescricao);
//
//        if (exposicao.getRegistoDemonstracao().validaDemonstracao(demonstravao)) {
//            return demonstravao;
//        } else {
//            return null;
//        }
//    }
}
