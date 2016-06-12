package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.lists.*;

/**
 *
 * @author Diana Silva
 */
public class AvaliarCandidaturaController {

    private static CentroExposicoes ce;
    private Candidatura candidatura;
    private FAE fae;
    private Avaliacao avaliacao;
    private Exposicao exposicao;
    private Questao questao;

    public AvaliarCandidaturaController(CentroExposicoes centroExposicoes) {
        ce = centroExposicoes;
    }
    
    public RegistoExposicoes getRegistoExposicoes(){
        return ce.getRegistoExposicoes();
    }

    public ListaCandidaturas getListaCandidaturas() {
        return exposicao.getRegistoCandidaturas();
    }

    public ListaAtribuicoes getListaCandidaturaAvaliacoes() {
        return candidatura.getListaAvaliacoes();
    }
    
    public void adicionarAvaliacao(){
        candidatura.getListaAvaliacoes().add(avaliacao);
    }
   
    public void criarAvaliacao(){
        avaliacao=new Avaliacao();
    }
    
    public void setCandidatura(Candidatura c){
        candidatura=c;
    }
    
    public void adicionarQuestao(){
        avaliacao.getListaQuestoes().criarQuestao(questao);
    }
    
    public void setRespostas(int resp1, int resp2, int resp3, int resp4, int resp5){
        avaliacao.getListaQuestoes().getListaQuestoes().get(0).setResposta(resp1);
        avaliacao.getListaQuestoes().getListaQuestoes().get(1).setResposta(resp2);
        avaliacao.getListaQuestoes().getListaQuestoes().get(2).setResposta(resp3);
        avaliacao.getListaQuestoes().getListaQuestoes().get(3).setResposta(resp4);
        avaliacao.getListaQuestoes().getListaQuestoes().get(4).setResposta(resp5);  
    }
    public String getInfoClassificacoes(){
        
        String info= avaliacao.getListaQuestoes().getListaQuestoes().get(0).display() + "\n";
        info+=avaliacao.getListaQuestoes().getListaQuestoes().get(1).display() + "\n";
        info+=avaliacao.getListaQuestoes().getListaQuestoes().get(2).display() + "\n";
        info+=avaliacao.getListaQuestoes().getListaQuestoes().get(3).display() + "\n";
        info+=avaliacao.getListaQuestoes().getListaQuestoes().get(4).display() + "\n";  
        info+="Média: " + calcularMedia();
        
        return info;
    }
    
    private double calcularMedia(){
        
        return avaliacao.getListaQuestoes().calcularMedia();
    }
  
    public void criarQuestao(){
        questao=new Questao();
    }
    
    public void setPergunta1(){
        questao.setPergunta(Criterio.CONHECIMENTO);
    }
    
    public void setPergunta2(){
        questao.setPergunta(Criterio.ADEQUACAO_CANDIDATURA);
    }
    
    public void setPergunta3(){
        questao.setPergunta(Criterio.ADEQUACAO_DEMONSTRACAO);
    }
    
    public void setPergunta4(){
        questao.setPergunta(Criterio.ADEQUACAO_CONVITES);
    }
    
    public void setPergunta5(){
        questao.setPergunta(Criterio.RECOMENDACAO_GLOBAL);
    }
    
    public void setResposta(int resposta){
        questao.setResposta(resposta);
    }
    
    public int getResposta(){
        return questao.getResposta();
    }
    
    
    
    
//    public RegistoExposicoes iniciarAvaliacao() {
//        return this.ce.getListaExposicoes();
//    }

    public Avaliacao setAvaliacao(String strResposta, String strJustificacao) {
        avaliacao.setResposta(strResposta);
        avaliacao.setJustificacao(strJustificacao);

        if (fae.validaAvaliacao(avaliacao)) {
            return avaliacao;
        } else {
            return null;
        }
    }
    
    public String getPergunta(){
        return questao.getPergunta();
    }

    public boolean registarDecisao() {
        return fae.registaAvaliacao(avaliacao);
    }

    public void selectExposicao(Exposicao e) {
        exposicao = e;
        this.avaliacao = exposicao.novaAvaliacao();
        this.candidatura = this.avaliacao.novaCandidatura();
    }

    public String getInfoResumo() {
        return this.avaliacao.getInfo() + this.candidatura.getInfo();
    }
}
