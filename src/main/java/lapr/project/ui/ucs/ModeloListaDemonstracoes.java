/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import javax.swing.AbstractListModel;
import lapr.project.model.lists.RegistoDemonstracoes;
import lapr.project.model.Demonstracao;

/**
 * Cria um modelo lista de demonstrações
 * @author Pedro Fernandes
 */
//public class ModeloListaDemonstracoes extends AbstractListModel {
//    /**
//     * Guarda as listas demonstrações
//     */
//    private RegistoDemonstracoes listaDemonstracoes;
//    /**
//     * Constrói uma instância de modelo lista demonstrações
//     * @param listaDemonstracoes lista demonstrações
//     */
//    public ModeloListaDemonstracoes(RegistoDemonstracoes listaDemonstracoes) {
//        this.listaDemonstracoes = listaDemonstracoes;
//    }
//    /**
//     * Devolve o tamanho da lista candidaturas
//     * @return tamanho da lista candidaturas
//     */
//    @Override
//    public int getSize() {
//        return listaDemonstracoes.tamanho();
//    }
//    /**
//     * Devolve o indice do elemento da lista
//     * @param indice indice
//     * @return indice do elemento da lista
//     */
//    @Override
//    public Object getElementAt(int indice) {
//        return listaDemonstracoes.obterDemonstracao(indice);
//    }
//    /**
//     * Adiciona um elemento à lista, recebida por parametro
//     * @param demonstracao demonstracao
//     * @return um elemento à lista, recebida por parametro
//     */
//    public boolean addElement(Demonstracao demonstracao){
//        boolean produtoAdicionado = listaDemonstracoes.adicionarDemonstracao(demonstracao);
//        if(produtoAdicionado)
//            fireIntervalAdded(this, getSize()-1, getSize()-1);
//        return produtoAdicionado;
//    } 
//    /**
//     * Remove um elemento à lista, recebida por parametro
//     * @param demonstracao demonstracao
//     * @return um elemento à lista, recebida por parametro
//     */
//    public boolean removeElement(Demonstracao demonstracao){
//        int indice = listaDemonstracoes.indiceDeDemonstracao(demonstracao);
//        boolean demonstracaoRemovida = listaDemonstracoes.removerDemonstracao(demonstracao);
//        if(demonstracaoRemovida)
//            fireIntervalRemoved(this, indice, indice);
//        return demonstracaoRemovida;
//    }
//    /**
//     * Devolve true ou false se está contido na lista uma candidatura recebida por parametro
//     * @param demonstracao demonstracao
//     * @return true ou false se está contido na lista uma candidatura recebida por parametro
//     */
//    public boolean contains(Demonstracao demonstracao){
//        return listaDemonstracoes.contem(demonstracao);
//    }
//    
//}
