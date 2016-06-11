package lapr.project.controller;

import java.util.*;
import lapr.project.model.*;
import lapr.project.model.lists.*;

/**
 *
 * @author Diana Silva
 */
public class AvaliarCandidaturaController {

    private CentroExposicoes m_ce;
    private Candidatura m_candidatura;
    private FAE m_fae;
    private Avaliacao m_avaliacao;
    private Exposicao m_exposicao;
    private Questao m_questao;

    public AvaliarCandidaturaController(CentroExposicoes ce) {
        m_ce = ce;
    }
    
    public RegistoExposicoes getRegistoExposicoes(){
        return m_ce.getListaExposicoes();
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
