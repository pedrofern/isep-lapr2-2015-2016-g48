package lapr.project.model.states;

import lapr.project.model.Exposicao;

/**
 *
 * @author Pedro Fernandes
 */
public class ExposicaoCriadaEstado implements ExposicaoEstado {
    
    private Exposicao exposicao;

    public ExposicaoCriadaEstado(Exposicao e) {
        this.exposicao = e;
    }

    @Override
    public boolean valida() {
        return true;
    }

    @Override
    public boolean setStateRegistada() {
        if (valida()) {
            return exposicao.setState(new ExposicaoRegistadaEstado(exposicao));
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
    public boolean isInEmSubmissao() {
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
    public boolean isInFAEDefinida() {
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
    public boolean setStateFAEDefinida() {
        return false;
    }

    @Override
    public boolean setStateEmSubmissao() {
        return false;
    }

    @Override
    public boolean setStateEmDetecaoConflitos() {
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
        return "ExposicaoStateCriada";
    }
}
