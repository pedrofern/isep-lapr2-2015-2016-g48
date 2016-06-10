package lapr.project.controller;

import java.util.*;
import lapr.project.model.*;
import lapr.project.model.lists.*;

/**
 *
 * @author Pedro Fernandes
 */
public class AvaliarCandidaturaController {

    private CentroExposicoes m_ce;
    private Candidatura m_candidatura;
    private FAE fae;
    private Avaliacao avaliacao;
    private Exposicao m_exposicao;

    public AvaliarCandidaturaController(CentroExposicoes ce) {
        m_ce = ce;
    }
    
    public RegistoExposicoes getRegistoExposicoes(){
        return m_ce.getListaExposicoes();
    }

    public ListaCandidaturas getListaCandidaturas() {
        return m_candidatura.getListaCandidaturas();
    }

    public RegistoExposicoes iniciarAvaliacao() {
        return this.m_ce.getListaExposicoes();
    }

    public Avaliacao setAvaliacao(String strResposta, String strJustificacao) {
        avaliacao.setResposta(strResposta);
        avaliacao.setJustificacao(strJustificacao);

        if (fae.validaAvaliacao(avaliacao)) {
            return avaliacao;
        } else {
            return null;
        }
    }

    public boolean registarDecisao() {
        return fae.registaAvaliacao(avaliacao);
    }

    public void selectExposicao(Exposicao e) {
        m_exposicao = e;
        this.avaliacao = m_exposicao.novaAvaliacao();
        this.m_candidatura = this.avaliacao.novaCandidatura();
    }

    public String getInfoResumo() {
        return this.avaliacao.getInfo() + this.m_candidatura.getInfo();
    }
}
