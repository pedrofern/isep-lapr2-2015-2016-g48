/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.EstatisticaFAE;
import lapr.project.model.Exposicao;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaKeywords;
import lapr.project.model.lists.RegistoExposicoes;

/**
 *
 * @author DianaSilva
 */
public class GerarEstatisticasKeywordsController {
    
    private CentroExposicoes ce;
    private ListaKeywords rankingAceites, rankingRecusadas;
    private ListaCandidaturas listaCandidaturas;
    
    public GerarEstatisticasKeywordsController(CentroExposicoes ce){
        this.ce=ce;
    }
    
    public boolean novoRankingAceites(){
        rankingAceites= new ListaKeywords();
        return rankingAceites.getListaKeyword().isEmpty();
    }
    
    public boolean novoRankingRecusadas(){
        rankingRecusadas= new ListaKeywords();
        return rankingRecusadas.getListaKeyword().isEmpty();
    }
    
    public RegistoExposicoes getExposicoesDecididas(){
        return ce.getRegistoExposicoes().getExposicoesCandidaturasDecididas();
    }
    
    public void setExposicao(Exposicao exposicao){
        listaCandidaturas=exposicao.getListaCandidaturas();
    }
    
//    public void gerarEstatisticasAceites(){
//        for(Candidatura c: listaCandidaturas.getListaCandidaturasAceites){
//            for(Keyword k: c.getListaKeywords().getListaKeyword()){
//                if(!rankingAceites.temKeyword(k)){
//                    Keyword keywordRanking=new Keyword();
//                    keywordRanking=k;
//                    keywordRanking.setUtilizacao();
//                    
//                    rankingAceites.adicionarKeyword(k));
//                } else{
//                    rankingAceites.setUtilizacao(k);
//                }
//            }
//        }
    
//        sort(rankingAceites);
//        sort(rankingRecusadas);
//    }
//    
//   
//    public void gerarFicheiro(){
//        
//    }
}
