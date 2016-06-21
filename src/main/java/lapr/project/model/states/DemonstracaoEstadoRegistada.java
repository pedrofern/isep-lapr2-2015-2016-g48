/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;

/**
 *
 * @author Edu
 */
public class DemonstracaoEstadoRegistada implements DemonstracaoEstado {

    private final Demonstracao demonstracao;

    public DemonstracaoEstadoRegistada(Demonstracao demonstracao) {
        this.demonstracao = demonstracao;
    }

    public boolean setDemonstracaoInteresse() {
        if (!demonstracao.getEstadoAtualDemonstracao().valida()) {
            return false;
        } else {
            return demonstracao.alterarEstado((DemonstracaoEstado) new DemonstracaoEstadoRegistada(demonstracao));
        }
    }

    public boolean valida() {
        return demonstracao.getEstadoAtualDemonstracao() instanceof DemonstracaoEstadoInicial;
    }

    @Override
    public String toString() {
        return "Estado: Demonstração Criada";
    }
}
