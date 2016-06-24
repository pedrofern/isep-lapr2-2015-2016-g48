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
@XmlSeeAlso({CandidaturaDemoAprovada.class,CandidaturaDemoCriada.class,
            CandidaturaDemoNaoAprovada.class,CandidaturaDemoSubmetida.class})
public class CandidaturaDemoEmInteresse implements CandidaturaDemoEstado, Serializable{
    
    private final CandidaturaDemonstracao candidaturaDemonstracao;
    
    public CandidaturaDemoEmInteresse(CandidaturaDemonstracao candidaturaDemonstracao){
        this.candidaturaDemonstracao=candidaturaDemonstracao;                
    }

    @Override
    public boolean validaEstadoCandidaturaDemo() {
        return candidaturaDemonstracao.getEstadoAtualCandidatura() instanceof CandidaturaDemoCriada;
    }
    
    @Override
    public String toString(){
        return "CandidaturaDemoEmInteresse";
    }
    
}
