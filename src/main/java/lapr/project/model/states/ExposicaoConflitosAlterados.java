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
 * @author Diana Silva
 */
@XmlRootElement
//@XmlTransient
//@XmlSeeAlso({ExposicaoCandidaturasAbertas.class,ExposicaoCandidaturasAvaliadas.class,
//            ExposicaoCandidaturasDecididas.class,ExposicaoCandidaturasEmAtribuicao.class,
//            ExposicaoCandidaturasEmAvaliacao.class,ExposicaoCandidaturasEmDecisao.class,
//            ExposicaoCandidaturasFechadas.class,
//            ExposicaoConflitosDetetados.class,ExposicaoDemonstracaoSemFAE.class,
//            ExposicaoEstadoCriada.class,ExposicaoEstadoInicial.class,
//            ExposicaoEstadoRegistada.class,ExposicaoEstadoTerminada.class,
//            ExposicaoFAESemDemonstracao.class,ExposicaoStandsAtribuidos.class,
//            ExposicaoStandsAtribuiveis.class})
public class ExposicaoConflitosAlterados extends TimerTask implements ExposicaoEstado,Serializable{
    
    private final Exposicao exposicao;
    
    public ExposicaoConflitosAlterados(Exposicao exposicao){
        this.exposicao=exposicao;
    }
    
    @Override
    public void run() {
        setConflitosAlterados();
    }
    
    public boolean setConflitosAlterados(){
        ExposicaoEstado estadoAtual=exposicao.getEstadoAtualExposicao();
        
        if(estadoAtual.valida()==true)
            exposicao.alterarEstado((ExposicaoEstado) new ExposicaoConflitosAlterados(exposicao));
        
        return false;
    }
    
    
    public boolean setCandidaturasEmAtribuicao(){
        ExposicaoEstado estadoAtual=exposicao.getEstadoAtualExposicao();
        
        if(estadoAtual.valida()==true)
            exposicao.alterarEstado((ExposicaoEstado) new ExposicaoCandidaturasEmAtribuicao(exposicao));
        
        return false;
    }
   
    @Override
    public boolean valida(){
       return exposicao.getEstadoAtualExposicao() instanceof ExposicaoConflitosDetetados; 
    }


    @Override
    public String toString(){
        return "Estado: conflitos alterados";
    }

}
