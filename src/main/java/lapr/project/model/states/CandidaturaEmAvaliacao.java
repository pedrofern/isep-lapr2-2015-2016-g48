/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.Candidatura;

/**
 *
 * @author Pedro Fernandes
 */
@XmlTransient
@XmlSeeAlso({CandidaturaAceite.class, CandidaturaAvaliada.class,CandidaturaEmAtribuicaoFAE.class,
        CandidaturaEmAtribuicaoStand.class,
        CandidaturaEmSubmissao.class, CandidaturaEstadoInicial.class,
        CandidaturaNaoAvaliada.class,CandidaturaRejeitada.class,
        CandidaturaRetirada.class, CandidaturaTerminada.class})
public class CandidaturaEmAvaliacao implements CandidaturaEstado, Serializable{
    
    private final Candidatura candidatura;
    
    public CandidaturaEmAvaliacao(Candidatura candidatura){
        this.candidatura=candidatura;                
    }

    @Override
    public boolean validaEstadoCandidatura() {
        return candidatura.getEstadoAtualCandidatura() instanceof CandidaturaEmAtribuicaoFAE;
    }
    
    @Override
    public String toString(){
        return "CandidaturaEmAvaliacao";
    }
    
}
