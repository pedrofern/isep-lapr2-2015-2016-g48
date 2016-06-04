package lapr.project.model;

/**
 *
 * @author Pedro Fernandes
 */
public class ProcessoAtribuicaoExposicao implements ProcessoAtribuicao {

    private ListaAvaliacoes listaAvaliacoes;

    /**
     * O mecanismo de atribuição associado ao processo de atribuição.
     */
    private MecanismoAtribuicao mecAt;

    /**
     * Construtor que instancia ProcessoAtribuicaoExposicao
     */
    public ProcessoAtribuicaoExposicao() {
        this.listaAvaliacoes = new ListaAvaliacoes();
    }

    /**
     * @return A lista de Avaliacoes do processo de atribuicao.
     */
    @Override
    public ListaAvaliacoes getListaDeAvaliacoes() {
        return listaAvaliacoes;
    }

    /**
     * Define o mecanismo de atribuicao associado ao processo de atribuicao.
     *
     * @param m O mecanismo que vai ser associado ao processo de atribuição.
     */
    @Override
    public MecanismoAtribuicao setMecanismoAtribuicao(MecanismoAtribuicao m) {
        this.mecAt = m;
        
        return mecAt;
    }

    /**
     * Define a lista de Avaliacoes do processo de atribuição.
     *
     * @param la A lista de Avaliacoes que vai ser associada ao processo de
     * atribuição.
     */
    public void setListaAvaliacoes(ListaAvaliacoes la) {
        this.listaAvaliacoes = la;
    }

    /**
     * Retorna a informação de um processo de atribuição.
     *
     * @return uma String com a informação de um processo de atribuição.
     */
    @Override
    public String getInfo() {
        return listaAvaliacoes.toString();
    }

    /**
     * Retorna uma nova instância de Avaliacao
     *
     * @return uma nova instância de Avaliacao
     */
    @Override
    public Avaliacao novaAvaliacao() {
        return new Avaliacao();
    }

    /**
     * Verifica se o processo de atribuição é igual a um objeto passado por
     * parâmetro
     *
     * @param o O objeto que vai ser comparado com o processo de atribuição.
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
        ProcessoAtribuicaoExposicao outroPAE = (ProcessoAtribuicaoExposicao) o;
        return this.listaAvaliacoes.equals(outroPAE.listaAvaliacoes);
    }
    
    /**
     * Distribui as Avaliacões.
     *
     * @param es
     * @return String
     */
    @Override
    public boolean atribui(Atribuivel es) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
