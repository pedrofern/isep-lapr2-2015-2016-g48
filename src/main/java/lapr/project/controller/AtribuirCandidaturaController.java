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

    public AtribuirCandidaturaController(CentroExposicoes centroExposicoes, Utilizador u) {
        ce = centroExposicoes;
        user=u;  
        listaAtribuicoes=new ListaAtribuicoes();
    }
    
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
    
    public void setExposicao(Exposicao e){
        exposicao=e;
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
