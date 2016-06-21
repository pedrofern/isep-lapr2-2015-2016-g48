/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.text.ParseException;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;

/**
 *
 * @author Edu
 */
public class DemonstracaoEstadoInicial implements DemonstracaoEstado {

    private final Demonstracao demonstracao;
    
    public DemonstracaoEstadoInicial (Demonstracao demonstracao){
        this.demonstracao=demonstracao;       
    }

    public boolean setCriada() throws ParseException{
        if(valida()){
            
            demonstracao.createTimers();
            return demonstracao.alterarEstado((DemonstracaoEstado)new DemonstracaoEstadoRegistada(demonstracao));
            
        }
        return false;
    }
    
    @Override
    public boolean valida(){
       return true;
    }

    
    public String toString(){
        return "Estado demonstração: inicial";
    }
    
}
