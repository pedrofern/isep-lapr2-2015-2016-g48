/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states.candidaturasDemo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.CandidaturaDemonstracao;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
public interface CandidaturaDemoState extends Serializable{
    
    /**
     * metodo que valida o estado
     *
     * @param cd CandidaturaDemonstracao
     * @return true se o estado for valido
     */
    public boolean valida(CandidaturaDemonstracao cd);

    /**
     * metodo que modifica CandidaturaDemonstracao criada
     *
     * @param cd CandidaturaDemonstracao
     * @return
     */
    public boolean setCandidaturaDemoCriada(CandidaturaDemonstracao cd);
    
    /**
     * metodo que modifica CandidaturaDemonstracao retirada
     *
     * @param cd CandidaturaDemonstracao
     * @return
     */
    public boolean setCandidaturaDemoRetirada(CandidaturaDemonstracao cd);
    
    /**
     * metodo que modifica CandidaturaDemonstracao em interesse
     *
     * @param cd CandidaturaDemonstracao
     * @return
     */
    public boolean setCandidaturaDemoEmInteresse(CandidaturaDemonstracao cd);
    
    /**
     * metodo que modifica CandidaturaDemonstracao aprovada
     *
     * @param cd CandidaturaDemonstracao
     * @return
     */
    public boolean setCandidaturaDemoAprovada(CandidaturaDemonstracao cd);
    
    /**
     * metodo que modifica CandidaturaDemonstracao nao aprovada
     *
     * @param cd CandidaturaDemonstracao
     * @return
     */
    public boolean setCandidaturaDemoNaoAprovada(CandidaturaDemonstracao cd);
    
    /**
     * metodo que modifica CandidaturaDemonstracao submetida
     *
     * @param cd CandidaturaDemonstracao
     * @return
     */
    public boolean setCandidaturaDemoSubmetida(CandidaturaDemonstracao cd);
    
    /**
     * metodo que modifica CandidaturaDemonstracao terminada
     *
     * @param cd CandidaturaDemonstracao
     * @return
     */
    public boolean setCandidaturaDemoTerminada(CandidaturaDemonstracao cd);
}
