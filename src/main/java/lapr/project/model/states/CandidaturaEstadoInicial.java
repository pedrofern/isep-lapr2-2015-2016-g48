/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import lapr.project.model.Candidatura;

/**
 *
 * @author Pedro Fernandes
 */
public class CandidaturaEstadoInicial implements CandidaturaEstado{
    private final Candidatura candidatura;
    
    public CandidaturaEstadoInicial(Candidatura candidatura){
        this.candidatura=candidatura;                
    }
    
    @Override
    public boolean validaEstadoCandidatura() {
        return true;
    }
    
    @Override
    public String toString(){
        return "CandidaturaEstadoInicial";
    }
    
}
