/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.Exposicao;
import lapr.project.utils.Data;
import lapr.project.utils.Utils;

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
            ExposicaoEstadoTerminada.class,
            ExposicaoFAESemDemonstracao.class,ExposicaoStandsAtribuidos.class,
            ExposicaoStandsAtribuiveis.class})
public class ExposicaoEstadoRegistada implements ExposicaoEstado,Serializable {
    
    private final Exposicao exposicao;
    
    public ExposicaoEstadoRegistada(Exposicao exposicao){
        this.exposicao=exposicao;
    }
    
    public boolean setFAESemDemonstracao(){
        if(exposicao.getEstadoAtualExposicao().valida()!=true){
            return false;
        } else {
            return exposicao.alterarEstado((ExposicaoEstado) new ExposicaoFAESemDemonstracao(exposicao));
        }
    }
    

    @Override
    public boolean valida(){
       ExposicaoEstado estado=exposicao.getEstadoAtualExposicao();
        return estado instanceof ExposicaoFAESemDemonstracao || exposicao.getEstadoAtualExposicao() instanceof ExposicaoDemonstracaoSemFAE;
    }


    
   @Override
    public String toString(){
        return "Estado: Exposição Registada (com FAE e demonstração)";
    }
}
