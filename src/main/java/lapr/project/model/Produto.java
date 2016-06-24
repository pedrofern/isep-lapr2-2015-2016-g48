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
public class Produto implements Serializable{

    private String nomeProduto;

    public Produto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Produto() {

    }

    public void setTitulo(String novoNomeProduto) {
        this.nomeProduto = novoNomeProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public boolean valida() {
        return true;
    }

    @Override
    public String toString() {
        return this.getNomeProduto();
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
        Produto outroProduto = (Produto) outroObjeto;
        
        return nomeProduto.equalsIgnoreCase(outroProduto.nomeProduto);
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nomeProduto);
        return hash;
    }
}
