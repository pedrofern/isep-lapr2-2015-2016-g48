/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.CandidaturaDemonstracao;

/**
 *
 * @author Pedro Fernandes
 */
@XmlTransient
@XmlSeeAlso({CandidaturaDemoAprovada.class,
            CandidaturaDemoEmInteresse.class,CandidaturaDemoNaoAprovada.class,
            CandidaturaDemoSubmetida.class})
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
