/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import javax.swing.AbstractListModel;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.Candidatura;


/**
 * Cria um modelo lista de candidatura
 * @author Pedro Fernandes
 */
public class ModeloListaCandidatura extends AbstractListModel{
    /**
     * Guarda as listas candidaturas
     */
    private ListaCandidaturas listaCandidaturas;
    /**
     * Constrói uma instância de modelo lista candidaturas
     * @param listaCandidaturas lista candidaturas
     */
    public ModeloListaCandidatura(ListaCandidaturas listaCandidaturas) {
        this.listaCandidaturas = listaCandidaturas;
    }
    /**
     * Devolve o tamanho da lista candidaturas
     * @return tamanho da lista candidaturas
     */
    @Override
    public int getSize() {
        return listaCandidaturas.tamanho();
    }
    /**
     * Devolve o indice do elemento da lista
     * @param indice indice
     * @return indice do elemento da lista
     */
    @Override
    public Object getElementAt(int indice) {
        return listaCandidaturas.obterCandidatura(indice);
    }
    /**
     * Adiciona um elemento à lista, recebida por parametro
     * @param candidatura candidatura
     * @return um elemento à lista, recebida por parametro
     */
    public boolean addElement(Candidatura candidatura){
        boolean candidaturaAdicionada = listaCandidaturas.addCandidatura(candidatura);
        if(candidaturaAdicionada)
            fireIntervalAdded(this, getSize()-1, getSize()-1);
        return candidaturaAdicionada;
    } 
    /**
     * Remove um elemento à lista, recebida por parametro
     * @param candidatura candidatura
     * @return um elemento à lista, recebida por parametro
     */
    public boolean removeElement(Candidatura candidatura){
        int indice = listaCandidaturas.indiceDeCandidatura(candidatura);
        boolean candidaturaRemovida = listaCandidaturas.removerCandidatura(candidatura);
        if(candidaturaRemovida)
            fireIntervalRemoved(this, indice, indice);
        return candidaturaRemovida;
    }
    /**
     * Devolve true ou false se está contido na lista uma candidatura recebida por parametro
     * @param candidatura candidatura
     * @return true ou false se está contido na lista uma candidatura recebida por parametro
     */
    public boolean contains(Candidatura candidatura){
        return listaCandidaturas.contem(candidatura);
    }
}
