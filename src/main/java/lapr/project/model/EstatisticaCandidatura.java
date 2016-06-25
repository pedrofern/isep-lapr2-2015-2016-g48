/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.lists.ListaCandidaturas;

/**
 *
 * @author DianaSilva
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

/**
 * Classe para objetos do tipo EstatisticaCandidatura que permite gerar e guardar as estatísticas
 * relativas às candidaturas de uma exposição
 */



public class EstatisticaCandidatura {
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
    public double getTaxaAceitacao() {
        return taxaAceitacao;
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
    public double getValorMedioSubmissao() {
        return valorMedioSubmissao;
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
        return listaCandidaturas;
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
            numeroAvaliacoes=c.getListaAvaliacoes().getListaAvaliacoes().size();
            for(Avaliacao a: c.getListaAvaliacoes().getListaAvaliacoes()){
                sum+=a.getMedia();
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
}
