
package lapr.project.model.mechanisms;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.Atribuicao;
import lapr.project.model.Candidatura;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.model.lists.ListaAtribuicoes;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.states.candidaturasExpo.CandidaturaEmAtribuicao;
import lapr.project.model.states.candidaturasExpo.CandidaturaEmAvaliacao;

/**
 *
 * @author DianaSilva
 */
@XmlRootElement
public class MecanismoCarga extends Mecanismo implements Serializable{

    private static final String TIPO_MECANISMO= "Carga Equitativa" ; 
    private ListaFAE listaFaes;
    private ListaCandidaturas listaCandidaturas;
    private ListaAtribuicoes listaAtribuicoes;
    private ListaAtribuicoes listaAtribuicoesNovas;
            
    public MecanismoCarga(){
    }

    
    public ListaFAE getListFaes(){
        return listaFaes;
    }
    
     public ListaCandidaturas getListCandidaturas(){
        return this.listaCandidaturas;
    }
     
     public ListaAtribuicoes getListaAtribuicoes(){
         return this.listaAtribuicoes;
     }
     
     public ListaAtribuicoes getListaAtribuicoesGeradas(){
         return this.listaAtribuicoesNovas;
     }
     
     
     public void setExposicao(Exposicao exposicao){
         listaFaes=exposicao.getListaFAE();
         listaCandidaturas=exposicao.getListaCandidaturas();
         listaAtribuicoes=new ListaAtribuicoes();
     }

    @Override
    public boolean atribui() {
        listaAtribuicoesNovas=new ListaAtribuicoes();
        int nCand=listaCandidaturas.getListaCandidaturas().size();
        int nFae=listaFaes.getListaFAE().size();
        
        int nCandidaturaFae=(nCand/nFae);
        
       for(Candidatura c:listaCandidaturas.getListaCandidaturas()){
           for (FAE f: listaFaes.getListaFAE()){  
        
             if(f.getNAtribuidas()<nCandidaturaFae){
                 
                    if(c.getEstadoAtualCandidatura() instanceof CandidaturaEmAtribuicao){
                             Atribuicao atribuicao=new Atribuicao(f,c);
                             listaAtribuicoesNovas.adicionarAtribuicao(atribuicao);
                             f.incrementaNAtribuidas();
                             c.setEstadoCandidatura(new CandidaturaEmAvaliacao());
                        }
                   }      
           }
        }
        
        return listaAtribuicoesNovas.getListaAtribuicoes().isEmpty();   
    }
  
    @Override
     public String toString(){
         return TIPO_MECANISMO;
     } 
    
}
