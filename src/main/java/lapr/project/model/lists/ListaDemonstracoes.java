package lapr.project.model.lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;

/**
 *
 * @author Pedro Fernandes
 */
public class ListaDemonstracoes {

    private ArrayList<Demonstracao> listaDemontracoes;
    
    /**
     * Construtor relativo a lista de demonstracoes
     */
    public ListaDemonstracoes() {
        listaDemontracoes = new ArrayList<>();
    }
    
     public Demonstracao novaDemonstracao() {
        
        return new Demonstracao();
    }

    /**
     * Metodo que retorna o demonstracao na posicao do indice passado por parametro
     *
     * @param indice indice
     * @return o demonstracao na posicao do indice passado por parametro
     */
    public Demonstracao obterDemonstracao(int indice) {
        return listaDemontracoes.get(indice);
    }

    /**
     * Metodo que vai retorna o array de demonstracoes
     *
     * @return o array de produtos
     */
    public Demonstracao[] getArray() {
        return listaDemontracoes.toArray(new Demonstracao[listaDemontracoes.size()]);
    }

    /**
     * Metodo que vai retorna a lista de demonstracoes
     *
     * @return lista de demonstracoes
     */
    public List<Demonstracao> getListaDemonstracoes() {
        return listaDemontracoes;
    }

    /**
     * Metodo que vai adicionar a demonstracao passado por parametro a lista
     *
     * @param demonstracao demonstracao
     * @return true se adicionar false em caso contrario
     */
    public boolean adicionarDemonstracao(Demonstracao demonstracao) {
        if (!listaDemontracoes.contains(demonstracao)) {
            return listaDemontracoes.add(demonstracao);
        }
        return false;
    }

    /**
     * Metodo que vai remover o demonstracao passado por parametro a lista
     *
     * @param demonstracao demonstracao
     * @return true se remover false em caso contrario
     */
    public boolean removerDemonstracao(Demonstracao demonstracao) {
        return listaDemontracoes.remove(demonstracao);
    }

    /**
     * Metodo que vai retorna o tamanho da lista
     *
     * @return o tamanho da lista
     */
    public int tamanho() {
        return this.listaDemontracoes.size();
    }
     /**
     * Metodo que vai retornar o indice da demonstracao passado por parametro
     *
     * @param demonstracao demonstracao
     * @return o indice da demonstracao passado por parametro
     */
    public int indiceDeDemonstracao(Demonstracao demonstracao) {
        return listaDemontracoes.indexOf(demonstracao);
    }
     /**
     * Metodo que vai verificar se a lista de demonstracoes contem o produto passado por parametro
     *
     * @param demonstracao demonstracao
     * @return true se existir false em caso contrario
     */
    public boolean contem(Demonstracao demonstracao) {
        return listaDemontracoes.contains(demonstracao);
    }
}
