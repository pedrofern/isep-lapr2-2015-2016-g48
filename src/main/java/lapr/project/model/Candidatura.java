package lapr.project.model;

import java.io.Serializable;
import java.util.ListIterator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.lists.*;
import lapr.project.model.states.candidaturasExpo.*;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Candidatura implements Serializable{

    private String nomeEmpresa;
    private String morada;
    private int telemovel;
    private int areaExposicao;
    private int quantidadeConvites;
    private ListaProduto listaProdutos;
    private ListaFAE listaFAE;
    private ListaCandidaturas listaCandidaturas;
    private ListaKeywords listaKeywords;
    private ListaAvaliacoes listaAvaliacoes;
    private Representante representante;
    @XmlTransient
    private CandidaturaEstado estadoCandidatura;
    private boolean decisao;

    public Candidatura(String nomeEmpresa, String morada, int telemovel, int areaExposicao, int quantidadeConvites) {
        estadoCandidatura = new CandidaturaEmSubmissao();
        this.nomeEmpresa = nomeEmpresa;
        this.morada = morada;
        this.telemovel = telemovel;
        this.areaExposicao = areaExposicao;
        this.quantidadeConvites = quantidadeConvites;
        listaProdutos = new ListaProduto();
        listaFAE = new ListaFAE();
        listaAvaliacoes=new ListaAvaliacoes();
        listaKeywords = new ListaKeywords();        
    }
    
    public Candidatura() {
       listaProdutos = new ListaProduto();
       listaFAE = new ListaFAE();
       listaAvaliacoes=new ListaAvaliacoes();
       listaKeywords = new ListaKeywords();
    }
   
    public Candidatura cloneCandidatura() {
        Candidatura c = new Candidatura(
                this.getNomeEmpresa(), 
                this.getMorada(), 
                this.getTelemovel(), 
                this.getAreaExposicao(), 
                this.getQuantidadeConvites());
        c.setListaKeywords(this.getListaKeywords());
        c.setListaProdutos(this.getListaProdutos());
        return c;
    }
    
    public boolean getDecisao(){
        return decisao;
    }
    
    public String getNomeEmpresa() {
        return this.nomeEmpresa;
    }
    
    public String getMorada() {
        return this.morada;
    }
    
    public int getTelemovel() {
        return this.telemovel;
    }
    
    public int getAreaExposicao(){
        return this.areaExposicao;
    }
    
    public int getQuantidadeConvites(){
        return this.quantidadeConvites;
    }
    
    public Representante getRepresentante(){
        return this.representante;
    }
    
    public String getInfo() {
        return this.toString();
    }
    
    public ListaFAE getListaFAE(){
        return listaFAE;
    }
    
    public ListaAvaliacoes getListaAvaliacoes(){
        return listaAvaliacoes;
    }
    
    public CandidaturaEstado getEstadoAtualCandidatura(){
        return estadoCandidatura;
    }
    
    public void setDecisao(boolean decisao){
        this.decisao=decisao;
    }
    
    public void setEstadoCandidatura(CandidaturaEstado estadoCandidatura){
        this.estadoCandidatura=estadoCandidatura;
    }

    public void setNomeEmpresa(String novoNomeEmpresa) {
        this.nomeEmpresa = novoNomeEmpresa;
    }

    public void setMorada(String novaMorada) {
        this.morada = novaMorada;
    }

    public void setTelemovel(int novoTelemovel) {
        this.telemovel = novoTelemovel;
    }

    public void setAreaExposicao(int novaAreaExposicao) {
        this.areaExposicao = novaAreaExposicao;
    }

    public void setQuantidadeConvites(int novaQuantidadeConvites) {
        this.quantidadeConvites = novaQuantidadeConvites;
    }
    
    public void setRepresentante(Utilizador u){
        this.representante= new Representante(u);
    }
    
  

    public ListaProduto getListaProdutos() {
        ListaProduto lProd = new ListaProduto();
        for (ListIterator<Produto> it = listaProdutos.getListaProduto().listIterator(); it.hasNext();) {
            lProd.adicionarProduto(it.next());
        }
        return lProd;
    }
    
    public void setListaProdutos(ListaProduto listaProdutos){
        this.listaProdutos = listaProdutos;
    }
    
    public ListaKeywords getListaKeywords() {
        ListaKeywords lKey = new ListaKeywords();
        for (ListIterator<Keyword> it = listaKeywords.getListaKeyword().listIterator(); it.hasNext();) {
            lKey.adicionarKeyword(it.next());
        }
        return lKey;
    }
    
    public void setListaKeywords(ListaKeywords listaKeywords){
        this.listaKeywords = listaKeywords;
    }
    
    public ListaCandidaturas getListaCandidaturas() {
        ListaCandidaturas lc = new ListaCandidaturas();
        
        return listaCandidaturas;
    }

    public boolean addProduto(String nomeProduto) {
        Produto p = new Produto(nomeProduto);
        p.valida();
        return addProduto(p);
    }

    private boolean addProduto(Produto p) {
        return listaProdutos.adicionarProduto(p);
    }

    public boolean validaCandidatura(Candidatura c) {
        return c.valida();
    }

    public boolean validaFAE(FAE f) {
        return f.validaMenbroFAE();
    }

    public boolean valida() {
        return validaNomeEmpresa() && validaMorada() && validaTelemovel() && 
                validaArea() && validaContives();
    }
    public boolean validaNomeEmpresa() {
        return !(nomeEmpresa == null || nomeEmpresa.isEmpty() || nomeEmpresa.matches(".*\\d+.*"));
    }

    public boolean validaMorada() {
        return !(morada == null || morada.isEmpty());
    }

    public boolean validaTelemovel() {  
        return !(telemovel<900000000 || telemovel>999999999);
    }

    public boolean validaArea() {
        return !(areaExposicao<1 || areaExposicao>999);
    }
    
    public boolean validaContives() {
        return !(quantidadeConvites<1 || quantidadeConvites>999);
    }

    @Override
    public String toString() {
        return this.nomeEmpresa;
    }
    
    public String toStringDadosGerais() {
        return "Representante Empresa: " + this.representante.toString()
                + "\nNome: "+ this.nomeEmpresa
                + "\nMorada: " + this.morada
                + "\nTelemóvel: " + this.telemovel
                + "\nÁrea pretendida: " + this.areaExposicao
                + "\nConvites pretendidos: " + this.quantidadeConvites;
    }
    
    public String toStringCompleto() {
        return this.toStringDadosGerais()
                + "\nKeywords:\n"+this.listaKeywords.getListaKeyword().toString()
                + "\nProdutos:\n" + this.listaProdutos.getListaProduto().toString();
    }
    
      public void setAtribuida() {
        CandidaturaEmAtribuicao state=(CandidaturaEmAtribuicao)estadoCandidatura;
        state.setCandidaturaEmAtribuicao(this);
    }
      
      public String getDecisaoString(){
          String decision;
          if(decisao==true){
              decision="aceite";
          }else{
              decision="recusada";
          }
          return decision;
      }

      public String[] toStringEstatistica(){
          String[] data={getNomeEmpresa(), getDecisaoString(), String.format("%.2f", getListaAvaliacoes().getMedia())};
          return data;
      }
}
