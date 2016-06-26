/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.lists.ListaCandidaturas;

/**
 *
 * @author DianaSilva
 */

/**
 * Classe para objetos do tipo EstatisticaCandidatura que permite gerar e guardar as estatísticas
 * relativas às candidaturas de uma exposição
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EstatisticaCandidatura implements Serializable{
    /**
     * Número de candidaturas aceites da lista de candidaturas
     */
    private int numeroCandidaturasAceites;
    /**
     * Número de candidaturas recusadas da lista de candidaturas
     */
    private int numeroCandidaturasRecusadas;
    
    /**
     * Taxa de aceitação das candidaturas
     */
    private double taxaAceitacao;
    
    /**
     * Valor médio por avaliação da candidatura
     */
    private double valorMedioSubmissao;
    
    /**
     * Lista de candidaturas que se pretende analisar na estatística
     */
    private ListaCandidaturas listaCandidaturas;
    
    
    /**
     * Construtor EstatisticaCandidatura inicializando as variáveis estatísticas com 0
     */
    public EstatisticaCandidatura(){
        numeroCandidaturasAceites=0;
        numeroCandidaturasRecusadas=0;
        taxaAceitacao=0;
        valorMedioSubmissao=0;
    }

    /**
     * @return the numeroCandidaturasAceites
     */
    public int getNumeroCandidaturasAceites() {
        return numeroCandidaturasAceites;
    }

    /**
     * @param numeroCandidaturasAceites the numeroCandidaturasAceites to set
     */
    public void setNumeroCandidaturasAceites(int numeroCandidaturasAceites) {
        this.numeroCandidaturasAceites = numeroCandidaturasAceites;
    }

    /**
     * @return the numeroCandidaturasRecusadas
     */
    public int getNumeroCandidaturasRecusadas() {
        return numeroCandidaturasRecusadas;
    }

    /**
     * @param numeroCandidaturasRecusadas the numeroCandidaturasRecusadas to set
     */
    public void setNumeroCandidaturasRecusadas(int numeroCandidaturasRecusadas) {
        this.numeroCandidaturasRecusadas = numeroCandidaturasRecusadas;
    }

    /**
     * @return the taxaAceitacao
     */
    public String getTaxaAceitacao() {
        DecimalFormat df= new DecimalFormat("###, ##0.00");
  
        return df.format(taxaAceitacao);
    }

    /**
     * @param taxaAceitacao the taxaAceitacao to set
     */
    public void setTaxaAceitacao(double taxaAceitacao) {
        this.taxaAceitacao = taxaAceitacao;
    }

    /**
     * @return the valorMedioSubmissao
     */
    public String getValorMedioSubmissao() {
        DecimalFormat df= new DecimalFormat("###, ##0.00");
        
        return df.format(valorMedioSubmissao);
        
    }

    /**
     * @param valorMedioSubmissao the valorMedioSubmissao to set
     */
    public void setValorMedioSubmissao(double valorMedioSubmissao) {
        this.valorMedioSubmissao = valorMedioSubmissao;
    }

    /**
     * @return the listaCandidaturas
     */
    public ListaCandidaturas getListaCandidaturas() {
        ListaCandidaturas lc=new ListaCandidaturas();
        for(Candidatura c: listaCandidaturas.getListaCandidaturas()){
            for(Avaliacao a: c.getListaAvaliacoes().getListaAvaliacoes()){
                if(a.getEstado()==true){
                    if(!lc.contem(c)){
                        lc.addCandidatura(c);
                    }
                }
            }
        }
        return lc;
    }

    /**
     * @param listaCandidaturas the listaCandidaturas to set
     */
    public void setListaCandidaturas(ListaCandidaturas listaCandidaturas) {
        this.listaCandidaturas = listaCandidaturas;
    }
    
    public double calcularValorMedioSubmissao(){
        int numeroAvaliacoes=0;
        int sum=0;
        
        for(Candidatura c:listaCandidaturas.getListaCandidaturas()){
            
            for(Avaliacao a: c.getListaAvaliacoes().getListaAvaliacoes()){
                sum+=a.getMedia();
                numeroAvaliacoes++;
            }
        }
        valorMedioSubmissao=Calculator.average(sum, numeroAvaliacoes);
         return valorMedioSubmissao; 
 
    }
    
     public double calcularTaxaAceitacao(){
         for(Candidatura c: listaCandidaturas.getListaCandidaturas()){
             if(c.getDecisao()==true){
                 numeroCandidaturasAceites++;
             }else{
                 numeroCandidaturasRecusadas++;
             }
         }
         taxaAceitacao=Calculator.calculateRate(numeroCandidaturasAceites, numeroCandidaturasAceites);
         return taxaAceitacao;
    }
     
     public void getEstatisticasCandidatura(){
         
     }
     
     public void getEstatisticasCandidaturaGlobal(){
         
     }
}
