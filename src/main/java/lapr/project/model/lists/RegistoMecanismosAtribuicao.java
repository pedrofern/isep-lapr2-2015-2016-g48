/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import lapr.project.model.mechanisms.MecanismoAtribuicao;

/**
 *
 * @author Diana
 */
public class RegistoMecanismosAtribuicao {
     private List<MecanismoAtribuicao> listaMecanismoAtribuicao;
     
     public RegistoMecanismosAtribuicao(){
         listaMecanismoAtribuicao=new ArrayList<>();
     }
     
    public List<MecanismoAtribuicao> getMecanismosAtribuicao() {
        List<MecanismoAtribuicao> lMecanismos = new ArrayList<>();

        for (ListIterator<MecanismoAtribuicao> it = listaMecanismoAtribuicao.listIterator(); it.hasNext();) {
            lMecanismos.add(it.next());
        }

        return lMecanismos;
    }
     
}
