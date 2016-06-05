package lapr.project.model.mechanisms;

import lapr.project.model.Avaliacao;
import lapr.project.model.lists.ListaAvaliacoes;
import lapr.project.model.mechanisms.MecanismoAtribuicao;

/**
 *
 * @author Pedro Fernandes
 */
public interface ProcessoAtribuicao {

    public ListaAvaliacoes getListaDeAvaliacoes();
    
    public abstract MecanismoAtribuicao setMecanismoAtribuicao(MecanismoAtribuicao m);

    public abstract boolean atribui(Atribuivel es);

    public abstract Avaliacao novaAvaliacao();

    public abstract void setListaAvaliacoes(ListaAvaliacoes la);

        public String getInfo();
}
