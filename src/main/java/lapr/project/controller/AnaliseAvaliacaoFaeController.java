/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.EstatisticaFAE;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.RegistoExposicoes;
import lapr.project.model.states.exposicao.ExposicaoCandidaturasAvaliadas;

/**
 *
 * @author DianaSilva
 */
public class AnaliseAvaliacaoFaeController {
    
    /**
     * O centro de exposicoes
     */
    private final CentroExposicoes ce;
    /**
     * O utilizador
     */
    private final Utilizador user;
    /**
     * A lista de faes
     */
    private ListaFAE listaFaes;
    /**
     * Esatatisticas do fae
     */
    private EstatisticaFAE estatistica;
    
    /**
     * Cria uma instancia desta classe e recebe como parametros o centro de exposicoes e o utilizador
     * @param centroExposicoes
     * @param user 
     */
    public AnaliseAvaliacaoFaeController(CentroExposicoes centroExposicoes, Utilizador user){
        this.ce=centroExposicoes;
        this.user=user;
    }
       /**
        * Devolve a lista de exposicoes do organizador
        * @return a lista
        */ 
    public RegistoExposicoes getExposicoesOrganizador(){
        return ce.getRegistoExposicoes().getExposicoesOrganizador(user);
    }
    /**
     * Devolve a lista de exposicoes do organizador que ja foram avaliadas
     * @return a lista
     */
    public RegistoExposicoes getExposicoesOrganizadorAvaliadas(){
        RegistoExposicoes leca=new RegistoExposicoes();
        for(Exposicao e: getExposicoesOrganizador().getExposicoes()){
            if(e.getEstadoAtualExposicao() instanceof ExposicaoCandidaturasAvaliadas){
                leca.adicionarExposicao(e);
            }
        }
        return leca;
    }
    /**
     * Altera a exposicao
     * @param exposicao 
     */
    public void setExposicao(Exposicao exposicao){
        this.listaFaes=exposicao.getListaFAE();
        this.estatistica=exposicao.getEstatisticaFAE();
    }
    /**
     * Altera o intervalo de confianca
     * @param ic 
     */
    public void setIntervaloConfianca(int ic){
        estatistica.calcularNivelSignificancia(ic);
    }
    /**
     * Altera a lista de faes
     * @param listaFaes 
     */
    public void setListaFaes(ListaFAE listaFaes){
        estatistica.setListaFaes(listaFaes);
    }
    /**
     * Calcula a media amostral
     * @return a media
     */
    public double calcularMediaAmostral(){
        return estatistica.calcularMediaAmostral();
    }
    /**
     * Calcula a media de faes
     * @param fae
     * @return a media
     */
    public double getMediaFae(FAE fae){
        return fae.getClassificacao().getMediaClassificacoes();
    }
    /**
     * Calcula o desvio dos faes
     * @param fae
     * @param mediaFae
     * @return o desvio calculado
     */
    public double calcularDesvioFAE(FAE fae, double mediaFae){
        double desvioFAE =estatistica.calcularDesvioFae(mediaFae);
        fae.getClassificacao().setMediaDesvios(desvioFAE);
        return desvioFAE;
    }
    /**
     * Calcula o desvio amostral
     * @return o desvio calculado
     */
    public double calcularDesvioAmostral(){
        listaFaes.getListaFAE().size();
        return estatistica.calcularDesvioAmostral();
    }
    
    /**
     * Calcula a variancia
     * @return a variancia
     */
    public double calcularVariancia(){
        return estatistica.calcularVarianciaFaes();
    }
    /**
     * Calcula o desvio padrao
     * @return o desvio padrao
     */
    public double calcularDesvioPadrao(){
        return estatistica.calcularDesvioPadrao();
    }   
    /**
     * Calcula o Z0
     * @return o Z0
     */
    public double calcularZ0(){
        return estatistica.calcularZ0();
    }
    /**
     * Gera estatisticas do fae
     * @param fae 
     */
    public void iniciarTesteEstatistico(FAE fae){
        EstatisticaFAE.testarHipoteseControlo();
        estatistica.testarHipoteseAlternativa(fae);
    }
    /**
     * Remove um fae
     * @param fae
     * @return true se removido, false se nao
     */
    public boolean removerFAE(FAE fae){
        return listaFaes.removerFAE(fae);
    }
    
}