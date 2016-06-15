/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Produto;

/**
 *
 * @author Pedro Fernandes
 */
public class ListaProduto implements Serializable {

    private ArrayList<Produto> listaProdutos;

    /**
     * Construtor relativo a lista de produtos
     */
    public ListaProduto() {
        listaProdutos = new ArrayList<>();
    }

    /**
     * Metodo que retorna o produto na posicao do indice passado por parametro
     *
     * @param indice indice
     * @return o produto na posicao do indice passado por parametro
     */
    public Produto obterProduto(int indice) {
        return listaProdutos.get(indice);
    }

    /**
     * Metodo que vai retorna o array de produtos
     *
     * @return o array de produtos
     */
    public Produto[] getArray() {
        return listaProdutos.toArray(new Produto[listaProdutos.size()]);
    }

    /**
     * Metodo que vai retorna a lista de produtos
     *
     * @return lista de produtos
     */
    public List<Produto> getListaProduto() {
        return listaProdutos;
    }

    /**
     * Metodo que vai adicionar o produto passado por parametro a lista
     *
     * @param produto produto
     * @return true se adicionar false em caso contrario
     */
    public boolean adicionarProduto(Produto produto) {
        if (!listaProdutos.contains(produto)) {
            return listaProdutos.add(produto);
        }
        return false;
    }

    /**
     * Metodo que vai remover o produto passado por parametro a lista
     *
     * @param produto produto
     * @return true se remover false em caso contrario
     */
    public boolean removerProduto(Produto produto) {
        return listaProdutos.remove(produto);
    }

    /**
     * Metodo que vai retorna o tamanho da lista
     *
     * @return o tamanho da lista
     */
    public int tamanho() {
        return this.listaProdutos.size();
    }
     /**
     * Metodo que vai retornar o indice do produto passado por parametro
     *
     * @param produto produto
     * @return o indice do produto passado por parametro
     */
    public int indiceDeProduto(Produto produto) {
        return listaProdutos.indexOf(produto);
    }
     /**
     * Metodo que vai verificar se a lista de produtos contem o produto passado por parametro
     *
     * @param produto produto
     * @return true se existir false em caso contrario
     */
    public boolean contem(Produto produto) {
        return listaProdutos.contains(produto);
    }

}
