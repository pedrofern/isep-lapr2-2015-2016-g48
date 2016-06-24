/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.io.Serializable;
import lapr.project.model.Candidatura;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pedro Fernandes
 */
//@XmlRootElement
@XmlTransient
@XmlSeeAlso({CandidaturaAvaliada.class,CandidaturaEmAtribuicaoFAE.class,
        CandidaturaEmAtribuicaoStand.class,CandidaturaEmAvaliacao.class,
        CandidaturaEmSubmissao.class, CandidaturaEstadoInicial.class,
        CandidaturaNaoAvaliada.class,CandidaturaRejeitada.class,
        CandidaturaRetirada.class, CandidaturaTerminada.class})
public class CandidaturaAceite implements CandidaturaEstado, Serializable{
    
    private final Candidatura candidatura;
    
    public CandidaturaAceite(Candidatura candidatura){
        this.candidatura=candidatura;                
    }

    @Override
    public boolean validaEstadoCandidatura() {
        return candidatura.getEstadoAtualCandidatura() instanceof CandidaturaAvaliada;
    }
    
    @Override
    public String toString(){
        return "CandidaturaAceite";
    }
    
}
