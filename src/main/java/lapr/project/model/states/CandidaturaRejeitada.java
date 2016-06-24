/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.Candidatura;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlTransient
//@XmlSeeAlso({CandidaturaAceite.class, CandidaturaAvaliada.class,CandidaturaEmAtribuicaoFAE.class,
//        CandidaturaEmAtribuicaoStand.class,CandidaturaEmAvaliacao.class,
//        CandidaturaEmSubmissao.class, CandidaturaEstadoInicial.class,
//        CandidaturaNaoAvaliada.class,
//        CandidaturaRetirada.class, CandidaturaTerminada.class})
public class CandidaturaRejeitada implements CandidaturaEstado, Serializable{

    private final Candidatura candidatura;
    
    public CandidaturaRejeitada(Candidatura candidatura){
        this.candidatura=candidatura;                
    }
    
    @Override
    public boolean validaEstadoCandidatura() {         
       return candidatura.getEstadoAtualCandidatura() instanceof CandidaturaAvaliada;
    }
    
    @Override
    public String toString(){
        return "CandidaturaRejeitada";
    }
    
}
