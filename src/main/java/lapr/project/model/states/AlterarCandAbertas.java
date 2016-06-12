/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.model.Exposicao;
import lapr.project.utils.Data;
import lapr.project.utils.Utils;

/**
 *
 * @author Diana Silva 
 * 
 * 
 */

public class AlterarCandAbertas implements ExposicaoEstado {
    
    private static Exposicao exposicao;
    
    public AlterarCandAbertas(Exposicao e){
        exposicao=e;
        
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
        Data dataAtual = Utils.getdataAtual();
        try {
            if (exposicao.getDataFimSubmissao().compareTo(Data.converterParaDate(dataAtual)) <= 0) {
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(AlterarCandAbertas.class.getName()).log(Level.SEVERE, null, ex);
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
