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

/**
 *
 * @author Pedro Fernandes
 */
public class DecidirCandidaturaController {
    
    private CentroExposicoes ce;
    private Candidatura candidatura;
    private Exposicao exposicao;
    private Utilizador utilizador;
    private ListaCandidaturas listaCandidaturas;
    private RegistoExposicoes registoExposicoes;
    private RegistoExposicoes leorganizador;
    
    public DecidirCandidaturaController(CentroExposicoes ce, Utilizador utilizador) {
        this.ce = ce;
        this.utilizador = utilizador;
    }
    
    public RegistoExposicoes getListaExposicoesOrganizador(){
        return leorganizador = ce.getRegistoExposicoes().getExposicoesOrganizador(utilizador);
    }
    
    public void selectExposicao(Exposicao exposicao){
        this.exposicao=exposicao;   
        listaCandidaturas = exposicao.getListaCandidaturas();//no estado a decidir
    }
    
    public void selectCandidatura(Candidatura candidatura){
        this.candidatura=candidatura;
    }
    
    public Candidatura getCandidaturaNome(){
        return candidatura;
    }
    
    public ListaAvaliacoes getDecisaoAvalicaoFAE(){
        return candidatura.getListaAvaliacoes();
    }
    
//    public String getAvalicaoQuestoesFAE(){
//        return candidatura.getListaAvaliacoes().
//    }
    
    
    
    
    
}
