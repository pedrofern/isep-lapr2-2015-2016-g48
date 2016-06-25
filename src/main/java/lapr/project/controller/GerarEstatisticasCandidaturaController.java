/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Candidatura;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.EstatisticaCandidatura;
import lapr.project.model.EstatisticaFAE;
import lapr.project.model.Exposicao;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.RegistoExposicoes;

/**
 *
 * @author DianaSilva
 */
public class GerarEstatisticasCandidaturaController {
    
    private final CentroExposicoes ce;
    private final Utilizador user;  
    private EstatisticaCandidatura estatistica;
    
    public GerarEstatisticasCandidaturaController(CentroExposicoes centroExposicoes, Utilizador user){
        this.user=user;
        ce=centroExposicoes;
    }
    
    public RegistoExposicoes getRegistoExposicoesOrganizador(){
        return ce.getRegistoExposicoes().getExposicoesOrganizador(user);
    }
    
    public void setExposicao(Exposicao exposicao){
        estatistica=exposicao.getEstatisticaCandidatura();
        estatistica.setListaCandidaturas(exposicao.getListaCandidaturas());
    }
    
    public void getEstatisticasCandidaturas(){
//        estatistica.getEstatisticasCandidaturas();
    }
    
    public void getEstatisticaCandidaturasGlobal(){
        
    }
}
