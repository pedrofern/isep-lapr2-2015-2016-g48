package lapr.project.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.lists.ListaQuestoes;

/**
 * Classe para objetos do tipo Avaliação que permite gerir e guardar as avaliações às candidaturas.
 * 
 * @author Diana Silva
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Avaliacao implements Serializable{

    /**
     * Avaliação final dada pelo FAE (aceite ou recusada)
     */
    private boolean avaliacaoDada;
    
    /**
     * justificação da avaliação dada
     */
    private String justificacao;
    
    /**
     * lista de questões para classificar de 1-5 (critérios)
     */
    private ListaQuestoes listaQuestoes;
    
    /**
     * Estado de avaliação da candidatura (avaliada ou não avaliada)
     */
    private boolean estado;
    
    /**
     * Média das respostas dadas pelo FAE nos critérios (1-5)
     */
    private double media;
    
     /**
     * Desvio relativamente à média da amostra nas respostas dadas pelo FAE nos critérios (1-5)
     */
    private double desvio;

    
    /**
     * Construtor Avaliação recebendo a avaliação e a justificação dadas pelo FAE.
     * Inicializa o estado como não avaliada a média com 0 e gera a lista de questões-respostas.
    
     * @param resposta a avaliação dada pelo FAE (aceite ou recusada)
     * @param justificacao a justificação dada pelo FAE
     */
    public Avaliacao(boolean resposta, String justificacao) {
        this.avaliacaoDada = resposta;
        this.justificacao = justificacao;
        this.estado = false;
        listaQuestoes = new ListaQuestoes();
        media=0;
    }

    /**
     * Construtor Avaliação sem argumento gerando uma nova lista de questões-respostas
     */
    public Avaliacao() {
        listaQuestoes = new ListaQuestoes();
    }

       /**
     * Obtem true se a avaliação tiver sido aceite, false se tiver sido
     * recusada.
     *
     * @return the resposta
     */
    public boolean getAvaliacao() {
        return avaliacaoDada;
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
     * @return estado (true se estiver avaliada, false se não estiver avaliada)
     */
    public boolean getEstado() {
        return estado;
    }
    
    /**
     * Retorna a lista de questões-respostas
     * @return a lista de questões-respostas definidas para as avaliações
     */

     public ListaQuestoes getListaQuestoes() {
        return listaQuestoes;
    }
     /**
      * Retorna a média das respostas dadas pelo FAE
      * @return média das respostas dadas pelo FAE
      */
     public double getMedia(){
         return media;
     }

   
     /**
      * Retorna o desvio nas avaliações do FAE relativamente aos restantes FAE na amostra
      * @return desvio nas avaliações do FAE
      */
     public double getDesvio(){
         return desvio;
     }
     
     /**
      * Altera o desvio do FAE em relação à amostra
      * @param desvio desvio do FAE na amostra
      */
     
     public void setDesvio(double desvio){
         this.desvio=desvio;
     }
     
     /**
      * Método que permite alterar a avaliação de aceite ou recusada
      * @param resposta 
      */

    public void setResposta(boolean resposta) {
        this.avaliacaoDada = resposta;
    }

    /**
     * Método que permite alterar a justificação dada na avaliação
     * @param j justificação da avaliação 
     */
    public void setJustificacao(String j) {
        justificacao = j;
    }
    
    /**
     * Altera o estado para avaliada
     */
    public void setAvaliada() {
        this.estado = true;
    }
    
    /**
     * Altera a média 
     * @param media médias das respostas dadas pelo FAE
     */
    public void setMedia(double media){
        this.media=media;
    }

    /**
     * Método que valida se a justificação está devidamente preenchida
     * @return 
     */
    public boolean valida() {
        return !(justificacao == null || justificacao.trim().isEmpty());
    }
    
    /**
     * Método que retorna aceite ou recusada conforme a avaliação dada pelo FAE
     * @return avaliação dada pelo FAE
     */
    public String getAvaliacaoString(){
        if (avaliacaoDada==true) return "Aceite";
        else return "Recusada";
    }

    /**
     * Método que retorna um texto representativo da avaliação
     * @return a descrição textual da avaliação
     */
    @Override
    public String toString() {
        String avaliacaoDada = "Avaliação: " + getAvaliacaoString() + "\nJustificação: " + this.justificacao + "\n";
        for (Questao q : listaQuestoes.getListaQuestoes()) {
            avaliacaoDada += q.getPergunta() + ":" + q.getResposta() + "\n";

        }
        avaliacaoDada += "Média: " + listaQuestoes.calcularMedia();
        return avaliacaoDada;
    }
}



