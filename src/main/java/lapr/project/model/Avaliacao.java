package lapr.project.model;

import java.util.List;
import lapr.project.model.lists.ListaQuestoes;

/**
 *
 * @author Diana Silva
 */
public class Avaliacao {

    private boolean resposta;
    private String justificacao;
    private ListaQuestoes listaQuestoes;
    private Criterio criterio;
    private boolean estado;

    public Avaliacao(boolean resposta, String justificacao) {
        this.resposta = resposta;
        this.justificacao = justificacao;
        this.estado = false;
        listaQuestoes = new ListaQuestoes();

    }

    public Avaliacao() {
        listaQuestoes = new ListaQuestoes();
    }

    public ListaQuestoes getListaQuestoes() {
        return listaQuestoes;
    }

    public void setResposta(boolean resposta) {
        this.resposta = resposta;
    }

    public void setJustificacao(String j) {
        justificacao = j;
    }

    /**
     * Obtem true se a avaliação tiver sido aceite, false se tiver sido
     * recusada.
     *
     * @return the resposta
     */
    public boolean getResposta() {
        return resposta;
    }

    /**
     * Obtem o estado da Avaliacao
     *
     * @return estado (true se estiver avaliada, false se não)
     */
    public boolean getEstado() {
        return estado;
    }

    /**
     * Altera o estado para avaliada
     */
    public void setAvaliada() {
        this.estado = true;
    }

    public boolean valida() {
        if (justificacao == null || justificacao.trim().isEmpty()) {
            return false;
        } else {

            return true;
        }

    }

    @Override
    public String toString() {
        String avaliacao = this.justificacao + " - " + getResposta() + "\n";
        for (Questao q : listaQuestoes.getListaQuestoes()) {
            avaliacao += q.getPergunta() + ":" + q.getResposta() + "\n";

        }
        avaliacao += "Média: " + listaQuestoes.calcularMedia();
        return avaliacao;
    }
}
