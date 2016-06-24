/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.io.Serializable;
import java.text.ParseException;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.Demonstracao;


/**
 *
 * @author Edu
 */
@XmlRootElement
//@XmlTransient
//@XmlSeeAlso({DemonstracaoEstadoCandidaturaAberto.class,DemonstracaoEstadoCriada.class,
//            DemonstracaoEstadoDecidida.class,
//            DemonstracaoEstadoInteresse.class,DemonstracaoEstadoRegistada.class,
//            DemonstracoesEstadoCandidaturaFechada.class})
public class DemonstracaoEstadoInicial implements DemonstracaoEstado, Serializable {

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
