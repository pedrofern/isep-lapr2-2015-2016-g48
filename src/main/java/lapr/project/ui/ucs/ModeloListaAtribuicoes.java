/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import javax.swing.AbstractListModel;
import lapr.project.model.Exposicao;
import lapr.project.model.lists.ListaAtribuicoes;
import lapr.project.model.Atribuicao;
import lapr.project.model.Candidatura;
import lapr.project.model.mechanisms.MecanismoAtribuicao;
import lapr.project.model.mechanisms.MecanismoCarga;
import lapr.project.model.mechanisms.MecanismoRanking;
import lapr.project.model.mechanisms.MecanismoTempoServico;

/**
 * Diana Silva
 */
public class ModeloListaAtribuicoes extends AbstractListModel {

    private static ListaAtribuicoes listaAtribuicoes;
    private static MecanismoCarga mecCarga;
    private static MecanismoTempoServico mecServico;
    private static MecanismoRanking mecRanking;
    
    public ModeloListaAtribuicoes(ListaAtribuicoes listaAtribuicoes){
        this.listaAtribuicoes=listaAtribuicoes;
    }
    
    public ListaAtribuicoes getAtribuicoes(){
        return listaAtribuicoes;
    }
    
    
    @Override
    public int getSize() {
        return listaAtribuicoes.getListaAtribuicoes().size();
    }

    @Override
    public Object getElementAt(int index) {
        return listaAtribuicoes.obterAtribuicao(index);
    }
    
    public void gerarAtribuicoes(MecanismoAtribuicao mecanismo,Exposicao e){
        if(mecanismo instanceof MecanismoCarga){
            MecanismoCarga m1=new MecanismoCarga();
            m1.setExposicao(e);
            m1.atribui(); 

            for(Atribuicao a: m1.getListaAtribuicoesGeradas().getListaAtribuicoes()){
                    addElement(a);
            }
        }
        if(mecanismo instanceof MecanismoTempoServico){
            MecanismoTempoServico m2=new MecanismoTempoServico();
            m2.setExposicao(e);
            m2.atribui(); 

            for(Atribuicao a: m2.getListaAtribuicoesGeradas().getListaAtribuicoes()){
                    addElement(a);
            }
        }
        if(mecanismo instanceof MecanismoRanking){
            MecanismoRanking m3=new MecanismoRanking();
            m3.setExposicao(e);
            m3.atribui(); 

            for(Atribuicao a: m3.getListaAtribuicoesGeradas().getListaAtribuicoes()){
                    addElement(a);
            }
        }
            
    }
 
    public boolean addAtribuicoesGeradas(ListaAtribuicoes lista){
        for(Atribuicao a: lista.getListaAtribuicoes()){
            addElement(a);
        }
        
        return true;
     }
     
     public boolean addElement(Atribuicao a){
         
        boolean atribuicaoAdicionada = listaAtribuicoes.adicionarAtribuicao(a);
        if(atribuicaoAdicionada)
            fireIntervalAdded(this, getSize()-1, getSize()-1);
        else System.out.println("Falhou");
        return atribuicaoAdicionada;
     } 
     

    public boolean removeElement(Atribuicao atrib){
        int indice = listaAtribuicoes.obterIndiceAtribuicao(atrib);
        boolean atribuicaoRemovida = listaAtribuicoes.removerAtribuicao(atrib);
        if(atribuicaoRemovida)
            fireIntervalRemoved(this, indice, indice);
        return atribuicaoRemovida;
    }
    
    public boolean removeAll(){
        for(Atribuicao a: listaAtribuicoes.getListaAtribuicoes()){
            removeElement(a);
        } 
        return listaAtribuicoes.getListaAtribuicoes().isEmpty();
    }
}