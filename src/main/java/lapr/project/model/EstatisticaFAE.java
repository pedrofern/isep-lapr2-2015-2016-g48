/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.lists.ListaFAE;

/**
 *
 * @author DianaSilva
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)


/**
 * Classe para objetos do tipo EstatisticaFAE que permite gerar e guardar as estatísticas
 * relativas aos FAE de uma exposição
 */
public class EstatisticaFAE {
    
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
     * @return a média amostral calculada
     */
    public double calcularMediaAmostral() {
        return 0;
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
 
        return 0;
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
    public double calcularVarianciaFaes() {
        return 0;
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
    public double calcularDesvioPadrao() {
        return 0;
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
        return nivelSignificancia;
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
    public double calcularZ0() {
        return 0;
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
    
    public boolean testarHipoteseAlternativa(FAE fae){
        return fae.getClassificacao().estaDecisaoAlerta();
    }

}
