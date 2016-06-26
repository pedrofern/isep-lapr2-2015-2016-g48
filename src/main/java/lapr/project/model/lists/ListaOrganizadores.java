package lapr.project.model.lists;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.Organizador;
import lapr.project.model.Utilizador;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaOrganizadores implements Serializable{

    /**
     * A lista de Organizadores.
     */
    private ArrayList<Organizador> listaOrganizadores;

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
     * @param o organizador a adicionar 
     * @return boolean
     */
    public boolean addOrganizador(Organizador o) {
       if (o == null) 
            return false;
 
        if (!o.valida() || !validaOrganizador(o))
            return false;
  
        else{
            return listaOrganizadores.add(o);
        }
        
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
     * @param u utilizador a verificar se existe ou não na lista de organizadores
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
    
     
    public boolean removerUtilizador(Organizador o) {
        return listaOrganizadores.remove(o);
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
