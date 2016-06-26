/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.lists.ListaFAE;

/**
 *
 * @author DianaSilva
 */

/**
 * Classe para objetos do tipo EstatisticaFAE que permite gerar e guardar as estatísticas
 * relativas aos FAE de uma exposição
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EstatisticaFAE implements Serializable{
    
    /**
     * Lista de FAE que se pretende analisar na estatística
     */
    private ListaFAE listaFaes;
  
    
    /**
     * Media da lista de FAE da exposição
     */
    private double mediaAmostral;
    
    /**
     * Desvio do FAE relativamente à media amostral
     */
    private double desvioFae;
    
    /**
     * Desvio médio amostral (distribuição normal) da lista de FAE da exposição
     */
    private double desvioAmostral;
    
    /**
     * Variância da amostra
     */
    private double varianciaFaes;
    
    /**
     * Desvio padrão amostral dos desvios dos FAE
     */
    private double desvioPadrao;
    
    /**
     * Média populacional a considerar nos testes de hipóteses
     */
    private static final int MEDIA_POPULACIONAL=1;
    
    /**
     * Nível de significância a considerar nos testes de hipóteses
     */
    private double nivelSignificancia;
    
    /**
     * Intervalo de confiança a considerar nos testes de hipóteses (95%, 99% ou 99,9%)
     */
    private double intervaloConfianca;
    
    /**
     * Zona a considerar nos testes de hipóteses
     */
    private double z0;
    
    /**
     * Lista de FAE a considerar na amostra
     */
    private ListaFAE listaFAE;
    
    private String teste;
    
    /**
     * Construtor EstatisticaFAE inicializando as variáveis estatísticas com 0
     */
    public EstatisticaFAE(){
        
        mediaAmostral=0;
        desvioAmostral=0;
        varianciaFaes=0;
        desvioPadrao=0;
        nivelSignificancia=0;
        intervaloConfianca=0;
        z0=0;  
        listaFAE=new ListaFAE();
    }

    /**
     * Obtém a média amostral (das classificações da lista de FAE)
     * @return the mediaAmostral
     */
    public double getMediaAmostral() {
        return mediaAmostral;
    }

    /**
     * Calcula a média amostral
     */
    public void setMediaAmostral(double mediaAmostral) {
        this.mediaAmostral=mediaAmostral;
     
    }

    /**
     * Obtém o desvio do FAE relativamente à amostra
     * @return the desvioFae
     */
    public double getDesvioFae() {
        return desvioFae;
    }

    /**
     * Define o desvio do FAE relativamente à amostra
     * @param mediaFae
     * @return o desvio do FAE calculado
     */
    public double calcularDesvioFae(double mediaFae) {
 
        return Math.abs(mediaAmostral-mediaFae);
    }

    /**
     * Obtém o desvio amostral
     * @return the desvioAmostral
     */
    public double getDesvioAmostral() {
        return desvioAmostral;
    }

    /**
     * Calcula o desvio amostral
     * @return o desvio amostral calculado
     */
    public double calcularDesvioAmostral() {
        return 0;
    }

    /**
     * Obtém a variância encontrada na amostra
     * @return the varianciaFaes
     */
    public double getVarianciaFaes() {
        return varianciaFaes;
    }

    /**
     * Calcula a variância
     * @return a variancia da amostra calculada
     */
    public void calcularVarianciaFaes() {
        int n=listaFAE.getListaFAE().size();
        double sum=0;
        for(FAE f: listaFAE.getListaFAE()){
            sum+=Math.pow(f.getClassificacao().getMediaDesvios(),2);
        }
        double p=1/(double)(n-1);
        varianciaFaes=p*sum;
    }

    /**
     * Obtém o desvio padrão 
     * @return the desvioPadrao
     */
    public double getDesvioPadrao() {
        return desvioPadrao;
    }

    /**
     * Calcula o desvio padrão 
     * @return o desvio padrão calculado
     */
    public void calcularDesvioPadrao() {
        desvioPadrao= Math.pow(Math.pow(varianciaFaes,2), 0.5);
    }

    /**
     * Obtém o nível de significância
     * @return to nivelSignificancia
     */
    public double getNivelSignificancia() {
        return nivelSignificancia;
    }

    /**
     * Calcula o nível de significância recebendo o intervalo de confiança
     * @param intervaloConfianca o intervalo de confiança a considerar nos testes
     * @return o nivel de significância calculado
     */
    public double calcularNivelSignificancia(double intervaloConfianca) {
        double ns=0;
        DecimalFormat df= new DecimalFormat("###, ##0.00");
        String novaString=df.format(intervaloConfianca);
        
        if(novaString.equals("90.00")){
           ns=1.645;
       }
       if(novaString.equals("95.00")){
           ns=1.960;
       }
       if(novaString.equals("99.00")){
           ns=2.580;
       }
       nivelSignificancia=ns;
        return ns;
    }

    /**
     * Obtém o valor obtido para teste
     * @return the z0
     */
    public double getZ0() {
        return z0;
    }

    /**
     * Calcula o valor para teste
     * @return o  valor da zona para teste calculada
     */
    public double calcularZ0(double desvio) {
        double d=desvio-1;
        int n= listaFAE.getListaFAE().size();
        double dentroRaiz=Math.pow(varianciaFaes, 2)/n;
        double divisor= Math.pow(dentroRaiz, 0.5);
        double z= d/divisor;
        return z;
    }

    /**
     * Retorna a lista de FAE considerada para amostra na estatística
     * @return a listaFaes
     */
    public ListaFAE getListaFaes() {
        return listaFaes;
    }

    /**
     * Define a lista de FAE para análise estatística
     * @param listaFaes the listaFaes to set
     */
    public void setListaFaes(ListaFAE listaFaes) {
        this.listaFaes = listaFaes;
    }
    
    /**
     * Testar H0- se a média populacional é igual a 1
     * 
     * @return resultado no teste da hipótese de controlo
     */
    
    public static boolean testarHipoteseControlo(){
        return MEDIA_POPULACIONAL == 1;
    }
    
    
    /**
     * Testar H1 - se a média populacional é superior a 1 (para criar alerta)
     * 
     * @param fae
     * @return o resultado no teste da hipótese alternativa
     */
    
    public boolean testarHipoteseAlternativa(FAE fae, double zTeste, double nivelSignificancia){
        if(zTeste>nivelSignificancia){
            fae.getClassificacao().setDecisaoAlerta(true);
        }
        else{
           fae.getClassificacao().setDecisaoAlerta(false);
        }
        return fae.getClassificacao().estaDecisaoAlerta();
    }
 


}
