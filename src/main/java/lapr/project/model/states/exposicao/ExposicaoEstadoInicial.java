/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states.exposicao;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.Exposicao;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
public class ExposicaoEstadoInicial extends ExposicaoEstado implements Serializable{
    /**
     * Valida se a exposicao é valida para lhe atribuir um estado
     *
     * @param exposicao
     * @return true se poder ser atribuido o estado
     */
    @Override
    public boolean valida(Exposicao exposicao) {
            Exposicao expo = (Exposicao) exposicao;
            return expo.valida();
    }

    /**
     * Altera o estado da exposicao
     *
     * @param exposicao
     * @return true se for alterado
     */
    @Override
    public boolean setExposicaoEstadoInicial(Exposicao exposicao) {
        if (this.valida(exposicao)) {
                Exposicao expo = (Exposicao) exposicao;
                expo.alterarEstado(this);
                return true;
        }
        return false;
    }
    
}
