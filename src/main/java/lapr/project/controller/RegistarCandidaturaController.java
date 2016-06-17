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
    private ListaCandidaturas listaCandidaturas;
    private Exposicao exposicao;
    private ListaDemonstracoes listaDemonstracoes;
    private CentroExposicoes ce;
    
    public RegistarCandidaturaController(CentroExposicoes ce) {
        this.ce=ce;
    }

    public void novaCandidatura() {
        candidatura = listaCandidaturas.novaCandidatura();
    }

    public String getCandidaturaString() {
        return candidatura.toString();
    }
    
    public RegistoExposicoes getRegistoExposicoes(){
        return ce.getRegistoExposicoes();
    }
    public ListaDemonstracoes getListaDemonstracoes(){
        return exposicao.getListaDemonstracoes();
    }
    public ListaProduto getListaProdutos(){
        return candidatura.getListaProdutos();
    }
    public ListaKeywords getListaKeywords(){
        return candidatura.getListaKeywords();
    }
    
    public void selectExposicao(Exposicao exposicao){
        this.exposicao=exposicao;   
        listaCandidaturas = exposicao.getListaCandidaturas();
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
    
    public Candidatura registaCandidatura(String nomeEmpresa,String morada,int telemovel,
                    int areaExposicao,int quantidadeConvites,
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

    public boolean valida() {
        if(candidatura.valida() == false){
            return false;
        }
        return true;
        
    }

    public boolean addProduto(Produto nomeProduto) {
            return candidatura.getListaProdutos().adicionarProduto(nomeProduto);
    }

    public Candidatura getCandidatura() {
        return candidatura;
    }
    
    public boolean novaCandidaturaDemonstracao(Demonstracao d){
            
        candidaturaDemonstracao = new CandidaturaDemonstracao(candidatura);
        
        return d.getListaCandidaturasDemonstracao().addCandidaturaDemonstracao(candidaturaDemonstracao);
    }

}
