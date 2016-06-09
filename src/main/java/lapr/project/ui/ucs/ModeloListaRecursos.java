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
 * @author Pedro Fernandes
 */
public class ModeloListaRecursos extends AbstractListModel {

    /**
     * Guarda lista recursos
     */
    private ListaRecurso listaRecursos;

    /**
     * Construtor de objetos modelo lista recursos
     *
     * @param listaRecursos lista recursos
     */
    public ModeloListaRecursos(ListaRecurso listaRecursos) {
        this.listaRecursos = listaRecursos;
    }

    /**
     * Retorna o tamanho da lista de recursos
     *
     * @return tamanho da lista de recursos
     */
    @Override
    public int getSize() {
        return listaRecursos.tamanho();
    }

    /**
     * Retorna o recurso na posição especificada
     *
     * @param indice indice
     * @return recurso na posição especificada
     */
    @Override
    public Object getElementAt(int indice) {
        return listaRecursos.obterRecurso(indice);
    }

    /**
     * adiciona recurso a lista de recursos
     *
     * @param recurso recurso
     * @return true se adicionar false caso contrario
     */
    public boolean addElement(Recurso recurso) {
        boolean recursoAdicionado = listaRecursos.adicionarRecurso(recurso);
        if (recursoAdicionado) {
            fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        }
        return recursoAdicionado;
    }

    /**
     * remove recurso a lista de recursos
     *
     * @param recurso recurso
     * @return true se remover false caso contrario
     */
    public boolean removeElement(Recurso recurso) {
        int indice = listaRecursos.indiceDe(recurso);
        boolean recursoRemovido = listaRecursos.removerRecurso(recurso);
        if (recursoRemovido) {
            fireIntervalRemoved(this, indice, indice);
        }
        return recursoRemovido;
    }
    /**
     * Verfica se o recurso especificado existe na lista de recursos
     * @param recurso recurso
     * @return true se existir false em caso contrario
     */
    public boolean contains(Recurso recurso) {
        return listaRecursos.contem(recurso);
    }

}
