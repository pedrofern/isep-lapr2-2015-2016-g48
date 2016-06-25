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

    
    /**
     * Cria instancia de AlterarCandidaturacontroller e recebe o centro de exposicoes e o utilizador como parametros
     * @param ce
     * @param utilizador 
     */
    public AlterarCandidaturaController(CentroExposicoes ce, Utilizador utilizador) {
        this.ce = ce;
        this.utilizador = utilizador;
    }
    /**
     * Devolve a lista de exposicoes
     * @return lista
     */
    public RegistoExposicoes getRegistoExposicoes(){
        return ce.getRegistoExposicoes();
    }
    /**
     * Devolve a lista de demonstracoes
     * @return lista
     */
    public ListaDemonstracoes getListaDemonstracoes(){
        listaDemoTemp = new ListaDemonstracoes();
        return exposicao.getListaDemonstracoes();
    }
    /**
     * Seleciona uma exposicao de uma combobox
     * @param exposicao 
     */
    public void selectExposicao(Exposicao exposicao){
        this.exposicao=exposicao;   
        listaCandidaturas = exposicao.getListaCandidaturas();
    }
    /**
     * Seleciona uma candidatura de uma combobox
     * @param candidatura 
     */
    public void selectCandidatura(Candidatura candidatura){
        this.candidatura=candidatura;
    }
    /**
     * Devolve a lista de candidaturas
     * @return a lista
     */
    public ListaCandidaturas getListaCandidaturas(){
        return listaCandidaturas;
    }
/**
 * Devolve a lista de candidaturas do representante
 * @param utilizador
 * @return a lista
 */
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
    /**
     * Devolve uma copia da informacao de uma candidatura
     * @return a copia
     */
    public Candidatura getInfoCandidatura(){
        return cClone = candidatura.cloneCandidatura();
    }
    /**
     * Altera os dados da candidatura
     * @param strNome
     * @param strEmail
     * @param strTelemovel
     * @param strAreaExpo
     * @param strQuantidadeConvites
     * @param listaProduto
     * @param listaKeywords
     * @return dados da candidatura
     */
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
    /**
     * Seleciona uma demonstracao de uma lista
     * @param demonstracao 
     */
    public void selectDemonstracao(Demonstracao demonstracao){
        this.demonstracao=demonstracao;
        listaDemoTemp.adicionarDemonstracao(demonstracao);
    }
        /**
         * Devolve a demonstracao que foi selecionada
         * @return a demonstracao selecionada
         */
    public ListaDemonstracoes getSelectedDemonstacao(){
        return listaDemoTemp;
    }
    /**
     * Regista uma candidatura a demonstracao
     */
    public void registCandidaturaDemonstracao(){
        candidaturaDemonstracao = new CandidaturaDemonstracao(candidatura);
        for (int i=0; i<listaDemoTemp.tamanho();i++){
            
            Demonstracao d = listaDemoTemp.getListaDemonstracoes().get(i);

            d.getListaCandidaturasDemonstracao().addCandidaturaDemonstracao(candidaturaDemonstracao);
 
        }   
    }
    /**
     * Cria uma nova candidatura a demonstracao
     * @param candidatura
     * @return uma nova candidatura a demonstracao
     */
    public CandidaturaDemonstracao novaCandidaturaDemonstracao(Candidatura candidatura){
        return candidaturaDemonstracao = new CandidaturaDemonstracao(candidatura);
    }
    /**
     * Adiciona uma candidatura a demonstracao a lista de candidaturas a demonstracao
     * @param candidaturaDemonstracao
     * @return a true se foi adicionada, false caso contrario
     */
    public boolean adicionarCandidaturaDemonstracao(CandidaturaDemonstracao candidaturaDemonstracao){        
        return demonstracao.getListaCandidaturasDemonstracao().addCandidaturaDemonstracao(candidaturaDemonstracao);
    }
}
