/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import javax.swing.AbstractListModel;
import lapr.project.model.Exposicao;
import lapr.project.model.lists.RegistoExposicoes;

/**
 *
 * @author Edu
 */
public class ModeloListaExposicao extends AbstractListModel {

    private RegistoExposicoes listaExposicao;

    public ModeloListaExposicao(RegistoExposicoes listaExposicao) {
        this.listaExposicao = listaExposicao;
    }

    @Override
    public int getSize() {
        return listaExposicao.getExposicoes().size();
    }

    @Override
    public Object getElementAt(int indice) {
        return listaExposicao.getExposicoes().get(indice);
    }

    public boolean addElement(Exposicao exposicao) {
        boolean exposicaoAdicionado = listaExposicao.adicionarExposicao(exposicao);
        if (exposicaoAdicionado) {
            fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        }
        return exposicaoAdicionado;
    }

    public boolean removeElement(Exposicao exposicao) {
        int indice = listaExposicao.getExposicoes().indexOf(exposicao);
        boolean exposicaoRemovido = listaExposicao.getExposicoes().remove(exposicao);
        if (exposicaoRemovido) {
            fireIntervalRemoved(this, indice, indice);
        }
        return exposicaoRemovido;
    }

    public boolean contains(Exposicao exposicao) {
        return listaExposicao.getExposicoes().contains(exposicao);
    }

    public void sort() {
        listaExposicao.ordenarPorPosicao();
    }

}
