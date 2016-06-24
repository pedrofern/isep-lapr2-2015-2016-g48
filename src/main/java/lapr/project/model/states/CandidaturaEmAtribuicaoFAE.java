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
@XmlSeeAlso({CandidaturaAceite.class, CandidaturaAvaliada.class,
        CandidaturaEmAtribuicaoStand.class,CandidaturaEmAvaliacao.class,
        CandidaturaEmSubmissao.class, CandidaturaEstadoInicial.class,
        CandidaturaNaoAvaliada.class,CandidaturaRejeitada.class,
        CandidaturaRetirada.class, CandidaturaTerminada.class})
public class CandidaturaEmAtribuicaoFAE implements CandidaturaEstado, Serializable{
    
    private final Candidatura candidatura;
    
    public CandidaturaEmAtribuicaoFAE(Candidatura candidatura){
        this.candidatura=candidatura;                
    }
    
    public boolean setEmAvaliacao(){
        if(validaEstadoCandidatura()){
            
            candidatura.setEstadoCandidatura(new CandidaturaEmAvaliacao(candidatura));
            return true;
        }
        return false;
    }

    @Override
    public boolean validaEstadoCandidatura() {
        return candidatura.getEstadoAtualCandidatura() instanceof CandidaturaEmSubmissao;
    }
    
    @Override
    public String toString(){
        return "CandidaturaEmAtribuicaoFAE";
    }
    
}
