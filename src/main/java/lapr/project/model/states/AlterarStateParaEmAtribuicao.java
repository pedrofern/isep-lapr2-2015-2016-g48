package lapr.project.model.states;

import java.util.TimerTask;
import lapr.project.model.Exposicao;

/**
 *
 * @author Pedro Fernandes
 */
public class AlterarStateParaEmAtribuicao extends TimerTask {

    private Exposicao exposicao;

    public AlterarStateParaEmAtribuicao(Exposicao exposicao) {
        this.exposicao = exposicao;
    }

    /**
     * Instanciar timer, para mudar o estado em atribuição.
     */
    @Override
    public void run() {
        exposicao.alteraParaEmAtribuicao();
    }
}
