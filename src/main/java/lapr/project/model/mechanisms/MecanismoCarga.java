
package lapr.project.model.mechanisms;

import java.io.Serializable;
import lapr.project.model.Candidatura;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.model.lists.ListaAtribuicoes;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaFAE;

/**
 *
 * @author DianaSilva
 */
public class MecanismoCarga implements Serializable{

    
    private static final String TIPO_MECANISMO= "Distribuir equitativamente" ;
    private Exposicao exposicao;
    private ListaFAE listaFaes;
    private  ListaCandidaturas listaCandidaturas;
    private  ListaAtribuicoes listaAtribuicoes;
    private ListaCandidaturas listaJaAtribuidas;
            
    public MecanismoCarga(Exposicao e){
        this.exposicao=e;
        this.listaFaes=e.getListaFAE();
        this.listaCandidaturas=e.getListaCandidaturas();
//        this.listaAtribuicoes=e.getRegistoAtribuicoes;
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
     
     
     public void setExposicao(Exposicao exposicao){
         this.exposicao=exposicao;
         listaFaes=exposicao.getListaFAE();
         listaCandidaturas=exposicao.getListaCandidaturas();
         listaAtribuicoes=new ListaAtribuicoes();
     }

    public void atribui() {

        int n_cand=listaCandidaturas.getListaCandidaturas().size();
        int n_fae=listaFaes.getListaFAE().size();
        
        int nCandidaturaFae=(n_cand/n_fae);

        for(Candidatura c:listaCandidaturas.getListaCandidaturas()){
  
            for (FAE f: listaFaes.getListaFAE()){
                for(int i=0; i<=nCandidaturaFae; i++){ 
//                    if(c.getEstado()==false){
//                        if(f.getEstado()==false){
//                            Atribuicao atribuicao=new Atribuicao(f,c);
//                            listaAtribuicoes.adicionarAtribuicao(atribuicao);
//                            f.setAtribuido();
//                            c.setAtribuida();
//                        }
//                      }      
               }
            }
        }
    }
  

    @Override
     public String toString(){
         return TIPO_MECANISMO;
     } 
    
}
