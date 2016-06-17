/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import lapr.project.model.Exposicao;

/**
 *
 * @author DianaSilva
 */
public class ExposicaoCandidaturasAvaliadas implements ExposicaoEstado{
    private final Exposicao exposicao;
    
    public ExposicaoCandidaturasAvaliadas(Exposicao exposicao){
        this.exposicao=exposicao;
    }
   
    @Override
    public boolean valida(){
       return exposicao.getEstadoAtualExposicao() instanceof ExposicaoCandidaturasEmAvaliacao; 
    }

    @Override
    public String toString(){
        return "Estado: candidaturas avaliadas";
    }

}
