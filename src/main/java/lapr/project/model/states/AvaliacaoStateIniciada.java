package lapr.project.model.states;

import lapr.project.model.Avaliacao;

/**
 *
 * @author Pedro Fernandes
 */
public class AvaliacaoStateIniciada implements AvaliacaoState{
    private Avaliacao avaliacao;

    public AvaliacaoStateIniciada(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public boolean valida() {
        return true;
    }

    @Override
    public boolean setStateIniciada() {
        return true;
    }

    @Override
    public boolean isInIniciada() {
        return true;
    }

    @Override
    public boolean isInConcluida() {
        return false;
    }

    @Override
    public boolean setStateConcluida() {
        return avaliacao.setState(new AvaliacaoStateConcluida(avaliacao));
    }

    @Override
    public String toString() {
        return "AvaliacaoStateIniciada";
    }
}
