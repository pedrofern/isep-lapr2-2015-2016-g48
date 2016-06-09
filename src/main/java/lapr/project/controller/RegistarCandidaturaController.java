package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.lists.ListaCandidaturas;

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

    public void setAreaExposicao(double areaExposicao) {
        m_candidatura.setAreaExposicao(areaExposicao);
    }

    public void setQuantidadeConvites(int quantidadeConvites) {
        m_candidatura.setQuantidadeConvites(quantidadeConvites);
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
