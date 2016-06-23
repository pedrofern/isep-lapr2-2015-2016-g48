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
    private Exposicao exposicao;
    private RegistoExposicoes registoExposicoes;
    private ListaDemonstracoes listaDemonstracoes;
    private ListaDemonstracoes listaTemp;
    private ListaProduto listaProduto;
    private ListaKeywords listaKeywords;
    private CentroExposicoes ce;
    private Utilizador utilizador;
    
    public RegistarCandidaturaController(CentroExposicoes ce, Utilizador u) {
        this.ce=ce;
        utilizador=u;
        registoExposicoes = ce.getRegistoExposicoes();
    }

    public void novaCandidatura() {
        candidatura = listaCandidaturas.novaCandidatura();
        listaProduto=candidatura.getListaProdutos();
        listaKeywords=candidatura.getListaKeywords();
        candidatura.setRepresentante(utilizador);
    }

    public String getCandidaturaString() {
        return candidatura.toString();
    }
    
    public RegistoExposicoes getExposicoes(){
       return registoExposicoes;
    }
    public RegistoExposicoes getExposicoesEstadoCandidaturasAbertas(){
       return registoExposicoes.getExposicoesCandidaturasAbertas();
    }
    
    public ListaDemonstracoes getListaDemonstracoes(){
        listaTemp = new ListaDemonstracoes();
        return listaDemonstracoes;
    }
    public ListaProduto getListaProdutos(){
        return listaProduto;
    }
    public ListaKeywords getListaKeywords(){
        return listaKeywords;
    }
    
    public void selectDemonstracao(Demonstracao demonstracao){
        this.demonstracao=demonstracao;
        listaTemp.adicionarDemonstracao(demonstracao);
    }
        
    public ListaDemonstracoes getSelectedDemonstacao(){
        return listaTemp;
    }
    
    public void selectExposicao(Exposicao exposicao){
        this.exposicao=exposicao;   
        listaCandidaturas = exposicao.getListaCandidaturas();
        listaDemonstracoes = exposicao.getListaDemonstracoes();
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        candidatura.setNomeEmpresa(nomeEmpresa);
    }

    public void setMorada(String morada) {
        candidatura.setMorada(morada);
    }

    public void setTelemovel(int telemovel) {
        candidatura.setTelemovel(telemovel);
    }

    public void setAreaExposicao(int areaExposicao) {
        candidatura.setAreaExposicao(areaExposicao);
    }

    public void setQuantidadeConvites(int quantidadeConvites) {
        candidatura.setQuantidadeConvites(quantidadeConvites);
    }
    
    public void setProdutos(ListaProduto listaProduto){
        candidatura.setListaProdutos(listaProduto);
    }
    
    public void setKeywords(ListaKeywords listaKeywords){
        candidatura.setListaKeywords(listaKeywords);
    }
    
    public void setRepresentante(Utilizador u){
        candidatura.setRepresentante(u);
    }
    
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
    
    public void registCandidaturaDemonstracao(){
        candidaturaDemonstracao = new CandidaturaDemonstracao(candidatura);
        for (int i=0; i<listaTemp.tamanho();i++){
            
            Demonstracao d = listaTemp.getListaDemonstracoes().get(i);

            d.getListaCandidaturasDemonstracao().addCandidaturaDemonstracao(candidaturaDemonstracao);
 
        }   
    }

    public boolean valida() {
        if(candidatura.valida() == false){
            return false;
        }
        return true; 
    }

    public boolean addProduto(Produto nomeProduto) {
            return listaProduto.adicionarProduto(nomeProduto);
    }
    
    public boolean addKeyword(Keyword keyword) {
            return listaKeywords.adicionarKeyword(keyword);
    }

    public Candidatura getCandidatura() {
        return candidatura;
    }
    
    public CandidaturaDemonstracao novaCandidaturaDemonstracao(Candidatura candidatura){
        return candidaturaDemonstracao = new CandidaturaDemonstracao(candidatura);
    }
    
    public boolean adicionarCandidaturaDemonstracao(CandidaturaDemonstracao candidaturaDemonstracao){        
        return demonstracao.getListaCandidaturasDemonstracao().addCandidaturaDemonstracao(candidaturaDemonstracao);
    }
}
