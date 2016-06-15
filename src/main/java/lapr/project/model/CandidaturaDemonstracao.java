/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import lapr.project.model.lists.*;

/**
 *
 * @author Pedro Fernandes
 */
public class CandidaturaDemonstracao {
    
    private String nomeEmpresaCD;
    private String moradaCD;
    private int telemovelCD;
    private int areaExposicaoCD;
    private int quantidadeConvitesCD;
    private ListaProduto listaProdutosCD;
    private ListaCandidaturasDemonstracoes listaCandidaturasDemo;

    public CandidaturaDemonstracao(Candidatura candidaturaExp) {
        this.nomeEmpresaCD = candidaturaExp.getNomeEmpresa();
        this.moradaCD = candidaturaExp.getMorada();
        this.telemovelCD = candidaturaExp.getTelemovel();
        this.areaExposicaoCD = candidaturaExp.getAreaExposicao();
        this.quantidadeConvitesCD = candidaturaExp.getQuantidadeConvites();
        listaProdutosCD = candidaturaExp.getListaProdutos();
    }
    
    public String getNomeEmpresaCD() {
        return this.nomeEmpresaCD;
    }
    
    public String getMoradaCD() {
        return this.moradaCD;
    }
    
    public int getTelemovelCD() {
        return this.telemovelCD;
    }
    
    public int getAreaExposicaoCD(){
        return this.areaExposicaoCD;
    }
    
    public int getQuantidadeConvitesCD(){
        return this.quantidadeConvitesCD;
    }
    
    public String getInfoCD() {
        return this.toString();
    }
    
    public void setNomeEmpresaCD(String novoNomeEmpresa) {
        this.nomeEmpresaCD = novoNomeEmpresa;
    }

    public void setMoradaCD(String novaMorada) {
        this.moradaCD = novaMorada;
    }

    public void setTelemovelCD(int novoTelemovel) {
        this.telemovelCD = novoTelemovel;
    }

    public void setAreaExposicaoCD(int novaAreaExposicao) {
        this.areaExposicaoCD = novaAreaExposicao;
    }

    public void setQuantidadeConvitesCD(int novaQuantidadeConvites) {
        this.quantidadeConvitesCD = novaQuantidadeConvites;
    }

    public ListaProduto getListaProdutosCD() {
        ListaProduto lProd = new ListaProduto();
        for (ListIterator<Produto> it = listaProdutosCD.getListaProduto().listIterator(); it.hasNext();) {
            lProd.adicionarProduto(it.next());
        }
        return lProd;
    }
    
    public void setListaProdutos(ListaProduto listaProdutos){
        listaProdutosCD = listaProdutos;
    }

    public ListaCandidaturasDemonstracoes getListaCandidaturas() {
        ListaCandidaturasDemonstracoes lc = new ListaCandidaturasDemonstracoes();
        for (ListIterator<CandidaturaDemonstracao> it = listaCandidaturasDemo.getListaCandidaturas().listIterator(); it.hasNext();) {
            lc.addCandidatura(it.next());
        }
        return lc;
    }

    public boolean addProduto(String nomeProduto) {
        Produto p = new Produto(nomeProduto);
        p.valida();
        return addProduto(p);
    }

    private boolean addProduto(Produto p) {
        return listaProdutosCD.adicionarProduto(p);
    }

    public boolean validaCandidatura(Candidatura c) {
        return c.valida();
    }

    public boolean validaFAE(FAE f) {
        return f.valida();
    }

    public boolean valida() {
        return validaNomeEmpresa() && validaMorada() && validaTelemovel() && 
                validaArea() && validaContives();
    }
    public boolean validaNomeEmpresa() {
        if (nomeEmpresaCD == null || nomeEmpresaCD.isEmpty() || nomeEmpresaCD.matches(".*\\d+.*")) {
            return false;
        }
        return true;
    }

    public boolean validaMorada() {
        if (moradaCD == null || moradaCD.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean validaTelemovel() {
        if (telemovelCD<900000000 || telemovelCD>999999999){
            return false;
        }
        return true;
    }

    public boolean validaArea() {
        if (areaExposicaoCD<1 || areaExposicaoCD>999){
            return false;
        }
        return true;
    }
    
    public boolean validaContives() {
        if (areaExposicaoCD<1 || areaExposicaoCD>999){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nomeEmpresaCD;
    }
    
    public String toStringDadosGeraisCD() {
        return this.nomeEmpresaCD + "\n" 
                + this.moradaCD + "\n" + 
                this.telemovelCD + "\n" + 
                this.areaExposicaoCD + "\n" + 
                this.quantidadeConvitesCD;
    }
    
    public String toStringCompleto() {
        return this.toStringDadosGeraisCD() + "\n" + this.getListaProdutosCD();
    }
}
