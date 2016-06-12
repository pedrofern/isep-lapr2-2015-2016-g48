package lapr.project.model;

import lapr.project.model.mechanisms.Atribuicao;
import java.util.*;

/**
 *
 * @author Pedro Fernandes
 */
public class Organizador {

    private Utilizador utilizador;

    public Organizador(Utilizador u) {
        utilizador=u;
    }

    private void setUtilizador(Utilizador u) {
        utilizador = u;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public boolean valida() {
        if (utilizador.valida()) {
            System.out.println("Organizador:valida: " + this.toString());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.utilizador.toString();
    }

    public boolean isUtilizador(Utilizador u) {
        if (this.utilizador != null) {
            return this.utilizador.equals(u);
        }
        return false;
    }

}
