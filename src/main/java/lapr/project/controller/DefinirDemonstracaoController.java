/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.lists.*;
import lapr.project.utils.Data;
import lapr.project.model.states.demonstracao.*;

/**
 *
 * @author Edu
 */
public class DefinirDemonstracaoController {

    private RegistoExposicoes registoExposicoes;
    private CentroExposicoes ce;
    private ListaDemonstracoes listaDemonstracoes;
    private Utilizador utilizador;
    private Exposicao exposicao;
    private Demonstracao demonstracao;

    /**
     * Cria uma nova instancia da classe
     * @param ce
     * @param utilizador 
     */
    public DefinirDemonstracaoController(CentroExposicoes ce, Utilizador utilizador) {
        this.ce = ce;
        this.utilizador = utilizador;
    }
/**
 * Devolve a lista de exposicoes
 * @return a lista de exposicoes
 */
    public RegistoExposicoes getRegistoExposicoes() {
        return registoExposicoes = ce.getRegistoExposicoes();
    }
/**
 * Altera exposicao
 * @param exposicao 
 */
    public void setExposicao(Exposicao exposicao) {
        this.exposicao = exposicao;
       listaDemonstracoes = exposicao.getListaDemonstracoes();
    }
/**
 * Devolve lista de demonstracoes criadas
 * @return lista de demonstracoes criadas
 */
    public ListaDemonstracoes getListaDemonstracoesCriadas() {
        return  listaDemonstracoes;
    }
/**
 * Altera demonstracao
 * @param demonstracao 
 */
    public void setDemonstracao(Demonstracao demonstracao) {
        this.demonstracao = demonstracao;
    }
/**
 * Altera periodo da candidatura
 * @param inicio
 * @param fim 
 */
    public void setPeriodoCanidatura(Data inicio, Data fim) {
        demonstracao.setPeriodoCandidaturas(inicio, fim);
    }
/**
 * Valida data
 * @return true se valida, false se nao
 */
       public boolean validaDataFimSuperiorInicio(){
        return  demonstracao.validaDataFimSuperiorInicio();
    }
       /**
        * Valida datas
        * @param datai
        * @param dataf
        * @return true se valida, false se nao
        */
       public boolean validaDatas(String datai, String dataf) {
        return demonstracao.validaDatas(datai, dataf); 
    }
    /**
     * Actualiza o estado da demonstracao
     * @return true se valido, false se nao
     */
    public boolean atualizaDemonstracao() {
        DemonstracaoEstado demoEstado = demonstracao.getEstadoAtualDemonstracao();
        demonstracao.setEstadoDemonstracao(demoEstado);        
        return demoEstado.valida(demonstracao);
    }

}
