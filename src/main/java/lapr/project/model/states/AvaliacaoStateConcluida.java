package lapr.project.model.states;

import lapr.project.model.Avaliacao;

/**
 *
 * @author Pedro Fernandes
 */
public class AvaliacaoStateConcluida implements AvaliacaoState{

    private Avaliacao avaliacao;

    public AvaliacaoStateConcluida(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public boolean valida() {
        return true;
    }

    @Override
    public boolean isInIniciada() {
        return false;
    }

    @Override
    public boolean isInConcluida() {
        return true;
    }

    @Override
    public boolean setStateConcluida() {
        return true;
    }

    @Override
    public boolean setStateIniciada() {
        return false;
    }

    @Override
    public String toString() {
        return "AvaliacaoStateConcluida";
    }
}
