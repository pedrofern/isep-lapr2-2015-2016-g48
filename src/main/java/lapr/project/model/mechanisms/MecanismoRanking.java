/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.mechanisms;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
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
@XmlTransient
@XmlSeeAlso({MecanismoCarga.class,
            MecanismoDetecaoConflito.class,
            MecanismoTempoServico.class})
public class MecanismoRanking implements Serializable, MecanismoAtribuicao{
    
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
//        Collections.sort(listaFaes.getListaFAE());
    }
 
     
     public ListaAtribuicoes getListaAtribuicoesGeradas(){
         return this.listaAtribuicoesNovas;
     }

    @Override
    public boolean atribui() {
        
        int n_cand=listaCandidaturas.getListaCandidaturas().size();
        int n_fae=listaFaes.getListaFAE().size();
        
        int n_fae_cand=n_fae/n_cand;
        
        double n_20_por_cento_fae=n_fae*0.2;
        double n_30_por_cento=n_fae*0.3;
        double n_50_por_cento=n_fae*0.5;
       
        
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
