package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaCandidaturasDemonstracoes;
import lapr.project.model.lists.ListaProduto;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistarCandidaturaController {

    private Representante eRepresentante;
    private Utilizador user;
    private Candidatura candidatura;
    private CandidaturaDemonstracao candidaturaDemonstracao;
    private ListaCandidaturas listaCandidaturas;

    private Exposicao exposicao;

    public RegistarCandidaturaController(Representante representante,Exposicao exp) {
        eRepresentante = representante;
        exposicao = exp;
        listaCandidaturas = exposicao.getRegistoCandidaturas(); 
    }

    public void novaCandidatura() {
        candidatura = eRepresentante.novaCandidatura();
    }

    public String getCandidaturaString() {
        return candidatura.toString();
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
    
    public Candidatura registaCandidatura(String nomeEmpresa,String morada,int telemovel,
                    int areaExposicao,int quantidadeConvites){
        candidatura.setNomeEmpresa(nomeEmpresa);
        candidatura.setMorada(morada);
        candidatura.setTelemovel(telemovel);
        candidatura.setAreaExposicao(areaExposicao);
        candidatura.setQuantidadeConvites(quantidadeConvites);
        
        if (listaCandidaturas.registaCandidaturas(candidatura)) {
            return candidatura;
        } else {
            return null;
        }
    }

    public boolean valida() {
        if(candidatura.valida() == false){
            return false;
        }else{
        return true;
        }
    }

    public boolean addProduto(String nomeProduto) {
        Produto p = eRepresentante.getProduto(nomeProduto);

        if (p != null) {
            return candidatura.addProduto(nomeProduto);
        } else {
            return false;
        }
    }

    public Candidatura getCandidatura() {
        return candidatura;
    }

    public boolean registaCandidatura() {
        return eRepresentante.registaCandidatura(candidatura);
    }
    
    public boolean novaCandidaturaDemonstracao(Demonstracao d){
            
        candidaturaDemonstracao = new CandidaturaDemonstracao(candidatura);
        
        return d.getListaCandidaturasDemonstracao().addCandidaturaDemonstracao(candidaturaDemonstracao);
    }

}
