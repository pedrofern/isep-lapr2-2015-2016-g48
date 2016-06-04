package lapr.project.model;

/**
 *
 * @author Pedro Fernandes
 */
public interface Atribuivel {

    /**
     *
     */
    void alteraParaEmAtribuicao();

    /**
     * Retorna um novo processo de atribuição.
     *
     * @return um novo processo de atribuição.
     */
    public ProcessoAtribuicao novaAtribuicao();

    /**
     * Define um novo processo de atribuição para o atribuivel.
     *
     * @param pd
     */
    public void setProcessoAtribuicao(ProcessoAtribuicao pa);
}
