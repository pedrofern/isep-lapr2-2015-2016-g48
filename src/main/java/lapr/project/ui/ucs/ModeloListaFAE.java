/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import javax.swing.AbstractListModel;
import lapr.project.model.FAE;
import lapr.project.model.Organizador;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.ListaOrganizadores;

/**
 *
 * @author Diana
 */

public class ModeloListaFAE extends AbstractListModel {

    private ListaFAE listaFAE;
    
    public ModeloListaFAE(ListaFAE lista) {
        listaFAE=lista;
    }
  
    @Override
    public Object getElementAt(int indice) {
        return listaFAE.getListaFAE().indexOf(indice);
    }
    
    public boolean addElement(FAE fae){
        
        boolean utilizadorAdicionado = listaFAE.adicionarFAE(fae);
        if(utilizadorAdicionado)

            fireIntervalAdded(this, getSize() -1, getSize() -1);
        return utilizadorAdicionado;      
       
    } 
    
    @Override
    public int getSize() {
        return listaFAE.getListaFAE().size();
    }
    
    public int getRowCount() {
        return listaFAE.getListaFAE().size();
    }

    public boolean removeElement(FAE fae){
        int indice = listaFAE.getListaFAE().indexOf(fae);
        boolean utilizadorRemovido = listaFAE.removerFAE(fae);
        if(utilizadorRemovido)
            fireIntervalRemoved(this, indice, indice);
        return utilizadorRemovido;
    }
    
    public boolean contains(FAE fae){
        return listaFAE.getListaFAE().contains(fae);
    }
    
    public ListaFAE getListaFAE(){
        return listaFAE;
    }

}
