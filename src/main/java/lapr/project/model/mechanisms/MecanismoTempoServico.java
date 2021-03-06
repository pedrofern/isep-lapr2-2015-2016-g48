/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.mechanisms;

import java.io.Serializable;
import lapr.project.model.Atribuicao;
import java.util.Collections;
import javax.xml.bind.annotation.XmlRootElement;
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
public class MecanismoTempoServico extends Mecanismo implements Serializable{
    
    private static final String TIPO= "Tempo de Serviço" ;
    private ListaFAE listaFaes;
    private ListaCandidaturas listaCandidaturas;
    private ListaAtribuicoes listaAtribuicoes;
    private ListaAtribuicoes listaAtribuicoesNovas;
    
    public MecanismoTempoServico(){
    }
    
    public ListaFAE getListaFaes(){
        return listaFaes;
    }
    
    public ListaAtribuicoes getListaAtribuicoes(){
        return listaAtribuicoes;
    }
    
    public void setExposicao(Exposicao exposicao){
        this.listaFaes=exposicao.getListaFAE();
        this.listaAtribuicoes=exposicao.getListaAtribuicoes();
        this.listaCandidaturas=exposicao.getListaCandidaturas();
    }
    
    public ListaCandidaturas getListaCandidaturas(){
        return listaCandidaturas;
    }
    
     public ListaAtribuicoes getListaAtribuicoesGeradas(){
         return this.listaAtribuicoesNovas;
     }
    
    
    public void sortFaeTempoServicoDecrescente(){
        Collections.sort(listaFaes.getListaFAE());
        Collections.reverse(listaFaes.getListaFAE());
    }

    @Override
    public boolean atribui() {
        sortFaeTempoServicoDecrescente();
        
        
        int nCand=listaCandidaturas.getListaCandidaturas().size();
  
        double n50porCentoCand=nCand*0.5;

        listaAtribuicoesNovas=new ListaAtribuicoes();
 
       for(Candidatura c:listaCandidaturas.getListaCandidaturas()){
           for (FAE f: listaFaes.getListaFAE()){  
        
             if(f.getNAtribuidas()<n50porCentoCand){
                  
                    if(c.getEstadoAtualCandidatura() instanceof CandidaturaEmAtribuicao){
                             Atribuicao atribuicao=new Atribuicao(f,c);
                             if(listaAtribuicoesNovas.adicionarAtribuicao(atribuicao)){
                                f.incrementaNAtribuidas();
                                c.setEstadoCandidatura(new CandidaturaEmAvaliacao());
                             }
                        }
                   }  
            }
        }
 
        return listaAtribuicoesNovas.getListaAtribuicoes().isEmpty();
    }
    
    public boolean guardarAtribuicoes(){
        return listaAtribuicoes.adicionharListaAtribuicoes(listaAtribuicoesNovas);
    }
    
    @Override
    public String toString(){
        return TIPO;
    }
    
}
