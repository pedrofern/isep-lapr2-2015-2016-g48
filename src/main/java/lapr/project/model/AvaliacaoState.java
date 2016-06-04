package lapr.project.model;

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
