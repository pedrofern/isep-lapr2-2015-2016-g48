
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lapr.project.model.Avaliacao;
import lapr.project.model.Candidatura;
import lapr.project.model.FAE;
import lapr.project.model.mechanisms.Atribuicao;

/**
 *
 * @author Pedro Fernandes
 */
public class ListaAvaliacoes {
     private List<Avaliacao> listaAvaliacoes;

    public ListaAvaliacoes() {
        this.listaAvaliacoes = new ArrayList<>();
    }

    /**
     * Obtem as revisoes do revisor passado por parametro.
     *
     * @param id revisor
     * @return lista revisoes
     */
    public List<Avaliacao> getAvaliacoesFAE(String id) {
        List<Avaliacao> listAvaliacoes = new ArrayList<>();

        for (Avaliacao a : getListaAvaliacoes()) {
//            if (a.isFAE(id)) {
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
        for (Avaliacao a : getListaAvaliacoes()) {
            if (!a.isConcluida()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Valida uma avaliacao
     *
     * @param avaliacao A avaliacao que vai ser validada
     * @return true se for válida, false se não for.
     */
    public boolean valida(Avaliacao avaliacao) {
        return avaliacao.valida();
    }

    /**
     * Adiciona uma Avaliacao à lista de Avaliacoes
     *
     * @param a A Avaliacao que vai ser adicionada à lista.
     */
    public void add(Avaliacao a) {
        this.getListaAvaliacoes().add(a);
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
        ListaAvaliacoes outraLA = (ListaAvaliacoes) o;
        return this.getListaAvaliacoes().equals(outraLA.getListaAvaliacoes());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.listaAvaliacoes);
        return hash;
    }

    /**
     * Obtem a lista de Avaliacoes
     *
     * @return the listaAvaliacoes
     */
    public List<Avaliacao> getListaAvaliacoes() {
        return listaAvaliacoes;
    }
    
    

    public boolean validaAvaliacaoCandidatura(Candidatura c) {
        return c.valida();
    }

    public boolean validaAvaliacaoFae(FAE f) {
        return f.valida();
    }

}