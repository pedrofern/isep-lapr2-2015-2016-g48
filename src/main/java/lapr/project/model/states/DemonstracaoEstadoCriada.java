/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.Demonstracao;

/**
 *
 * @author Edu
 */
@XmlRootElement
//@XmlTransient
//@XmlSeeAlso({DemonstracaoEstadoCandidaturaAberto.class,
//            DemonstracaoEstadoDecidida.class,DemonstracaoEstadoInicial.class,
//            DemonstracaoEstadoInteresse.class,DemonstracaoEstadoRegistada.class,
//            DemonstracoesEstadoCandidaturaFechada.class})
public class DemonstracaoEstadoCriada implements DemonstracaoEstado {

    private final Demonstracao demonstracao;

    public DemonstracaoEstadoCriada(Demonstracao demonstracao) {
        this.demonstracao = demonstracao;
    }

    public boolean setDemonstracaoInteresse() {
        if (!demonstracao.getEstadoAtualDemonstracao().valida()) {
            return false;
        } else {
            return demonstracao.alterarEstado((DemonstracaoEstado) new DemonstracaoEstadoCriada(demonstracao));
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
