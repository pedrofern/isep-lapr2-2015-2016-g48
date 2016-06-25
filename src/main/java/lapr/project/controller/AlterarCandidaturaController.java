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
    private CandidaturaDemonstracao candidaturaDemonstracao;
    private Demonstracao demonstracao;
    private Exposicao exposicao;
    private CentroExposicoes ce;
    private Utilizador utilizador;
    private ListaCandidaturas listaCandidaturas;
    private ListaDemonstracoes listaDemoTemp;

    
    
    public AlterarCandidaturaController(CentroExposicoes ce, Utilizador utilizador) {
        this.ce = ce;
        this.utilizador = utilizador;
    }
    
    public RegistoExposicoes getRegistoExposicoes(){
        return ce.getRegistoExposicoes();
    }
    
    public ListaDemonstracoes getListaDemonstracoes(){
        listaDemoTemp = new ListaDemonstracoes();
        return exposicao.getListaDemonstracoes();
    }
    
    public void selectExposicao(Exposicao exposicao){
        this.exposicao=exposicao;   
        listaCandidaturas = exposicao.getListaCandidaturas();
    }
    public void selectCandidatura(Candidatura candidatura){
        this.candidatura=candidatura;
    }
    
    public ListaCandidaturas getListaCandidaturas(){
        return listaCandidaturas;
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
    
    public void selectDemonstracao(Demonstracao demonstracao){
        this.demonstracao=demonstracao;
        listaDemoTemp.adicionarDemonstracao(demonstracao);
    }
        
    public ListaDemonstracoes getSelectedDemonstacao(){
        return listaDemoTemp;
    }
    
    public void registCandidaturaDemonstracao(){
        candidaturaDemonstracao = new CandidaturaDemonstracao(candidatura);
        for (int i=0; i<listaDemoTemp.tamanho();i++){
            
            Demonstracao d = listaDemoTemp.getListaDemonstracoes().get(i);

            d.getListaCandidaturasDemonstracao().addCandidaturaDemonstracao(candidaturaDemonstracao);
 
        }   
    }
    
    public CandidaturaDemonstracao novaCandidaturaDemonstracao(Candidatura candidatura){
        return candidaturaDemonstracao = new CandidaturaDemonstracao(candidatura);
    }
    
    public boolean adicionarCandidaturaDemonstracao(CandidaturaDemonstracao candidaturaDemonstracao){        
        return demonstracao.getListaCandidaturasDemonstracao().addCandidaturaDemonstracao(candidaturaDemonstracao);
    }
}
