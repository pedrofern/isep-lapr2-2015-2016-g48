/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Candidatura;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Keyword;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaKeywords;
import lapr.project.model.lists.RegistoExposicoes;

/**
 *
 * @author DianaSilva
 */
public class GerarEstatisticasKeywordsController {
    
    private CentroExposicoes ce;
    private ListaKeywords rankingAceites;
    private ListaKeywords rankingRecusadas;
    private ListaCandidaturas listaCandidaturas;
    
    /**
     * Cria nova instancia da classe
     * @param ce 
     */
    public GerarEstatisticasKeywordsController(CentroExposicoes ce){
        this.ce=ce;
    }
    /**
     * Verifica se novos rankings foram aceites
     * @return true se sim, false se nao
     */
    public boolean novoRankingAceites(){
        rankingAceites= new ListaKeywords();
        return rankingAceites.getListaKeyword().isEmpty();
    }
    /**
     * verifica se novos rankings foram recusados
     * @return true se sim, false se nao
     */
    public boolean novoRankingRecusadas(){
        rankingRecusadas= new ListaKeywords();
        return rankingRecusadas.getListaKeyword().isEmpty();
    }
    /**
     * Devolve lista de exposicoes decididas
     * @return lista de exposicoes decididas
     */
    public RegistoExposicoes getExposicoesDecididas(){
        return ce.getRegistoExposicoes().getExposicoesCandidaturasDecididas();
    }
    /**
     * Altera exposicao
     * @param exposicao 
     */
    public void setExposicao(Exposicao exposicao){
        listaCandidaturas=exposicao.getListaCandidaturas();
    }
    
    public void gerarEstatisticasAceites(){
        for(Candidatura c: listaCandidaturas.getListaCandidaturas()){
            if(c.getDecisao()==true){
                
           
                for(Keyword k: c.getListaKeywords().getListaKeyword()){
                    if(!rankingAceites.contem(k)){
                        Keyword keywordRanking=new Keyword();
                        keywordRanking=k;
                        keywordRanking.setUtilizacoes();

                        rankingAceites.adicionarKeyword(k);
                    } else{
                        rankingAceites.setUtilizacao(k);
                    }
                }
            }
        }
    
//        sort(rankingAceites);
//        sort(rankingRecusadas);
    }
}
