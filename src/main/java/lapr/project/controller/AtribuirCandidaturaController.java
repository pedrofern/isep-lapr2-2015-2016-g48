package lapr.project.controller;

import lapr.project.model.Atribuicao;
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
    private static ListaFAE listaFAEs;
    private static ListaCandidaturas listaCandidaturas;
    private ListaAtribuicoes listaAtribuicoes;

    public AtribuirCandidaturaController(CentroExposicoes centroExposicoes, Utilizador u) {
        ce = centroExposicoes;
        user=u;  
        listaAtribuicoes=new ListaAtribuicoes();
    }
    
    public RegistoExposicoes getListaExposicoes(Utilizador u){
        RegistoExposicoes listaExposicoesAtribuiveisOrg=new RegistoExposicoes();
        listaExposicoesAtribuiveisOrg=ce.getRegistoExposicoes().getExposicoesCandidaturasEmAtribuicao();
        return listaExposicoesAtribuiveisOrg;
    }
    
    public void setExposicao(Exposicao e){
        exposicao=e;
        listaFAEs=e.getListaFAE();
        listaAtribuicoes=e.getListaAtribuicoes();
        listaCandidaturas=e.getListaCandidaturas().getListaCandidaturasEmAtribuicao();
    }
    
    public Exposicao getExposicao(){
        return exposicao;
    }
    
    public ListaFAE getListaFaes(){
        return exposicao.getListaFAE();
    }
    
    public ListaAtribuicoes getListaAtribuicoes(){
        return listaAtribuicoes;
    }
    
    public void guardaAtribuicoes(ListaAtribuicoes listaAtribuicoes){
        exposicao.setListaAtribuicoes(listaAtribuicoes);
        
    }
    
    public ListaCandidaturas getListaCandidaturas(){
        return listaCandidaturas;
    }
        
}
