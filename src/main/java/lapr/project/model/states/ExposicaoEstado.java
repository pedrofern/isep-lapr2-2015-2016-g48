package lapr.project.model.states;

/**
 *
 * @author Pedro Fernandes
 */
public interface ExposicaoEstado {
    
    boolean valida();

    boolean isInRegistada();

    boolean isInFAEDefinida();

    boolean isInEmSubmissao();

    boolean isInEmDetecaoConflitos();

    boolean isInEmAtribuicao();

    boolean isInEmRevisao();

    boolean isInEmDecisao();

    boolean isInEmDecidida();

    boolean setStateRegistada();

    boolean setStateFAEDefinida();

    boolean setStateEmSubmissao();

    boolean setStateEmDetecaoConflitos();

    boolean setStateEmAtribuicao();

    boolean setStateEmRevisao();

    boolean setStateEmDecisao();

    boolean setStateEmDecidida();
    
}
