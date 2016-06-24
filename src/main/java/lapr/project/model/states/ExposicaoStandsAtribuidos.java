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
@XmlSeeAlso({ExposicaoCandidaturasAbertas.class,ExposicaoCandidaturasAvaliadas.class,
            ExposicaoCandidaturasDecididas.class,ExposicaoCandidaturasEmAtribuicao.class,
            ExposicaoCandidaturasEmAvaliacao.class,ExposicaoCandidaturasEmDecisao.class,
            ExposicaoCandidaturasFechadas.class,ExposicaoConflitosAlterados.class,
            ExposicaoConflitosDetetados.class,ExposicaoDemonstracaoSemFAE.class,
            ExposicaoEstadoCriada.class,ExposicaoEstadoInicial.class,
            ExposicaoEstadoRegistada.class,ExposicaoEstadoTerminada.class,
            ExposicaoFAESemDemonstracao.class,
            ExposicaoStandsAtribuiveis.class})
public class ExposicaoStandsAtribuidos extends TimerTask implements ExposicaoEstado,Serializable{
    
    private final Exposicao exposicao;
    
    public ExposicaoStandsAtribuidos(Exposicao exposicao){
        this.exposicao=exposicao;
    }

    @Override
    public void run() {
        setStandsAtribuidos();
        setExposicaoCompleta();
    }
    
    public boolean setStandsAtribuidos(){
        ExposicaoEstado estadoAtual=exposicao.getEstadoAtualExposicao();
        
        if(estadoAtual.valida()==true)
            exposicao.alterarEstado((ExposicaoEstado) new ExposicaoStandsAtribuidos(exposicao));
        
        return false;
    }
    
    public boolean setExposicaoCompleta(){
        ExposicaoEstado estadoAtual=exposicao.getEstadoAtualExposicao();
        
        if(estadoAtual instanceof ExposicaoStandsAtribuidos)
            exposicao.alterarEstado((ExposicaoEstado) new ExposicaoEstadoTerminada(exposicao));
        
        return false;
    }
  
    
    @Override
    public boolean valida(){
       ExposicaoEstado estado=exposicao.getEstadoAtualExposicao();
        return estado instanceof ExposicaoStandsAtribuiveis;
    }

    @Override
    public String toString(){
        return "Estado: stands atribuídos-completa";
    }
}
