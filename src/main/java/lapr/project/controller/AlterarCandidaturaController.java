package lapr.project.controller;

import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class AlterarCandidaturaController {
    private static CentroExposicoes ce;
    private static Utilizador user;
    private static Candidatura candidatura;

    public AlterarCandidaturaController(CentroExposicoes centroExposicoes) {
        ce = centroExposicoes;
    }
//
//    public Candidatura getCandidatura(String nomeEmpresa) {
//        //Atenção - é à exposição q tem de se ir buscar a lista de candidaturas..
////        
////        candidatura = ce.getListaCandidaturas().getCandidaturaByNomeEmpresa(nomeEmpresa);
//        return candidatura;
//    }

    public boolean alteraDados(String strNome, String strEmail, int strTelemovel, int strAreaExpo, int strQuantidadeConvites) {
        Candidatura cClone = candidatura.clone();
        cClone.setNomeEmpresa(strNome);
        cClone.setMorada(strEmail);
        cClone.setTelemovel(strTelemovel);
        cClone.setAreaExposicao(strAreaExpo);
        cClone.setQuantidadeConvites(strQuantidadeConvites);
//        return ce.getListaCandidaturas().alteraCandidatura(candidatura, cClone);
        return false;
    }
}
