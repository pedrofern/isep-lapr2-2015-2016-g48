package lapr.project.controller;

import java.io.Serializable;
import lapr.project.model.*;
import lapr.project.model.lists.*;

/**
 *
 * @author Diana Silva
 */
public class AvaliarCandidaturaController implements Serializable {

    private static CentroExposicoes ce;
    private Candidatura candidatura;
    private Avaliacao avaliacao;
    private Exposicao exposicao;
    private Questao questao;
    private Utilizador user;

    /**
     * Cria uma nova instancia da classe
     * @param centroExposicoes 
     */
    public AvaliarCandidaturaController(CentroExposicoes centroExposicoes, Utilizador user) {
        ce = centroExposicoes;
        this.user=user;
    }
/**
 * Devolve a lista de exposicoes atribuidas ao fae
 * @return a lista de exposicoes atribuidas ao fae
 */
    public RegistoExposicoes getExposicoesAtribuidasFAE() {
        return ce.getRegistoExposicoes();
    }
/**
 * Devolve a lista de candidaturas
 * @return a lista de candidaturas
 */
    public ListaCandidaturas getListaCandidaturasAtribuidasFAE(Utilizador fae) {
//        return exposicao.getListaAtribuicoes().getCandidaturasAtribuidasFAE(fae);
        return exposicao.getListaCandidaturas();
    }
/**
 * Devolve a lista de candiaturas avaliacoes
 * @return a lista de candiaturas avaliacoes
 */
    public ListaAvaliacoes getListaCandidaturaAvaliacoes() {
        return candidatura.getListaAvaliacoes();
    }
    /**
     * Adiciona uma avaliacao a lista de avaliacoes 
     */
    public void adicionarAvaliacao(){
        candidatura.getListaAvaliacoes().add(avaliacao);
    }
   /**
    * Cria uma nova avaliacao
    */
    public void criarAvaliacao(){
        avaliacao=new Avaliacao();
    }
    /**
     * Altera a candidatura
     * @param c 
     */
    public void setCandidatura(Candidatura c){
        candidatura=c;
    }
    /**
     * Adiciona uma questao a lista de questoes
     */
    public void adicionarQuestao(){
        avaliacao.getListaQuestoes().criarQuestao(questao);
    }
    /**
     *  
     * @param resp1
     * @param resp2
     * @param resp3
     * @param resp4
     * @param resp5 
     */
    public void setRespostas(int resp1, int resp2, int resp3, int resp4, int resp5){
        avaliacao.getListaQuestoes().getListaQuestoes().get(0).setResposta(resp1);
        avaliacao.getListaQuestoes().getListaQuestoes().get(1).setResposta(resp2);
        avaliacao.getListaQuestoes().getListaQuestoes().get(2).setResposta(resp3);
        avaliacao.getListaQuestoes().getListaQuestoes().get(3).setResposta(resp4);
        avaliacao.getListaQuestoes().getListaQuestoes().get(4).setResposta(resp5);  
    }
    /**
     * Devolve a informacao sobre as classificacoes
     * @return 
     */
    public String getInfoClassificacoes(){
        
        String info= avaliacao.getListaQuestoes().getListaQuestoes().get(0).display() + "\n";
        info+=avaliacao.getListaQuestoes().getListaQuestoes().get(1).display() + "\n";
        info+=avaliacao.getListaQuestoes().getListaQuestoes().get(2).display() + "\n";
        info+=avaliacao.getListaQuestoes().getListaQuestoes().get(3).display() + "\n";
        info+=avaliacao.getListaQuestoes().getListaQuestoes().get(4).display() + "\n";  
        info+="Média: " + calcularMedia();
        
        return info;
    }
    /**
     * calcula a media
     * @return a media
     */
    private double calcularMedia(){
        
        return avaliacao.getListaQuestoes().calcularMedia();
    }
  /**
   * cria questao
   */
    public void criarQuestao(){
        questao=new Questao();
    }
    /**
     * Altera pergunta 1
     */
    public void setPergunta1(){
        questao.setPergunta(Criterio.CONHECIMENTO);
    }
    /**
     * Altera pergunta 2
     */
    public void setPergunta2(){
        questao.setPergunta(Criterio.ADEQUACAO_CANDIDATURA);
    }
    /**
     * Altera pergunta 3
     */
    public void setPergunta3(){
        questao.setPergunta(Criterio.ADEQUACAO_DEMONSTRACAO);
    }
    /**
     * Altera pergunta 4
     */
    public void setPergunta4(){
        questao.setPergunta(Criterio.ADEQUACAO_CONVITES);
    }
    /**
     * Altera pergunta 5
     */
    public void setPergunta5(){
        questao.setPergunta(Criterio.RECOMENDACAO_GLOBAL);
    }
    /**
     * Altera resposta
     * @param resposta 
     */
    public void setResposta(int resposta){
        questao.setResposta(resposta);
    }
    /**
     * Devolve resposta
     * @return resposta
     */
    public int getResposta(){
        return questao.getResposta();
    }
/**
 * Altera avaliacao
 * @param bResposta
 * @param strJustificacao
 * @return a avaliacao alterada
 */
    public Avaliacao setAvaliacao(boolean bResposta, String strJustificacao) {
        avaliacao.setResposta(bResposta);
        avaliacao.setJustificacao(strJustificacao);

        if (candidatura.getListaAvaliacoes().valida(avaliacao)) {
            return avaliacao;
        } else {
            return null;
        }
    }
    /**
     * Devolve pergunta
     * @return pergunta
     */
    public String getPergunta(){
        return questao.getPergunta();
    }
/**
 * Adiciona uma decisao a lista de avaliacoes
 * @return true se adicionado, false se nao
 */
    public boolean registarDecisao() {
        return candidatura.getListaAvaliacoes().add(avaliacao);
    }
/**
 * seleciona uma exposicao de uma lista
 * @param e 
 */
    public void selectExposicao(Exposicao e) {
        exposicao = e;
        
    }
/**
 * Devolve informacao resumida
 * @return 
 */
    public String getInfoResumo() {
        return this.avaliacao.toString() + this.candidatura.getInfo();
    }
/**
 * Devolve informacao da avaliacao
 * @return informacao da avaliacao
 */
    public String getInfoAvaliacao() {
        return avaliacao.toString();
    }

    
    public void adicionarMediaFAE(Utilizador user){
        for(FAE f:exposicao.getListaFAE().getListaFAE()){
            if(f.getEmail().equalsIgnoreCase(user.getUsername())){
                f.getClassificacao().incrementaNumeroSubmissoes();
                f.getClassificacao().incrementaValorÀSoma(calcularMedia());
            }
        }
    }
    
    public Utilizador getUser(){
        return user;
    }
}
