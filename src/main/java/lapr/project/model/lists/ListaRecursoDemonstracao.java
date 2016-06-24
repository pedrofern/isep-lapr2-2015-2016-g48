/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.Recurso;

/**
 *
 * @author Edu
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaRecursoDemonstracao implements Serializable{

    private ArrayList<Recurso> listarecursodemonstracao;

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
     
      public boolean contem(Recurso recurso){
        return listarecursodemonstracao.contains(recurso);
    }
    

}
