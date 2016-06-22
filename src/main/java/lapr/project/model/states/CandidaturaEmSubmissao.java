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
public class CandidaturaEmSubmissao implements CandidaturaEstado, Serializable{
    
    private final Candidatura candidatura;
    
    public CandidaturaEmSubmissao(Candidatura candidatura){
        this.candidatura=candidatura;                
    }

    @Override
    public boolean validaEstadoCandidatura() {
        return candidatura.getEstadoAtualCandidatura() instanceof CandidaturaEstadoInicial;
    }
    
    public boolean setEstado(){
        CandidaturaEstado estadoAtual=candidatura.getEstadoAtualCandidatura();
        
        if(estadoAtual.validaEstadoCandidatura()==true)
            candidatura.setEstadoCandidatura((CandidaturaEstado) new CandidaturaEmSubmissao(candidatura));
        
        return false;
        
    }
    
    @Override
    public String toString(){
        return "CandidaturaEmSubmissao";
    }
    
}
