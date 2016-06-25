/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states.demonstracao;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.Demonstracao;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
public class DemonstracaoEmAberto extends DemonstracaoEstado implements Serializable{
    /**
     * Valida se a demonstracao é valida para lhe atribuir um estado
     *
     * @param demonstracao
     * @return true se poder ser atribuido o estado
     */
    @Override
    public boolean valida(Demonstracao demonstracao) {
            Demonstracao demo = (Demonstracao) demonstracao;
            DemonstracaoState state = demo.getEstadoAtualDemonstracao();
            if (state instanceof DemonstracaoDecididas) {
            return true;
        }
        return false;
    }

    /**
     * Altera o estado da candidatura
     *
     * @param demonstracao
     * @return true se for alterado
     */
    @Override
    public boolean setDemonstracaoEmAberto(Demonstracao demonstracao) {
        if (this.valida(demonstracao)) {
                Demonstracao demo = (Demonstracao) demonstracao;
                demo.setEstadoDemonstracao(this);
                return true;
        }
        return false;
    }
    
    
}
