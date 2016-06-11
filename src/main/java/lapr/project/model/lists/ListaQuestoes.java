
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Avaliacao;
import lapr.project.model.Questao;

/**
 *
 * @author Diana
 */

public class ListaQuestoes {
    private Avaliacao m_avaliacao;
    private List<Questao> m_listaQuestoes;
    private Questao m_questao;
    
    public ListaQuestoes(){
        
        m_listaQuestoes=new ArrayList<>();
    }
    
    public List<Questao> getListaQuestoes(){
        return this.m_listaQuestoes;
    }
    
    public boolean criarQuestao(Questao novaQuestao){
        
        return m_listaQuestoes.contains(novaQuestao)
                ? false
                : m_listaQuestoes.add(novaQuestao);
    }
  
}