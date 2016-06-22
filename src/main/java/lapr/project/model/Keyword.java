/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Pedro Fernandes
 */
public class Keyword implements Serializable{
    
    private String keywordDescricao;

    public Keyword(String keyword) {
        this.keywordDescricao = keyword;
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
     * Metodo que vai comprar objetos Keyword entre si
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
    
}
