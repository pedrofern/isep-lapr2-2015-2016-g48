/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import javax.swing.AbstractListModel;
import lapr.project.model.lists.ListaProduto;
import lapr.project.model.Produto;

/**
 *
 * @author Pedro Fernandes
 */
public class ModeloListaProdutos extends AbstractListModel {

    /**
     * Guarda as listas de produtos
     */
    private ListaProduto listaProdutos;

    /**
     * Constroi uma instancia de modelo lista produtos
     *
     * @param listaProdutos lista produtos
     */
    public ModeloListaProdutos(ListaProduto listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    /**
     * Metodo que retorna o tamanho da lista de produtos
     *
     * @return tamanho da lista de produtos
     */
    @Override
    public int getSize() {
        return listaProdutos.tamanho();
    }

    /**
     * Metodo que retorna o produto no indice especificado
     *
     * @param indice indice
     * @return o produto no indice especificado
     */
    @Override
    public Object getElementAt(int indice) {
        return listaProdutos.obterProduto(indice);
    }

    /**
     * Metodo que adiciona o produto especificado a lista
     *
     * @param produto produto
     * @return true se adicionar false em caso contrario
     */
    public boolean addElement(Produto produto) {
        boolean produtoAdicionado = listaProdutos.adicionarProduto(produto);
        if (produtoAdicionado) {
            fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        }
        return produtoAdicionado;
    }

    /**
     * Metodo que remove o produto especificado a lista
     *
     * @param produto produto
     * @return true se remover false em caso contrario
     */
    public boolean removeElement(Produto produto) {
        int indice = listaProdutos.indiceDeProduto(produto);
        boolean produtoRemovido = listaProdutos.removerProduto(produto);
        if (produtoRemovido) {
            fireIntervalRemoved(this, indice, indice);
        }
        return produtoRemovido;
    }
    /**
     * Metodo que verifica se o produto existe na lista
     * @param produto produto
     * @return true se existir false caso contrario
     */
    public boolean contains(Produto produto) {
        return listaProdutos.contem(produto);
    }

}
