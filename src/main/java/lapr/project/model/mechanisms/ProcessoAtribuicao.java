package lapr.project.model.mechanisms;

import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.Avaliacao;
import lapr.project.model.lists.ListaAtribuicoes;


/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
public interface ProcessoAtribuicao {

    public ListaAtribuicoes getListaDeAvaliacoes();
    
    public abstract MecanismoAtribuicao setMecanismoAtribuicao(MecanismoAtribuicao m);

    public abstract boolean atribui(Atribuivel es);

    public abstract Avaliacao novaAvaliacao();

    public abstract void setListaAvaliacoes(ListaAtribuicoes la);

        public String getInfo();
}
