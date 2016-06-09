package lapr.project.controller;

import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class AlterarCandidaturaController {
    private CentroExposicoes m_centroDeExposicoes;
    private Candidatura m_candidatura;

    public AlterarCandidaturaController(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
    }

    public Candidatura getCandidatura(String nomeEmpresa) {
        m_candidatura = m_centroDeExposicoes.getRegistoCandidaturas().getCandidaturaByNomeEmpresa(nomeEmpresa);
        return m_candidatura;
    }

    public boolean alteraDados(String strNome, String strEmail, int strTelemovel, int strAreaExpo, int strQuantidadeConvites) {
        Candidatura cClone = m_candidatura.clone();
        cClone.setNomeEmpresa(strNome);
        cClone.setMorada(strEmail);
        cClone.setTelemovel(strTelemovel);
        cClone.setAreaExposicao(strAreaExpo);
        cClone.setQuantidadeConvites(strQuantidadeConvites);
        return m_centroDeExposicoes.getRegistoCandidaturas().alteraCandidatura(m_candidatura, cClone);
    }
}
