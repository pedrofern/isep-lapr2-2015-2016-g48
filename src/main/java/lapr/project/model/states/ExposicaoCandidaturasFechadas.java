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
 * @author DianaSilva
 */
@XmlTransient
@XmlSeeAlso({ExposicaoCandidaturasAbertas.class,ExposicaoCandidaturasAvaliadas.class,
            ExposicaoCandidaturasDecididas.class,ExposicaoCandidaturasEmAtribuicao.class,
            ExposicaoCandidaturasEmAvaliacao.class,ExposicaoCandidaturasEmDecisao.class,
            ExposicaoConflitosAlterados.class,
            ExposicaoConflitosDetetados.class,ExposicaoDemonstracaoSemFAE.class,
            ExposicaoEstadoCriada.class,ExposicaoEstadoInicial.class,
            ExposicaoEstadoRegistada.class,ExposicaoEstadoTerminada.class,
            ExposicaoFAESemDemonstracao.class,ExposicaoStandsAtribuidos.class,
            ExposicaoStandsAtribuiveis.class})
public class ExposicaoCandidaturasFechadas extends TimerTask implements ExposicaoEstado,Serializable{
    private final Exposicao exposicao;
    
    public ExposicaoCandidaturasFechadas(Exposicao exposicao){
        this.exposicao=exposicao;
    }

      @Override
    public void run() {
        setCandidaturasFechadas();
    }
    
    public boolean setCandidaturasFechadas(){
        ExposicaoEstado estadoAtual=exposicao.getEstadoAtualExposicao();
        
        if(estadoAtual.valida()==true)
            exposicao.alterarEstado((ExposicaoEstado) new ExposicaoCandidaturasFechadas(exposicao));
        
        return false;
    }
    
    public boolean setConflitosDetetados(){
        ExposicaoEstado estadoAtual=exposicao.getEstadoAtualExposicao();
        
        if(estadoAtual.valida()==true)
            exposicao.alterarEstado((ExposicaoEstado) new ExposicaoConflitosDetetados(exposicao));
        
        return false;
    }
    
     @Override
    public boolean valida(){
       return exposicao.getEstadoAtualExposicao() instanceof ExposicaoCandidaturasAbertas; 
    }
    
    @Override
    public String toString(){
        return "Estado: candidaturas fechadas";
    }

    
}
