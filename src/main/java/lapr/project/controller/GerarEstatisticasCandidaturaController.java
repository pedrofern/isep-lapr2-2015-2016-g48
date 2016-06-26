/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.text.DecimalFormat;
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
    
    public GerarEstatisticasCandidaturaController(CentroExposicoes centroExposicoes, Utilizador user){
        this.user=user;
        ce=centroExposicoes;
        estatistica=new EstatisticaCandidatura();
        estatistica.setListaCandidaturas(new ListaCandidaturas());
        
    }
    
    public RegistoExposicoes getRegistoExposicoesOrganizador(){
        RegistoExposicoes lecd = new RegistoExposicoes();
        
        for(Exposicao e: ce.getRegistoExposicoes().getExposicoesOrganizador(user).getExposicoes()){
            for(Exposicao e1: ce.getRegistoExposicoes().getExposicoesCandidaturasDecididas().getExposicoes()){
                if(e.equals(e1)){
                    lecd.adicionarExposicao(e1);
                }
            }
        }
        
        return lecd;
    }
    
    public void setExposicao(Exposicao exposicao){
        estatistica=exposicao.getEstatisticaCandidatura();
        estatistica.setListaCandidaturas(exposicao.getListaCandidaturas());
    }
    
    public ListaCandidaturas getListaCandidaturas(){
        return estatistica.getListaCandidaturas();
    }
    
    public String getValorMedioSubmissaoExposicao(){
        estatistica.calcularValorMedioSubmissao();
        return estatistica.getValorMedioSubmissao();
    }
    
    public String getTaxaAceitacaoExposicao(){
        estatistica.calcularTaxaAceitacao();
        return estatistica.getTaxaAceitacao();
    }
    
    public String getValorMedioSubmissaoGlobal(){
        calcularValorMedioSubmissaoGlobal();
        DecimalFormat df= new DecimalFormat("###, ##0.00");
        
        return df.format(valorMedioSubmissao);
    }
    
    public String getTaxaAceitacaoGlobal(){
        calcularTaxaAceitacaoGlobal();
        
        DecimalFormat df= new DecimalFormat("###, ##0.00");
        
        return df.format(taxaAceitacao);
    }
    
    public double calcularValorMedioSubmissaoGlobal(){
        int numeroExposicoes=0;
        double sum=0;
        for(Exposicao e: ce.getRegistoExposicoes().getExposicoesCandidaturasDecididas().getExposicoes()){
            estatistica=e.getEstatisticaCandidatura();
            estatistica.setListaCandidaturas(e.getListaCandidaturas());
            
            sum+=estatistica.calcularValorMedioSubmissao();
            numeroExposicoes++;
            
        }
        
        valorMedioSubmissao=Calculator.average(sum, numeroExposicoes);
        return valorMedioSubmissao;
    }
    
    public double calcularTaxaAceitacaoGlobal(){
        int numeroExposicoes=0;
        double sum=0;
        for(Exposicao e: ce.getRegistoExposicoes().getExposicoes()){
            estatistica=e.getEstatisticaCandidatura();
            estatistica.setListaCandidaturas(e.getListaCandidaturas());
            sum+=estatistica.calcularTaxaAceitacao();
            numeroExposicoes++;
            
        }
        taxaAceitacao=Calculator.average(sum, numeroExposicoes);
        return taxaAceitacao;
    }
}
