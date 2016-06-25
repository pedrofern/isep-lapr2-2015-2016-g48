/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states.candidaturasExpo;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.Candidatura;

/**
 *
 * @author Pedro Fernandes
 */
@XmlTransient
@XmlSeeAlso({CandidaturaAceite.class, CandidaturaAvaliada.class,
    CandidaturaCriada.class, CandidaturaEmAtribuicao.class, CandidaturaEmAvaliacao.class,
    CandidaturaEmSubmissao.class, CandidaturaNaoAvaliada.class,
    CandidaturaRejeitada.class, CandidaturaRetirada.class, 
    CandidaturaStandAtribuido.class, CandidaturaStandConfirmado.class,
    CandidaturaTerminada.class})
public abstract class CandidaturaEstado implements CandidaturaState{
/**
     * metodo que valida o estado
     *
     * @param c Candidatura
     * @return true se o estado fo valido
     */
    @Override
    public boolean valida(Candidatura c){
        return false;
    }

    /**
     * metodo que modifica candidatura criada
     *
     * @param c Candidatura
     * @return
     */
    @Override
    public boolean setCandidaturaCriada(Candidatura c){
        return false;
    }

    /**
     * metodo que modifica candidatura em submissao
     * @param c Candidatura
     * @return 
     */
    @Override
    public boolean setCandidaturaEmSubmissao(Candidatura c){
        return false;
    }
    
    /**
     * metodo que modifica candidatura atribuida
     *
     * @param c Candidatura
     * @return true se o estado for alterado
     */
    @Override
    public boolean setCandidaturaEmAtribuicao(Candidatura c){
        return false;
    }
    
    /**
     * metodo que modifica candidatura atribuida
     *
     * @param c Candidatura
     * @return true se o estado for alterado
     */
    @Override
    public boolean setCandidaturaEmAvaliacao(Candidatura c){
        return false;
    }

    /**
     * metodo que modifica candidatura avaliada
     *
     * @param c Candidatura
     * @return true se o estado for alterado
     */
    @Override
    public boolean setCandidaturaNaoAvaliada(Candidatura c){
        return false;
    }

   /**
     * metodo que modifica candidatura para avalida
     *
     * @param c Candidatura
     * @return true se o estado for alterado
     */
    @Override
    public boolean setCandidaturaAvaliada(Candidatura c){
        return false;
    }
    
    /**
     * metodo que modifica candidatura aceite
     *
     * @param c Candidatura
     * @return true se o estado for alterado
     */
    @Override
    public boolean setCandidaturaAceite(Candidatura c){
        return false;
    }
    
    /**
     * metodo que modifica candidatura rejeitada
     * @param c Candidatura
     * @return 
     */
    @Override
    public boolean setCandidaturaRejeitada(Candidatura c){
        return false;
    }

    /**
     * metodo que modifica candidatura retirada
     *
     * @param c Candidatura
     * @return true se o estado for alterado
     */
    @Override
    public boolean setCandidaturaRetirada(Candidatura c){
        return false;
    }

    /**
     * metedo que modifica o estado da candidatura avaliada com stand atribuido.
     * 
     * @param c Candidatura 
     * @return 
     */
    @Override
    public boolean setCandidaturaStandAtribuido(Candidatura c){
        return false;
    }
    
    /**
     * metedo que modifica o estado da candidatura avaliada com stand atribuido.
     * 
     * @param c Candidatura 
     * @return 
     */
    @Override
    public boolean setCandidaturaStandConfirmado(Candidatura c){
        return false;
    }

    /**
     * metodo que modifica candidatura terminada
     *
     * @param c Candidatura
     * @return true se o estado for alterado
     */
    @Override
    public boolean setCandidaturaTerminada(Candidatura c){
        return false;
    }
}