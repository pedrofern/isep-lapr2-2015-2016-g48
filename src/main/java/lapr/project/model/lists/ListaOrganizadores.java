package lapr.project.model.lists;

import java.util.*;
import lapr.project.model.Organizador;
import lapr.project.model.Utilizador;

/**
 *
 * @author Pedro Fernandes
 */
public class ListaOrganizadores {

    /**
     * A lista de Organizadores.
     */
    private List<Organizador> m_listaOrganizadores;

    /**
     * Constroi um ArrayList de Organizadores.
     */
    public ListaOrganizadores() {
        m_listaOrganizadores = new ArrayList<Organizador>();
    }

    /**
     * Valida o Organizador e se for válido adiciona a uma Lista de Organizador.
     *
     * @param u o utilizador a adicionar.
     * @return boolean
     */
    public boolean addOrganizador(Utilizador u) {
        if (u == null) {
            return false;
        }
        Organizador o = new Organizador(u);

        if (o.valida() && validaOrganizador(o)) {
            return addOrganizador(o);
        } else {
            return false;
        }
    }

    /**
     * Adiciona o Organizador a uma Lista.
     *
     * @param o o Organizador a adicionar
     * @return m_listaOrganizadores
     */
    private boolean addOrganizador(Organizador o) {
        return m_listaOrganizadores.add(o);
    }

    /**
     * Validação do Organizador.
     *
     * @param o o Organizador
     * @return boolean
     */
    private boolean validaOrganizador(Organizador o) {
        System.out.println("ListaOrganizadores: validaOrganizador:" + o.toString());
        return true;
    }

    /**
     * Verifica se existe o Organizador com a mesma ID recebida por parametro.
     *
     * @param strID a identificação do Organizador
     * @return bollean
     */
    public boolean hasUtilizador(Utilizador u) {
        for (Organizador org : this.m_listaOrganizadores) {
            if (org.getUtilizador().getUsername().equals(u)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Devolve a descrição textual da Lista de Organizadores.
     *
     * @return características da Lista de Organizadores.
     */
    @Override
    public String toString() {
        return "ListaOrganizadores:" + "m_listaOrganizadores=" + m_listaOrganizadores;
    }

}
