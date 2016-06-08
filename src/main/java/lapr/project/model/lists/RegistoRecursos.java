package lapr.project.model.lists;

import java.util.*;
import lapr.project.model.Recurso;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistoRecursos {

    private ArrayList<Recurso> listaRecursos;
    /**
     * Construtor relativo a lista de Recursos
     */
    public RegistoRecursos() {
        listaRecursos = new ArrayList<>();
    }
    /**
     * Metodo que retorna o recurso no indice passado por parametro
     * @param indice indice
     * @return o recurso no indice passado por parametro
     */
    public Recurso obterRecurso(int indice) {
        return listaRecursos.get(indice);
    }
    /**
     * Metodo que retorna o array de Recurso
     * @return o array de Recurso
     */
    public Recurso[] getArray() {
        return listaRecursos.toArray( new Recurso[listaRecursos.size()] );
    }
    /**
     * Metodo que retorna a lista de Recursos
     * @return lista recursos
     */
    public ArrayList<Recurso> getListaRecursos(){
        return listaRecursos;
    }
    /**
     * Metodo para adicionar o recurso passado por parametro a lista de recursos
     * @param recurso recurso
     * @return true se o recurso for adicionado false em caso contrario
     */
    public boolean adicionarRecurso(Recurso recurso) {
        if (!listaRecursos.contains(recurso)) {
            return listaRecursos.add(recurso);
        }
        return false;
    }
     /**
     * Metodo para remover o recurso passado por parametro a lista de recursos
     * @param recurso recurso
     * @return true se o recurso for removido false em caso contrario
     */
    public boolean removerRecurso(Recurso recurso) {
        return listaRecursos.remove(recurso);
    }
    /**
     * Metodo para retornar o tamanho da lista de recursos
     * @return o tamanho da lista de recursos
     */
    public int tamanho() {
        return this.listaRecursos.size();
    }
    /**
     * Metodo que retorna o indice do recurso passado por parametro
     * @param recurso recurso
     * @return o indice do recurso passado por parametro
     */
    public int indiceDeRecurso(Recurso recurso) {
        return listaRecursos.indexOf(recurso);
    }
    /**
     * Metodo que verifica se o recurso passado por  parametro existe na lista 
     * @param recurso recurso
     * @return true se existir false em caso contrario
     */
    public boolean contem(Recurso recurso){
        return listaRecursos.contains(recurso);
    }
}
