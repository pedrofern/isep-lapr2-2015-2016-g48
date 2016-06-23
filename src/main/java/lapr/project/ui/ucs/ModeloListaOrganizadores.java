/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import javax.swing.AbstractListModel;
import lapr.project.model.Organizador;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaOrganizadores;

/**
 *
 * @author Diana
 */

public class ModeloListaOrganizadores extends AbstractListModel {

    private ListaOrganizadores listaOrganizadores;
    
    public ModeloListaOrganizadores(ListaOrganizadores lista) {
        listaOrganizadores=lista;
    }
  
    @Override
    public Object getElementAt(int indice) {
        return listaOrganizadores.getListaOrganizadores().indexOf(indice);
    }
    
    public boolean addElement(Organizador o){
       
        boolean utilizadorAdicionado = listaOrganizadores.addOrganizador(o);
        if(utilizadorAdicionado){
            fireIntervalAdded(this, getSize() -1, getSize() -1);
            
        }
        return utilizadorAdicionado;      
       
    } 
    
    @Override
    public int getSize() {
        return listaOrganizadores.getListaOrganizadores().size();
    }
    
    public int getRowCount() {
        return listaOrganizadores.getListaOrganizadores().size();
    }

    public boolean removeElement(Organizador o){
        int indice = listaOrganizadores.getListaOrganizadores().indexOf(o);
        boolean utilizadorRemovido = listaOrganizadores.removerUtilizador(o);
        if(utilizadorRemovido)
            fireIntervalRemoved(this, indice, indice);
        return utilizadorRemovido;
    }
    
    public boolean contains(Organizador o){
        return listaOrganizadores.getListaOrganizadores().contains(o);
    }
 
    
    public ListaOrganizadores getListaOrganizadores(){
        return listaOrganizadores;
    }

}
