/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.io.Serializable;
import lapr.project.model.Demonstracao;


/**
 *
 * @author Edu
 */
public class DemonstracaoEstadoDecidida implements DemonstracaoEstado, Serializable{
    
    private final Demonstracao  demonstracao;

    public DemonstracaoEstadoDecidida(Demonstracao demonstracao){
        this.demonstracao=demonstracao;
    }
    
    public boolean setDecididas(){
        if(demonstracao.valida()!=true){
            return false;
        } else {
            return demonstracao.alterarEstado((DemonstracaoEstado) new DemonstracaoEstadoDecidida(demonstracao));
        }     
    }
 
    @Override
    public String toString(){
        return "Estado: candidaturas em decisão";
    }

    @Override
    public boolean valida(){
       return demonstracao.getEstadoAtualDemonstracao()instanceof DemonstracaoEstadoInteresse; 
    }  
}
