/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Calculator;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.EstatisticaCandidatura;
import lapr.project.model.Exposicao;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.RegistoExposicoes;

/**
 *
 * @author DianaSilva
 */
public class GerarEstatisticasCandidaturaController {
    
    private final CentroExposicoes ce;
    private final Utilizador user;  
    private EstatisticaCandidatura estatistica;
    private double valorMedioSubmissao=0;
    private double taxaAceitacao=0;
    
    /**
     * Cria nova instancia da classe
     * @param centroExposicoes
     * @param user 
     */
    public GerarEstatisticasCandidaturaController(CentroExposicoes centroExposicoes, Utilizador user){
        this.user=user;
        ce=centroExposicoes;
        estatistica=new EstatisticaCandidatura();
        estatistica.setListaCandidaturas(new ListaCandidaturas());
        
    }
    /**
     * Devolve lista de exposicoes do organizador
     * @return lista de exposicoes do organizador
     */
    public RegistoExposicoes getRegistoExposicoesOrganizador(){
        return ce.getRegistoExposicoes().getExposicoesOrganizador(user);
    }
    /**
     * Altera exposicao
     * @param exposicao 
     */
    public void setExposicao(Exposicao exposicao){
        estatistica=exposicao.getEstatisticaCandidatura();
        estatistica.setListaCandidaturas(exposicao.getListaCandidaturas());
    }
    /**
     * Devolve lista de candidaturas
     * @return lista de candidaturas
     */
    public ListaCandidaturas getListaCandidaturas(){
        return estatistica.getListaCandidaturas();
    }
    /**
     * Devolve o valor medio da submissao da exposicao
     * @return o valor medio da submissao da exposicao
     */
    public double getValorMedioSubmissaoExposicao(){
        return estatistica.getValorMedioSubmissao();
    }
    /**
     * Devolve taxa de aceitacao exposicao
     * @return taxa
     */
    public double getTaxaAceitacaoExposicao(){
        return estatistica.getTaxaAceitacao();
    }
    /**
     * Devolve valor medio de submissao global
     * @return valor medio
     */
    public double getValorMedioSubmissaoGlobal(){
        return valorMedioSubmissao;
    }
    /**
     * Devolve taxa de aceitacao global
     * @return taxa
     */
    public double getTaxaAceitacaoGlobal(){
        return taxaAceitacao;
    }
    /**
     * Calcula valor medio de submissao global
     * @return valor medio
     */
    public double calcularValorMedioSubmissaoGlobal(){
        int numeroExposicoes=0;
        double sum=0;
        for(Exposicao e: ce.getRegistoExposicoes().getExposicoes()){
            estatistica=e.getEstatisticaCandidatura();
            estatistica.setListaCandidaturas(e.getListaCandidaturas());
            sum+=estatistica.calcularValorMedioSubmissao();
            numeroExposicoes++;
            valorMedioSubmissao=Calculator.average(sum, numeroExposicoes);
        }
        return valorMedioSubmissao;
    }
    /**
     * Calcula taxa de aceitacao global
     * @return taxa 
     */
    public double calcularTaxaAceitacaoGlobal(){
        int numeroExposicoes=0;
        double sum=0;
        for(Exposicao e: ce.getRegistoExposicoes().getExposicoes()){
            estatistica=e.getEstatisticaCandidatura();
            estatistica.setListaCandidaturas(e.getListaCandidaturas());
            sum+=estatistica.calcularTaxaAceitacao();
            numeroExposicoes++;
            taxaAceitacao=Calculator.average(sum, numeroExposicoes);
        }
        return taxaAceitacao;
    }
}
