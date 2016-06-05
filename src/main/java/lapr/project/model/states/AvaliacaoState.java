package lapr.project.model.states;

/**
 *
 * @author Pedro Fernandes
 */
public interface AvaliacaoState {
    boolean valida();

    boolean isInConcluida();

    boolean isInIniciada();

    boolean setStateIniciada();

    boolean setStateConcluida();
}
