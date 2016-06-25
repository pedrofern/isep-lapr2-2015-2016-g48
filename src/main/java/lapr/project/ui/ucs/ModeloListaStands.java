/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import javax.swing.AbstractListModel;
import lapr.project.model.lists.*;
import lapr.project.model.*;

/**
 *
 * @author anasilva
 */
public class ModeloListaStands extends AbstractListModel{
    
    /**
     * Guarda lista stands
     */
    private RegistoStands listaStands;

    /**
     * Construtor de objetos modelo lista stands
     *
     * @param listaStands lista stands
     */
    public ModeloListaStands(RegistoStands listaStands) {
        this.listaStands = listaStands;
    }

    /**
     * Retorna o tamanho da lista de stands
     *
     * @return tamanho da lista de stands
     */
    @Override
    public int getSize() {
    return listaStands.tamanho();
    }

    /**
     * Retorna o stand na posição especificada
     *
     * @param indice indice
     * @return stand na posição especificada
     */
    @Override
    public Object getElementAt(int indice) {
        return listaStands.obterStand(indice);
    }

    /**
     * adiciona stand a lista de stands
     *
     * @param stand stand
     * @return true se adicionar false caso contrario
     */
    public boolean addElement(Stand stand) {
        boolean StandAdicionado = listaStands.adicionarStand(stand);
        if (StandAdicionado) {
            fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        }
        return StandAdicionado;
    }

    /**
     * remove stand a lista de stands
     *
     * @param stand stand
     * @return true se remover false caso contrario
     */
    public boolean removeElement(Stand stand) {
        int indice = listaStands.indiceDeStand(stand);
        boolean StandRemovido = listaStands.removerStand(stand);
        if (StandRemovido) {
            fireIntervalRemoved(this, indice, indice);
        }
        return StandRemovido;
    }
    /**
     * Verfica se o stand especificado existe na lista de stands
     * @param stand stand
     * @return true se existir false em caso contrario
     */
    public boolean contains(Stand stand) {
        return listaStands.contem(stand);
    }
}
