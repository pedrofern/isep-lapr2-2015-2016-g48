/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states.candidaturasExpo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.Candidatura;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
public interface CandidaturaState extends Serializable{

    /**
     * metodo que valida o estado
     *
     * @param c Candidatura
     * @return true se o estado fo valido
     */
    public boolean valida(Candidatura c);

    /**
     * metodo que modifica candidatura criada
     *
     * @param c Candidatura
     * @return
     */
    public boolean setCandidaturaCriada(Candidatura c);

    /**
     * metodo que modifica candidatura em submissao
     * @param c Candidatura
     * @return 
     */
    public boolean setCandidaturaEmSubmissao(Candidatura c);
    
    /**
     * metodo que modifica candidatura atribuida
     *
     * @param c Candidatura
     * @return true se o estado for alterado
     */
    public boolean setCandidaturaEmAtribuicao(Candidatura c);
    
    /**
     * metodo que modifica candidatura atribuida
     *
     * @param c Candidatura
     * @return true se o estado for alterado
     */
    public boolean setCandidaturaEmAvaliacao(Candidatura c);

    /**
     * metodo que modifica candidatura avaliada
     *
     * @param c Candidatura
     * @return true se o estado for alterado
     */
    public boolean setCandidaturaNaoAvaliada(Candidatura c);

   /**
     * metodo que modifica candidatura para avalida
     *
     * @param c Candidatura
     * @return true se o estado for alterado
     */
    public boolean setCandidaturaAvaliada(Candidatura c);
    
    /**
     * metodo que modifica candidatura aceite
     *
     * @param c Candidatura
     * @return true se o estado for alterado
     */
    public boolean setCandidaturaAceite(Candidatura c);
    
    /**
     * metodo que modifica candidatura rejeitada
     * @param c Candidatura
     * @return 
     */
    public boolean setCandidaturaRejeitada(Candidatura c);

    /**
     * metodo que modifica candidatura retirada
     *
     * @param c Candidatura
     * @return true se o estado for alterado
     */
    public boolean setCandidaturaRetirada(Candidatura c);


    /**
     * metedo que modifica o estado da candidatura avaliada com stand atribuido.
     * 
     * @param c Candidatura 
     * @return 
     */
    public boolean setCandidaturaStandAtribuido(Candidatura c);
    
    /**
     * metedo que modifica o estado da candidatura avaliada com stand atribuido.
     * 
     * @param c Candidatura 
     * @return 
     */
    public boolean setCandidaturaStandConfirmado(Candidatura c);

    /**
     * metodo que modifica candidatura terminada
     *
     * @param c Candidatura
     * @return true se o estado for alterado
     */
    public boolean setCandidaturaTerminada(Candidatura c);
}

