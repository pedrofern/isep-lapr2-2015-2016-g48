/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.io.Serializable;
import java.util.TimerTask;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.Exposicao;

/**
 *
 * @author Diana
 */
@XmlRootElement
//@XmlTransient
//@XmlSeeAlso({ExposicaoCandidaturasAbertas.class,ExposicaoCandidaturasAvaliadas.class,
//            ExposicaoCandidaturasDecididas.class,ExposicaoCandidaturasEmAtribuicao.class,
//            ExposicaoCandidaturasEmDecisao.class,
//            ExposicaoCandidaturasFechadas.class,ExposicaoConflitosAlterados.class,
//            ExposicaoConflitosDetetados.class,ExposicaoDemonstracaoSemFAE.class,
//            ExposicaoEstadoCriada.class,ExposicaoEstadoInicial.class,
//            ExposicaoEstadoRegistada.class,ExposicaoEstadoTerminada.class,
//            ExposicaoFAESemDemonstracao.class,ExposicaoStandsAtribuidos.class,
//            ExposicaoStandsAtribuiveis.class})
public class ExposicaoCandidaturasEmAvaliacao extends TimerTask implements ExposicaoEstado,Serializable{
    
    private final Exposicao exposicao;
    
    public ExposicaoCandidaturasEmAvaliacao(Exposicao exposicao){
        this.exposicao=exposicao;
    }

    @Override
    public void run() {
        setCandidaturasEmAvaliacao();
    }
    
    public boolean setCandidaturasEmAvaliacao(){
        ExposicaoEstado estadoAtual=exposicao.getEstadoAtualExposicao();
        
        if(estadoAtual.valida()==true)
            exposicao.alterarEstado((ExposicaoEstado) new ExposicaoCandidaturasEmAvaliacao(exposicao));
        
        return false;
    }
    
    public boolean setCandidaturasAvaliadas(){
        ExposicaoEstado estadoAtual=exposicao.getEstadoAtualExposicao();
        
        if(estadoAtual.valida()==true)
            exposicao.alterarEstado((ExposicaoEstado) new ExposicaoCandidaturasAvaliadas(exposicao));
        
        return false;
    }
    
    public boolean setCandidaturasNaoAvaliadas(){
        ExposicaoEstado estadoAtual=exposicao.getEstadoAtualExposicao();
        
        if(estadoAtual.valida()==true)
            exposicao.alterarEstado((ExposicaoEstado) new ExposicaoEstadoTerminada(exposicao));
        
        return false;
    }
    
    
    @Override
    public boolean valida(){
       return exposicao.getEstadoAtualExposicao() instanceof ExposicaoCandidaturasEmAtribuicao; 
    }


    @Override
    public String toString(){
        return "Estado: candidaturas em avaliação";
    }

}
