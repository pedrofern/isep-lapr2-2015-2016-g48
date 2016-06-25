/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.lists.*;
import lapr.project.model.states.candidaturasExpo.*;

/**
 *
 * @author Pedro Fernandes
 */
public class DecidirCandidaturaController {
    
    /**
     * O centro de exposicoes
     */
    private CentroExposicoes ce;
    /**
     * A candidatura
     */
    private Candidatura candidatura;
    /**
     * A exposicao
     */
    private Exposicao exposicao;
    /**
     * O utilizador
     */
    private Utilizador utilizador;
    /**
     * A lista de avaliacoes
     */
    private ListaAvaliacoes listaAvaliacoes;
    /**
     * A lista de candidaturas
     */
    private ListaCandidaturas listaCandidaturas;
    
    /**
     * O registo de exposicoes
     */
    private RegistoExposicoes registoExposicoes;
    
    /**
     * A lista de exposicoes do organizador
     */
    private RegistoExposicoes leorganizador;
    /**
     * A decisao
     */
    private boolean decisao;
    
    /**
     * Cria uma instancia nova da classe
     * @param ce
     * @param utilizador 
     */
    public DecidirCandidaturaController(CentroExposicoes ce, Utilizador utilizador) {
        this.ce = ce;
        this.utilizador = utilizador;
        registoExposicoes = ce.getRegistoExposicoes();
    }
    /**
     * Devolve a lista de exposicoes do organizador
     * @return 
     */
    public RegistoExposicoes getListaExposicoesOrganizador(){
        return leorganizador = registoExposicoes.getExposicoesOrganizador(utilizador);
    }
    /**
     * Devolve a lista de exposicoes
     * @return a lista de exposicoes
     */
    public RegistoExposicoes getListaExposicoes(){
        return registoExposicoes;
    }
    /**
     * Seleciona uma exposicao de uma lista
     * @param exposicao 
     */
    public void selectExposicao(Exposicao exposicao){
        this.exposicao=exposicao;  
        listaCandidaturas = exposicao.getListaCandidaturas();
    }
    /**
     * Seleciona uma candidatura de uma lista
     * @param candidatura 
     */
    public void selectCandidatura(Candidatura candidatura){
        this.candidatura=candidatura;
        listaAvaliacoes = candidatura.getListaAvaliacoes();
    }
    /**
     * Devolve Informacao da candidatura por decidir
     * @return Informacao da candidatura por decidir
     */
    public ListaCandidaturas getInformacaoDaCandidaturaPorDecidir(){
        return listaCandidaturas;
    }
    /**
     * Devolve a lista de avaliacoes do fae
     * @return 
     */
    public ListaAvaliacoes getListaAvaliacoesFAE(){
        return listaAvaliacoes;
    }
/**
 * Devolve a lista de candidaturas por decidir
 * @return a lista de candidaturas por decidir
 */
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
/**
 * Decide se aceita ou rejeita a decisao
 * @param decisao 
 */
    public void registaDecisao(boolean decisao){        
        if(candidatura.getEstadoAtualCandidatura() instanceof CandidaturaAvaliada){
            candidatura.setDecisao(decisao);
            if (decisao){
                candidatura.setEstadoCandidatura(new CandidaturaAceite());
            }
            candidatura.setEstadoCandidatura(new CandidaturaRejeitada());
        }
    }
    
}
