/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.io.Serializable;
import lapr.project.model.Candidatura;

/**
 *
 * @author Pedro Fernandes
 */
public class CandidaturaRejeitada implements CandidaturaEstado, Serializable{

    private final Candidatura candidatura;
    
    public CandidaturaRejeitada(Candidatura candidatura){
        this.candidatura=candidatura;                
    }
    
    @Override
    public boolean validaEstadoCandidatura() {         
       return candidatura.getEstadoAtualCandidatura() instanceof CandidaturaAvaliada;
    }
    
    @Override
    public String toString(){
        return "CandidaturaRejeitada";
    }
    
}