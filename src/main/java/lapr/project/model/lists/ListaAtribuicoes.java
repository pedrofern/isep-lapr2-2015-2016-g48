package lapr.project.model.lists;

import java.util.*;
import lapr.project.model.mechanisms.Atribuicao;

/**
 *
 * @author DianaSilva
 */
public class ListaAtribuicoes {
    private List<Atribuicao> listaAtribuicoes;

    public ListaAtribuicoes() {
        this.listaAtribuicoes = new ArrayList<>();
    }

    
    
    public Atribuicao novaAtribuicaoCandidatura() {
        return new Atribuicao();
    }
    /**
     * Obtem as revisoes do revisor passado por parametro.
     *
     * @param id revisor
     * @return lista revisoes
     */
    public List<Atribuicao> getAvaliacoesFAE(String id) {
        List<Atribuicao> listAvaliacoes = new ArrayList<>();

        for (Atribuicao a : getListaAtribuicoes()) {
//            if (a.temFAE(id)) {
//                listAvaliacoes.add(a);
//            }
        }
        return listAvaliacoes;
    }

    /**
     * Verifica se as Avaliacoes estão concluídas.
     *
     * @return true se estiverem concluídas, false se não estiverem.
     */
    boolean isAvaliacoesConcluidas() {
        for (Atribuicao a : getListaAtribuicoes()) {
//            if (!a.isConcluida()) {
//                return false;
//            }
        }
        return true;
    }

    /**
     * Valida uma atribuicao
     *
     * @param atribuicao A atribuicao que vai ser validada
     * @return true se for válida, false se não for.
     */
    public boolean valida(Atribuicao atribuicao) {
        for(Atribuicao a: listaAtribuicoes){
            if(atribuicao.equals(this)){
                return false;
            }
        }
        return true;
    }

    /**
     * Adiciona uma Atribuicao à lista de Avaliacoes
     *
     * @param a A Atribuicao que vai ser adicionada à lista.
     */
    public void add(Atribuicao a) {
        this.getListaAtribuicoes().add(a);
    }

    /**
     * Verifica se a lista de Avaliacoes é igual a um objeto passado por parâmetro
     *
     * @param o O objeto que vai ser comparado com a lista de Avaliacoes
     * @return True se forem iguais, false se não forem.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        ListaAtribuicoes outraLA = (ListaAtribuicoes) o;
        return this.getListaAtribuicoes().equals(outraLA.getListaAtribuicoes());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.listaAtribuicoes);
        return hash;
    }

    /**
     * Obtem a lista de Avaliacoes
     *
     * @return the listaAtribuicoes
     */
    public List<Atribuicao> getListaAtribuicoes() {
        return listaAtribuicoes;
    }

    public Object obterAtribuicao(int index) {
        return listaAtribuicoes.get(index);
    }
    
    public boolean addListaAtribuicoes(ListaAtribuicoes lista){
        for(Atribuicao a: lista.getListaAtribuicoes()){
           if(valida(a)){
              listaAtribuicoes.add(a); 
           }  
        }
        if (listaAtribuicoes.isEmpty()) return false;
        return true;
    }
    
    
}
