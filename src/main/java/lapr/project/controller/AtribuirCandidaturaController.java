package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.lists.*;

/**
 *
 * @author DianaSilva
 */
public class AtribuirCandidaturaController {

    private static CentroExposicoes ce;
    private Exposicao exposicao;
    private Utilizador user;
    private ListaCandidaturas listaCandidaturas;
    private ListaAtribuicoes listaAtribuicoes;

    /**
     * Cria nova instancia da classe
     * @param centroExposicoes
     * @param u 
     */
    public AtribuirCandidaturaController(CentroExposicoes centroExposicoes, Utilizador u) {
        ce = centroExposicoes;
        user=u;  
        listaAtribuicoes=new ListaAtribuicoes();
    }
    /**
     * Devolve a lista de exposicoes
     * @return a lista de exposicoes
     */
    public RegistoExposicoes getListaExposicoes(){
        RegistoExposicoes listaExposicoesAtribuiveisOrg=new RegistoExposicoes();
        for(Exposicao e:ce.getRegistoExposicoes().getExposicoesOrganizador(user).getExposicoes()){
            for(Exposicao e1: ce.getRegistoExposicoes().getExposicoesCandidaturasEmAtribuicao().getExposicoes()){
                if(e.equals(e1)){
                    listaExposicoesAtribuiveisOrg.adicionarExposicao(e);
                }
            }
        };
        return listaExposicoesAtribuiveisOrg;
    }
    /**
     * Altera a exposicao
     * @param e 
     */
    public void setExposicao(Exposicao e){
        exposicao=e;
        listaAtribuicoes=e.getListaAtribuicoes();
        listaCandidaturas=e.getListaCandidaturas().getListaCandidaturasEmAtribuicao();
    }
    /**
     * Devolve a exposicao
     * @return 
     */
    public Exposicao getExposicao(){
        return exposicao;
    }
    /**
     * Devolve a lista de faes
     * @return a lista de faes
     */
    public ListaFAE getListaFaes(){
        return exposicao.getListaFAE();
    }
    /**
     * Devolve a lista de atribuicoes 
     * @return a lista de atribuicoes
     */
    public ListaAtribuicoes getListaAtribuicoes(){
        return listaAtribuicoes;
    }
    /**
     * Guarda a lista de atribuicoes
     * @param listaAtribuicoes 
     */
    public void guardaAtribuicoes(ListaAtribuicoes listaAtribuicoes){
        exposicao.setListaAtribuicoes(listaAtribuicoes);
        
    }
    /**
     * Devolve a lista de candidaturas
     * @return a lista de candidaturas
     */
    public ListaCandidaturas getListaCandidaturas(){
        return listaCandidaturas;
    }
        
}
