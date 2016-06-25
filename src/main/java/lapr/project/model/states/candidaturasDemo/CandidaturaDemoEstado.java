/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states.candidaturasDemo;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.CandidaturaDemonstracao;

/**
 *
 * @author Pedro Fernandes
 */
@XmlTransient
@XmlSeeAlso({CandidaturaDemoCriada.class, CandidaturaDemoRetirada.class,
    CandidaturaDemoEmInteresse.class, CandidaturaDemoAprovada.class,
    CandidaturaDemoNaoAprovada.class, CandidaturaDemoSubmetida.class,
    CandidaturaDemoTerminada.class})
public abstract class CandidaturaDemoEstado implements CandidaturaDemoState{
    /**
     * metodo que valida o estado
     *
     * @param cd CandidaturaDemonstracao
     * @return true se o estado for valido
     */
    @Override
    public boolean valida(CandidaturaDemonstracao cd){
        return false;
    }

    /**
     * metodo que modifica CandidaturaDemonstracao criada
     *
     * @param cd CandidaturaDemonstracao
     * @return
     */
    @Override
    public boolean setCandidaturaDemoCriada(CandidaturaDemonstracao cd){
        return false;
    }
    
    /**
     * metodo que modifica CandidaturaDemonstracao retirada
     *
     * @param cd CandidaturaDemonstracao
     * @return
     */
    @Override
    public boolean setCandidaturaDemoRetirada(CandidaturaDemonstracao cd){
        return false;
    }
    
    /**
     * metodo que modifica CandidaturaDemonstracao em interesse
     *
     * @param cd CandidaturaDemonstracao
     * @return
     */
    @Override
    public boolean setCandidaturaDemoEmInteresse(CandidaturaDemonstracao cd){
        return false;
    }
    
    /**
     * metodo que modifica CandidaturaDemonstracao aprovada
     *
     * @param cd CandidaturaDemonstracao
     * @return
     */
    @Override
    public boolean setCandidaturaDemoAprovada(CandidaturaDemonstracao cd){
        return false;
    }
    
    /**
     * metodo que modifica CandidaturaDemonstracao nao aprovada
     *
     * @param cd CandidaturaDemonstracao
     * @return
     */
    public boolean setCandidaturaDemoNaoAprovada(CandidaturaDemonstracao cd){
        return false;
    }
    
    /**
     * metodo que modifica CandidaturaDemonstracao submetida
     *
     * @param cd CandidaturaDemonstracao
     * @return
     */
    @Override
    public boolean setCandidaturaDemoSubmetida(CandidaturaDemonstracao cd){
        return false;
    }
    
    /**
     * metodo que modifica CandidaturaDemonstracao terminada
     *
     * @param cd CandidaturaDemonstracao
     * @return
     */
    @Override
    public boolean setCandidaturaDemoTerminada(CandidaturaDemonstracao cd){
        return false;
    }

}
