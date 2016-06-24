/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.Keyword;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaKeywords implements Serializable {

    private ArrayList<Keyword> listaKeyword;

    /**
     * Construtor relativo a lista de keywords
     */
    public ListaKeywords() {
        listaKeyword = new ArrayList<>();
    }

    /**
     * Metodo que retorna o keyword na posicao do indice passado por parametro
     *
     * @param indice indice
     * @return o keyword na posicao do indice passado por parametro
     */
    public Keyword obterKeyword(int indice) {
        return listaKeyword.get(indice);
    }

    /**
     * Metodo que vai retorna o array de keyword
     *
     * @return o array de keyword
     */
    public Keyword[] getArray() {
        return listaKeyword.toArray(new Keyword[listaKeyword.size()]);
    }

    /**
     * Metodo que vai retorna a lista de keywords
     *
     * @return lista de keywords
     */
    public List<Keyword> getListaKeyword() {
        return listaKeyword;
    }

    /**
     * Metodo que vai adicionar keyword passado por parametro a lista
     *
     * @param keyword keyword
     * @return true se adicionar false em caso contrario
     */
    public boolean adicionarKeyword(Keyword keyword) {
        if (!listaKeyword.contains(keyword)) {
            return listaKeyword.add(keyword);
        }
        return false;
    }

    /**
     * Metodo que vai remover keyword passado por parametro a lista
     *
     * @param keyword keyword
     * @return true se remover false em caso contrario
     */
    public boolean removerKeyword(Keyword keyword) {
        return listaKeyword.remove(keyword);
    }

    /**
     * Metodo que vai retorna o tamanho da lista
     *
     * @return o tamanho da lista
     */
    public int tamanho() {
        return this.listaKeyword.size();
    }
     /**
     * Metodo que vai retornar o indice do keyword passado por parametro
     *
     * @param keyword keyword
     * @return o indice do keyword passado por parametro
     */
    public int indiceDeKeyword(Keyword keyword) {
        return listaKeyword.indexOf(keyword);
    }
     /**
     * Metodo que vai verificar se a lista de keywords contem o keyword passado por parametro
     *
     * @param keyword keyword
     * @return true se existir false em caso contrario
     */
    public boolean contem(Keyword keyword) {
        return listaKeyword.contains(keyword);
    }

}
