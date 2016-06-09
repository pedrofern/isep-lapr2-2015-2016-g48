/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lapr.project.model.*;

/**
 *
 * @author Edu
 */
public class ListaRecurso {
    
    private List<Recurso> listaRecurso;

    public ListaRecurso() {
        listaRecurso = new ArrayList<>();
    }
    
    public Recurso obterRecurso(int indice) {
        return listaRecurso.get(indice);
    }

    public boolean adicionarRecurso(Recurso recurso) {
        if (!listaRecurso.contains(recurso)) {
            return listaRecurso.add(recurso);
        }
        return false;
    }

    public boolean removerRecurso(Recurso recurso) {
        return listaRecurso.remove(recurso);
    }

    public int tamanho() {
        return this.listaRecurso.size();
    }

    public int indiceDe(Recurso recurso) {
        return listaRecurso.indexOf(recurso);
    }
    
    public boolean contem(Recurso recurso){
        return listaRecurso.contains(recurso);
    }
    
    public void ordenarPorPosicao(){
        Collections.sort(listaRecurso);
    }
    
      public Recurso[] getArray() {
        return listaRecurso.toArray( new Recurso[listaRecurso.size()] );
    }
    
}
    
