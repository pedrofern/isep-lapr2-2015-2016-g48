/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import java.util.ListIterator;
import lapr.project.model.*;
import lapr.project.model.lists.*;
import lapr.project.model.states.*;

/**
 *
 * @author Pedro Fernandes
 */
public class DecidirCandidaturaController {
    
    private CentroExposicoes ce;
    private Candidatura candidatura;
    private Exposicao exposicao;
    private Utilizador utilizador;
    private ListaAvaliacoes listaAvaliacoes;
    private ListaCandidaturas listaCandidaturas;
    private RegistoExposicoes registoExposicoes;
    private RegistoExposicoes leorganizador;
    private boolean decisao;
    
    public DecidirCandidaturaController(CentroExposicoes ce, Utilizador utilizador) {
        this.ce = ce;
        this.utilizador = utilizador;
        registoExposicoes = ce.getRegistoExposicoes();
    }
    
    public RegistoExposicoes getListaExposicoesOrganizador(){
        return leorganizador = registoExposicoes.getExposicoesOrganizador(utilizador);
    }
    
    public RegistoExposicoes getListaExposicoes(){
        return registoExposicoes;
    }
    
    public void selectExposicao(Exposicao exposicao){
        this.exposicao=exposicao;  
        listaCandidaturas = exposicao.getListaCandidaturas();
    }
    
    public void selectCandidatura(Candidatura candidatura){
        this.candidatura=candidatura;
        listaAvaliacoes = candidatura.getListaAvaliacoes();
    }
    
//    public ListaCandidaturas getInformacaoDaCandidaturaPorDecidir(){
//        //for candida avaliadas
//        
//        return listaCandidaturas;
//    }

    public ListaCandidaturas getListaCandidaturasPorDecidir(){
        ListaCandidaturas listaTemp = listaCandidaturas;
        for (int i=0;i<listaCandidaturas.tamanho();i++){
            Candidatura c = listaCandidaturas.obterCandidatura(i);
            if(c.getEstadoAtualCandidatura() instanceof CandidaturaAvaliada){
                listaTemp.addCandidatura(c);
            }
        }
        return listaTemp;
    }

    public void registaDecisao(boolean decisao){        
        if(candidatura.getEstadoAtualCandidatura() instanceof CandidaturaAvaliada){
            candidatura.setDecisao(decisao);
            if (decisao){
                candidatura.setEstadoCandidatura(new CandidaturaAceite(candidatura));
            }
            candidatura.setEstadoCandidatura(new CandidaturaRejeitada(candidatura));
        }
    }
    
}
