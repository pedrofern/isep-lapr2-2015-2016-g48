package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaProduto;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistarCandidaturaController {

    private Representante e_representante;
    private Utilizador m_user;
    private Candidatura m_candidatura;
    private ListaCandidaturas m_listaCandidaturas;
    private Exposicao m_exposicao;

    public RegistarCandidaturaController(Representante representante,Exposicao exp) {
        e_representante = representante;
        m_exposicao = exp;
        m_listaCandidaturas = m_exposicao.getRegistoCandidaturas(); 
    }

    public void novaCandidatura() {
        m_candidatura = e_representante.novaCandidatura();
    }

    public String getCandidaturaString() {
        return m_candidatura.toString();
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        m_candidatura.setNomeEmpresa(nomeEmpresa);
    }

    public void setMorada(String morada) {
        m_candidatura.setMorada(morada);
    }

    public void setTelemovel(int telemovel) {
        m_candidatura.setTelemovel(telemovel);
    }

    public void setAreaExposicao(int areaExposicao) {
        m_candidatura.setAreaExposicao(areaExposicao);
    }

    public void setQuantidadeConvites(int quantidadeConvites) {
        m_candidatura.setQuantidadeConvites(quantidadeConvites);
    }
    
    public void setProdutos(ListaProduto listaProduto){
        m_candidatura.setListaProdutos(listaProduto);
    }
    
    public Candidatura registaCandidatura(String nomeEmpresa,String morada,int telemovel,
                    int areaExposicao,int quantidadeConvites){
        m_candidatura.setNomeEmpresa(nomeEmpresa);
        m_candidatura.setMorada(morada);
        m_candidatura.setTelemovel(telemovel);
        m_candidatura.setAreaExposicao(areaExposicao);
        m_candidatura.setQuantidadeConvites(quantidadeConvites);
        
        if (m_listaCandidaturas.registaCandidaturas(m_candidatura)) {
            return m_candidatura;
        } else {
            return null;
        }
    }

    public boolean valida() {
        return true;
    }

    public boolean addProduto(String nomeProduto) {
        Produto p = e_representante.getProduto(nomeProduto);

        if (p != null) {
            return m_candidatura.addProduto(nomeProduto);
        } else {
            return false;
        }
    }

    public Candidatura getCandidatura() {
        return m_candidatura;
    }

    public boolean registaCandidatura() {
        return e_representante.registaCandidatura(m_candidatura);
    }
}
