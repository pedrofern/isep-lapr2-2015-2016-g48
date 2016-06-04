package lapr.project.model;

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
