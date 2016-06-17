/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Demonstracao;
import lapr.project.model.FAE;
import lapr.project.model.Recurso;
import lapr.project.model.Utilizador;

/**
 *
 * @author Edu
 */
public class ListaRecursoDemonstracao {

    private List<Recurso> listarecursodemonstracao;

    public ListaRecursoDemonstracao() {
        listarecursodemonstracao = new ArrayList<>();
    }

    public void addRecursoDemonstracao(Recurso recurso) {

        listarecursodemonstracao.add(recurso);

    }

    public List<Recurso> getListaRecursoDemonstracao() {
       
        return listarecursodemonstracao;
    }

    public void criaRecursoDemonstracao(String recurso) {

        addRecursoDemonstracao(new Recurso(recurso));
    }

    public boolean valida(Recurso r) {

        if (!listarecursodemonstracao.contains(r)) {
            return listarecursodemonstracao.add(r);
        }
        return false;
    }
    
     public void removerRecurso(Recurso recurso) {
        listarecursodemonstracao.remove(recurso);
    }

}
