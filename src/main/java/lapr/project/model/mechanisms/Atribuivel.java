package lapr.project.model.mechanisms;

import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.mechanisms.ProcessoAtribuicao;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
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
