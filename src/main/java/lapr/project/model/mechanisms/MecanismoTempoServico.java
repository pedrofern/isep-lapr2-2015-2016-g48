/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.mechanisms;

import java.io.Serializable;
import lapr.project.model.Atribuicao;
import java.util.Collections;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
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
@XmlTransient
@XmlSeeAlso({MecanismoCarga.class,
            MecanismoRanking.class,
            MecanismoDetecaoConflito.class})
public class MecanismoTempoServico implements Serializable, MecanismoAtribuicao {
    
    private static final String TIPO= "Tempo de Serviço" ;
    private Exposicao exposicao;
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
        this.exposicao=exposicao;
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
        int nFae=listaFaes.getListaFAE().size();
  
        double n20porCentoCand=nCand*0.2;
        double n30porCentoCand=nCand*0.3;
        double n50porCentoCand=nCand*0.5;

        listaAtribuicoesNovas=new ListaAtribuicoes();
 
       for(Candidatura c:listaCandidaturas.getListaCandidaturas()){
           for (FAE f: listaFaes.getListaFAE()){  
        
             if(f.getNAtribuidas()<n50porCentoCand){
                  
                    if(c.getEstadoAtualCandidatura() instanceof CandidaturaEmAtribuicaoFAE){
                             Atribuicao atribuicao=new Atribuicao(f,c);
                             if(listaAtribuicoesNovas.adicionarAtribuicao(atribuicao)){
                                f.incrementaNAtribuidas();
                                c.setEstadoCandidatura(new CandidaturaEmAvaliacao(c));
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
