/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lapr.project.model.Utilizador;

/**
 *
 * @author Edu
 */
public class ListaUtilizadores {

    private List<Utilizador> listaUtilizadores;

    public ListaUtilizadores() {
        listaUtilizadores = new ArrayList<>();
    }
    
    public Utilizador obterUtilizador(int indice) {
        return listaUtilizadores.get(indice);
    }

    public boolean adicionarUtilizador(Utilizador utilizador) {
        if (!listaUtilizadores.contains(utilizador)) {
            return listaUtilizadores.add(utilizador);
        }
        return false;
    }

    public boolean removerUtilizador(Utilizador utilizador) {
        return listaUtilizadores.remove(utilizador);
    }

    public int tamanho() {
        return this.listaUtilizadores.size();
    }

    public int indiceDe(Utilizador utilizador) {
        return listaUtilizadores.indexOf(utilizador);
    }
    
    public boolean contem(Utilizador utilizador){
        return listaUtilizadores.contains(utilizador);
    }
    
    public void ordenarPorPosicao(){
        Collections.sort(listaUtilizadores);
    }
    
}