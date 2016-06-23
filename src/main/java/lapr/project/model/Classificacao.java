/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 * Classe que permite classificar o FAE, analisando estatisticamente as avaliações do FAE
 * 
 * @author DianaSilva
 */
public class Classificacao {
    
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
     * Construtor Classificação sem argumento inicializando as variáveis de instância com zero ou booleano false.
     */
    public Classificacao(){
        numeroSubmissoes=0;
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
     * Altera o numero de submissoes avaliadas pelo FAE
     * 
     * @param numeroSubmissoes o numero de submissoes avaliadas pelo FAE
     */
    public void setNumeroSubmissoes(int numeroSubmissoes) {
        this.numeroSubmissoes = numeroSubmissoes;
    }

    /**
     * Altera a media das classificações dadas pelo FAE
     * @param mediaClassificacoes média a alterar
     */
    public void setMediaClassificacoes(double mediaClassificacoes) {
        this.mediaClassificacoes = mediaClassificacoes;
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
}
