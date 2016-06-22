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
 * @author Diana Silva
 */
public class ExposicaoCandidaturasEmAtribuicao implements ExposicaoEstado,Serializable{
    
    private final Exposicao exposicao;
    
    public ExposicaoCandidaturasEmAtribuicao(Exposicao exposicao){
        this.exposicao=exposicao;
    }
    
    @Override
    public boolean valida(){
       return exposicao.getEstadoAtualExposicao() instanceof ExposicaoConflitosAlterados; 
    }


    @Override
    public String toString(){
        return "Estado: candidaturas em atribuição";
    }
}
