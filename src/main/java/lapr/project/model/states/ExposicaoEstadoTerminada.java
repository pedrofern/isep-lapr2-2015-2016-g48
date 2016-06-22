/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.io.Serializable;
import lapr.project.model.Exposicao;

/**
 *
 * @author DianaSilva
 */
public class ExposicaoEstadoTerminada implements ExposicaoEstado,Serializable{
    private final Exposicao exposicao;
    
    public ExposicaoEstadoTerminada(Exposicao exposicao){
        this.exposicao=exposicao;
    }
    
    @Override
    public boolean valida(){
        ExposicaoEstado estado=exposicao.getEstadoAtualExposicao();
       return estado instanceof ExposicaoStandsAtribuidos || estado instanceof ExposicaoCandidaturasEmAvaliacao; 
    }

    @Override
    public String toString(){
        return "Estado: exposição terminada";
    }

    
}
