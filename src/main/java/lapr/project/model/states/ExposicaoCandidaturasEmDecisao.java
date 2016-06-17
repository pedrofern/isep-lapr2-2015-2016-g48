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
public class ExposicaoCandidaturasEmDecisao implements ExposicaoEstado{
    private final Exposicao exposicao;

    public ExposicaoCandidaturasEmDecisao(Exposicao exposicao){
        this.exposicao=exposicao;
    }
    
    public boolean setDecididas(){
        if(exposicao.valida()!=true){
            return false;
        } else {
            return exposicao.alterarEstado((ExposicaoEstado) new ExposicaoCandidaturasDecididas(exposicao));
        }     
    }
 
    @Override
    public String toString(){
        return "Estado: candidaturas em decisão";
    }

    @Override
    public boolean valida(){
       return exposicao.getEstadoAtualExposicao() instanceof ExposicaoCandidaturasAvaliadas; 
    }  
}