/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.io.Serializable;
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
//            DemonstracaoEstadoDecidida.class,DemonstracaoEstadoInicial.class,
//            DemonstracaoEstadoRegistada.class,
//            DemonstracoesEstadoCandidaturaFechada.class})
public class DemonstracaoEstadoInteresse implements DemonstracaoEstado, Serializable {
    
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
