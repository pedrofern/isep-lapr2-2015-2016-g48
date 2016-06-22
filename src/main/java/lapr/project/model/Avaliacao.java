package lapr.project.model;

import java.io.Serializable;
import java.util.List;
import lapr.project.model.lists.ListaQuestoes;

/**
 *
 * @author Diana Silva
 */
public class Avaliacao implements Serializable{

    private boolean avaliacao;
    private String justificacao;
    private ListaQuestoes listaQuestoes;
    private Criterio criterio;
    private boolean estado;

    public Avaliacao(boolean resposta, String justificacao) {
        this.avaliacao = resposta;
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
        this.avaliacao = resposta;
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
    public boolean getAvaliacao() {
        return avaliacao;
    }
    
    /**
     * Obtém a justificação dada pela FAE sobre a avaliação efectuada
     * @return a justificação
     */
    public String getJustificacao(){
        return justificacao;
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
    
    public String getAvaliacaoString(){
        if (avaliacao==true) return "Aceite";
        else return "Recusada";
    }

    @Override
    public String toString() {
        String avaliacao = "Avaliação: " + getAvaliacaoString() + "\nJustificação: " + this.justificacao + "\n";
        for (Questao q : listaQuestoes.getListaQuestoes()) {
            avaliacao += q.getPergunta() + ":" + q.getResposta() + "\n";

        }
        avaliacao += "Média: " + listaQuestoes.calcularMedia();
        return avaliacao;
    }
}
