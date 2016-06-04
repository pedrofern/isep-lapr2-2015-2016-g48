package lapr.project.model;

import java.util.List;

/**
 *
 * @author Pedro Fernandes
 */
public class Avaliacao {
    
    private AvaliacaoState state;
    private String resposta;
    private String justificacao;
    private Candidatura m_candidatura;
    private Organizador organizador;
    private List<Avaliacao> m_listaAvaliacoes;
        private FAE fae;

    public Avaliacao(String resposta, String justificacao) {
        this.resposta = resposta;
        this.justificacao = justificacao;
    }

    public Avaliacao() {

    }
    
    /**
     * Verifica se a avaliacao esta no estado concluida.
     *
     * @return boolean concluida ou não
     */
    public boolean isConcluida() {
        return this.getState().isInConcluida();
    }
    
    public Candidatura setCandidatura(Candidatura c) {
        if (organizador.validaAvaliacao(c)) {
            return c;
        } else {
            return null;
        }
    }

    public FAE setCandidatura(FAE f) {
        if (organizador.validaAvaliacao(f)) {
            return f;
        } else {
            return null;
        }
    }

    public void setResposta(String r) {
        resposta = r;
    }

    public void setJustificacao(String j) {
        justificacao = j;
    }

        /**
     * Obtem o FAE da avaliacao.
     *
     * @return the fae
     */
    public FAE getFAE() {
        return fae;
    }
    
    /**
     * Obtem a candidaura decidida.
     *
     * @return the candidatura
     */
    public Candidatura getM_candidatura() {
        return m_candidatura;
    }

    /**
     * Obtem a aceitação da decisão da candidatura.
     *
     * @return the resposta
     */
    public String getResposta() {
        return resposta;
    }

    public String getInfo() {
        return this.toString() + "\n";
    }
/**
     * Altera o estado para um estado passado por parametro.
     *
     * @param state
     * @return boolean se alterou ou não
     */
    public boolean setState(AvaliacaoState state) {
        this.state = state;
        return true;
    }
    
    /**
     * Altera o estado para o estado recebido por parametro.
     *
     * @param state
     * @return boolean se alterou ou não
     */
    public boolean setState(String state) {
        if (state.equals("AvaliacaoStateConcluida")) {
            return setState(new AvaliacaoStateConcluida(this));
        }
        if (state.equals("AvaliacaoStateIniciada")) {
            return setState(new AvaliacaoStateIniciada(this));
        }
        return false;
    }

    /**
     * Obtem o estado da Avaliacao
     *
     * @return the state
     */
    public AvaliacaoState getState() {
        return state;
    }
    
    boolean isFAE(String id) {
        return getFAE().getUtilizador().getUsername().equals(id);
    }
    
    /**
     * Altera o estado para avaliacao concluida.
     *
     * @return boolean se alterou ou não
     */
    public boolean setConcluida() {
        return this.getState().setStateConcluida();
    }

    @Override
    public String toString() {
        return this.justificacao + " - " + getResposta() + "\n";
    }

    public boolean valida() {
        System.out.println("Decisao: valida: " + this.toString());
        return true;
    }

    public Candidatura novaCandidatura() {
        return new Candidatura();
    }
}
