/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Calculator;
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
     * Total de médias da amostra
     */
    private double totalMedias;
    
    /**
     * Número de submissões da amostra
     */
    private int numeroSubmissoes;
    
    /**
     * Intervalo de Confiança 
     */    
    private double ic;

    
    /**
     * Cria uma instancia desta classe e recebe como parametros o centro de exposicoes e o utilizador
     * @param centroExposicoes
     * @param user 
     */
    public AnaliseAvaliacaoFaeController(CentroExposicoes centroExposicoes, Utilizador user){
        this.ce=centroExposicoes;
        this.user=user;
        totalMedias=0;
        numeroSubmissoes=0;
        ic=0;
    }
       /**
        * Devolve a lista de exposicoes do organizador que já foram avaliadas
        * @return a lista
        */ 
    public RegistoExposicoes getExposicoes(){
        RegistoExposicoes leca=new RegistoExposicoes();
        for(Exposicao e: ce.getRegistoExposicoes().getExposicoesOrganizador(user).getExposicoes()){
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
        this.estatistica=exposicao.getEstatisticaFAE();
        estatistica.setListaFaes(exposicao.getListaFAE());
        
    }
    /**
     * Altera o intervalo de confianca
     * @param ic 
     */
    public void setIntervaloConfianca(double ic){
        this.ic=ic;
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
        for(FAE f: estatistica.getListaFaes().getListaFAE()){
             totalMedias+=f.getClassificacao().getMediaClassificacoes();
            numeroSubmissoes++;
        }

        double mediaAmostral=Calculator.average(totalMedias, numeroSubmissoes);
        estatistica.setMediaAmostral(mediaAmostral);
        return mediaAmostral;
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
    public void calcularDesvioFAE(FAE fae, double mediaFae){
        calcularMediaAmostral();
        double desvioFAE =estatistica.calcularDesvioFae(mediaFae);
        fae.getClassificacao().setMediaDesvios(desvioFAE);
    }
    
    
    public double getDesvioFAE(FAE fae){
        calcularDesvioFAE(fae, fae.getClassificacao().getMediaClassificacoes());
        return fae.getClassificacao().getMediaDesvios();
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
        estatistica.calcularVarianciaFaes();
        return estatistica.getVarianciaFaes();
    }
    /**
     * Calcula o desvio padrao
     * @return o desvio padrao
     */
    public double calcularDesvioPadrao(){
        estatistica.calcularDesvioPadrao();
        return estatistica.getDesvioPadrao();
    }   
    
    public double calcularNivelSignificancia(){
        return estatistica.calcularNivelSignificancia(ic);
    }
    
    
    /**
     * Calcula o Z0
     * @param f fae a avaliar
     * @return o Z0
     */
    public double calcularZ0(FAE f){
        return estatistica.calcularZ0(getDesvioFAE(f));
    }
    
    
    /**
     * Gera estatisticas do fae
     * @return  resultado do teste
     */
    public String iniciarTesteEstatistico(FAE f){
        String resultado="";
        if(f.getClassificacao().getNumeroSubmissoes()<30){
            resultado="n<30";
        }else{
            if(EstatisticaFAE.testarHipoteseControlo()==false){
                    resultado="Sim";
                }

                if(estatistica.testarHipoteseAlternativa(f, calcularZ0(f), calcularNivelSignificancia())==true)
                    resultado="Sim";
                else{
                    resultado= "Não";
                }
        }
        return resultado;
    }
    /**
     * Remove um fae
     * @param fae
     * @return true se removido, false se nao
     */
    public boolean removerFAE(FAE fae){
        return listaFaes.removerFAE(fae);
    }
    
    public ListaFAE getListaFAE(){
        return estatistica.getListaFaes();
    }
    
    public String[] toStringEstatistica(FAE f){

        String[] data={f.getNome(), String.format("%.2f", getMediaFae(f)),String.format("%.2f", getDesvioFAE(f)), String.format("%.2f", calcularMediaAmostral()),
        String.format("%.2f", calcularZ0(f)), iniciarTesteEstatistico(f)};
//         
                  
                  return data;
      }
    
}