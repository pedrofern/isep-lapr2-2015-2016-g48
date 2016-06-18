package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.lists.*;
import java.util.*;

/**
 *
 * @author Pedro Fernandes
 */
public class AlterarCandidaturaController {
    
    private Candidatura candidatura;
    private Candidatura cClone;
    private Exposicao exposicao;
    private CentroExposicoes ce;
    private Utilizador utilizador;
    private ListaCandidaturas listaCandidaturas;

    public AlterarCandidaturaController(CentroExposicoes ce, Utilizador utilizador) {
        this.ce = ce;
        this.utilizador = utilizador;
    }
    
    public RegistoExposicoes getRegistoExposicoes(){
        return ce.getRegistoExposicoes();
    }
    
    public ListaDemonstracoes getListaDemonstracoes(){
        return exposicao.getListaDemonstracoes();
    }
    
    public void selectExposicao(Exposicao exposicao){
        this.exposicao=exposicao;   
        listaCandidaturas = exposicao.getListaCandidaturas();
    }
    public void selectCandidatura(Candidatura candidatura){
        this.candidatura=candidatura;
    }

    public ListaCandidaturas getListaCandidaturasRepresentante(Utilizador utilizador){
        ListaCandidaturas lstCandidaturasRep = new ListaCandidaturas();

        for (ListIterator<Candidatura> it = this.listaCandidaturas.getListaCandidaturas().listIterator(); it.hasNext();) {
            Candidatura c = it.next();
            if(c.getRepresentante().isRepresentante(utilizador)){
                lstCandidaturasRep.addCandidatura(it.next());
            }  
        }
        return lstCandidaturasRep;
    }
    
    public Candidatura getInfoCandidatura(){
        return cClone = candidatura.cloneCandidatura();
    }
    
    public boolean alteraDados(String strNome, String strEmail, int strTelemovel,
            int strAreaExpo, int strQuantidadeConvites, 
            ListaProduto listaProduto, ListaKeywords listaKeywords) {
        
        cClone.setNomeEmpresa(strNome);
        cClone.setMorada(strEmail);
        cClone.setTelemovel(strTelemovel);
        cClone.setAreaExposicao(strAreaExpo);
        cClone.setQuantidadeConvites(strQuantidadeConvites);
        cClone.setListaProdutos(listaProduto);
        cClone.setListaKeywords(listaKeywords);
        
        return candidatura.getListaCandidaturas().alteraCandidatura(candidatura, cClone);
    }
    
    
}
