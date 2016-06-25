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
public class CandidaturaDemoCriada extends CandidaturaDemoEstado implements Serializable {
    /**
     * Valida se a candidatura é valida para lhe atribuir um estado
     *
     * @param candidatura
     * @return true se poder ser atribuido o estado
     */
    @Override
    public boolean valida(CandidaturaDemonstracao candidatura) {
            CandidaturaDemonstracao cand = (CandidaturaDemonstracao) candidatura;
            return cand.valida();
    }

    /**
     * Altera o estado da candidatura
     *
     * @param candidatura
     * @return true se for alterado
     */
    @Override
    public boolean setCandidaturaDemoCriada(CandidaturaDemonstracao candidatura) {
        if (this.valida(candidatura)) {
                CandidaturaDemonstracao cand = (CandidaturaDemonstracao) candidatura;
                cand.setEstadoCandidaturaDemo(this);
                return true;
        }
        return false;
    }
}
