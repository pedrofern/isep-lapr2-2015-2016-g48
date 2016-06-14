/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.mechanisms;

import java.util.Collections;
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
public class MecanismoTempoServico implements MecanismoAtribuicao {
    
    private static final String TIPO= "Tempo de Serviço" ;
    private static Exposicao exposicao;
    private static ListaFAE listaFaes;
    private static ListaCandidaturas listaCandidaturas;
    private static ListaAtribuicoes listaAtribuicoes;
    private static ListaAtribuicoes listaAtribuicoesNovas;
    
    public MecanismoTempoServico(Exposicao e){
        this.exposicao=e;
        this.listaFaes=e.getListaFAEs();
        this.listaCandidaturas=e.getRegistoCandidaturas();
        this.listaAtribuicoes=e.getListaAtribuicoes();
    }
    
    public MecanismoTempoServico(){
        exposicao=new Exposicao();
        listaFaes=new ListaFAE();
        listaCandidaturas=new ListaCandidaturas();
        listaAtribuicoes=new ListaAtribuicoes();
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
    
    public void sortFaeTempoServico(){
        Collections.sort(listaFaes.getListaFAE());
    }
    
    @Override
    public boolean atribui(ProcessoAtribuicao pa) {
        listaAtribuicoesNovas=new ListaAtribuicoes();
        for (FAE f:listaFaes.getListaFAE()){
            for(Candidatura c:listaCandidaturas.getListaCandidaturas()){
                
                Atribuicao atribuicao=new Atribuicao(f,c);
                if(listaAtribuicoes.valida(atribuicao)){
                    atribuicao.setAtribuida();
                    listaAtribuicoesNovas.add(atribuicao);
                    
                }        
            }
        }
        return listaAtribuicoesNovas.getListaAtribuicoes().isEmpty();
    }
    
    public boolean guardarAtribuicoes(){
        return listaAtribuicoes.addListaAtribuicoes(listaAtribuicoesNovas);
    }
    
    public String toString(){
        return TIPO;
    }
    
}
