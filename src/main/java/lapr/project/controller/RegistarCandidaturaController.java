package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.lists.*;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistarCandidaturaController {
    
    private Candidatura candidatura;
    private CandidaturaDemonstracao candidaturaDemonstracao;
    private Demonstracao demonstracao;
    private ListaCandidaturas listaCandidaturas;
    private RegistoExposicoes registoExposicoes;
    private ListaDemonstracoes listaDemonstracoes;
    private ListaDemonstracoes listaTemp;
    private ListaProduto listaProduto;
    private ListaKeywords listaKeywords;
    private CentroExposicoes ce;
    private Utilizador utilizador;
    
    /**
     * Cria nova instancia da classe
     * @param ce
     * @param u 
     */
    public RegistarCandidaturaController(CentroExposicoes ce, Utilizador u) {
        this.ce=ce;
        utilizador=u;
        registoExposicoes = ce.getRegistoExposicoes();
    }
/**
 * Cria uma nova candidatura
 */
    public void novaCandidatura() {
        candidatura = listaCandidaturas.novaCandidatura();
        listaProduto=candidatura.getListaProdutos();
        listaKeywords=candidatura.getListaKeywords();
        candidatura.setRepresentante(utilizador);
    }
/**
 * Devolve dados da Candidatura como string
 * @return dados da Candidatura como string
 */
    public String getCandidaturaString() {
        return candidatura.toString();
    }
    /**
     * Devolve lista exposicoes
     * @return lista exposicoes
     */
    public RegistoExposicoes getExposicoes(){
       return registoExposicoes;
    }
    /**
     * Devolve a lista de exposicoes com estado de candidatiras abertas
     * @return lista de exposicoes com estado de candidatiras abertas
     */
    public RegistoExposicoes getExposicoesEstadoCandidaturasAbertas(){
       return registoExposicoes.getExposicoesCandidaturasAbertas();
    }
    /**
     * Devolve a lista de demonstracoes
     * @return a lista de demonstracoes
     */
    public ListaDemonstracoes getListaDemonstracoes(){
        listaTemp = new ListaDemonstracoes();
        return listaDemonstracoes;
    }
    /**
     * Devolve lista de produtos
     * @return lista de produtos
     */
    public ListaProduto getListaProdutos(){
        return listaProduto;
    }
    /**
     * Devolve a lista de keywords
     * @return a lista de keywords
     */
    public ListaKeywords getListaKeywords(){
        return listaKeywords;
    }
    
    /*
    Seleciona uma demonstracao de uma lista
    */
    public void selectDemonstracao(Demonstracao demonstracao){
        this.demonstracao=demonstracao;
        listaTemp.adicionarDemonstracao(demonstracao);
    }
        
    /**
     * Devolve lista temporaria de demonstracoes
     * @return lista temporaria de demonstracoes
     */
    public ListaDemonstracoes getSelectedDemonstacao(){
        return listaTemp;
    }
    /**
     * Seleciona uma exposicao de uma lista
     * @param exposicao 
     */
    public void selectExposicao(Exposicao exposicao){  
        listaCandidaturas = exposicao.getListaCandidaturas();
        listaDemonstracoes = exposicao.getListaDemonstracoes();
    }

    /**
     * Altera nome da empresa
     * @param nomeEmpresa 
     */
    public void setNomeEmpresa(String nomeEmpresa) {
        candidatura.setNomeEmpresa(nomeEmpresa);
    }
/**
 * Altera morada
 * @param morada 
 */
    public void setMorada(String morada) {
        candidatura.setMorada(morada);
    }
/**
 * Altera telemovel
 * @param telemovel 
 */
    public void setTelemovel(int telemovel) {
        candidatura.setTelemovel(telemovel);
    }
/**
 * Altera area da exposicao
 * @param areaExposicao 
 */
    public void setAreaExposicao(int areaExposicao) {
        candidatura.setAreaExposicao(areaExposicao);
    }
/**
 * Altera quantidade de convites
 * @param quantidadeConvites 
 */
    public void setQuantidadeConvites(int quantidadeConvites) {
        candidatura.setQuantidadeConvites(quantidadeConvites);
    }
    /**
     * Altera lista de produtos
     * @param listaProduto 
     */
    public void setProdutos(ListaProduto listaProduto){
        candidatura.setListaProdutos(listaProduto);
    }
    /**
     * Altera lista de keywords
     * @param listaKeywords 
     */
    public void setKeywords(ListaKeywords listaKeywords){
        candidatura.setListaKeywords(listaKeywords);
    }
    /**
     * Altera representante
     * @param u 
     */
    public void setRepresentante(Utilizador u){
        candidatura.setRepresentante(u);
    }
    /**
     * Regista dados da candidatura
     * @param nomeEmpresa
     * @param morada
     * @param telemovel
     * @param areaExposicao
     * @param quantidadeConvites
     * @param listaProdutos
     * @param listaKeywords
     * @return dadosda candidatura
     */
    public Candidatura registaCandidatura(String nomeEmpresa,String morada,
        int telemovel, int areaExposicao,int quantidadeConvites,
        ListaProduto listaProdutos,ListaKeywords listaKeywords){

        candidatura.setNomeEmpresa(nomeEmpresa);
        candidatura.setMorada(morada);
        candidatura.setTelemovel(telemovel);
        candidatura.setAreaExposicao(areaExposicao);
        candidatura.setQuantidadeConvites(quantidadeConvites);
        candidatura.setListaProdutos(listaProdutos);
        candidatura.setListaKeywords(listaKeywords);


        if (listaCandidaturas.registaCandidaturas(candidatura)) {
            return candidatura;
        } else {
            return null;
        }   
    }
    /**
     * Regista dados da candidatura a demonstracao
     */
    public void registCandidaturaDemonstracao(){
        candidaturaDemonstracao = new CandidaturaDemonstracao(candidatura);
        for (int i=0; i<listaTemp.tamanho();i++){
            
            Demonstracao d = listaTemp.getListaDemonstracoes().get(i);

            d.getListaCandidaturasDemonstracao().addCandidaturaDemonstracao(candidaturaDemonstracao);
 
        }   
    }
/**
 * Valida candidatura
 * @return true se valida, false se nao
 */
    public boolean valida() {
        if(candidatura.valida() == false){
            return false;
        }
        return true; 
    }
/**
 * Adiciona produtoa lista de produtos
 * @param nomeProduto
 * @return true se adicionado, false se nao
 */
    public boolean addProduto(Produto nomeProduto) {
            return listaProduto.adicionarProduto(nomeProduto);
    }
    /**
     * Adiciona keyword a lista de keywords
     * @param keyword
     * @return true se valida, false se nao
     */
    public boolean addKeyword(Keyword keyword) {
            return listaKeywords.adicionarKeyword(keyword);
    }
/**
 * Devolve candidatura
 * @return candidatura
 */
    public Candidatura getCandidatura() {
        return candidatura;
    }
    /**
     * Cria nova candidatura a demonstracao
     * @param candidatura
     * @return nova candidatura a demonstracao
     */
    public CandidaturaDemonstracao novaCandidaturaDemonstracao(Candidatura candidatura){
        return candidaturaDemonstracao = new CandidaturaDemonstracao(candidatura);
    }
    /**
     * Adiciona candidatura a demonstracao
     * @param candidaturaDemonstracao
     * @return true se adicionado, false se nao
     */
    public boolean adicionarCandidaturaDemonstracao(CandidaturaDemonstracao candidaturaDemonstracao){        
        return demonstracao.getListaCandidaturasDemonstracao().addCandidaturaDemonstracao(candidaturaDemonstracao);
    }
}
