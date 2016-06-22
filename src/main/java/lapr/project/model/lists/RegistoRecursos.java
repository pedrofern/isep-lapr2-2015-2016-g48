package lapr.project.model.lists;

import java.io.Serializable;
import java.util.*;
import lapr.project.model.Recurso;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistoRecursos implements Serializable{

    private ArrayList<Recurso> listaRecursos;
    private Recurso m_r;
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
    public List<Recurso> getListaRecursos(){
        return listaRecursos;
    }
    
    
    /**
     * Metodo para adicionar o recurso passado por parametro a lista de recursos
     * @param recurso recurso
     * @return true se o recurso for adicionado false em caso contrario
     */
    
    
        
    /**
     * Metodo que adiciona o recurso passado por parametro a lista
     * @param r reucrso
     * @return true se adicionar false caso contrario
     */
    public boolean addRecurso(Recurso r) {
       if(!listaRecursos.contains(r)){
            return listaRecursos.add(r);
        }
       
       return false;
    }
    
    public Recurso novoRecurso() {
        
    
        m_r= new Recurso();
        
       listaRecursos.add(m_r);
        
       return m_r;
       
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
    
    
    /**
     * Metodo que retorna um recurso
     * @param recurso recurso
     * @return recurso
     */
    public Recurso getRecurso(String recurso) {
        for (Recurso r : listaRecursos) {
            if (r.getDescricao().equalsIgnoreCase(recurso)) {
                return r;
            }
        }

        return null;

    }
    
    
    /**
     * Metodo que regista um recurso
     * @param r recurso
     * @return true se registar ou false caso contrario
     */
    public boolean registaRecurso(Recurso r) {
        if (validaRecurso(r)) {
            addRecurso(r);
            return true;
        }
        return false;
    }
    /**
     * Metodo que valida recurso
     * @param r recurso
     * @return true se validar false caso contrario
     */
    public boolean validaRecurso(Recurso r) {
        return !listaRecursos.contains(r);
    }
    
     public int countRecurso(){
        return listaRecursos.size();
    }
 
    
}
