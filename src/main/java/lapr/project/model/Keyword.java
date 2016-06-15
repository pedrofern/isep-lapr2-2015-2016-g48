/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Objects;

/**
 *
 * @author Pedro Fernandes
 */
public class Keyword {
    
    private String keyword;

    public Keyword(String keyword) {
        this.keyword = keyword;
    }

    public Keyword() {

    }

    public void setKeyword(String novaKeyword) {
        this.keyword = novaKeyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public boolean valida() {
        return true;
    }

    @Override
    public String toString() {
        return this.getKeyword();
    }
    
    /**
     * Metodo que vai comprar objetos produto entre si
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
        
        return keyword.equalsIgnoreCase(outraKeyword.keyword);
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.keyword);
        return hash;
    }
    
}
