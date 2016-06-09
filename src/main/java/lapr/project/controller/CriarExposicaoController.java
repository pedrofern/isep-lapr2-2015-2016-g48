package lapr.project.controller;

import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.lists.RegistoExposicoes;
import lapr.project.model.*;
import java.util.*;

/**
 *
 * @author Pedro Fernandes
 */
public class CriarExposicaoController {

    private final CentroExposicoes m_oCE;
    private Exposicao m_exposicao;
    private RegistoExposicoes m_regExposicoes;
    private RegistoUtilizadores m_regUtilizadores;
    private ListaOrganizadores m_lstOrganizadores;

    public CriarExposicaoController(CentroExposicoes ce) {
        this.m_oCE = ce;
        m_regExposicoes = ce.getRegistoExposicoes();
        m_regUtilizadores = ce.getRegistoUtilizadores();
    }

    public void novaExposicao() {
//        this.m_exposicao = m_regExposicoes.novaExposicao();
    }

    /**
     * Modifica o título do evento.
     *
     * @param strTitulo o título do evento
     */
    public void setTitulo(String strTitulo) {
        m_exposicao.setTitulo(strTitulo);
    }

    /**
     * Modifica a descrição do evento.
     *
     * @param strDescricao a descrição
     */
    public void setDescricao(String strDescricao) {
        m_exposicao.setTextoDescritivo(strDescricao);
    }

    /**
     * Modifica o local do evento.
     *
     * @param strLocal o local
     */
    public void setLocal(String strLocal) {
        m_exposicao.setLocal(strLocal);
    }

    /**
     * Modifica a data inicial do evento.
     *
     * @param strDataInicio a data de início
     */
    public void setDataInicio(Date strDataInicio) {
        m_exposicao.setDataInicio(strDataInicio);
    }

    /**
     * Modifica a data final do evento.
     *
     * @param strDataFim a data final
     */
    public void setDataFim(Date strDataFim) {
        m_exposicao.setDataFim(strDataFim);
    }

    public void setDataInicioSubmissao(Date strDataInicioSubmissao) {
        m_exposicao.setDataInicioSubmissao(strDataInicioSubmissao);
    }

    public void setDataFimSubmissao(Date strDataFimSubmissao) {
        m_exposicao.setDataFimSubmissao(strDataFimSubmissao);
    }

    public void setDataInicioAtribuicao(Date strDataInicioAtribuicao) {
        m_exposicao.setDataInicioAtribuicao(strDataInicioAtribuicao);
    }

    public List<Utilizador> getListaUtilizadores() {
        return this.m_oCE.getUtilizadores();
    }

    public Utilizador addOrganizador(String strId) {
        Utilizador u = m_regUtilizadores.getUtilizadorByID(strId);
        m_exposicao.getListaOrganizadores().addOrganizador(u);
        return u;

    }

    public void addOrganizador(Utilizador u) {
        this.m_lstOrganizadores.addOrganizador(u);
    }
    
    public void novoOrganizador(Utilizador u) {
        this.m_lstOrganizadores.addOrganizador(u);
    }

    public Exposicao getExposicao() {
        return m_exposicao;
    }

    public Exposicao registaExposicao() {
        if (m_regExposicoes.registaExposicao(m_exposicao)) {
            return m_exposicao;
        }
        return null;
    }
    
    private void createTimers() {
//        AlterarStateParaEmSubmissao task1 = new AlterarStateParaEmSubmissao(m_exposicao);
//        this.m_oCE.schedule(task1, m_exposicao.getDataInicioSubmissao());
//
//        AlterarStateParaEmAtribuicao task2 = new AlterarStateParaEmAtribuicao(m_exposicao);
//        this.m_oCE.schedule(task2, m_exposicao.getDataInicioAtribuicao());
//
//        DetetarConflitosController task3 = new DetetarConflitosController(m_oCE, m_exposicao);
//        this.m_oCE.schedule(task3, m_exposicao.getDataFimSubmissao());
    }

    public boolean validaExposicao() {
        return m_regExposicoes.validaExposicao(m_exposicao);
    }

    public String getExposicaoString() {
        return this.m_exposicao.toString();
    }
}
