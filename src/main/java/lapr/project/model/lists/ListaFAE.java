package lapr.project.model.lists;

import java.util.*;
import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class ListaFAE {

    /**
     * A lista de fae
     */
    private List<FAE> listaFAE;
    private FAE fae;
    

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
     * Valida o Organizador e se for válido adiciona a uma Lista de Organizador.
     *
     * @param u o utilizador a adicionar.
     * @return boolean
     */
    public boolean addFAE(FAE fae) {
        return listaFAE.add(fae);
    }

    /**
     * Cria e retorna um novo organizador
     *
     * @param u
     */
    public void criaFAE(Utilizador u) {
       
        addFAE( new FAE(u));
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
            return true;
        }
        return true;
    }

    /**
     * Verifica se existe o Organizador com a mesma ID recebida por parametro.
     *
     * @param strID a identificação do Organizador
     * @return bollean
     */
    public boolean hasUtilizador(Utilizador u) {
        for (FAE org : this.listaFAE) {
            if (org.getUtilizador().getUsername().equals(u)) {
                return true;
            }
        }
        return false;
    }

    public boolean removerUtilizador(Utilizador utilizador) {
        return listaFAE.remove(utilizador);
    }

    public boolean removerFAE(FAE fae) {
        return listaFAE.remove(fae);
    }

    public void ordenarPorPosicao() {
//        Collections.sort(listaOrganizadores);
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

    public FAE getFAE() {
        return fae;
    }


    public boolean hasFAE(FAE fae) {
        for (FAE f : this.listaFAE) {
            if (f.equals(fae)) {
                return true;
            }
        }
        return false;
    }

    public boolean adicionarFAE(FAE fae) {

        if (hasFAE(fae)) {
            return false;
        } else {
            return listaFAE.add(fae);
        }
    }

    public boolean registaFAE(FAE fae) {
        if (fae.valida()) {
            return addFAE(fae);
        } else {
            return false;
        }
    }

}


