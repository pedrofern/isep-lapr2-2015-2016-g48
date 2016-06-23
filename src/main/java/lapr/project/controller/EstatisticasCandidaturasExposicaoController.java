/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;
import java.util.List;
import lapr.project.model.*;
import lapr.project.model.lists.*;


/**
 *
 * @author anasilva
 */
public class EstatisticasCandidaturasExposicaoController {

    
    private CentroExposicoes ce;
    private Candidatura cand;
    private ListaCandidaturas lista;
   
    
    public EstatisticasCandidaturasExposicaoController(CentroExposicoes ce){
     
        this.ce=ce;
    }
  
    
    
    public ListaCandidaturas getListaCandidaturas(){
        return lista=new ListaCandidaturas();
    }
    
    public void novaCandidatura(){
        cand=lista.novaCandidatura();
    }
    
    public void selectCandidatura(Candidatura c) {
        this.cand = c;
        lista = cand.getListaCandidaturas();
    }
}

