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
public class ExposicaoEstadoCriada implements ExposicaoEstado,Serializable {

   private final Exposicao exposicao;
   
   public ExposicaoEstadoCriada(Exposicao e){
       exposicao=e;
   }
    
   public boolean setDemonstracaoSemFAE(){
       if (!exposicao.getEstadoAtualExposicao().valida())
           return false;
       else
           return exposicao.alterarEstado((ExposicaoEstado) new ExposicaoFAESemDemonstracao(exposicao));
    }
   
   public boolean setFAEDefinidoSemDemonstracao(){
       if (!exposicao.getEstadoAtualExposicao().valida())
        return false;
       else 
           return exposicao.alterarEstado((ExposicaoEstado) new ExposicaoFAESemDemonstracao(exposicao));
   }
    
   @Override
    public boolean valida(){
       return exposicao.getEstadoAtualExposicao() instanceof ExposicaoEstadoInicial; 
    }

   @Override
    public String toString(){
        return "Estado: Exposição Criada";
    }
}
