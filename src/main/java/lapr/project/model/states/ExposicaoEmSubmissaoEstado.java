package lapr.project.model.states;

import java.util.*;
import lapr.project.model.Exposicao;
import lapr.project.utils.*;

/**
 *
 * @author Pedro Fernandes
 */
public class ExposicaoEmSubmissaoEstado implements ExposicaoEstado{
    private Exposicao exposicao;

    public ExposicaoEmSubmissaoEstado(Exposicao e) {
        this.exposicao = e;
    }

    /**
     * Valida se o evento está em submissão e terminou o periodo de submissões,
     * em caso afirmativo é possivel alterar o estado.
     *
     * @return boolean se evento está em submissão e ultrapassou data final de
     * submissões
     */
    @Override
    public boolean valida() {
        Date dataAtual = Utils.getdataAtual();
        if (exposicao.getDataFimSubmissao().compareTo(dataAtual) <= 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isInEmSubmissao() {
        return true;
    }

    @Override
    public boolean setStateEmSubmissao() {
        return true;
    }

    @Override
    public boolean setStateEmDetecaoConflitos() {
        if (valida()) {
            return exposicao.setState(new ExposicaoStateEmDetecaoConflitos(exposicao));
        }
        return false;
    }

    public Exposicao getExposicao() {
        return this.exposicao;
    }

    @Override
    public boolean isInRegistada() {
        return false;
    }

    @Override
    public boolean isInFAEDefinida() {
        return false;
    }

    @Override
    public boolean isInEmDetecaoConflitos() {
        return false;
    }

    @Override
    public boolean isInEmAtribuicao() {
        return false;
    }

    @Override
    public boolean isInEmRevisao() {
        return false;
    }

    @Override
    public boolean isInEmDecisao() {
        return false;
    }

    @Override
    public boolean isInEmDecidida() {
        return false;
    }

    @Override
    public boolean setStateRegistada() {
        return false;
    }

    @Override
    public boolean setStateFAEDefinida() {
        return false;
    }

    @Override
    public boolean setStateEmAtribuicao() {
        return false;
    }

    @Override
    public boolean setStateEmRevisao() {
        return false;
    }

    @Override
    public boolean setStateEmDecisao() {
        return false;
    }

    @Override
    public boolean setStateEmDecidida() {
        return false;
    }

    @Override
    public String toString() {
        return "ExposicaoStateEmSubmissao";
    }
}
