/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.io.Serializable;
import java.text.ParseException;
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
            ExposicaoEstadoCriada.class,
            ExposicaoEstadoRegistada.class,ExposicaoEstadoTerminada.class,
            ExposicaoFAESemDemonstracao.class,ExposicaoStandsAtribuidos.class,
            ExposicaoStandsAtribuiveis.class})
public class ExposicaoEstadoInicial implements ExposicaoEstado,Serializable {

    private final  Exposicao exposicao;
    
    public ExposicaoEstadoInicial(Exposicao exposicao){
        this.exposicao=exposicao;       
    }
    
    public boolean setCriada() throws ParseException{
        if(valida()){
            
//            exposicao.createTimers();
            return exposicao.alterarEstado(new ExposicaoEstadoCriada(exposicao));
            
        }
        return false;
    }
    
    @Override
    public boolean valida(){
       return true;
    }

    
    public String toString(){
        return "Estado exposição: inicial";
    }
    
}
