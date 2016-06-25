/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author DianaSilva
 */
@XmlRootElement
public class MecanismoRanking extends Mecanismo implements Serializable{
    
    private static final String TIPO= "Qualidade FAE" ;
    private Exposicao exposicao;
    private ListaFAE listaFaes;
    private ListaCandidaturas listaCandidaturas;
    private ListaAtribuicoes listaAtribuicoes;
    private ListaAtribuicoes listaAtribuicoesNovas;
    
    public MecanismoRanking(){
    }
 
    public ListaFAE getListaFaes(){
        return listaFaes;
    }
    
    public ListaAtribuicoes getListaAtribuicoes(){
        return listaAtribuicoes;
    }
    
    public void setExposicao(Exposicao exposicao){
        this.exposicao=exposicao;
        this.listaFaes=listaFaes;
        this.listaAtribuicoes=listaAtribuicoes;
        this.listaCandidaturas=listaCandidaturas;
    }
    
    public ListaCandidaturas getListaCandidaturas(){
        return listaCandidaturas;
    }
    
    public void sortFaeRanking(){
    }
 
     
     public ListaAtribuicoes getListaAtribuicoesGeradas(){
         return this.listaAtribuicoesNovas;
     }

    @Override
    public boolean atribui() {
        
        int n_cand=listaCandidaturas.getListaCandidaturas().size();
        int n_fae=listaFaes.getListaFAE().size();
        
        listaAtribuicoesNovas=new ListaAtribuicoes();
        
        
        for (FAE f:listaFaes.getListaFAE()){
            for(Candidatura c:listaCandidaturas.getListaCandidaturas()){
                
                Atribuicao atribuicao=new Atribuicao(f,c);
                if(listaAtribuicoesNovas.adicionarAtribuicao(atribuicao))
                     atribuicao.setAtribuida();      
             }        
        }
        return listaAtribuicoesNovas.getListaAtribuicoes().isEmpty();
    }
    
    public boolean guardarAtribuicoes(){
        return listaAtribuicoes.adicionharListaAtribuicoes(listaAtribuicoesNovas);
    }
    
    public String toString(){
        return TIPO;
    }
}
