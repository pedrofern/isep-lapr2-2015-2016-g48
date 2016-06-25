
package lapr.project.model.lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.Calculator;
import lapr.project.model.Questao;

/**
 *
 * @author Diana
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaQuestoes implements Serializable{

    private ArrayList<Questao> m_listaQuestoes;
    private double media;
    
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

    public double calcularMedia() {
        List<Integer> respostas=new ArrayList<Integer>();
        
        for (int i=0; i<m_listaQuestoes.size(); i++){
            int resp=m_listaQuestoes.get(i).getResposta();
            respostas.add(resp);
        }
        
//        int resp1=resposta.get(0);
//        int resp2=resposta.get(1);
//        int resp3=resposta.get(2);
//        int resp4=resposta.get(3);
//        int resp5=resposta.get(4);
//        
//        int soma=Calculator.sum(resp1, resp2, resp3, resp4, resp5);
        int soma= Calculator.sum(respostas);
        int count=Calculator.countQuestions(m_listaQuestoes);
        int countRespostas=Calculator.countRespostas(respostas);
        
//        if(verifica(count, countRespostas)){
            media=Calculator.average(soma, count);
            return media;
//        }
   
    }
    
    public double getMedia(){
        return media;
    }
    
    private boolean verifica(int v1, int v2){
       return v1==v2;
    }
    
  
}