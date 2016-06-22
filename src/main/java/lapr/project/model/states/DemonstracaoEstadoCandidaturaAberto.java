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
public class DemonstracaoEstadoCandidaturaAberto implements DemonstracaoEstado, Serializable{
     private final  Demonstracao demonstracao;
    
    public DemonstracaoEstadoCandidaturaAberto(Demonstracao demonstracao){
        this.demonstracao=demonstracao;
    }

    public void run() {
        setDemonstracoesEmAberto();
    }
    
    public boolean setDemonstracoesEmAberto(){
        DemonstracaoEstado estadoAtual=demonstracao.getEstadoAtualDemonstracao();
        
        if(true==estadoAtual.valida())
            demonstracao.alterarEstado(new DemonstracaoEstadoCandidaturaAberto(demonstracao));
        
        return false;
    }
    
    @Override
    public boolean valida(){
       return demonstracao.getEstadoAtualDemonstracao() instanceof DemonstracaoEstadoDecidida; 
    }

   @Override
    public String toString(){
       return "Estado: demonstrações em aberto ";
    }

}