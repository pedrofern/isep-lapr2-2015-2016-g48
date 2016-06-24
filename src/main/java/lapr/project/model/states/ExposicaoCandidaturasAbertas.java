/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.io.Serializable;
import java.util.TimerTask;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.Exposicao;

/**
 *
 * @author Diana Silva
 */
@XmlTransient
@XmlSeeAlso({ExposicaoCandidaturasAvaliadas.class,
            ExposicaoCandidaturasDecididas.class,ExposicaoCandidaturasEmAtribuicao.class,
            ExposicaoCandidaturasEmAvaliacao.class,ExposicaoCandidaturasEmDecisao.class,
            ExposicaoCandidaturasFechadas.class,ExposicaoConflitosAlterados.class,
            ExposicaoConflitosDetetados.class,ExposicaoDemonstracaoSemFAE.class,
            ExposicaoEstadoCriada.class,ExposicaoEstadoInicial.class,
            ExposicaoEstadoRegistada.class,ExposicaoEstadoTerminada.class,
            ExposicaoFAESemDemonstracao.class,ExposicaoStandsAtribuidos.class,
            ExposicaoStandsAtribuiveis.class})
public class ExposicaoCandidaturasAbertas extends TimerTask implements ExposicaoEstado, Serializable{
    private final Exposicao exposicao;
    
    public ExposicaoCandidaturasAbertas(Exposicao exposicao){
        this.exposicao=exposicao;
    }

    @Override
    public void run() {
        setCandidaturasAbertas();
    }
    
    public boolean setCandidaturasAbertas(){
        ExposicaoEstado estadoAtual=exposicao.getEstadoAtualExposicao();
        
        if(true==estadoAtual.valida())
            exposicao.alterarEstado(new ExposicaoCandidaturasAbertas(exposicao));
        
        return false;
    }
    
    @Override
    public boolean valida(){
       return exposicao.getEstadoAtualExposicao() instanceof ExposicaoEstadoRegistada; 
    }

   @Override
    public String toString(){
       return "Estado: candidaturas em submissão";
    }

}
