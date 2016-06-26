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
public class Representante implements Comparable<Utilizador>, Serializable{
    
    private Utilizador utilizador;
    
    public Representante(Utilizador u) {
        utilizador=u;
    }
    public Representante(){
        
    }

    private void setRepresentante(Utilizador u) {
        utilizador = u;
    }

    public Utilizador getRepresentante() {
        return utilizador;
    }

    public boolean valida() {
        if (utilizador.valida()) {
 
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return utilizador.getNome();
    }

    public boolean isRepresentante(Utilizador u) {
        if (this.utilizador != null) {
            return this.utilizador.equals(u);
        }
        return false;
    }

    @Override
    public int compareTo(Utilizador u) {
         return utilizador.getEmail().compareTo(u.getEmail());
    }
    
    /**
 * Compara o Utilizador com outro objecto
 * @param outroObjeto
 * @return true se o objecto recebido é equivalente  e false caso contrario 
 */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Utilizador outroUtilizador = (Utilizador) outroObjeto;

        return utilizador.getNome().equalsIgnoreCase(outroUtilizador.getNome());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.utilizador);
        return hash;
    }
}
