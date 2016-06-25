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
public class CandidaturaNaoAvaliada extends CandidaturaEstado implements Serializable {

    /**
     * Valida o estado para verificar se pode ser atualizado
     *
     * @param candidatura
     * @return true se poder ser alterado o estado
     */
    @Override
    public boolean valida(Candidatura candidatura) {
        Candidatura cand = (Candidatura) candidatura;
        CandidaturaState state = cand.getEstadoAtualCandidatura();
        if (state instanceof CandidaturaEmAvaliacao) {
            return true;
        }
        return false;
    }

    /**
     * Altera o estado da candidatura
     *
     * @param candidatura
     * @return true se for alterado
     */
    @Override
    public boolean setCandidaturaNaoAvaliada(Candidatura candidatura) {
        if (this.valida(candidatura)) {
                Candidatura cand = (Candidatura) candidatura;
                cand.setEstadoCandidatura(this);
                return true;
        }
        return false;
    }

}

