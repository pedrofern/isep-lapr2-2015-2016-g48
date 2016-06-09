/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import javax.swing.AbstractListModel;
import lapr.project.model.Utilizador;

/**
 *
 * @author Edu
 */
public class ModeloListaUtilizadores extends AbstractListModel {

    private ListaUtilizadores listaUtilizadores;
    
    public ModeloListaUtilizadores(ListaUtilizadores listaUtilizadores) {
        this.listaUtilizadores = listaUtilizadores;
    }

    @Override
    public int getSize() {
        return listaUtilizadores.tamanho();
    }

    @Override
    public Object getElementAt(int indice) {
        return listaUtilizadores.obterUtilizador(indice);
    }
    
    public boolean addElement(Utilizador utilizador){
        boolean utilizadorAdicionado = listaUtilizadores.adicionarUtilizador(utilizador);
        if(utilizadorAdicionado)
            fireIntervalAdded(this, getSize()-1, getSize()-1);
        return utilizadorAdicionado;
    } 

    public boolean removeElement(Utilizador utilizador){
        int indice = listaUtilizadores.indiceDe(utilizador);
        boolean utilizadorRemovido = listaUtilizadores.removerUtilizador(utilizador);
        if(utilizadorRemovido)
            fireIntervalRemoved(this, indice, indice);
        return utilizadorRemovido;
    }
    
    public boolean contains(Utilizador utilizador){
        return listaUtilizadores.contem(utilizador);
    }
    
    public void sort(){
        listaUtilizadores.ordenarPorPosicao();
    }

}

