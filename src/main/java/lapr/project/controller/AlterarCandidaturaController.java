package lapr.project.controller;

import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class AlterarCandidaturaController {
    private static CentroExposicoes m_ce;
    private static Utilizador m_user;
    private static Candidatura m_candidatura;

    public AlterarCandidaturaController(CentroExposicoes ce) {
        m_ce = ce;
    }
//
//    public Candidatura getCandidatura(String nomeEmpresa) {
//        //Atenção - é à exposição q tem de se ir buscar a lista de candidaturas..
////        
////        m_candidatura = m_ce.getListaCandidaturas().getCandidaturaByNomeEmpresa(nomeEmpresa);
//        return m_candidatura;
//    }

    public boolean alteraDados(String strNome, String strEmail, int strTelemovel, int strAreaExpo, int strQuantidadeConvites) {
        Candidatura cClone = m_candidatura.clone();
        cClone.setNomeEmpresa(strNome);
        cClone.setMorada(strEmail);
        cClone.setTelemovel(strTelemovel);
        cClone.setAreaExposicao(strAreaExpo);
        cClone.setQuantidadeConvites(strQuantidadeConvites);
//        return m_ce.getListaCandidaturas().alteraCandidatura(m_candidatura, cClone);
        return false;
    }
}
