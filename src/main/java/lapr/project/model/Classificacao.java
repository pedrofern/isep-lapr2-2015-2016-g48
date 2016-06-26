/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que permite classificar o FAE, analisando estatisticamente as avaliações do FAE
 * 
 * @author DianaSilva
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Classificacao implements Serializable{
    
   /**
     * numero de submissões avaliadas pelo FAE
     */
    private int numeroSubmissoes;
    /*
    * média das avaliações dadas pelo FAE
    */
    private double mediaClassificacoes;
    
    /**
     * média do desvio do FAE modelada por uma distribuição normal
     */
    private double mediaDesvios;
    
    /**
     * decisão de alerta relativa ao desvio nas avaliações do FAE
     */
    private boolean decisaoAlerta;
    
    /**
     * Soma de todas as médias dadas pelo FAE
     */
    private int sumSubmissoes;
    
    /**
     * Construtor Classificação sem argumento inicializando as variáveis de instância com zero ou booleano false.
     */
    public Classificacao(){
        numeroSubmissoes=0;
        sumSubmissoes=0;
        mediaClassificacoes=0;
        mediaDesvios=0;
        decisaoAlerta=false;
    }

    /**
     * Método que retorna o número de submissões avaliadas pelo FAE
     * @return o numeroSubmissoes
     */
    public int getNumeroSubmissoes() {
        return numeroSubmissoes;
    }

    /**
     * Método que retorna a média das classificações dadas pelo FAE
     * @return a média das classificações dadas pelo FAE
     */
    public double getMediaClassificacoes() {
        calcularMediaFAE();
        setMediaClassificacoes(mediaClassificacoes);
        return mediaClassificacoes;
    }

    /**
     * Método que retorna a média dos desvios nas classificações do FAE comparativamente com os restantes FAEs
     * @return a media dos desvios nas classificações do FAE da distribuição amostral
     */
    public double getMediaDesvios() {
        return mediaDesvios;
    }

    /**
     * Método que retorna a decisão (true se o desvio medio é superior a 1)
     * @return a decisão de alerta
     */
    public boolean estaDecisaoAlerta() {
        return decisaoAlerta;
    }
    
    /**
     * Método que retorna a decisão (true se o desvio medio é superior a 1)
     * @return a decisão de alerta
     */
    public String estaDecisaoAlertaString() {
        if(decisaoAlerta==true){
            return "Sim";
        }else{
            return "Não";
        }
    }
    
    /**
     * Altera o numero de submissoes avaliadas pelo FAE
     * 
     * @param numeroSubmissoes o numero de submissoes avaliadas pelo FAE
     */
    public void incrementaNumeroSubmissoes() {
        numeroSubmissoes++;
    }
    
    
    public void incrementaValorÀSoma(double media){
        sumSubmissoes+=media;
    }

    /**
     * Altera a media das classificações dadas pelo FAE
     * @param mediaClassificacoes média a alterar
     */
    public void setMediaClassificacoes(double media) {
        this.mediaClassificacoes = media;
    }

    /**
     * Altera a média dos desvios nas classificações do FAE comparativamente com os restantes FAEs
     * @param mediaDesvios a média dos desvios a alterar
     */
    public void setMediaDesvios(double mediaDesvios) {
        this.mediaDesvios = mediaDesvios;
    }

    /**
     * Alterar a decisão de alerta relativa aos desvios nas avaliações do FAE
     * @param decisaoAlerta a decisão de alerta a alterar
     */
    public void setDecisaoAlerta(boolean decisaoAlerta) {
        this.decisaoAlerta = decisaoAlerta;
    }
    
    public void calcularMediaFAE(){
        mediaClassificacoes= Calculator.average(sumSubmissoes, numeroSubmissoes);
    }
}
