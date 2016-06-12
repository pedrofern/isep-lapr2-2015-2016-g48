package lapr.project.controller;

import java.util.*;
import lapr.project.model.*;
import lapr.project.model.lists.*;

/**
 *
 * @author Diana Silva
 */
public class AvaliarCandidaturaController {

    private static CentroExposicoes m_ce;
    private Candidatura m_candidatura;
    private FAE m_fae;
    private Avaliacao m_avaliacao;
    private Exposicao m_exposicao;
    private Questao m_questao;

    public AvaliarCandidaturaController(CentroExposicoes ce) {
        m_ce = ce;
    }
    
    public RegistoExposicoes getRegistoExposicoes(){
        return m_ce.getRegistoExposicoes();
    }

    public ListaCandidaturas getListaCandidaturas() {
        return m_exposicao.getRegistoCandidaturas();
    }

    public ListaAvaliacoes getListaCandidaturaAvaliacoes() {
        return m_candidatura.getListaAvaliacoes();
    }
    
    public void adicionarAvaliacao(){
        m_candidatura.getListaAvaliacoes().add(m_avaliacao);
    }
   
    public void criarAvaliacao(){
        m_avaliacao=new Avaliacao();
    }
    
    public void setCandidatura(Candidatura c){
        m_candidatura=c;
    }
    
    public void adicionarQuestao(){
        m_avaliacao.getListaQuestoes().criarQuestao(m_questao);
    }
    
    public void setRespostas(int resp1, int resp2, int resp3, int resp4, int resp5){
        m_avaliacao.getListaQuestoes().getListaQuestoes().get(0).setResposta(resp1);
        m_avaliacao.getListaQuestoes().getListaQuestoes().get(1).setResposta(resp2);
        m_avaliacao.getListaQuestoes().getListaQuestoes().get(2).setResposta(resp3);
        m_avaliacao.getListaQuestoes().getListaQuestoes().get(3).setResposta(resp4);
        m_avaliacao.getListaQuestoes().getListaQuestoes().get(4).setResposta(resp5);  
    }
    public String getInfoClassificacoes(){
        
        String info= m_avaliacao.getListaQuestoes().getListaQuestoes().get(0).display() + "\n";
        info+=m_avaliacao.getListaQuestoes().getListaQuestoes().get(1).display() + "\n";
        info+=m_avaliacao.getListaQuestoes().getListaQuestoes().get(2).display() + "\n";
        info+=m_avaliacao.getListaQuestoes().getListaQuestoes().get(3).display() + "\n";
        info+=m_avaliacao.getListaQuestoes().getListaQuestoes().get(4).display() + "\n";  
        info+="Média: " + calcularMedia();
        
        return info;
    }
    
    private double calcularMedia(){
        
        return m_avaliacao.getListaQuestoes().calcularMedia();
    }
  
    public void criarQuestao(){
        m_questao=new Questao();
    }
    
    public void setPergunta1(){
        m_questao.setPergunta(Criterio.CONHECIMENTO);
    }
    
    public void setPergunta2(){
        m_questao.setPergunta(Criterio.ADEQUACAO_CANDIDATURA);
    }
    
    public void setPergunta3(){
        m_questao.setPergunta(Criterio.ADEQUACAO_DEMONSTRACAO);
    }
    
    public void setPergunta4(){
        m_questao.setPergunta(Criterio.ADEQUACAO_CONVITES);
    }
    
    public void setPergunta5(){
        m_questao.setPergunta(Criterio.RECOMENDACAO_GLOBAL);
    }
    
    public void setResposta(int resposta){
        m_questao.setResposta(resposta);
    }
    
    public int getResposta(){
        return m_questao.getResposta();
    }
    
    
    
    
//    public RegistoExposicoes iniciarAvaliacao() {
//        return this.m_ce.getListaExposicoes();
//    }

    public Avaliacao setAvaliacao(String strResposta, String strJustificacao) {
        m_avaliacao.setResposta(strResposta);
        m_avaliacao.setJustificacao(strJustificacao);

        if (m_fae.validaAvaliacao(m_avaliacao)) {
            return m_avaliacao;
        } else {
            return null;
        }
    }
    
    public String getPergunta(){
        return m_questao.getPergunta();
    }

    public boolean registarDecisao() {
        return m_fae.registaAvaliacao(m_avaliacao);
    }

    public void selectExposicao(Exposicao e) {
        m_exposicao = e;
        this.m_avaliacao = m_exposicao.novaAvaliacao();
        this.m_candidatura = this.m_avaliacao.novaCandidatura();
    }

    public String getInfoResumo() {
        return this.m_avaliacao.getInfo() + this.m_candidatura.getInfo();
    }
}
