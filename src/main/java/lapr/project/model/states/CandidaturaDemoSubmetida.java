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
import lapr.project.model.CandidaturaDemonstracao;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
//@XmlTransient
//@XmlSeeAlso({CandidaturaDemoAprovada.class,CandidaturaDemoCriada.class,
//            CandidaturaDemoEmInteresse.class,CandidaturaDemoNaoAprovada.class})
public class CandidaturaDemoSubmetida implements CandidaturaDemoEstado, Serializable{
    
    private final CandidaturaDemonstracao candidaturaDemonstracao;
    
    public CandidaturaDemoSubmetida(CandidaturaDemonstracao candidaturaDemonstracao){
        this.candidaturaDemonstracao=candidaturaDemonstracao;                
    }

    @Override
    public boolean validaEstadoCandidaturaDemo() {
        return candidaturaDemonstracao.getEstadoAtualCandidatura() instanceof CandidaturaDemoAprovada;
    }
    
    @Override
    public String toString(){
        return "CandidaturaDemoSubmetida";
    }
    
}
