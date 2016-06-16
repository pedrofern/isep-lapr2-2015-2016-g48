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
    private List<Organizador> listaOrganizadores;

    /**
     * Constroi um ArrayList de Organizadores.
     */
    public ListaOrganizadores() {
        listaOrganizadores = new ArrayList<Organizador>();
    }
    
    public List<Organizador> getListaOrganizadores(){
        return listaOrganizadores;
    }

    /**
     * Valida o Organizador e se for válido adiciona a uma Lista de Organizador.
     *
     * @param u o utilizador a adicionar.
     * @return boolean
     */
    public boolean addOrganizador(Organizador o) {
       if (o == null) 
            return false;
 
        if (!o.valida() && !validaOrganizador(o))
            return false;

        return listaOrganizadores.add(o);
    }

    /**
     * Cria e retorna um novo organizador
     *
     * @param o o Organizador a adicionar
     * @return listaOrganizadores
     */
    public Organizador criaOrganizador(Utilizador u) {
        Organizador o=new Organizador(u);
        return o;
    }

    /**
     * Validação do Organizador.
     *
     * @param o o Organizador
     * @return boolean
     */
    private boolean validaOrganizador(Organizador o) {
        for(Organizador o1:  listaOrganizadores){
            if (o1.getUtilizador().getEmail().equalsIgnoreCase(o.getUtilizador().getEmail())) {
                return false;
            }
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
        for (Organizador org : this.listaOrganizadores) {
            if (org.getUtilizador().getID().equals(u.getID())) {
                return true;
            }
        }
        return false;
    }
    
     
    public boolean removerUtilizador(Utilizador utilizador) {
        return listaOrganizadores.remove(utilizador);
    }
    
     
    public void ordenarPorPosicao(){
//        Collections.sort(listaOrganizadores);
    }

    /**
     * Devolve a descrição textual da Lista de Organizadores.
     *
     * @return características da Lista de Organizadores.
     */
    @Override
    public String toString() {
        return "ListaOrganizadores:" + "listaOrganizadores=" + listaOrganizadores;
    }

}
