package lapr.project.controller;

import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.lists.RegistoExposicoes;
import lapr.project.model.*;
import lapr.project.utils.Data;

/**
 *
 * @author Pedro Fernandes
 */
public class CriarExposicaoController {

    private static CentroExposicoes ce;
    private Exposicao exposicao;
    private RegistoExposicoes regExposicoes;
    private RegistoUtilizadores regUtilizadores;
    private ListaOrganizadores lstOrganizadores;

    public CriarExposicaoController(CentroExposicoes centroExposicoes) {
        ce = centroExposicoes;
        regExposicoes = ce.getRegistoExposicoes();
        regUtilizadores = ce.getRegistoUtilizadores();
    }

    public void novaExposicao() {
        this.exposicao = regExposicoes.novaExposicao();
    }

    /**
     * Modifica o título do evento.
     *
     * @param strTitulo o título do evento
     */
    public void setTitulo(String strTitulo) {
        exposicao.setTitulo(strTitulo);
    }

    /**
     * Modifica a descrição do evento.
     *
     * @param strDescricao a descrição
     */
    public void setDescricao(String strDescricao) {
        exposicao.setTextoDescritivo(strDescricao);
    }

    /**
     * Modifica o local do evento.
     *
     * @param strLocal o local
     */
    public void setLocal(String strLocal) {
        exposicao.setLocal(strLocal);
    }

    /**
     * Modifica a data inicial do evento.
     *
     * @param strDataInicio a data de início
     */
    public void setDataInicio(Data strDataInicio) {
        exposicao.setDataInicio(strDataInicio);
    }

    /**
     * Modifica a data final do evento.
     *
     * @param strDataFim a data final
     */
    public void setDataFim(Data strDataFim) {
        exposicao.setDataFim(strDataFim);
    }

    public void setDataInicioSubmissao(Data strDataInicioSubmissao) {
        exposicao.setDataInicioSubmissao(strDataInicioSubmissao);
    }

    public void setDataFimSubmissao(Data strDataFimSubmissao) {
        exposicao.setDataFimSubmissao(strDataFimSubmissao);
    }

    public void setDataInicioAtribuicao(Data strDataInicioAtribuicao) {
        exposicao.setDataInicioAtribuicao(strDataInicioAtribuicao);
    }

    public RegistoUtilizadores getListaUtilizadores() {
        return this.ce.getRegistoUtilizadores();
    }

    public Utilizador addOrganizador(String strId) {
        Utilizador u = regUtilizadores.getUtilizadorByID(strId);
        exposicao.getListaOrganizadores().addOrganizador(u);
        return u;

    }

    public void addOrganizador(Utilizador u) {
        this.lstOrganizadores.addOrganizador(u);
    }
    
    public void novoOrganizador(Utilizador u) {
        this.lstOrganizadores.addOrganizador(u);
    }

    public Exposicao getExposicao() {
        return exposicao;
    }

    public Exposicao registaExposicao() {
        if (regExposicoes.registaExposicao(exposicao)) {
            return exposicao;
        }
        return null;
    }
    
    public Exposicao criaExposicao(String titulo, String descricao, String local, Data dInicio, Data dFim) {        
        exposicao.setTitulo(titulo);
        exposicao.setTextoDescritivo(descricao);
        exposicao.setLocal(local);
        exposicao.setDataInicio(dInicio);
        exposicao.setDataFim(dFim);
        
        if (regExposicoes.registaExposicao(exposicao)) {
            return exposicao;
        } else {
            return null;
        }

    }
    
    private void createTimers() {
//        AlterarStateParaEmSubmissao task1 = new AlterarStateParaEmSubmissao(exposicao);
//        this.m_oCE.schedule(task1, exposicao.getDataInicioSubmissao());
//
//        AlterarStateParaEmAtribuicao task2 = new AlterarStateParaEmAtribuicao(exposicao);
//        this.m_oCE.schedule(task2, exposicao.getDataInicioAtribuicao());
//
//        DetetarConflitosController task3 = new DetetarConflitosController(m_oCE, exposicao);
//        this.m_oCE.schedule(task3, exposicao.getDataFimSubmissao());
    }

    public boolean validaExposicao() {
        return regExposicoes.validaExposicao(exposicao);
    }

    public String getExposicaoString() {
        return this.exposicao.toString();
    }
}
