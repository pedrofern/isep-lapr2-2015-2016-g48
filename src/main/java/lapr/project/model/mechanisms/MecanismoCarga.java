
package lapr.project.model.mechanisms;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.Atribuicao;
import lapr.project.model.Candidatura;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.model.lists.ListaAtribuicoes;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.states.CandidaturaEmAtribuicaoFAE;
import lapr.project.model.states.CandidaturaEmAvaliacao;

/**
 *
 * @author DianaSilva
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlTransient
//@XmlSeeAlso({MecanismoDetecaoConflito.class,
//            MecanismoRanking.class,
//            MecanismoTempoServico.class})
public class MecanismoCarga implements Serializable, MecanismoAtribuicao{

    private static final String TIPO_MECANISMO= "Carga Equitativa" ;
    private Exposicao exposicao;
    private ListaFAE listaFaes;
    private  ListaCandidaturas listaCandidaturas;
    private  ListaAtribuicoes listaAtribuicoes;
    private ListaCandidaturas listaJaAtribuidas;
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
         this.exposicao=exposicao;
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
                 
                    if(c.getEstadoAtualCandidatura() instanceof CandidaturaEmAtribuicaoFAE){
                             Atribuicao atribuicao=new Atribuicao(f,c);
                             listaAtribuicoesNovas.adicionarAtribuicao(atribuicao);
                             f.incrementaNAtribuidas();
                             c.setEstadoCandidatura(new CandidaturaEmAvaliacao(c));
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
