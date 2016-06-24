package lapr.project.model;

import java.io.Serializable;
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
}
