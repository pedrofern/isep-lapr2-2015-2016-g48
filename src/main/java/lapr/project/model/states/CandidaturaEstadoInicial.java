/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlRootElement;
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
//        CandidaturaEmSubmissao.class, 
//        CandidaturaNaoAvaliada.class,CandidaturaRejeitada.class,
//        CandidaturaRetirada.class, CandidaturaTerminada.class})
public class CandidaturaEstadoInicial implements CandidaturaEstado, Serializable{

    private CandidaturaEmSubmissao estadoCandidaturaEmSubmissao;
    
    public CandidaturaEstadoInicial(Candidatura candidatura){
        estadoCandidaturaEmSubmissao = new CandidaturaEmSubmissao(candidatura);
    }
    
    @Override
    public boolean validaEstadoCandidatura() {
        return true;
    }
    
    @Override
    public String toString(){
        return "CandidaturaEstadoInicial";
    }
    
}
