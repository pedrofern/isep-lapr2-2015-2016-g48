package lapr.project.controller;

import java.util.*;
import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class AvaliarCandidaturaController {

    private CentroExposicoes m_centroDeExposicoes;
    private Candidatura m_candidatura;
    private FAE fae;
    private Avaliacao avaliacao;
    private Exposicao m_exposicao;

    public AvaliarCandidaturaController(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
    }

    public List<Candidatura> getListaCandidaturas() {
        return m_candidatura.getListaCandidaturas();
    }

    public List<Exposicao> iniciarAvaliacao() {
        return this.m_centroDeExposicoes.getListaExposicoes();
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
