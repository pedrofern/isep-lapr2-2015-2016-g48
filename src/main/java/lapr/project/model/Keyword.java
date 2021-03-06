/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Keyword implements Serializable{
    
    private String keywordDescricao;
    private int utilizacoes;

    public Keyword(String keyword) {
        this.keywordDescricao = keyword;
        this.utilizacoes=0;
    }
    public Keyword(){
        
    }

    public void setKeyword(String novaKeyword) {
        this.keywordDescricao = novaKeyword;
    }

    public String getKeyword() {
        return keywordDescricao;
    }

    public boolean valida() {
        if (keywordDescricao == null || keywordDescricao.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getKeyword();
    }
    
    /**
     * Metodo que vai comparar objetos Keyword entre si
     * @param outroObjeto outro produto
     * @return se os objetos forem iguais retorna true caso contrario false
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Keyword outraKeyword = (Keyword) outroObjeto;
        
        return keywordDescricao.equalsIgnoreCase(outraKeyword.keywordDescricao);
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.keywordDescricao);
        return hash;
    }

    /**
     * Obtém o número de vezes que a keyword já foi utilizada
     * @return número de vezes que a keyword foi utilizada
     */
    public int getUtilizacoes() {
        return utilizacoes;
    }

    /**
     * Incrementa um valor no contador de utilizações da password
     * @param utilizacoes número de vezes que a keyword foi utilizada
     */
    public void setUtilizacoes() {
        utilizacoes++;
    }
    
    
    
}
