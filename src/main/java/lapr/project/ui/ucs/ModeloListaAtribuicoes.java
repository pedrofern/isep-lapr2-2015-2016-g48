/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import javax.swing.AbstractListModel;
import lapr.project.model.Exposicao;
import lapr.project.model.lists.ListaAtribuicoes;
import lapr.project.model.mechanisms.Atribuicao;
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
    
    public void gerarAtribuicoes(Object mecanismo,Exposicao e){
         if (mecanismo instanceof MecanismoCarga){
             MecanismoCarga m1=new MecanismoCarga();
             m1.setExposicao(e);
             m1.atribui();
           
             
         }
    }
    
//    public void getAtribuicoesFae(FAE f){
//          
//             for(Atribuicao a:m1.getListaAtribuicoes().getListaAtribuicoes()){
//                 addElement(a);
//             }
//    }
   
}
