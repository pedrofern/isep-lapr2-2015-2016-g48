package lapr.project.model.states;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.model.Exposicao;
import lapr.project.utils.*;
import static lapr.project.utils.Data.getDataAtualDate;

/**
 *
 * @author Pedro Fernandes
 */
public class ExposicaoStateEmRevisao implements ExposicaoEstado{

    private Exposicao exposicao;

    public ExposicaoStateEmRevisao(Exposicao e) {
        this.exposicao = e;
    }

    @Override
    public boolean valida() {
        Data dataAtual = Utils.getdataAtual();
        
        try {
            if (exposicao.getDataFimSubmissao().compareTo(getDataAtualDate()) <= 0) {
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(ExposicaoStateEmRevisao.class.getName()).log(Level.SEVERE, null, ex);
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
