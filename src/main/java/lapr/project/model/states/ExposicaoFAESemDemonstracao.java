/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import lapr.project.model.Exposicao;

/**
 *
 * @author Diana Silva
 */
public class ExposicaoFAESemDemonstracao implements ExposicaoEstado{
    
    private final Exposicao exposicao;
    
    public ExposicaoFAESemDemonstracao(Exposicao exposicao){
        this.exposicao=exposicao;
    }
    
    public boolean setRegistada(){
        if(exposicao.getEstadoAtualExposicao().valida()!=true)
            return false;
        else
            return exposicao.alterarEstado((ExposicaoEstado) new ExposicaoDemonstracaoSemFAE(exposicao));
    }
    
    public boolean setEstadoCriada(){
        if(exposicao.getEstadoAtualExposicao().valida()!=true){
            return false;
        } else {
            return exposicao.alterarEstado((ExposicaoEstado) new ExposicaoEstadoRegistada(exposicao));
        }
    }
    
    @Override
    public boolean valida(){
       return exposicao.getEstadoAtualExposicao() instanceof ExposicaoEstadoInicial; 
    }
    
   @Override
    public String toString(){
        return "Estado; exposição com FAE definido, sem demonstração";
    }
}
