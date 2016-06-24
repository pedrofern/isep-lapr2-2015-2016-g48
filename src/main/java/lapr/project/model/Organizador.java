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
public class Organizador implements Serializable{

    private Utilizador utilizador;

    public Organizador(Utilizador u) {
        utilizador=u;
    }
    public Organizador() {
        utilizador=new Utilizador();
    }
 

    private void setUtilizador(Utilizador u) {
        utilizador = u;
    }

    public Utilizador getUtilizador() {
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

    public boolean isUtilizador(Utilizador u) {
        if (this.utilizador != null) {
            return this.utilizador.equals(u);
        }
        return false;
    }

}
