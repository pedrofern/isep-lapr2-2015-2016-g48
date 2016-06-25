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
import lapr.project.model.states.ExposicaoCandidaturasAvaliadas;

/**
 *
 * @author DianaSilva
 */
public class AnaliseAvaliacaoFaeController {
    
    private final CentroExposicoes ce;
    private final Utilizador user;
    private ListaFAE listaFaes;
    private EstatisticaFAE estatistica;
    
    public AnaliseAvaliacaoFaeController(CentroExposicoes centroExposicoes, Utilizador user){
        this.ce=centroExposicoes;
        this.user=user;
    }
        
    public RegistoExposicoes getExposicoesOrganizador(){
        return ce.getRegistoExposicoes().getExposicoesOrganizador(user);
    }
    
    public RegistoExposicoes getExposicoesOrganizadorAvaliadas(){
        RegistoExposicoes leca=new RegistoExposicoes();
        for(Exposicao e: getExposicoesOrganizador().getExposicoes()){
            if(e.getEstadoAtualExposicao() instanceof ExposicaoCandidaturasAvaliadas){
                leca.adicionarExposicao(e);
            }
        }
        return leca;
    }
    
    public void setExposicao(Exposicao exposicao){
        this.listaFaes=exposicao.getListaFAE();
        this.estatistica=exposicao.getEstatisticaFAE();
    }
    
    public void setIntervaloConfianca(int ic){
        estatistica.calcularNivelSignificancia(ic);
    }
    
    public void setListaFaes(ListaFAE listaFaes){
        estatistica.setListaFaes(listaFaes);
    }
    
    public double calcularMediaAmostral(){
        return estatistica.calcularMediaAmostral();
    }
    
    public double getMediaFae(FAE fae){
        return fae.getClassificacao().getMediaClassificacoes();
    }
    
    public double calcularDesvioFAE(FAE fae, double mediaFae){
        double desvioFAE =estatistica.calcularDesvioFae(mediaFae);
        fae.getClassificacao().setMediaDesvios(desvioFAE);
        return desvioFAE;
    }
    
    public double calcularDesvioAmostral(){
        listaFaes.getListaFAE().size();
        return estatistica.calcularDesvioAmostral();
    }
    
    
    public double calcularVariancia(){
        return estatistica.calcularVarianciaFaes();
    }
    
    public double calcularDesvioPadrao(){
        return estatistica.calcularDesvioPadrao();
    }   
    
    public double calcularZ0(){
        return estatistica.calcularZ0();
    }
    
    public void iniciarTesteEstatistico(FAE fae){
        EstatisticaFAE.testarHipoteseControlo();
        estatistica.testarHipoteseAlternativa(fae);
    }
    
    public boolean removerFAE(FAE fae){
        return listaFaes.removerFAE(fae);
    }
    
}