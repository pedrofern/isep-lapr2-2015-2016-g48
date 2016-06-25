/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.RegistoExposicoes;

/**
 *
 * @author DianaSilva
 */
public class GerarEstatisticasCandidaturaController {
    
    private CentroExposicoes ce;
    private Utilizador user;  
    private ListaCandidaturas listaCandidaturas;
    
    public GerarEstatisticasCandidaturaController(CentroExposicoes centroExposicoes, Utilizador user){
        this.user=user;
        ce=centroExposicoes;
    }
    
    public RegistoExposicoes getRegistoExposicoesOrganizador(){
        return ce.getRegistoExposicoes().getExposicoesOrganizador(user);
    }
    
    public void setExposicao(Exposicao exposicao){
        listaCandidaturas=exposicao.getListaCandidaturas();
    }
    
//    public void novaEstatistica(){
//        exposicao.criar....
//    }
    
    public void getEstatisticaCandidaturasGlobal(){
        
    }
}
