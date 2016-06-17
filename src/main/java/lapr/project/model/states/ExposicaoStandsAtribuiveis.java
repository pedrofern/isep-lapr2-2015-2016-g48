/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.util.TimerTask;
import lapr.project.model.Exposicao;

/**
 *
 * @author Diana Silva
 */
public class ExposicaoStandsAtribuiveis extends TimerTask implements ExposicaoEstado{
    private final Exposicao exposicao;
    
    public ExposicaoStandsAtribuiveis(Exposicao exposicao){
        this.exposicao=exposicao;
    }

    @Override
    public void run() {
        setStandsAtribuiveis();
    }
    
    public boolean setStandsAtribuiveis(){
        ExposicaoEstado estadoAtual=exposicao.getEstadoAtualExposicao();
        
        if(estadoAtual.valida()!=true) {
            return false;
        } else {
            exposicao.alterarEstado((ExposicaoEstado) new ExposicaoStandsAtribuiveis(exposicao));
        }
        
        return false;
    }
   
    
    @Override
    public boolean valida(){
       ExposicaoEstado estado=exposicao.getEstadoAtualExposicao();
        return estado instanceof ExposicaoCandidaturasDecididas;
    }

    
   @Override
    public String toString(){
        return "Estado; stands em atribuição";
    }
 
}
