/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.io.Serializable;
import lapr.project.model.CandidaturaDemonstracao;

/**
 *
 * @author Pedro Fernandes
 */
public class CandidaturaDemoCriada implements CandidaturaDemoEstado, Serializable{
    
    private final CandidaturaDemonstracao candidaturaDemonstracao;
    
    public CandidaturaDemoCriada(CandidaturaDemonstracao candidaturaDemonstracao){
        this.candidaturaDemonstracao=candidaturaDemonstracao;                
    }

    @Override
    public boolean validaEstadoCandidaturaDemo() {
        return true;
    }
    
    @Override
    public String toString(){
        return "CandidaturaDemoCriada";
    }
    
}