package lapr.project.model;


/**
 *
 * @author Pedro Fernandes
 */
public class ExposicaoStateEmDetecaoConflitos implements ExposicaoEstado {
    private Exposicao exposicao;

    public ExposicaoStateEmDetecaoConflitos(Exposicao e) {
        this.exposicao = e;
    }

    @Override
    public boolean valida() {
        return true;
    }

    @Override
    public boolean isInEmDetecaoConflitos() {
        return true;
    }

    @Override
    public boolean setStateEmDetecaoConflitos() {
        return true;
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
    public boolean isInEmSubmissao() {
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
    public boolean setStateEmSubmissao() {
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
        return "ExposicaoStateEmDetecaoConflitos";
    }
}
