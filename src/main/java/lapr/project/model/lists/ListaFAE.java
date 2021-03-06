package lapr.project.model.lists;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaFAE implements Serializable{

    /**
     * A lista de fae
     */
    private ArrayList<FAE> listaFAE;

    /**
     * Constroi um ArrayList de FAE
     */
    public ListaFAE() {
        listaFAE = new ArrayList<>();
    }

    public List<FAE> getListaFAE() {
        return listaFAE;
    }

    /**
     * Cria e retorna um novo organizador
     *
     * @param u
     */
    public FAE addFAE(Utilizador u) {

        return new FAE(u);

    }

    /**
     * Validação do Organizador.
     *
     * @param fae o Organizador
     * @return boolean
     */
    private boolean validaFAE(FAE fae) {
        for (FAE o1 : listaFAE) {
            if (o1.getUtilizador().getEmail().equalsIgnoreCase(fae.getUtilizador().getEmail())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica se existe o Organizador com a mesma ID recebida por parametro.
     *
     * @param u
     * @param strID a identificação do Organizador
     * @return bollean
     */
    public boolean hasUtilizador(Utilizador u) {
        for (FAE fae : this.listaFAE) {
            if (fae.getUtilizador().getUsername().equals(u.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public boolean removerFAE(FAE fae) {
        return listaFAE.remove(fae);
    }

    /**
     * Devolve a descrição textual da Lista de Organizadores.
     *
     * @return características da Lista de Organizadores.
     */
    @Override
    public String toString() {
        return "ListaFAE:" + "listaFAE=" + listaFAE;
    }

    public boolean hasFAE(FAE fae) {
        for (FAE f : this.listaFAE) {
            if (f.equals(fae)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Valida o Organizador e se for válido adiciona a uma Lista de Organizador.
     *
     * @param u o utilizador a adicionar.
     * @return boolean
     */
    public boolean addFAE(FAE fae) {
        if (validaFAE(fae)) {
            return listaFAE.add(fae);
        }
        return false;

    }

    public boolean registaFAE(FAE fae) {
        if (fae.validaMenbroFAE()) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public FAE[] getArray() {
        return listaFAE.toArray( new FAE[listaFAE.size()] );
    }

    public boolean validaMinFAE() {
        return listaFAE.size() >= 2;
    }

    public String toStringCompleto() {
        String str = "";

        for (int i = 0; i < listaFAE.size(); i++) {
            str += "\t\t" + listaFAE.get(i).getUtilizador().toStringGeral() + "\n";
        }

        return str;
    }

}
