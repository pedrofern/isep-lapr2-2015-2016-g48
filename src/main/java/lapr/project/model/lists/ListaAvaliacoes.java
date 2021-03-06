
package lapr.project.model.lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.Avaliacao;
import lapr.project.model.Calculator;
import lapr.project.model.Candidatura;
import lapr.project.model.FAE;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaAvaliacoes implements Serializable{
     private ArrayList<Avaliacao> listaAvaliacoes;

    public ListaAvaliacoes() {
        this.listaAvaliacoes = new ArrayList<>();
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
    public boolean add(Avaliacao a) {
        return getListaAvaliacoes().add(a);
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
        return f.validaMenbroFAE();
    }
    
    public double getMedia(){
        int sum=0;
        int total=0;
        for(Avaliacao a: listaAvaliacoes){
            sum+=a.getMedia();
            total++;
        }
        return Calculator.average(sum, total);
    }

}
