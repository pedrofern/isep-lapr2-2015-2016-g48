/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.io.Serializable;
import java.util.TimerTask;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.Demonstracao;

/**
 *
 * @author Edu
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlTransient
//@XmlSeeAlso({DemonstracaoEstadoCandidaturaAberto.class,DemonstracaoEstadoCriada.class,
//            DemonstracaoEstadoDecidida.class,DemonstracaoEstadoInicial.class,
//            DemonstracaoEstadoInteresse.class,DemonstracaoEstadoRegistada.class,})
public class DemonstracoesEstadoCandidaturaFechada extends TimerTask 
        implements DemonstracaoEstado,Serializable {

    private final Demonstracao demonstracao;

    public DemonstracoesEstadoCandidaturaFechada(Demonstracao demonstracao) {
        this.demonstracao = demonstracao;
    }

    @Override
    public void run() {
        setCandidaturasFechadas();
    }

    public boolean setCandidaturasFechadas() {
        DemonstracaoEstado estadoAtual = demonstracao.getEstadoAtualDemonstracao();

        if (estadoAtual.valida() == true) {
            demonstracao.alterarEstado((DemonstracaoEstado) new DemonstracoesEstadoCandidaturaFechada(demonstracao));
        }

        return false;
    }

    

    @Override
    public boolean valida() {
        return demonstracao.getEstadoAtualDemonstracao() instanceof DemonstracaoEstadoCandidaturaAberto;
    }

    @Override
    public String toString() {
        return "Estado: candidaturas fechadas";
    }
}
