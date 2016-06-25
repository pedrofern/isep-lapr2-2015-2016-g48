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
public class CandidaturaCriada extends CandidaturaEstado implements Serializable  {


    /**
     * Valida se a candidatura é valida para lhe atribuir um estado
     *
     * @param candidatura
     * @return true se poder ser atribuido o estado
     */
    @Override
    public boolean valida(Candidatura candidatura) {
            Candidatura cand = (Candidatura) candidatura;
            return cand.valida();
    }

    /**
     * Altera o estado da candidatura
     *
     * @param candidatura
     * @return true se for alterado
     */
    @Override
    public boolean setCandidaturaCriada(Candidatura candidatura) {
        if (this.valida(candidatura)) {
                Candidatura cand = (Candidatura) candidatura;
                cand.setEstadoCandidatura(this);
                return true;
        }
        return false;
    }

   
}
