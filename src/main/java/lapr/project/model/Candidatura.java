package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Pedro Fernandes
 */
public class Candidatura {

    private String nomeEmpresa;
    private String morada;
    private int telemovel;
    private double areaExposicao;
    private int quantidadeConvites;
    private List<Produto> e_listaProdutos;
    private List<FAE> e_listaFAE;
    private List<Candidatura> c_listaCandidaturas;

    public Candidatura(String nomeEmpresa, String morada, int telemovel, double areaExposicao, int quantidadeConvites) {
        this.nomeEmpresa = nomeEmpresa;
        this.morada = morada;
        this.telemovel = telemovel;
        this.areaExposicao = areaExposicao;
        this.quantidadeConvites = quantidadeConvites;
        e_listaProdutos = new ArrayList<Produto>();
        e_listaFAE = new ArrayList<FAE>();
        c_listaCandidaturas = new ArrayList<Candidatura>();

    }

    @Override
    public Candidatura clone() {
        return new Candidatura(this.getNomeEmpresa(), this.getMorada(), this.getTelemovel(), this.getAreaExposicao(), this.getQuantidadeConvites());
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
    
    public double getAreaExposicao(){
        return this.areaExposicao;
    }
    
    public int getQuantidadeConvites(){
        return this.quantidadeConvites;
    }
    
    public Candidatura() {
        e_listaProdutos = new ArrayList<Produto>();
    }

    public String getInfo() {
        return this.toString();
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

    public void setAreaExposicao(double novaAreaExposicao) {
        this.areaExposicao = novaAreaExposicao;
    }

    public void setQuantidadeConvites(int novaQuantidadeConvites) {
        this.quantidadeConvites = novaQuantidadeConvites;
    }

    public List<Produto> getListaProdutos() {
        List<Produto> lOrg = new ArrayList<Produto>();
        for (ListIterator<Produto> it = e_listaProdutos.listIterator(); it.hasNext();) {
            lOrg.add(it.next());
        }
        return lOrg;
    }

    public List<Candidatura> getListaCandidaturas() {
        List<Candidatura> lc = new ArrayList<Candidatura>();
        for (ListIterator<Candidatura> it = c_listaCandidaturas.listIterator(); it.hasNext();) {
            lc.add(it.next());
        }
        return lc;
    }

    public boolean addProduto(String nomeProduto) {
        Produto p = new Produto(nomeProduto);
        p.valida();
        return addProduto(p);
    }

    private boolean addProduto(Produto p) {
        return e_listaProdutos.add(p);
    }

    public boolean validaCandidatura(Candidatura c) {
        return c.valida();
    }

    public boolean validaFAE(FAE f) {
        return f.valida();
    }

    public boolean valida() {
        System.out.println("Candidatura: valida: " + this.toString());
        return true;
    }

    @Override
    public String toString() {
        return this.nomeEmpresa + "\n" + this.morada + "\n" + this.telemovel + "\n" + this.areaExposicao + "\n" + this.quantidadeConvites;
    }

}
