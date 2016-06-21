/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;

/**
 *
 * @author Edu
 */
public class DemonstracaoEstadoInteresse implements DemonstracaoEstado {
    
        private final Demonstracao demonstracao;
 
    public DemonstracaoEstadoInteresse(Demonstracao demonstracao){
        this.demonstracao=demonstracao;
    }
    
    public boolean setRegistada(){
        if(demonstracao.getEstadoAtualDemonstracao().valida()!=true)
            return false;
        else
            return demonstracao.alterarEstado((DemonstracaoEstado) new DemonstracaoEstadoInteresse(demonstracao));
    }
    
 
    
    @Override
    public boolean valida(){
       return demonstracao.getEstadoAtualDemonstracao() instanceof DemonstracaoEstadoRegistada; 
    }
    
   @Override
    public String toString(){
        return "Estado; exposição com FAE definido, sem demonstração";
    }
    
}
