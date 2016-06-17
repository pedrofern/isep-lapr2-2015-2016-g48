package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.lists.*;

/**
 *
 * @author Pedro Fernandes
 */
public class AlterarCandidaturaController {
    
    private Candidatura candidatura;
    private Exposicao exposicao;

    public AlterarCandidaturaController(Exposicao exposicao, Candidatura candidatura) {
        this.exposicao = exposicao;
        this.candidatura=candidatura;
    }

    public Candidatura getCandidatura(Candidatura candidatura) {
        return candidatura;        
    }

    public boolean alteraCandidatura(String strNome,
            String strEmail, int strTelemovel, 
            int strAreaExpo, int strQuantidadeConvites,
            ListaProduto listaProduto, ListaKeywords listaKeywords) {
        Candidatura cClone = candidatura.cloneCandidatura();
        cClone.setNomeEmpresa(strNome);
        cClone.setMorada(strEmail);
        cClone.setTelemovel(strTelemovel);
        cClone.setAreaExposicao(strAreaExpo);
        cClone.setQuantidadeConvites(strQuantidadeConvites);
        cClone.setListaProdutos(listaProduto);
        cClone.setListaKeywords(listaKeywords);
        
            return exposicao.getListaCandidaturas().alteraCandidatura(candidatura, cClone);         
    }
}
